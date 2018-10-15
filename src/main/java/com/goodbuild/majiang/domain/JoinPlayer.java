package com.goodbuild.majiang.domain;

import java.io.Serializable;

/**
 * @Author: xue.l
 * @Date: 2018/10/11 17:39
 * @Description:
 * @Version: 1.0.0
 */
public class JoinPlayer implements Serializable {

    private Long playerId;

    private Long roomId;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
