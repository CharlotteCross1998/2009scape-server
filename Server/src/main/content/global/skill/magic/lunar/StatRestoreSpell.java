package content.global.skill.magic.lunar;

import content.data.consumables.Consumables;
import core.game.consumable.Potion;
import core.plugin.Initializable;
import core.game.node.entity.combat.spell.MagicSpell;
import core.game.node.entity.combat.spell.Runes;
import core.game.node.Node;
import core.game.node.entity.Entity;
import core.game.node.entity.combat.spell.SpellType;
import core.game.node.entity.player.Player;
import core.game.node.entity.player.link.audio.Audio;
import core.game.bots.AIPlayer;
import core.game.node.entity.player.link.SpellBookManager.SpellBook;
import core.game.node.item.Item;
import core.game.world.map.RegionManager;
import core.game.world.update.flag.context.Animation;
import core.game.world.update.flag.context.Graphics;
import core.plugin.Plugin;

import java.util.List;

@Initializable
public class StatRestoreSpell extends MagicSpell {

	private static final Animation ANIMATION = new Animation(4413);
	private static final Graphics GRAPHICS = new Graphics(733, 130);

	private static final int[] IDS = new int[] { 2434, 139, 141, 143, 2430, 127, 129, 131, 3024, 3026, 3028, 3030 };

	public StatRestoreSpell() {
		super(SpellBook.LUNAR, 81, 84, null, null, null, new Item[] { new Item(Runes.ASTRAL_RUNE.getId(), 2), new Item(Runes.EARTH_RUNE.getId(), 10), new Item(Runes.WATER_RUNE.getId(), 10) });
	}

	@Override
	public Plugin<SpellType> newInstance(SpellType arg) throws Throwable {
		SpellBook.LUNAR.register(27, this);
		return this;
	}

	@Override
	public boolean cast(Entity entity, Node target) {
		final Player player = ((Player) entity);
		Item item = ((Item) target);
		final Potion potion = (Potion) Consumables.getConsumableById(item.getId());
		player.getInterfaceManager().setViewedTab(6);
		if (potion == null) {
			player.getPacketDispatch().sendMessage("You can only cast this spell on a potion.");
			return false;
		}
		if (!item.getDefinition().isTradeable() || !isRestore(item.getId())) {
			player.getPacketDispatch().sendMessage("You can't cast this spell on that item.");
			return false;
		}
		List<Player> pl = RegionManager.getLocalPlayers(player, 1);
		int plSize = pl.size() - 1;
		int doses = potion.getDose(item);
		if (plSize > doses) {
			player.getPacketDispatch().sendMessage("You don't have enough doses.");
			return false;
		}
		if (doses > plSize) {
			doses = plSize;
		}
		if (pl.size() == 0) {
			return false;
		}
		if (!super.meetsRequirements(player, true, false)) {
			return false;
		}
		int size = 1;
		for (Player players : pl) {
			Player o = (Player) players;
			if (!o.isActive() || o.getLocks().isInteractionLocked() || o == player) {
				continue;
			}
			if (!o.getSettings().isAcceptAid() && !(o instanceof AIPlayer)) {
				continue;
			}
			o.graphics(GRAPHICS);
			player.getPacketDispatch().sendMessage("You can only cast this spell on a potion.");
			potion.getEffect().activate(o);
			size++;
		}
		if (size == 1) {
			player.getPacketDispatch().sendMessage("There is nobody around that has accept aid on to share the potion with you.");
			return false;
		}
		super.meetsRequirements(player, true, true);
		potion.getEffect().activate(player);
		player.getAudioManager().send(new Audio (2899), true);
		player.animate(ANIMATION);
		player.graphics(GRAPHICS);
		player.getInventory().remove(item);
		player.getInventory().add(new Item(potion.getIds()[size - 1]));
		return true;
	}

	private boolean isRestore(int id) {
		for (int i : IDS) {
			if (i == id) {
				return true;
			}
		}
		return false;
	}

}
