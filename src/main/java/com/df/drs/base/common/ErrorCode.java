package com.df.drs.base.common;

import com.df.drs.base.annotation.Remark;

import java.lang.reflect.Field;
import java.util.Hashtable;

/**
 * 返回码定义.
 */
public final class ErrorCode {
    private ErrorCode() {
    }

    @Remark(remark = "资料未审核")
    public static final int UNEXAMINE = -7;

    @Remark(remark = "审核未通过")
    public static final int EXAMINE = -8;

    @Remark(remark = "未知错误")
    public static final int UNKNOWN = -1;

    @Remark(remark = "请求成功")
    public static final int SUCCESS = 0;


    /**
     * 参数问题
     */
    @Remark(remark = "参数为空")
    public static final int PARAMETER_NULL = 400;

    @Remark(remark = "参数格式错误")
    public static final int PARAMETER_TYPE_ERROR = 401;

    @Remark(remark = "未找到")
    public static final int UNFIND = 402;

    /**
     * 操作问题
     */
    @Remark(remark = "修改失败！")
    public static final int CHANGE_ERROR = 410;
    @Remark(remark = "添加失败！")
    public static final int ADD_ERROR = 411;
    @Remark(remark = "删除失败！")
    public static final int DEL_ERROR= 412;
    @Remark(remark = "保存失败！")
    public static final int SAVE_ERROR = 413;
    @Remark(remark = "查询失败！")
    public static final int QUERY_ERROR = 414;



    /**
     * 消息格式错误
     */
    @Remark(remark = "消息格式错误")
    public static final int CLIENT_FORMAT_ERROR = 1100;
    /**
     * 身份验证失败
     */
    @Remark(remark = "身份验证失败")
    public static final int CLIENT_AUTH_ERROR = 1200;

    @Remark(remark = "身份令牌过期")
    public static final int CLIENT_AUTH_TOKEN_EXPIRED = 1210;

    /**
     * 第三方权限缺失
     */
    @Remark(remark = "第三发权限缺失")
    public static final int REQUIRE_THIRD_ROLE = 1202;

    /**
     * 操作超时
     */
    @Remark(remark = "操作超时")
    public static final int CLIENT_TIMEOUT = 1300;

    /**
     * 访问被拒绝
     */
    @Remark(remark = "访问被拒绝")
    public static final int CLIENT_ACCESS_DENIED = 1400;

    /**
     * 客户端超时退出
     */
    @Remark(remark = "客户端超时退出")
    public static final int CLIENT_TIMEOUT_LOCKED = 1500;

    /**
     * 找不到资源
     */
    @Remark(remark = "找不到资源")
    public static final int CLIENT_RESOURCE_NOT_FOUND = 2100;

    /**
     * 余额不足
     */
    @Remark(remark = "余额不足")
    public static final int CLIENT_CREDIT_LOWER_LIMIT = 2400;

    /**
     * 超过配额
     */
    @Remark(remark = "超过配额")
    public static final int CLIENT_OVER_QUOTA = 2500;

    /**
     * 服务器内部错误
     */
    @Remark(remark = "内部错误")
    public static final int SERVER_INTERNAL_ERROR = 5000;

    /**
     * 服务器繁忙
     */
    @Remark(remark = "服务器繁忙")
    public static final int SERVER_BUSY = 5100;

    /**
     * 资源不足
     */
    @Remark(remark = "资源不足")
    public static final int SERVER_RESOURCE_LIMIT = 5200;

    /**
     * 服务更新中
     */
    @Remark(remark = "服务更新中")
    public static final int SERVER_UPDATE = 5300;


    static final Hashtable<Integer, String> codeMsgMap = new Hashtable<>(
            20);

    static {
        Field[] fields = ErrorCode.class.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Remark.class)) {
                try {
                    codeMsgMap.put(field.getInt(null),
                            field.getAnnotation(Remark.class).remark());
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getMsg(int responseCode) {
        if (codeMsgMap.containsKey(responseCode)) {
            return codeMsgMap.get(responseCode);
        }
        return "未知错误";

    }

}
