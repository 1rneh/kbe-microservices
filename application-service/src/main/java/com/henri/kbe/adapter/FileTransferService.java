package com.henri.kbe.adapter;

import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.*;

@Service
public class FileTransferService {

    private Logger logger = LoggerFactory.getLogger(FileTransferService.class);

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

    public boolean uploadFile(String localFilePath, String remoteFilePath) {
        ChannelSftp channelSftp = createChannelSftp();
        try {
            channelSftp.put(localFilePath, remoteFilePath);
            return true;
        } catch (SftpException e) {
            logger.error("Error upload file", e);
        } finally {
            disconnectChannelSftp(channelSftp);
        }
        return false;
    }

    public boolean downloadFile(String localFilePath, String remoteFilePath) {
        ChannelSftp channelSftp = createChannelSftp();
        OutputStream outputStream;
        try {
            File file = new File(localFilePath);
            outputStream = new FileOutputStream(file);
            channelSftp.get(remoteFilePath, outputStream);
            return true;
        } catch (SftpException | FileNotFoundException e) {
            logger.error("Error download file", e);
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
            logger.error("Create ChannelSftp error", e);
        }
        return null;
    }

    private void disconnectChannelSftp(ChannelSftp channelSftp) {
        try {
            if (channelSftp == null) return;
            if (channelSftp.isConnected()) channelSftp.disconnect();
            if (channelSftp.getSession() != null) channelSftp.getSession().disconnect();
        } catch (JSchException e) {
            logger.error("SFTP disconnect error", e);
        }
    }
}
