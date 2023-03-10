package content.global.skill.summoning.familiar;

import core.game.dialogue.DialoguePlugin;
import core.game.dialogue.FacialExpression;
import core.game.node.entity.npc.NPC;
import core.plugin.Initializable;
import core.game.node.entity.player.Player;

/**
 * Handles the beaver dialgoue.
 * @author Empathy
 *
 */
@Initializable
public final class BeaverDialogue extends DialoguePlugin {

		/**
		 * Constructs a new {@code BeaverDialogue} {@code Object}.
		 */
		public BeaverDialogue() {
			/**
			 * empty.
			 */
		}

		/**
		 * Constructs a new {@code BeaverDialogue} {@code Object}.
		 * 
		 * @param player the player.
		 */
		public BeaverDialogue(Player player) {
			super(player);
		}

		@Override
		public DialoguePlugin newInstance(Player player) {
			return new BeaverDialogue(player);
		}

		@Override
		public boolean open(Object... args) {
			npc = (NPC) args[0];
			interpreter.sendDialogues(player, FacialExpression.HALF_GUILTY, "How much wood would a woodchuck chuck if a", "woodchuck could chuck wood?");
			stage = 0;
			return true;
		}

		@Override
		public boolean handle(int interfaceId, int buttonId) {
			switch (stage) {
			case 0:
				interpreter.sendDialogues(npc, FacialExpression.HALF_GUILTY, "Approximately 32,768 depending on his woodcutting", "level.");
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
			return new int[] { 8635 };
		}
	}
