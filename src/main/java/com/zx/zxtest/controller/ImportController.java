package com.zx.zxtest.controller;

import com.zx.zxtest.service.LineImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/server/import")
public class ImportController {

    @Autowired
    private LineImportService lineImportService;

    /**
     * 导入单线图数据
     * @param jsonData
     */
    @PostMapping(value = "/singleLine")
    public String tower(@RequestParam String jsonData) {
        String result = lineImportService.lineImport(jsonData);
        return "success";
    }



}
