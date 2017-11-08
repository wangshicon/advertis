package com.lord.advertis.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 *
 * @Description: 文件上传工具类
* @author Lord
 * @date 2017年11月6日 下午6:12:29
 */
public class FileUtil {

    /**
     * 删除文件
     *
     * @param filePath
     */
    public static void deleteFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 截取文件类型
     * @author WangShiCong
     * @since 2017-11-8
     * @return afterStr
     */
    public static String subSuffix(String str){
        int i = str.lastIndexOf(".");
        str=str.substring(i, str.length());
        return str;
    }

}
