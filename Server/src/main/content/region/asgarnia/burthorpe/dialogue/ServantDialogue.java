package content.region.asgarnia.burthorpe.dialogue;

import core.game.dialogue.DialoguePlugin;
import core.game.dialogue.FacialExpression;
import core.game.node.entity.npc.NPC;
import core.plugin.Initializable;
import core.game.node.entity.player.Player;

/**
 * Handles the ServantDialogue dialogue.
 * @author 'Vexia
 */
@Initializable
public class ServantDialogue extends DialoguePlugin {

	public ServantDialogue() {

	}

	public ServantDialogue(Player player) {
		super(player);
	}

	@Override
	public DialoguePlugin newInstance(Player player) {

		return new ServantDialogue(player);
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
			interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "Hi!");
			stage = 1;
			break;
		case 1:
			interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "Look, I'd better not talk. I'll get in trouble.");
			stage = 2;
			break;
		case 2:
			interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "If you want someone to show you round the castle ask", "Eohric, the Head Servant.");
			stage = 3;
			break;
		case 3:
			end();
			break;
		}
		return true;
	}

	@Override
	public int[] getIds() {
		return new int[] { 1081 };
	}
}
