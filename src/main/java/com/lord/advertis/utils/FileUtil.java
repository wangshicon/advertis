package com.lord.advertis.utils;

import java.io.File;

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
}
