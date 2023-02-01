package content.region.asgarnia.falador.dialogue;

import core.game.dialogue.DialoguePlugin;
import core.game.dialogue.FacialExpression;
import core.game.node.entity.npc.NPC;
import core.plugin.Initializable;
import core.game.node.entity.player.Player;

/**
 * Represents the falador shop keeper dialogue plugin.
 * @author 'Vexia
 * @version 1.0
 */
@Initializable
public final class FaladorShopKeeperDialogue extends DialoguePlugin {

	/**
	 * Constructs a new {@code FaladorShopKeepDialogue} {@code Object}.
	 */
	public FaladorShopKeeperDialogue() {
		/**
		 * empty.
		 */
	}

	/**
	 * Constructs a new {@code FaladorShopKeepDialogue} {@code Object}.
	 * @param player the player.
	 */
	public FaladorShopKeeperDialogue(Player player) {
		super(player);
	}

	@Override
	public DialoguePlugin newInstance(Player player) {
		return new FaladorShopKeeperDialogue(player);
	}

	@Override
	public boolean open(Object... args) {
		npc = (NPC) args[0];
		interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "Can I help you at all?");
		stage = 0;
		return true;
	}

	@Override
	public boolean handle(int interfaceId, int buttonId) {
		switch (stage) {
		case 0:
			interpreter.sendOptions("Select an Option", "Yes, please. What are you selling?", "How should I use your shop?", "No, thanks.");
			stage = 1;
			break;
		case 1:
			switch (buttonId) {
			case 1:
				end();
				npc.openShop(player);
				break;
			case 2:
				interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "I'm glad you ask! You can buy as many of the items", "stocked as you wish. You can also sell most items to the", "shop.");
				stage = 20;
				break;
			case 3:
				end();
				break;

			}
			break;
		case 20:
			end();
			break;
		}
		return true;
	}

	@Override
	public int[] getIds() {
		return new int[] { 526, 527 };
	}
}
