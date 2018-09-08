package com.ssqx.controller;


import com.ssqx.dao.vo.UserInfo;
import com.ssqx.service.OperationUserService;
import com.ssqx.tools.PARAMETER;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userController")
public class UserController {

    @Resource
    private OperationUserService operationUserService;

    @RequestMapping("/selectAllUser.do")
    public String selectAllUser(HttpServletRequest request, HttpServletResponse response) {

        Gson gson = new Gson();

        List<UserInfo> userInfoList = operationUserService.selectAllUser();

        return gson.toJson(userInfoList, new TypeToken<List<UserInfo>>(){}.getType());
    }

    @RequestMapping("/selectUserByName.do")
    public String selectUserByName(HttpServletRequest request, HttpServletResponse response) {

        Gson gson = new Gson();

        String userName = request.getParameter("userName");
        List<UserInfo> userInfoList = operationUserService.selectUserByName(userName);

        return gson.toJson(userInfoList, new TypeToken<List<UserInfo>>(){}.getType());
    }

    @RequestMapping("/deleteUser.do")
    public String deleteUser(HttpServletRequest request, HttpServletResponse response) {

        Gson gson = new Gson();

        int userId = Integer.parseInt(request.getParameter("userId"));
        String result = operationUserService.deleteUser(userId);

        Map<String, String> map = new HashMap<>();
        map.put("result", result);

        return gson.toJson(map);
    }

    @RequestMapping("/changeUserinfo.do")
    public String changeUserinfo(HttpServletRequest request, HttpServletResponse response) {

        Gson gson = new Gson();
        String result;

        String user = request.getParameter("user");
        UserInfo userInfo;
        userInfo = gson.fromJson(user, UserInfo.class);
        if (userInfo != null) {
            result = operationUserService.changeUserinfo(userInfo);
        } else {
            result = PARAMETER.ERROR;
        }

        Map<String, String> map = new HashMap<>();
        map.put("result", result);

        return gson.toJson(map);
    }

}
