package content.region.misthalin.varrock.dialogue;

import core.game.dialogue.DialoguePlugin;
import core.game.dialogue.FacialExpression;
import core.game.node.entity.npc.NPC;
import core.plugin.Initializable;
import core.game.node.entity.player.Player;

/**
 * Represents the dialogue plugin used for ambassador fernook.
 * @author 'Vexia
 * @version 1.0
 */
@Initializable
public final class AmbassadorFernook extends DialoguePlugin {

	/**
	 * Constructs a new {@code AmbassadorFernook} {@code Object}.
	 */
	public AmbassadorFernook() {
		/**
		 * empty.
		 */
	}

	/**
	 * Constructs a new {@code AmbassadorFernook} {@code Object}.
	 * @param player the player.
	 */
	public AmbassadorFernook(Player player) {
		super(player);
	}

	@Override
	public DialoguePlugin newInstance(Player player) {
		return new AmbassadorFernook(player);
	}

	@Override
	public boolean open(Object... args) {
		npc = (NPC) args[0];
		interpreter.sendDialogues(player, FacialExpression.HALF_GUILTY, "Hello Ambassador. Are you here visiting King Roald?");
		stage = 0;
		return true;
	}

	@Override
	public boolean handle(int interfaceId, int buttonId) {
		switch (stage) {
		case 0:
			interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "Well, in theory, but he always seems to be busy.");
			stage = 1;
			break;
		case 1:
			interpreter.sendDialogues(player, FacialExpression.HALF_GUILTY, "You don't seem that upset by that, though...");
			stage = 2;
			break;
		case 2:
			interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "Oh no, I like travelling, and if you become a diplomat", "patience is a vital skill.");
			stage = 3;
			break;
		case 3:
			interpreter.sendDialogues(player, FacialExpression.HALF_GUILTY, "I'll try to remember that.");
			stage = 4;
			break;
		case 4:
			end();
			break;
		}
		return true;
	}

	@Override
	public int[] getIds() {
		return new int[] { 4582 };
	}
}
