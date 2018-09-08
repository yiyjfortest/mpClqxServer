package com.ssqx.service.impl;

import com.ssqx.dao.mapper.AccoutDetailMapper;
import com.ssqx.dao.mapper.ClothInfoMapper;
import com.ssqx.dao.mapper.UserInfoMapper;
import com.ssqx.dao.vo.*;
import com.ssqx.service.SellService;
import com.ssqx.tools.PARAMETER;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SellServiceImpl implements SellService {

    @Resource
    private ClothInfoMapper clothInfoMapper;
    @Resource
    private AccoutDetailMapper accoutDetailMapper;
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public String sell(int outPrice, int inPrice, String openId, int number, String storeName) {

        int result;

        ClothInfoExample selectExample = new ClothInfoExample();
        selectExample.createCriteria().andOutPriceEqualTo(outPrice)
                .andInPriceEqualTo(inPrice).andStatusEqualTo(PARAMETER.NORMAL_STATUS)
                .andStoreNameEqualTo(storeName);
        List<ClothInfo> clothInfoList = clothInfoMapper.selectByExample(selectExample);

        if (clothInfoList.isEmpty()) {
            return PARAMETER.ERROR;
        }

        ClothInfo clothInfo = clothInfoList.get(0);
        clothInfo.setNumber(clothInfo.getNumber() + number);
        clothInfo.setUpdateDate(new Date());
        result = clothInfoMapper.updateByPrimaryKey(clothInfo);
        if (result != PARAMETER.SUCCESS_SQL) {
            return PARAMETER.ERROR;
        }


        //售出或退回时，更新流水账明细表
        UserInfoExample userInfoExample = new UserInfoExample();
        userInfoExample.createCriteria().andOpenIdEqualTo(openId).andStatusEqualTo(PARAMETER.NORMAL_STATUS);
        List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoExample);

        if (userInfoList.isEmpty()) {
            return PARAMETER.ERROR;
        }

        AccoutDetail accoutDetail = new AccoutDetail();
        accoutDetail.setInPrice(inPrice);
        accoutDetail.setOutPrice(outPrice);
        accoutDetail.setOpenId(openId);
        accoutDetail.setUserName(userInfoList.get(0).getName());
        accoutDetail.setCreateDate(new Date());
        accoutDetail.setStoreName(storeName);
        result = accoutDetailMapper.insertSelective(accoutDetail);

        return result != PARAMETER.SUCCESS_SQL ? PARAMETER.ERROR : PARAMETER.SUCCESS;
    }

    @Override
    public String stock(String flag, ClothInfo clothInfo) {

        int result;

        if (flag.equals(PARAMETER.STOCK_ADD)) {
            //数据库没有信息，新增库存
            clothInfo.setCreateDate(new Date());
            result = clothInfoMapper.insertSelective(clothInfo);

            return result != PARAMETER.SUCCESS_SQL ? PARAMETER.ERROR : PARAMETER.SUCCESS;
        }

        clothInfo.setUpdateDate(new Date());
        result = clothInfoMapper.updateByPrimaryKeySelective(clothInfo);

        return result != PARAMETER.SUCCESS_SQL ? PARAMETER.ERROR : PARAMETER.SUCCESS;
    }


}
