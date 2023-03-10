package content.region.morytania.canifis.dialogue;

import core.game.dialogue.DialoguePlugin;
import core.game.dialogue.FacialExpression;
import core.game.node.entity.npc.NPC;
import core.plugin.Initializable;
import core.game.node.entity.player.Player;

/**
 * Represents the dialogue used for the yuri npc.
 * @author 'Vexia
 * @version 1.0
 */
@Initializable
public final class YuriDialogue extends DialoguePlugin {

	/**
	 * Constructs a new {@code YuriDialogue} {@code Object}.
	 */
	public YuriDialogue() {
		/**
		 * empty.
		 */
	}

	/**
	 * Constructs a new {@code YuriDialogue} {@code Object}.
	 * @param player the player.
	 */
	public YuriDialogue(Player player) {
		super(player);
	}

	@Override
	public DialoguePlugin newInstance(Player player) {
		return new YuriDialogue(player);
	}

	@Override
	public boolean open(Object... args) {
		npc = (NPC) args[0];
		interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "Hmm... you smell strange...");
		stage = 0;
		return true;
	}

	@Override
	public boolean handle(int interfaceId, int buttonId) {
		end();
		return true;
	}

	@Override
	public int[] getIds() {
		return new int[] { 6028 };
	}
}
