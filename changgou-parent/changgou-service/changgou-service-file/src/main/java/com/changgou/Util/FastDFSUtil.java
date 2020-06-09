package com.changgou.Util;
/*
 * 上传 下载 删除 信息获取 storage/tracker信息获取
 * */

import com.changgou.File.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;


public class FastDFSUtil {

    /*加载tracker链接信息*/
    static {
        try {
            String filename = new ClassPathResource("fdfs_client.conf").getPath();
            ClientGlobal.init(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String[] upload(FastDFSFile file) throws IOException, MyException {
        // 附加信息
//        NameValuePair[] pair = new NameValuePair[1];
//        pair[0] = new NameValuePair("author", file.getAuthor());
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return storageClient.upload_file(file.getContent(), file.getExt(), null);
        // http://192.168.0.108:8080:/group1/M00/00/00/wKgAbF7fLz6AQjMlAAHUSSqbwWg854.jpg
    }

}
