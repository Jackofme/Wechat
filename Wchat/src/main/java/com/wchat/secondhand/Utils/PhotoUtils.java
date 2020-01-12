package com.wchat.secondhand.Utils;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Component
public class PhotoUtils {
    /**
     * 将图片存储到文件夹中
     * @param file
     * @return 图片的位置
     * @throws IOException
     */
    public static String storagePhoto(MultipartFile file){
        // 下面这个地址的获取，后期需要自己去试，然后才可以处理
        String path = System.getProperty("user.dir") + "/src/main/resources/img";   // 获取项目图片存储路径
        String fileName = file.getOriginalFilename();//获取到上传文件的名字  (可能会出现文件重名)
        File dir = new File(path,fileName);  // 创建一个文件地址，一个文件地址的引用
        if(!dir.exists()){
            dir.mkdirs(); // 文件名不存在则直接创建一个相应的文件夹
        }
        try{
            file.transferTo(dir); // 将文件转移到这个文件地址，也就是存储到这个文件里面
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("图片存储异常");
        }
        return path + fileName;
    }
}
