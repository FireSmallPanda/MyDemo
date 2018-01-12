package cn.danywer.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    /**
     * 添加cookie
     * @param response
     * @param key 键
     * @param value 值
     */
    public static void setCookie(HttpServletResponse response,String key,String value){
    // 得到过期时间
        int session_time = Integer.valueOf(PropertiesUtil.load("redis_config.properties", "session_time"));
        Cookie cookie = new Cookie(key, value);

        cookie.setMaxAge(session_time);
        // 添加cookie
        response.addCookie(cookie);
    }

    /**
     * 得到cookie
     * @param request
     * @param key
     */
    public static String getCookie(HttpServletRequest request, String key){
        Cookie[] cookies = request.getCookies();
        System.out.print("conk------------------------------"+cookies.hashCode());
        for(Cookie cookie : cookies){
            if(cookie.getName().equals(key)){


                String value = cookie.getValue();

                if(value.indexOf("%")>-1){
                    value =  UrlUtil.getURLDecoderString(value);
                    value = value.replaceAll("\"","");
                }

                return value;

            }
        }
        return  null;
    }


}
