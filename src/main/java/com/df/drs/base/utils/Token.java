package com.df.drs.base.utils;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import net.minidev.json.JSONObject;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Token
 * @Description
 * @Date 2019/12/2 9:43
 * @author Liu Yaoguang
 */
public class Token {

    private static final byte[] secret = "smapadqweasdzxcmmasdsadsaasasasewcdsxz".getBytes();


    //生成一个token
    public static String creatToken(Map<String,Object> payloadMap) throws JOSEException {

        //3.先建立一个头部Header
        /**
         * JWSHeader参数：1.加密算法法则,2.类型，3.。。。。。。。
         * 一般只需要传入加密算法法则就可以。
         * 这里则采用HS256
         *
         * JWSAlgorithm类里面有所有的加密算法法则，直接调用。
         */
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);

        //建立一个载荷Payload
        Payload payload = new Payload(new JSONObject(payloadMap));

        //将头部和载荷结合在一起
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        //建立一个密匙

        JWSSigner jwsSigner = new MACSigner(secret);

        //签名
        jwsObject.sign(jwsSigner);

        //生成token
        return jwsObject.serialize();
    }



    public static Map<String,Object> valid(String token) throws ParseException, JOSEException {

//        解析token
        JWSObject jwsObject = JWSObject.parse(token);

        //获取到载荷
        Payload payload=jwsObject.getPayload();

        //建立一个解锁密匙
        JWSVerifier jwsVerifier = new MACVerifier(secret);

        Map<String, Object> resultMap = new HashMap<>();
        //判断token
        if (jwsObject.verify(jwsVerifier)) {
            resultMap.put("Result", 0);
            //载荷的数据解析成json对象。
            JSONObject jsonObject = payload.toJSONObject();
            resultMap.put("data", jsonObject);

            //判断token是否过期
            if (jsonObject.containsKey("exp")) {
                Long expTime = Long.valueOf(jsonObject.get("exp").toString());
                Long nowTime = System.currentTimeMillis();
                //判断是否过期
                if (nowTime > expTime) {
                    //已经过期
                    resultMap.clear();
                    resultMap.put("Result", 2);

                }
            }
        }else {
            resultMap.put("Result", 1);
        }
        return resultMap;

    }

//    //生成token的业务逻辑
//    public static String TokenTest(String uid) {
//        //获取生成token
//        Map<String, Object> map = new HashMap<>();
//        //建立载荷，这些数据根据业务，自己定义。
//        map.put("uid", uid);
//        //生成时间
//        map.put("sta", System.currentTimeMillis());
//        System.out.println(map.get("sta"));
//        //过期时间
//        map.put("exp", System.currentTimeMillis()+(1000*60*60*24));
//        try {
//            String token = Token.creatToken(map);
//            System.out.println("token="+token);
//            return token;
//        } catch (JOSEException e) {
//            System.out.println("生成token失败");
//            e.printStackTrace();
//        }
//        return null;
//
//    }
//
//    //处理解析的业务逻辑
//    public static void ValidToken(String token) {
//        //解析token
//        try {
//            if (token != null) {
//
//                Map<String, Object> validMap = Token.valid(token);
//                int i = (int) validMap.get("Result");
//                if (i == 0) {
//                    System.out.println("token解析成功");
//                    JSONObject jsonObject = (JSONObject) validMap.get("data");
//                    System.out.println("uid是" + jsonObject.get("uid"));
//                    System.out.println("sta是"+jsonObject.get("sta"));
//                    System.out.println("exp是"+jsonObject.get("exp"));
//                } else if (i == 2) {
//                    System.out.println("token已经过期");
//                }
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } catch (JOSEException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public static void main(String[] ages) {
//        //获取token
//        String uid = "kkksuejrmf";
//        String token = TokenTest(uid);
//        //解析token
//        ValidToken(token);
//        System.out.println(System.currentTimeMillis()+"=======");
//    }


}
