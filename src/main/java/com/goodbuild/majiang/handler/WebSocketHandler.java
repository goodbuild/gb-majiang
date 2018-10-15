package com.goodbuild.majiang.handler;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;

/**
 * @Author: xue.l
 * @Date: 2018/10/12 11:22
 * @Description:
 * @Version: 1.0.0
 */
public interface WebSocketHandler<T> {

    void connectHandle(SocketIOClient client);

    void disConnectHandle(SocketIOClient client);

    void messageHandle(SocketIOClient client, AckRequest request, T message);
}
