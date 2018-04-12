package pers.hdh.sell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * WebSocketConfig class<br/>
 *
 * @author hdonghong
 * @date 2018/04/11
 */
@Component
public class WebSocketConfig {

//    由于测试环境下，没有websocket环境，所以测试的时候需要注释掉；正常启动的时候取消注释就可以了
//    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
