package com.df.drs.base.utils;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yuan
 * @project drs
 * @description 文件上传工具类
 * @date 2020/5/29 10:13
 **/
public class FileUploadUtils {

    /**
     * 单文件上传
     * @param file
     * @return
     */
    public static boolean fileUpload(MultipartFile file) {
        // 文件为空
        if (file.isEmpty()) {
            return false;
        }

        // 文件名
        String fileName = getFileName(file.getOriginalFilename());
        // 文件大小
        int fileSize = (int) file.getSize();
        System.out.println("上传的文件名："+fileName+",文件大小："+fileSize+"B");

        // 保存的目录
        String path = getUploadPath();
        System.out.println("文件路径"+path);
        File dest = new File(path + "/" + fileName);
//        // 父级目录不存在则创建
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdir();
//        }

        // 保存文件
        try {
            file.transferTo(dest);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 多文件上传
     * @param request
     * @return
     */
    public static boolean multifileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("fileName");

        if (files.isEmpty()) {
            return false;
        }

        for (MultipartFile file: files) {
            // 调用单文件上传
            fileUpload(file);
        }

        return true;
    }

    /**
     * 文件名后缀前加一个时间戳
     * @param fileName
     * @return
     */
    private static String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");
        String nowStr = sdf.format(new Date());
        fileName = fileName.substring(0,index)+"_"+nowStr+fileName.substring(index);
        return fileName;
    }

    /**
     * 获取系统路径
     * @return
     */
    private static String getUploadPath() {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (!path.exists()) {
            path = new File("");
        }
        File upload = new File(path.getAbsolutePath(), "static/upload");
        if (!upload.exists()) {
            upload.mkdirs();
        }
        return upload.getAbsolutePath();
    }
}
