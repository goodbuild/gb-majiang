package com.goodbuild.majiang.listener;

import com.corundumstudio.socketio.SocketIOServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author: xue.l
 * @Date: 2018/10/12 10:56
 * @Description:
 * @Version: 1.0.0
 */
@Component
public class ApplicationContextCloseListener implements ApplicationListener<ContextClosedEvent> {

    private final SocketIOServer socketIOServer;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ApplicationContextCloseListener(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;
    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        socketIOServer.stop();
        logger.info("============= Websocket server stop complete! =============");
    }
}
