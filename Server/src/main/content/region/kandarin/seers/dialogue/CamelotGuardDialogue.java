package content.region.kandarin.seers.dialogue;

import core.game.dialogue.DialoguePlugin;
import core.game.dialogue.FacialExpression;
import core.game.node.entity.npc.NPC;
import core.plugin.Initializable;
import core.game.node.entity.player.Player;

/**
 * Represents the dialogue plugin used for the camelot guards.
 * @author 'Vexia
 * @version 1.0
 */
@Initializable
public final class CamelotGuardDialogue extends DialoguePlugin {

	/**
	 * Constructs a new {@code CamelotGuardDialogue} {@code Object}.
	 */
	public CamelotGuardDialogue() {
		/**
		 * empty.
		 */
	}

	public CamelotGuardDialogue(Player player) {
		super(player);
	}

	@Override
	public DialoguePlugin newInstance(Player player) {
		return new CamelotGuardDialogue(player);
	}

	@Override
	public boolean open(Object... args) {
		npc = (NPC) args[0];
		interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "Welcome to the Seer's Village courthouse. Court", "is not in session today, so you're not allowed downstairs.");
		stage = 0;
		return true;
	}

	@Override
	public boolean handle(int interfaceId, int buttonId) {
		switch (stage) {
		case 0:
			end();
			break;
		}
		return true;
	}

	@Override
	public int[] getIds() {
		return new int[] { 812 };
	}
}
