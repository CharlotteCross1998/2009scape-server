package content.global.ame.events

import content.global.ame.RandomEventNPC
import core.game.node.entity.npc.NPC
import core.tools.RandomFunction
import org.rs09.consts.NPCs
import core.api.utils.WeightBasedTable

class MysteriousOldManNPC(var type: String = "", override var loot: WeightBasedTable? = null) : RandomEventNPC(NPCs.MYSTERIOUS_OLD_MAN_410) {
    override fun init() {
        super.init()
        sayLine()
    }

    override fun tick() {
        super.tick()
        if(RandomFunction.random(1,10) == 5) sayLine()
    }

    fun sayLine() {
        when(type){
            "sexam" -> sendChat("Surprise exam, ${player.username.capitalize()}!")
        }
    }

    override fun talkTo(npc: NPC) {
        when(type){
            "sexam" -> player.dialogueInterpreter.open(MysteriousOldManDialogue("sexam"),this.asNpc())
        }
    }
}