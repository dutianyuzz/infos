package com.siifi.infos.utils;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

public class FileUtils {
    //图片上传
    public String upload(MultipartFile file, String path, String fileName){
        // 生成新的文件名
        String realPath = path + "/" + FileNameUtils.getFileName(fileName);
/*        //使用原文件名
        String realPath = path + "/" + fileName;*/
        File dest = new File(realPath);
        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
            //保存文件
            file.transferTo(dest);
        }catch (IllegalStateException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return realPath;
    }
}
