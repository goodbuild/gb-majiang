package com.goodbuild.majiang.handler;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.goodbuild.majiang.domain.PlayInfo;
import com.goodbuild.majiang.domain.PlayInfoList;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xue.l
 * @Date: 2018/10/12 11:25
 * @Description:
 * @Version: 1.0.0
 */
public abstract class AbstractWebSocketHandler<T> implements WebSocketHandler<T>, ApplicationContextAware {

    private SocketIOServer socketIOServer;

    private final ConcurrentHashMap<AbstractWebSocketHandler<T>, PlayInfoList> WEBSOCKET_HANDLER_CACHE = new ConcurrentHashMap<>();

    @Override
    @OnConnect
    public final void connectHandle(SocketIOClient client) {
        PlayInfoList newPlayInfoList = new PlayInfoList();
        PlayInfoList playInfoList = WEBSOCKET_HANDLER_CACHE.putIfAbsent(this,newPlayInfoList);
        if (playInfoList == null) {
            playInfoList = newPlayInfoList;
        }
        doConnect(client, playInfoList);
    }

    @Override
    @OnDisconnect
    public void disConnectHandle(SocketIOClient client) {
        doDisConnect(client, WEBSOCKET_HANDLER_CACHE.get(this));
    }


    protected  void doConnect(SocketIOClient client, PlayInfoList playInfoList){}

    protected  void doDisConnect(SocketIOClient client, PlayInfoList playInfoList){}

    protected PlayInfoList getWebSocketCache(AbstractWebSocketHandler<T> socketHandler) {
       return WEBSOCKET_HANDLER_CACHE.get(socketHandler);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        socketIOServer = applicationContext.getBean(SocketIOServer.class);
    }
}
