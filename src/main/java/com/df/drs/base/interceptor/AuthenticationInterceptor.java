package com.df.drs.base.interceptor;

/**
 * @Classname Authenticat
 * @Description
 * @Date 2019/12/6 9:17
 * @author Liu Yaoguang
 */


import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.df.drs.base.annotation.PassToken;
import com.df.drs.base.annotation.UserLoginToken;
import com.df.drs.base.utils.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Liu Yaoguang
 * @Classname AuthenticationInterceptor
 * @Description
 * @Date 2019/11/19 14:30
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    private static Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);
    private static final List<String> U = new ArrayList<>(Arrays.asList("/getbefore"));

//    @Autowired
//    UserService userService;
//    @Autowired
//    private WxLoginDao wxLoginDao;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = httpServletRequest.getHeader("token");
        HttpSession session = httpServletRequest.getSession();
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    returnJson(httpServletResponse, "无token，请重新登录");
                    return false;
                }
                Date date;
                try {
                    date = JWT.decode(token).getExpiresAt();
                    if (new Date().after(date)) {
                        returnJson(httpServletResponse, "token过期");
                        return false;
                    }
                } catch (JWTDecodeException e) {
                    returnJson(httpServletResponse, "token错误1");
                    return false;
                }

//                // 获取 token 中的 user id
//                String username;
//                try {
//                    username = JWT.decode(token).getAudience().get(0);
//                } catch (JWTDecodeException j) {
//                    returnJson(httpServletResponse, "token错误2");
//                    return false;
//                }
//                User user = userService.select(username);
//                if (user == null) {
//                    returnJson(httpServletResponse, "用户不存在，请重新登录");
//                    return false;
//                }
//                // 验证 token
//                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
//                try {
//                    jwtVerifier.verify(token);
//                } catch (JWTVerificationException e) {
//                    returnJson(httpServletResponse, "401验证异常");
//                    return false;
//                }
//                session.setAttribute("username",user.getUsername());

                // 微信验证token
                Map<String, Object> validMap = Token.valid(token);
                int i = (int) validMap.get("Result");
                if (i == 0) {
                    JSONObject jsonObject = (JSONObject) validMap.get("data");
                    // 解析载荷的openid
                    String openid = jsonObject.get("openid").toString();
                    // 通过openid查找患者
//                    WxLogin wxLogin = wxLoginDao.selectByPrimaryKey(openid);
//                    if (null == wxLogin) {
//                        returnJson(httpServletResponse,"用户不存在！");
//                        return false;
//                    } else {
//                        return true;
//                    }
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

    private void returnJson(HttpServletResponse response, String json) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}