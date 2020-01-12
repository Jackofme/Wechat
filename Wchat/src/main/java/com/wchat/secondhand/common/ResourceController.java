package com.wchat.secondhand.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Controller
public class ResourceController {
    /**
     * 专门用来获取静态资源中的图像信息 Img
     * @param photo
     * @return
     * @throws IOException
     */
        @RequestMapping(value = "/common/getPhoto", method = RequestMethod.GET)
        public BufferedImage getPhoto(@RequestParam(value = "photo") String photo) throws IOException {
            BufferedImage img = null;
            File file = null;
            System.out.println("检查输入的地址");
            System.out.println(System.getProperty("user.dir") + "/src/main/resources/img/" + photo);
            file = new File(System.getProperty("user.dir") + "/src/main/resources/img/" + photo);
            if(file.exists()){
                System.out.println("THE PATH IS EXIST");
            }else{
                System.out.println("THE PATH IS NOT EXIST");
            }
            img = ImageIO.read(file);
        return img;
    }
}
