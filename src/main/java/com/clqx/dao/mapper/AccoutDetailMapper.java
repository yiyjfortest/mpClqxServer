package com.clqx.dao.mapper;

import com.clqx.dao.vo.AccoutDetail;
import com.clqx.dao.vo.AccoutDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccoutDetailMapper {
    long countByExample(AccoutDetailExample example);

    int deleteByExample(AccoutDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccoutDetail record);

    int insertSelective(AccoutDetail record);

    List<AccoutDetail> selectByExample(AccoutDetailExample example);

    AccoutDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccoutDetail record, @Param("example") AccoutDetailExample example);

    int updateByExample(@Param("record") AccoutDetail record, @Param("example") AccoutDetailExample example);

    int updateByPrimaryKeySelective(AccoutDetail record);

    int updateByPrimaryKey(AccoutDetail record);
}