package com.morgan.manage.common.utils;

/**
 * @Author:morgan.b.chen
 * @Description: 封装接口统一返回数据格式
 * @Date:2018/7/8
 */
public class AjaxResult {

    //请求是否成功
    private Boolean success;
    //请求提示信息
    private String message;
    //状态码
    private Integer code;
    //返回数据
    private Object data;

    public AjaxResult(){}

    public AjaxResult(Boolean success) {
        this(success,null,null);
    }

    public AjaxResult(Boolean success, String message) {
        this(success,message,null);
    }

    public AjaxResult(Boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static AjaxResult ok() {
        return new AjaxResult(true, "操作成功", null);
    }

    public static AjaxResult ok(String msg) {
        return new AjaxResult(true, msg, null);
    }

    public static AjaxResult ok(String msg, Object data) {
        return new AjaxResult(true, msg, data);
    }

    public static AjaxResult error() {
        return new AjaxResult(false, "操作失败", null);
    }

    public static AjaxResult error(String msg) {
        return new AjaxResult(false, msg, null);
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
