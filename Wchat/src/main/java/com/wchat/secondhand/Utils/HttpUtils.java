package com.wchat.secondhand.Utils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class HttpUtils {
    public static Map<String, Object> getWxUserOpenid(String code, String APPID, String APPSecret) {
            //拼接url
            StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
            url.append("appid=");//appid设置
            url.append(APPID);
            url.append("&secret=");//secret设置
            url.append(APPSecret);
            url.append("&js_code=");//code设置
            url.append(code);
            url.append("&grant_type=authorization_code");
            Map<String, Object> map = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();//构建一个Client

            HttpGet get = new HttpGet(url.toString());    //构建一个GET请求
            HttpResponse response = client.execute(get);//提交GET请求
            HttpEntity result = response.getEntity();//拿到返回的HttpResponse的"实体"
            String content = EntityUtils.toString(result);
            JSONObject res = new JSONObject(content); // 将字符串封装成一个json 数据
            //把信息封装到map
//            map = DataCvgUtils.parseJSON2Map(res);//这个小工具的代码在下面
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
