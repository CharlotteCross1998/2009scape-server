package content.region.asgarnia.burthorpe.dialogue;

import core.game.dialogue.DialoguePlugin;
import core.game.dialogue.FacialExpression;
import core.game.node.entity.npc.NPC;
import core.plugin.Initializable;
import core.game.node.entity.player.Player;

/**
 * Handles the OcaDialogue dialogue.
 * @author 'Vexia
 */
@Initializable
public class OcaDialogue extends DialoguePlugin {

	public OcaDialogue() {

	}

	public OcaDialogue(Player player) {
		super(player);
	}

	@Override
	public DialoguePlugin newInstance(Player player) {

		return new OcaDialogue(player);
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
			interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "Hello stranger.");
			stage = 1;
			break;
		case 1:
			end();
			break;
		}
		return true;
	}

	@Override
	public int[] getIds() {
		return new int[] { 1085 };
	}
}
