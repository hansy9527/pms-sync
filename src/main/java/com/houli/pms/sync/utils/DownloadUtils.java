package com.houli.pms.sync.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @ClassName DownloadUtils
 * @Deacription TODO
 * @Author Admin
 * @Date 2021/11/15 下午5:30
 * @Version 1.0
 **/
public class DownloadUtils {

    public static void download(String fileRealPath, HttpServletResponse res) throws IOException {
        // 发送给客户端的数据
        OutputStream outputStream = res.getOutputStream();
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        // 读取filename
        bis = new BufferedInputStream(new FileInputStream(new File(fileRealPath)));
        int i = bis.read(buff);
        while (i != -1) {
            outputStream.write(buff, 0, buff.length);
            outputStream.flush();
            i = bis.read(buff);
        }
    }
}
