package com.kaptcha.util;

import javax.servlet.http.HttpServletRequest;

/**
 * CodeUtil  class
 *
 * 验证码比对工具类
 *
 * 这个类用来比对生成的验证码与用户输入的验证码。
 * 生成的验证码会自动加到session中，用户输入的通过getParameter获得。注意getParameter的key值要与页面中验证码的name值一致
 * @author : yuxiang
 * @date : 2019-07-30 11:59
 **/
public class CodeUtil {
    /**
     * 将获取到的前端参数转为string类型
     * @param request
     * @param key
     * @return
     */
    public static String getString(HttpServletRequest request, String key) {
        try {
            String result = request.getParameter(key);
            if(result != null) {
                result = result.trim();
            }
            if("".equals(result)) {
                result = null;
            }
            return result;
        }catch(Exception e) {
            return null;
        }
    }
    /**
     * 验证码校验
     * @param request
     * @return
     */
    public static boolean checkVerifyCode(HttpServletRequest request) {
        //获取生成的验证码
        String verifyCodeExpected = (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        //获取用户输入的验证码
        String verifyCodeActual = CodeUtil.getString(request, "verifyCodeActual");
        if(verifyCodeActual == null ||!verifyCodeActual.equals(verifyCodeExpected)) {
            return false;
        }
        return true;
    }
}
