package core.game.global.action;

import core.game.node.entity.player.Player;

interface LadderAchievementCheck {
    default void checkAchievement(Player player) {
        return;
    }
}
