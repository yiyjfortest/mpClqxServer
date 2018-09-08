package com.ssqx.controller;

import com.ssqx.dao.vo.AccoutDetail;
import com.ssqx.service.GetAccoutDetailService;
import com.ssqx.tools.BaseUtil;
import com.ssqx.tools.PARAMETER;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/accoutDetailController")
public class AccoutDetailController {

    @Resource
    private GetAccoutDetailService getAccoutDetailService;

    @RequestMapping("/getAccoutDetail.do")
    public String getAccoutDetail(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        Gson gson = new Gson();

        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        Date startDate = BaseUtil.stringToDate(startTime, PARAMETER.START_TIME);
        Date endDate = BaseUtil.stringToDate(endTime, PARAMETER.END_TIME);

        List<AccoutDetail> accoutDetailList = getAccoutDetailService.getAccoutDetail(startDate, endDate);

        return gson.toJson(accoutDetailList, new TypeToken<List<AccoutDetail>>(){}.getType());
    }

}
