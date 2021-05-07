package com.gugu.port_test.service;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * @author minmin
 * @since 2021/05/07 23:19
 */
@Component
public class ListenerServer {
    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Resource
    private WebSocketService webSocketService;

    public void startListener(Integer port) {
        threadPoolTaskExecutor.submit(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                serverSocket.setSoTimeout(10 * 1000);
                Socket accept = serverSocket.accept();
                try(PrintWriter printWriter = new PrintWriter(accept.getOutputStream())) {
                    printWriter.write("Port Connection Success...");
                    printWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                webSocketService.sendMessage(String.format("Port:%s Connection Success", port));
            }catch (SocketTimeoutException socketTimeoutException){
                webSocketService.sendMessage(String.format("Port:%s No connection for ten seconds", port));
            }
            catch (Exception e) {
                webSocketService.sendMessage(e.getMessage());
            }
        });
    }
}
