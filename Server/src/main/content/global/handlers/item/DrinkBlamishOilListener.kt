package content.global.handlers.item

import core.api.*
import org.rs09.consts.Items
import core.game.interaction.InteractionListener
import core.game.interaction.IntType

class DrinkBlamishOilListener : InteractionListener {

    override fun defineListeners() {
        on(Items.BLAMISH_OIL_1582, IntType.ITEM, "drink"){ player, _ ->
            sendPlayerDialogue(player, "You know... I'd really rather not.")
            return@on true
        }
    }
}