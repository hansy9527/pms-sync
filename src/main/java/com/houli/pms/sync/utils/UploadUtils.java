package com.houli.pms.sync.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Objects;

/**
 * 文件上传 utils
 *
 * @author 98285
 * @version v2.0
 * @className UploadUtils
 * @description TODO
 * @date 2021/3/19
 */
public class UploadUtils {


    /**
     * 本地服务器存储文件
     *
     * @param file          上传文件
     * @param directoryPath 保存文件路径
     * @param fileName      文件名称
     * @return
     */
    public static boolean localServersStorageFile(MultipartFile file, String directoryPath, String fileName) {

        FileOutputStream out = null;
        try {


//            System.out.println(fileName);
            // 获取文件存放地址
            File f = new File(directoryPath);
            if (!f.exists()) {
                // 不存在路径则进行创建
                FileUtil.mkdir(directoryPath);
            }
            // 重新自定义文件的名称
            directoryPath = directoryPath + fileName;
            out = new FileOutputStream(directoryPath);
            out.write(file.getBytes());
            out.flush();
            out.close();

            return true;

        } catch (Exception e) {

        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }


    /**
     * 生成文件名称
     *
     * @param originalFilename 原文件名称
     * @param stringBuilder    字符串拼接
     * @return String           文件名称
     */
    public static String generateFileName(String originalFilename, StringBuilder stringBuilder) {
        // 文件后缀
        String suffix = Objects.requireNonNull(originalFilename).substring(originalFilename.lastIndexOf("."));
        return stringBuilder.append(IdUtil.objectId()).append(Long.toHexString(System.currentTimeMillis())).append(suffix).toString();
    }

    /**
     * 生成文件保存的路径
     * @param stringBuilder
     * @return
     */
    public static String generateDirectoryPath(StringBuilder stringBuilder) {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DAY_OF_MONTH);
        String monthStr = String.format("%02d", month);
        return stringBuilder.append(year).append("/").append(monthStr).append("/").append(day).append("/").toString();

    }
}
