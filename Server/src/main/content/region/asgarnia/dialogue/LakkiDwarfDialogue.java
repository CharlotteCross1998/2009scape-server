package content.region.asgarnia.dialogue;

import core.game.dialogue.DialoguePlugin;
import core.game.dialogue.FacialExpression;
import core.game.node.entity.npc.NPC;
import core.plugin.Initializable;
import core.game.node.entity.player.Player;

/**
 * Represents the dialogue used for lakki the dwarf npc. (holder dialogue until
 * quest)
 * @author 'Vexia
 * @version 1.0
 */
@Initializable
public final class LakkiDwarfDialogue extends DialoguePlugin {

	/**
	 * Constructs a new {@code LakkiDwarfDialogue} {@code Object}.
	 */
	public LakkiDwarfDialogue() {
		/**
		 * empty.
		 */
	}

	/**
	 * Constructs a new {@code LakkiDwarfDialogue} {@code Object}.
	 * @param player the player.
	 */
	public LakkiDwarfDialogue(Player player) {
		super(player);
	}

	@Override
	public DialoguePlugin newInstance(Player player) {
		return new LakkiDwarfDialogue(player);
	}

	@Override
	public boolean open(Object... args) {
		npc = (NPC) args[0];
		interpreter.sendDialogues(player, FacialExpression.HALF_GUILTY, "Hello!");
		stage = 0;
		return true;
	}

	@Override
	public boolean handle(int interfaceId, int buttonId) {
		switch (stage) {
		case 0:
			interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "I'm sorry, I can't talk right now.");
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
		return new int[] { 7722 };
	}
}
