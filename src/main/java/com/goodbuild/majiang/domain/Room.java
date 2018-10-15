package com.goodbuild.majiang.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: xue.l
 * @Date: 2018/10/11 15:10
 * @Description: 房间
 * @Version: 1.0.0
 */
public class Room implements Serializable {

    private Long id;

    private User owner;

    private final CopyOnWriteArraySet<User> players;

    public Room() {
        players = new CopyOnWriteArraySet();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addPlayer(User player) {
        players.add(player);
    }

    public Set<User> getPlayers() {
        return Collections.unmodifiableSet(players);
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
