package com.ssqx.service;

import com.ssqx.dao.vo.UserInfo;

import java.util.List;

public interface OperationUserService {

    List<UserInfo> selectAllUser();

    List<UserInfo> selectUserByName(String userName);

    String deleteUser(int id);

    String changeUserinfo(UserInfo userInfo);

}
