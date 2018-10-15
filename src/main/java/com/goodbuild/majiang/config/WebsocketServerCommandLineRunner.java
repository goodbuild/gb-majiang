package com.goodbuild.majiang.config;

import com.corundumstudio.socketio.SocketIOServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.stereotype.Component;

/**
 * @Author: xue.l
 * @Date: 2018/10/12 10:31
 * @Description:
 * @Version: 1.0.0
 */
@Component
public class WebsocketServerCommandLineRunner implements CommandLineRunner {

    private final SocketIOServer socketIOServer;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public WebsocketServerCommandLineRunner(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;
    }

    @Override
    public void run(String... args) throws Exception {
        socketIOServer.start();
        logger.info("================= Websocket server startup completed! ================");
    }
}
