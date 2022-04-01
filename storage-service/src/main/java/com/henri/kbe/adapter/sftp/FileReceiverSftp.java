package com.henri.kbe.adapter.sftp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.jcraft.jsch.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

@Service
public class FileReceiverSftp {
/*
    @Value("${sftp.host}")
    private String host;

    @Value("${sftp.port}")
    private Integer port;

    @Value("${sftp.username}")
    private String username;

    @Value("${sftp.password}")
    private String password;

    @Value("${sftp.sessionTimeout}")
    private Integer sessionTimeout;

    @Value("${sftp.channelTimeout}")
    private Integer channelTimeout;

    public boolean downloadFile(String localFilePath, String remoteFilePath) {
        ChannelSftp channelSftp = createChannelSftp();
        OutputStream outputStream;
        try {
            File file = new File(localFilePath);
            outputStream = new FileOutputStream(file);
            channelSftp.get(remoteFilePath, outputStream);
            return true;
        } catch (SftpException | FileNotFoundException e) {
        } finally {
            disconnectChannelSftp(channelSftp);
        }
        return false;
    }

    private ChannelSftp createChannelSftp() {

        try {
            JSch jSch = new JSch();
            Session session = jSch.getSession(username, host, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(password);
            session.connect(sessionTimeout);
            Channel channel = session.openChannel("sftp");
            channel.connect(channelTimeout);
            return (ChannelSftp) channel;
        } catch (JSchException e) {
        }
        return null;
    }

    private void disconnectChannelSftp(ChannelSftp channelSftp) {
        try {
            if (channelSftp == null) return;
            if (channelSftp.isConnected()) channelSftp.disconnect();
            if (channelSftp.getSession() != null) channelSftp.getSession().disconnect();
        } catch (JSchException e) {
        }
    }

 */
}
