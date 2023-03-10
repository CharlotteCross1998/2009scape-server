package content.region.misthalin.varrock.dialogue;

import core.game.dialogue.DialoguePlugin;
import core.game.dialogue.FacialExpression;
import core.game.node.entity.npc.NPC;
import core.plugin.Initializable;
import core.game.node.entity.player.Player;

/**
 * Handles the ValaineDialogue dialogue.
 * @author 'Vexia
 */
@Initializable
public class ValaineDialogue extends DialoguePlugin {

	public ValaineDialogue() {

	}

	public ValaineDialogue(Player player) {
		super(player);
	}

	@Override
	public DialoguePlugin newInstance(Player player) {

		return new ValaineDialogue(player);
	}

	@Override
	public boolean open(Object... args) {
		npc = (NPC) args[0];
		interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "Hello there. Want to have a look at what we're selling", "today?");
		stage = 0;
		return true;
	}

	@Override
	public boolean handle(int interfaceId, int buttonId) {
		switch (stage) {
		case 0:
			interpreter.sendOptions("Select an Option", "Yes please.", "No thank you.");
			stage = 1;
			break;
		case 1:
			switch (buttonId) {
			case 1:
				interpreter.sendDialogues(player, FacialExpression.HALF_GUILTY, "Yes please.");
				stage = 10;
				break;
			case 2:
				interpreter.sendDialogues(player, FacialExpression.HALF_GUILTY, "No thank you.");
				stage = 3;
				break;
			}
			break;
		case 3:
			end();
			break;
		case 10:
			end();
			npc.openShop(player);
			break;
		}
		return true;
	}

	@Override
	public int[] getIds() {
		return new int[] { 536 };
	}
}
