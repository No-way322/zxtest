package com.zx.zxtest.mapper;


import com.zx.zxtest.entity.SingleLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LineImportMapper {

    void updateTowerInfo(List<SingleLine> list);
}
