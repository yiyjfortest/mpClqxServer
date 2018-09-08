package com.ssqx.service.impl;

import com.ssqx.dao.mapper.UserInfoMapper;
import com.ssqx.dao.vo.UserInfo;
import com.ssqx.dao.vo.UserInfoExample;
import com.ssqx.service.OperationUserService;
import com.ssqx.tools.PARAMETER;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OperationUserServiceImpl implements OperationUserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectAllUser() {

        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andStatusEqualTo(PARAMETER.NORMAL_STATUS);
        example.setOrderByClause("create_date desc");
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(example);

        return userInfoList.isEmpty() ? new ArrayList<UserInfo>() : userInfoList;
    }

    @Override
    public List<UserInfo> selectUserByName(String userName) {

        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andStatusEqualTo(PARAMETER.NORMAL_STATUS).andNameEqualTo(userName);
        example.setOrderByClause("create_date desc");
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(example);

        return userInfoList.isEmpty() ? new ArrayList<UserInfo>() : userInfoList;

    }

    @Override
    public String deleteUser(int id) {

        int i = userInfoMapper.deleteByPrimaryKey(id);

        return i == PARAMETER.SUCCESS_SQL ? PARAMETER.SUCCESS : PARAMETER.ERROR;

    }

    @Override
    public String changeUserinfo(UserInfo userInfo) {

        userInfo.setUpdateDate(new Date());
        int i = userInfoMapper.updateByPrimaryKeySelective(userInfo);

        return i == PARAMETER.SUCCESS_SQL ? PARAMETER.SUCCESS : PARAMETER.ERROR;

    }

}
