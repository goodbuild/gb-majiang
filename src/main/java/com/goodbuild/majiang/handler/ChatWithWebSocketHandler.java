package com.goodbuild.majiang.handler;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.goodbuild.majiang.domain.PlayInfoList;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;

/**
 * @Author: xue.l
 * @Date: 2018/10/12 11:20
 * @Description:
 * @Version: 1.0.0
 */
@Service
@ServerEndpoint("/chatweth")
public class ChatWithWebSocketHandler extends AbstractWebSocketHandler<Object> {

    @Override
    protected void doConnect(SocketIOClient client, PlayInfoList playInfoList) {
        super.doConnect(client, playInfoList);
    }

    @Override
    public void messageHandle(SocketIOClient client, AckRequest request, Object message) {

    }
}
