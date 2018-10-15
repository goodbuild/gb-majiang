package com.goodbuild.majiang.domain;

import com.corundumstudio.socketio.SocketIOClient;
import com.goodbuild.majiang.game.GamePlayer;

import java.io.Serializable;

/**
 * @Author: xue.l
 * @Date: 2018/10/11 17:09
 * @Description:
 * @Version: 1.0.0
 */
public class User extends GamePlayer implements Serializable {

    private String username;

    private SocketIOClient client;



    public User(Long userId, int scores) {
        super(userId, scores);
    }

    public User(Long userId, int scores, String username) {
       this(userId, scores);
        this.username = username;
    }

    public SocketIOClient getClient() {
        return client;
    }

    public void setClient(SocketIOClient client) {
        this.client = client;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
