package com.ssqx.dao.mapper;

import com.ssqx.dao.vo.ClothInfo;
import com.ssqx.dao.vo.ClothInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClothInfoMapper {
    long countByExample(ClothInfoExample example);

    int deleteByExample(ClothInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClothInfo record);

    int insertSelective(ClothInfo record);

    List<ClothInfo> selectByExample(ClothInfoExample example);

    ClothInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClothInfo record, @Param("example") ClothInfoExample example);

    int updateByExample(@Param("record") ClothInfo record, @Param("example") ClothInfoExample example);

    int updateByPrimaryKeySelective(ClothInfo record);

    int updateByPrimaryKey(ClothInfo record);
}