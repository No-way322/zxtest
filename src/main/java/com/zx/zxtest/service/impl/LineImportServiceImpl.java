package com.zx.zxtest.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zx.zxtest.entity.SingleLine;
import com.zx.zxtest.mapper.LineImportMapper;
import com.zx.zxtest.service.LineImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineImportServiceImpl implements LineImportService {

    @Autowired(required = false)
    private LineImportMapper lineImportDao;


    @Override
    public String lineImport(String jsonData) {
        JSONObject json = JSONObject.parseObject(jsonData);
        JSONArray jsonArray = json.getJSONArray("element");
        List<SingleLine> list = JSONObject.parseArray(jsonArray.toJSONString(), SingleLine.class);
        List<SingleLine> towerList = list.stream().filter(e -> e.getDevtypename().contains("运行杆塔")).collect(Collectors.toList());
        List<SingleLine> finalList = new ArrayList<>();
        for (SingleLine singleLine : towerList) {
            String rdfid = singleLine.getRdfid();
            String assetid = singleLine.getAssetid();
            rdfid = substringGuid(rdfid);
            assetid = substringGuid(assetid);
            singleLine.setRdfid(rdfid);
            singleLine.setAssetid(assetid);

            finalList.add(singleLine);
        }
        lineImportDao.updateTowerInfo(finalList);
        return "1";
    }

    /**
     * 截取字符串
     * @param id
     * @return
     */
    private String substringGuid(String id) {
        String[] ids = id.split("_");
        String guid = ids[ids.length-1];
        return guid;
    }
}
