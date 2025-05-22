package cn.moonify.interceptors;

import cn.moonify.Utils.JwtUtil;
import cn.moonify.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 令牌验证
        String token = request.getHeader("Authorization");
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            ThreadLocalUtil.setUsername(claims.get("username").toString());
            return true;
        } catch (Exception e) {
            // 令牌验证未通过
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // http响应状态设置为401
            return false;
        }


    }
}
