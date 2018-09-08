package com.ssqx.service.impl;

import com.ssqx.dao.mapper.AuthMapper;
import com.ssqx.dao.mapper.UserInfoMapper;
import com.ssqx.dao.vo.Auth;
import com.ssqx.dao.vo.UserInfo;
import com.ssqx.dao.vo.UserInfoExample;
import com.ssqx.service.GetAuthService;
import com.ssqx.tools.PARAMETER;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GetAuthServiceImpl implements GetAuthService {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private AuthMapper authMapper;

    @Override
    public int getAuthForOpenId(String openId) {

        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andOpenIdEqualTo(openId).andStatusEqualTo(PARAMETER.NORMAL_STATUS);
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(example);
        if (userInfoList.isEmpty()) {
            UserInfo userInfo = new UserInfo();
            userInfo.setOpenId(openId);
            userInfo.setCreateDate(new Date());
            userInfo.setUpdateDate(new Date());
            userInfo.setStatus(PARAMETER.NORMAL_STATUS);
            userInfoMapper.insertSelective(userInfo);
            return PARAMETER.COMMON_AUTH;
        }

        int authId = userInfoList.get(0).getAuthId();

        Auth auth = authMapper.selectByPrimaryKey(authId);

        return auth.getAuth();
    }


}
