package com.briup.cms.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.cms.util.JwtTokenUtils;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @description: 登陆
 * @author: wangzh
 * @create: 2019-03-21 15:56
 **/
@Api(description = "登陆相关接口")
@RestController
@RequestMapping("/authentication")
public class LoginController {

    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;


    @PostMapping("/form")
    @ApiOperation(value = "登入身份验证（JWT验证）", notes = "登入")
    public void login(String username, String password) {
        // TODO 这里面不需要写任何代码，由UserDeatilsService去处理
    }

    @GetMapping("/getUserDetailByToken")
    @ApiOperation(value = "根据token得到用户信息")
    public Message getUserDetailByToken(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        response.setContentType("application/json;charset=UTF-8");
        if (token != null && StringUtils.startsWith(token, JwtTokenUtils.TOKEN_PREFIX)) {
            token = StringUtils.substring(token, JwtTokenUtils.TOKEN_PREFIX.length());
            UserDetails details = userDetailsService.loadUserByUsername(JwtTokenUtils.getUsername(token));

            return MessageUtil.success(details);
        } else {
            return MessageUtil.error(401, "token失效");
        }
    }

    @PostMapping("/logout")
    @ApiOperation(value="登出", notes="登出")
    public Message login(HttpServletRequest request,HttpServletResponse response){
        String token=request.getHeader(JwtTokenUtils.TOKEN_HEADER);
        response.setContentType("application/json;charset=UTF-8");
        if(token!=null&&StringUtils.startsWith(token,JwtTokenUtils.TOKEN_PREFIX)){
            // 这里需要删除redis中的token，但是现在没有redis就先放着吧
            return MessageUtil.success("登出成功");
        }else{
            return MessageUtil.error(401,"token失效");
        }
    }

    

}
