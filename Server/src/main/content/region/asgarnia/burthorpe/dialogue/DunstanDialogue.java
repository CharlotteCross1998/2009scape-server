package content.region.asgarnia.burthorpe.dialogue;

import core.game.dialogue.DialoguePlugin;
import core.game.dialogue.FacialExpression;
import core.game.node.entity.npc.NPC;
import core.plugin.Initializable;
import core.game.node.entity.player.Player;

/**
 * Represnts the dialogue plugin used for dunstan.
 * @author 'Vexia
 * @version 1.0
 */
@Initializable
public final class DunstanDialogue extends DialoguePlugin {

	/**
	 * Constructs a new {@code DunstanDialogue} {@code Object}.
	 */
	public DunstanDialogue() {
		/**
		 * empty.
		 */
	}

	/**
	 * Constructs a new {@code DunstanDialogue} {@code Object}.
	 * @param player the player.
	 */
	public DunstanDialogue(Player player) {
		super(player);
	}

	@Override
	public DialoguePlugin newInstance(Player player) {
		return new DunstanDialogue(player);
	}

	@Override
	public boolean open(Object... args) {
		npc = (NPC) args[0];
		interpreter.sendDialogues(player, FacialExpression.HALF_GUILTY, "Hi!");
		stage = 0;
		return true;
	}

	@Override
	public boolean handle(int interfaceId, int buttonId) {
		switch (stage) {
		case 0:
			interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "Hi! Did you want something?");
			stage = 1;
			break;
		case 1:
			interpreter.sendOptions("Select an Option", "Is it OK if I use your anvil?", "Nothing, thanks.");
			stage = 2;
			break;
		case 2:
			switch (buttonId) {
			case 1:
				interpreter.sendDialogues(player, FacialExpression.HALF_GUILTY, "Is it OK if I use your anvil?");
				stage = 10;
				break;
			case 2:
				interpreter.sendDialogues(player, FacialExpression.HALF_GUILTY, "Nothing, thanks.");
				stage = 20;
				break;
			}
			break;
		case 10:
			interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "So you're a smithy are you?");
			stage = 11;
			break;
		case 11:
			interpreter.sendDialogues(player, FacialExpression.HALF_GUILTY, "I dabble.");
			stage = 12;
			break;
		case 12:
			interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "A fellow smith is welcome to use my anvil!");
			stage = 13;
			break;
		case 13:
			interpreter.sendDialogues(player, FacialExpression.HALF_GUILTY, "Thanks!");
			stage = 14;
			break;
		case 14:
			end();
			break;
		case 20:
			end();
			break;
		}
		return true;
	}

	@Override
	public int[] getIds() {
		return new int[] { 1082 };
	}
}
