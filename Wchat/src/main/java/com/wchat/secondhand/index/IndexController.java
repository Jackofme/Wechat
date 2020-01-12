package com.wchat.secondhand.index;

import com.wchat.secondhand.Utils.PhotoUtils;
import com.wchat.secondhand.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    IndexService indexService;




    /**
     * 获取所有商品列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/index/getItemList", method = RequestMethod.GET)
    public List<Items> getItemList(){
        List<Items> list = new ArrayList<Items>();
        try{  // 数据库异常处理
            list = indexService.getItemsList();
        }catch(Exception e){
            e.printStackTrace();
        }
        for(Items items: list){
            System.out.println(items.getLocation());
        }
        return list;
    }


    /**
     * 插入商品
     * @param items
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/index/insertItems", method = RequestMethod.POST)
    public boolean insertItems(@RequestBody Items items){   // @RequestBody
            System.out.println("I am comming");

            System.out.println(items.getAddress());

            boolean status = false;
            try{
                status = indexService.insertItems(items);
            }catch(Exception e){
                e.printStackTrace();
            }
            return status;
    }


    /**
     * 上传图片
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "index/upload", method = RequestMethod.POST)
    public String upFile(@RequestBody  MultipartFile file, HttpServletRequest request)throws IOException {
        String path = System.getProperty("user.dir") + "/src/main/resources/img";   // 获取项目图片存储路径

        System.out.println(request.getSession().getServletContext());

//      String path = request.getSession().getServletContext().getRealPath("upload");

        String fileName = file.getOriginalFilename();//获取到上传文件的名字  (可能会出现文件重名)

        File dir = new File(path,fileName);  // 创建一个文件地址，一个文件地址的引用

        if(!dir.exists()){
            dir.mkdirs(); // 文件名不存在则直接创建一个相应的文件夹
        }
        file.transferTo(dir); // 将文件转移到这个文件地址，也就是存储到这个文件里面

        return "/upload"+"/"+fileName;

    }

    @ResponseBody
    @RequestMapping(value = "index/uploadItem", method = RequestMethod.POST)
    public boolean upLoadItems(Items items, @RequestParam(value = "file") MultipartFile file){
        /*
        1、 将图片存储到文件夹
        2、将图片地址存储到Items类中
        3、将东西存储到数据库中
         */
        String address = null;
        address = PhotoUtils.storagePhoto(file);
        items.setAddress(address);
        boolean answer = indexService.insertItems(items);
        return answer;
    }
}
