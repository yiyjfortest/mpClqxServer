package com.ssqx.controller;

import com.ssqx.service.GetAuthService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/authController")
public class AuthController {

    @Resource
    private GetAuthService getAuthService;

    @RequestMapping("/getAuth.do")
    public String getAuth(HttpServletResponse response, HttpServletRequest request) {

        Gson gson = new Gson();

        String openId = request.getParameter("openId");
        int auth = getAuthService.getAuthForOpenId(openId);

        Map<String, Integer> map = new HashMap<>();
        map.put("auth", auth);

        return gson.toJson(map);
    }

}
