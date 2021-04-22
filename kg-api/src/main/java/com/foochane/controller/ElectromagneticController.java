package com.foochane.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.foochane.utils.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;


@Controller
public class ElectromagneticController {

    /**
     *频谱时序预测
     */
    @RequestMapping(value = "api/electromagnetic/predict",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getResultData1(){

        JSONObject jsonObject = new JSONObject();
        String path = "json/" + "Frequency_predict" + ".json";
        ClassPathResource classPathResource = new ClassPathResource(path);
        try {
            File file = classPathResource.getFile();
            String s = FileUtils.readJsonFile(file);
            jsonObject = JSON.parseObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


    /**
     *时间-频段占用
     */
    @RequestMapping(value = "api/band/list",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getResultData2(){

        JSONObject jsonObject = new JSONObject();
        String path = "json/" + "band_list" + ".json";
        ClassPathResource classPathResource = new ClassPathResource(path);
        try {
            File file = classPathResource.getFile();
            String s = FileUtils.readJsonFile(file);
            jsonObject = JSON.parseObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
