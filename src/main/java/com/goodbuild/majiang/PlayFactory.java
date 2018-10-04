package com.goodbuild.majiang;


import com.goodbuild.majiang.game.Play;
import com.goodbuild.majiang.game.baseMajiang.BasePlayImpl;

public class PlayFactory {

    /**
     * 基础玩法
     * @return
     */
    public static Play createBasePlay(int maxNumberByGame) {
        return new BasePlayImpl(maxNumberByGame);
    }
}
