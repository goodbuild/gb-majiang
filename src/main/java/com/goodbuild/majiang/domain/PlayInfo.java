package com.goodbuild.majiang.domain;

import com.goodbuild.majiang.game.baseMajiang.BasePlayImpl;

/**
 * @Author: xue.l
 * @Date: 2018/10/12 13:52
 * @Description:
 * @Version: 1.0.0
 */
public class PlayInfo extends BasePlayImpl {

    private Long playId;

    private User owner;

    public PlayInfo(int maxNumberByGame, Long playId, User owner) {
        super(maxNumberByGame);
        this.playId = playId;
        this.owner = owner;
    }

    public Long getPlayId() {
        return playId;
    }

    public void setPlayId(Long playId) {
        this.playId = playId;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
