package com.hhwy.demo.controller;

import com.hhwy.demo.domain.GoodsInfo;
import com.hhwy.demo.domain.GoodsType;
import com.hhwy.demo.domain.GoodsTypeDetail;
import com.hhwy.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author 王阳
 * @create 2020-03-28-9:53
 */
@RestController
@RequestMapping("goodsController")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @RequestMapping(value = "insertGoodsSort",method = RequestMethod.POST)
    public Map<String,Object> insertGoodsSort(@RequestBody GoodsType goodsType){
        System.out.println(goodsType.toString());
        Map<String,Object> map = new HashMap<>();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        goodsType.setId(uuid);
        Integer flag = goodsService.addGoodsSort(goodsType);
        map.put("flag",flag);
        return map;
    }

    @RequestMapping(value = "insertGoodsInfo",method = RequestMethod.POST)
    public Map<String,Object> insertGoodsInfo(@RequestBody GoodsInfo goodsInfo){
        Map<String,Object> map = new HashMap<>();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String good_code=System.currentTimeMillis()+"";
        goodsInfo.setId(uuid);
        goodsInfo.setGoods_code(good_code);
        Integer flag = goodsService.addGoodsInfo(goodsInfo);
        map.put("flag",flag);
        return map;
    }

    @RequestMapping(value = "selectGoodsSort",method = RequestMethod.POST)
    public Map<String,Object> selectGoodsSort(@RequestBody GoodsType goodsType){
        Map<String,Object> map=new HashMap<>();
        List<GoodsTypeDetail> list=null;
        Integer count = null;
        try{
            list= goodsService.selectGoodsSort(goodsType);
            count = goodsService.getSortCount(goodsType);
            map.put("rows", list);
            map.put("total",count);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "selectGoodsSortAll",method = RequestMethod.GET)
    public List<GoodsType> selectGoodsSortAll(){
        List<GoodsType> cList = goodsService.selectGoodsSortAll();
        return cList;
    }

    @RequestMapping(value = "/updateGoodsSort",method = RequestMethod.POST)
    public Map<String,Object> updateGoodsSort(@RequestBody GoodsType goodsType){
        Map<String,Object> map = new HashMap<>();
        Integer  result= goodsService.updateGoodsSort(goodsType);
        map.put("flag",result);
        return  map;
    }

    @RequestMapping(value = "/updateGoodsInfo",method = RequestMethod.POST)
    public Map<String,Object> updateGoodsInfo(@RequestBody GoodsInfo goodsInfo){
        Map<String,Object> map = new HashMap<>();
        Integer  result= goodsService.updateGoodsInfo(goodsInfo);
        map.put("flag",result);
        return  map;
    }

    /**
     * 删除货物类别
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteGoodSort",method = RequestMethod.POST)
    public Map<String,Object> deleteGoodSort(String id){
        Map<String,Object> map = new HashMap<>();
        Integer flag = goodsService.deleteGoodsSort(id);
        map.put("flag",flag);
        return map;
    }


    @RequestMapping(value = "selectGoodsInfo",method = RequestMethod.POST)
    public Map<String,Object> selectGoodsInfo(@RequestBody GoodsInfo goodsInfo){
        Map<String,Object> map=new HashMap<>();
        List<GoodsInfo> list=null;
        Integer count = null;
        try{
            list= goodsService.selectGoodsInfo(goodsInfo);
            count = goodsService.getInfoCount(goodsInfo);
            map.put("rows", list);
            map.put("total",count);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(map.toString());

        return map;
    }
    @RequestMapping(value = "deleteGoodInfo",method = RequestMethod.POST)
    public Map<String,Object> deleteGoodInfo(String[] id){

        Map<String,Object> map = new HashMap<>();
        Integer flag = goodsService.deleteGoodsInfo(id);
        map.put("flag",flag);
        return map;
    }
    @RequestMapping(value = "updateGoodsInfoNum",method = RequestMethod.POST)
    public Map<String,Object> updateGoodsInfoNum(GoodsInfo goodsInfo){
        System.out.println(goodsInfo.toString());
        Map<String,Object> map = new HashMap<>();
        Integer flag = goodsService.updateGoodsInfoNum(goodsInfo);
        map.put("flag",flag);
        return map;
    }

}
