package com.df.drs.base.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuan
 * @project drs
 * @description 微信登录的工具类
 * @date 2020/5/26 18:32
 **/
public class WeChatUtils {
    // 获取openid的url
    public static final String WX_URL = "https://api.weixin.qq.com/sns/jscode2session";
    // 小程序的appID
    public static final String APP_ID = "wxde593dd7a3928f77";
    // 小程序的secret
    public static final String SECRET = "fa721cda77f0b042e052aabe1e523063";
    // 授权码模式
    public static final String GRANT_TYPE = "authorization_code";

    /**
     * 获取openId和sessionKey
     *
     * @param code
     * @return
     */
    public static JSONObject getSessionKeyOrOpenId(String code) {
        Map<String, String> params = new HashMap<>();
        // 设置post请求的参数
        params.put("appid", APP_ID);
        params.put("secret", SECRET);
        params.put("grant_type", GRANT_TYPE);
        params.put("js_code", code);
        // String转为Json
        JSONObject jsonObject = JSON.parseObject(HttpClientUtils.doPost(WX_URL, params));
        return jsonObject;
    }

    /**
     * 获取用户信息
     *
     * @param encryptedData
     * @param sessionKey
     * @param iv
     * @return
     */
//    public static JSONObject getUserInfo(String encryptedData, String sessionKey, String iv) {
//        // 被加密的数据
//        byte[] dataByte = Base64.decode(encryptedData);
//        // 加密秘钥
//        byte[] keyByte = Base64.decode(sessionKey);
//        // 加密算法向量
//        byte[] ivByte = Base64.decode(iv);
//        try {
//            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
//            int base = 16;
//            if (keyByte.length % base != 0) {
//                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
//                byte[] temp = new byte[groups * base];
//                Arrays.fill(temp, (byte) 0);
//                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
//                keyByte = temp;
//            }
//            // 初始化
//            Security.addProvider(new BouncyCastleProvider());
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
//            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
//            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
//            parameters.init(new IvParameterSpec(ivByte));
//
//            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
//            byte[] resultByte = cipher.doFinal(dataByte);
//            if (null != resultByte && resultByte.length > 0) {
//                String result = new String(resultByte, "UTF-8");
//                return JSON.parseObject(result);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
