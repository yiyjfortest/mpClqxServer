package com.ssqx.controller;

import com.ssqx.dao.vo.ClothInfo;
import com.ssqx.service.SellService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/sellController")
public class SellController {

    @Resource
    private SellService sellService;

    @RequestMapping("/sell.do")
    public String sell(HttpServletRequest request, HttpServletResponse response) {

        Gson gson = new Gson();
        String result;

        int outPrice = Integer.parseInt(request.getParameter("outPrice"));
        int inPrice = Integer.parseInt(request.getParameter("inPrice"));
        String openId = request.getParameter("openId");
        int number = Integer.parseInt(request.getParameter("number"));
        String storeName = request.getParameter("storeName");
        result = sellService.sell(outPrice, inPrice, openId, number, storeName);

        Map<String, String> map = new HashMap<>();
        map.put("result", result);

        return gson.toJson(map);
    }

    @RequestMapping("/stock.do")
    public String stock(HttpServletRequest request, HttpServletResponse response) {

        Gson gson = new Gson();
        String result;

        String flag = request.getParameter("flag");
        String cloth = request.getParameter("cloth");
        ClothInfo clothInfo = gson.fromJson(cloth, ClothInfo.class);
        result = sellService.stock(flag, clothInfo);

        Map<String, String> map = new HashMap<>();
        map.put("result", result);

        return gson.toJson(map);
    }

}
