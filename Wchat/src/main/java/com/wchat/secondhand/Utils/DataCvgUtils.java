package com.wchat.secondhand.Utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

/**
 * 进行数据间的转换
 */
public class DataCvgUtils {
    /**
     * 将json 数据转换为Map
     * @param json
     * @return Map
     */
//    public static Map<String, Object> parseJSON2Map(JSONObject json) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        // 最外层解析
//        for (Object k : json.keySet()) {
//            Object v = json.get((String) k);
//            if (v instanceof JSONArray) {   // 如果内层还是数组的话，继续解析
//                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//                @SuppressWarnings("unchecked")  //  @SuppressWarnings 用于抑制警告
//                Iterator<JSONObject> it = ((JSONArray) v).iterator();
//                while (it.hasNext()) {
//                    JSONObject json2 = it.next();
//                    list.add(parseJSON2Map(json2));
//                }
//                map.put(k.toString(), list);
//            } else {
//                map.put(k.toString(), v);
//            }
//        }
//        return map;
//    }
}
