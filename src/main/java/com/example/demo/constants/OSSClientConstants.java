package com.example.demo.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: lulongji
 */
public class OSSClientConstants {
    //阿里云API的外网域名
    public static final String ENDPOINT = "xx";
    //阿里云API的密钥Access Key ID
    public static final String ACCESS_KEY_ID = "xx";
    //阿里云API的密钥Access Key Secret
    public static final String ACCESS_KEY_SECRET = "xx";
    //阿里云API的bucket名称
    public static final String BACKET_NAME = "xx";
    //阿里云API的文件夹名称
    public static final String FOLDER = "xx/";
    public static final String FOLDER_VIDEO = "xx/";
    public static final String FORMAT = new SimpleDateFormat("yyyyMMdd").format(new Date());
    public static final String FORMATS = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
}