package com.ssqx.service.impl;

import com.ssqx.dao.mapper.AccoutDetailMapper;
import com.ssqx.dao.vo.AccoutDetail;
import com.ssqx.dao.vo.AccoutDetailExample;
import com.ssqx.service.GetAccoutDetailService;
import com.ssqx.tools.PARAMETER;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GetAccoutDetailServiceImpl implements GetAccoutDetailService {

    @Resource
    private AccoutDetailMapper accoutDetailMapper;

    @Override
    public List<AccoutDetail> getAccoutDetail(Date startDate, Date endDate) {

        AccoutDetailExample example = new AccoutDetailExample();
        example.createCriteria().andCreateDateBetween(startDate, endDate).andStatusEqualTo(PARAMETER.NORMAL_STATUS);
        List<AccoutDetail> accoutDetailList = accoutDetailMapper.selectByExample(example);

        return accoutDetailList.isEmpty() ? new ArrayList<AccoutDetail>() : accoutDetailList;

    }

}
