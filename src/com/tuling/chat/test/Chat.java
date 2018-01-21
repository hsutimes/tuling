package com.tuling.chat.test;

import com.tuling.chat.util.Aes;
import com.tuling.chat.util.Md5;
import com.tuling.chat.util.PostServer;
import org.json.JSONObject;

/**
 * 图灵问答机器人
 *
 * @author hsutimes
 * 语音api接口
 * // http://fanyi.baidu.com/gettts?lan=en&text=Turing&spd=3&source=web
 * // http://fanyi.baidu.com/gettts?lan=zh&text=Turing&spd=3&source=web
 */
public class Chat {
    private String userId;

    public Chat() {
        userId = setUserId();
    }

    public JSONObject getReplay(String str) {
        // apiKey
        String apiKey = "e5e1946deae848259415a7d0b7a69ff2";

        // 发送json请求
        JSONObject json = new JSONObject();
        json.put("key", apiKey);
        json.put("info", str);
        json.put("userid", userId);

        // 请求图灵api
        String result = PostServer.SendPost(json.toString(), "http://www.tuling123.com/openapi/api");
        JSONObject obj = new JSONObject(result);
        return obj;
    }

    private String setUserId() {
        String id = "";
        for (int i = 0; i < 32; i++) {
            id += (int) (Math.random() * 10) + "";
        }
        return id;
    }
}