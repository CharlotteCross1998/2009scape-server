package content.region.morytania.canifis.dialogue;

import core.game.dialogue.DialoguePlugin;
import core.game.dialogue.FacialExpression;
import core.game.node.entity.npc.NPC;
import core.plugin.Initializable;
import core.game.node.entity.player.Player;

/**
 * Represents the dialogue used for malak.
 * @author 'Vexia
 * @version 1.0
 */
@Initializable
public class MalakDialogue extends DialoguePlugin {

	/**
	 * Constructs a new {@code MalakDialogue} {@code Object}.
	 */
	public MalakDialogue() {
		/**
		 * empty.
		 */
	}

	/**
	 * Constructs a new {@code MalakDialogue} {@code Object}.
	 * @param player the player.
	 */
	public MalakDialogue(Player player) {
		super(player);
	}

	@Override
	public DialoguePlugin newInstance(Player player) {
		return new MalakDialogue(player);
	}

	@Override
	public boolean open(Object... args) {
		npc = (NPC) args[0];
		interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "Away from me, dog.", "I have business to discuss with the barkeeper.");
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
		return new int[] { 1920 };
	}
}
