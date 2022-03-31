package com.henri.kbe.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestSftpFileTransfer implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
/*
    @Autowired
    private FileTransferService fileTransferService;

    private Logger logger = LoggerFactory.getLogger(TestSftpFileTransfer.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Start upload file");
        boolean isUploaded = fileTransferService.uploadFile("./readme.txt", "/readme.txt");
        logger.info("Upload result: " + String.valueOf(isUploaded));
        logger.info("Start download file");
        boolean isDownloaded = fileTransferService.downloadFile("./readme2.txt", "/readme.txt");
        logger.info("Download result: " + String.valueOf(isDownloaded));

    }


 */
}
