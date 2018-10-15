package com.goodbuild.majiang.handler;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.goodbuild.majiang.domain.PlayInfo;
import com.goodbuild.majiang.domain.PlayInfoList;
import com.goodbuild.majiang.domain.User;
import com.goodbuild.majiang.game.GamePlayer;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

/**
 * @Author: xue.l
 * @Date: 2018/10/12 11:10
 * @Description:
 * @Version: 1.0.0
 */
@Service
@ServerEndpoint("/room")
public class RoomWebScoketHandler extends AbstractWebSocketHandler<Object> {

    @Override
    protected void doConnect(SocketIOClient client, PlayInfoList playInfoList) {
        try {
            if (client.getHandshakeData().getUrlParams().get("userId") == null) {
                return;
            }
            String userId = client.getHandshakeData().getUrlParams().get("userId").get(0);
            if (client.getHandshakeData().getUrlParams().get("playId") != null) {
                String playId = client.getHandshakeData().getUrlParams().get("playId").get(0);
                PlayInfo playInfo = playInfoList.getPlayInfo(Long.parseLong(playId));

                User user = new User(Long.parseLong(userId), 100, userId);
                user.setClient(client);
                playInfo.addGamePlayer(user);
            } else {
                User user = new User(Long.parseLong(userId), 100, userId);
                user.setClient(client);
                PlayInfo playInfo = playInfoList.addPlayInfo(new PlayInfo(8, 0L, user));
                playInfo.addGamePlayer(user);
                client.sendEvent("receiveConnect", playInfo.getPlayId());
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }


    @Override
    @OnEvent("messageevent")
    public void messageHandle(SocketIOClient client, AckRequest request, Object message) {
        PlayInfoList playInfoList = getWebSocketCache(this);
        PlayInfo playInfo = playInfoList.getPlayInfo(0L);
        List<GamePlayer> gamePlayers = playInfo.getGamePlayers();
    }
}
