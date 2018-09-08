package com.ssqx.service;

import com.ssqx.dao.vo.ClothInfo;

public interface SellService {

    String sell(int outPrice, int inPrice, String openId, int number, String storeName);

    String stock(String flag, ClothInfo clothInfo);

}
