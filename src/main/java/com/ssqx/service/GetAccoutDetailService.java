package com.ssqx.service;

import com.ssqx.dao.vo.AccoutDetail;

import java.util.Date;
import java.util.List;

public interface GetAccoutDetailService {
    List<AccoutDetail> getAccoutDetail(Date startDate, Date endDate);
}
