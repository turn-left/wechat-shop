package com.ethen.wechatshop.portal.auth;

import com.ethen.wechatshop.common.ResponseVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TokenAuthenticationService {

    public static final long EXPIRES = 432_000_000;             // 5天
    public static final String SECRET = "p@ssw02d";             // JWT密码
    public static final String TOKEN_PREFIX = "Bearer";         // token前缀
    public static final String HEADER_STRING = "Authorization"; // 存放Token的Header Key




    public static void addAuthentication(HttpServletResponse response, String username) {
        //生成JWT
        String JWT = Jwts.builder()
                //保存权限（角色）
                .claim("authorities", "ROLE_ADMIN,AUTH_WRITE")
                //用户名写入标题
                .setSubject(username)
                //有效期设置
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRES))
                //设置签名
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        //将JWT写入body
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        ResponseVo<String> responseVo = new ResponseVo<>(0, "成功",JWT);
        try {
            response.getOutputStream().println(ResponseUtil.buildJson(responseVo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取认证信息
     * @param request
     * @return
     */
    public static Authentication getAuthentication(HttpServletRequest request) {
        //从header中拿token
        String token = request.getHeader(HEADER_STRING);
        if (!StringUtils.isEmpty(token)) {
            //解析token
            Claims claims = Jwts.parser()
                    //验签
                    .setSigningKey(SECRET)
                    //去掉bearer
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            //拿用户名
            String userName = claims.getSubject();
            //解析权限角色
            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
            if (!StringUtils.isEmpty(userName)) {
                return new UsernamePasswordAuthenticationToken(userName, null, authorities);
            }
        }
        return null;
    }

}
