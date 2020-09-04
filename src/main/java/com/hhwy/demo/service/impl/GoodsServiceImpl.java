package com.hhwy.demo.service.impl;

import com.hhwy.business.market.util.ConvertListUtil;
import com.hhwy.demo.domain.GoodsInfo;
import com.hhwy.demo.domain.GoodsType;
import com.hhwy.demo.domain.GoodsTypeDetail;
import com.hhwy.demo.service.GoodsService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 王阳
 * @create 2020-03-28-9:53
 */
@Component
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    @Override
    public Integer addGoodsSort(GoodsType goodsType) {
        Integer flag = sqlSessionTemplate.insert ("goods.sql.addGoodsSort", goodsType);
        return flag;
    }

    @Override
    public Integer addGoodsInfo(GoodsInfo goodsInfo) {
        Integer flag = sqlSessionTemplate.insert ("goods.sql.addGoodsInfo",goodsInfo);
        return flag;
    }

    @Override
    public List<GoodsTypeDetail> selectGoodsSort(GoodsType goodsType) {

        List<GoodsTypeDetail> list = sqlSessionTemplate.selectList("goods.sql.selectGoodsSort",goodsType);
        try {
            ConvertListUtil.convert(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public List<GoodsInfo> selectGoodsInfo(GoodsInfo goodsInfo) {
        List<GoodsInfo> list = sqlSessionTemplate.selectList("goods.sql.selectGoodsInfo",goodsInfo);
        return list;
    }
    @Override
    public List<GoodsType> selectGoodsSortAll() {
        List<GoodsType> list = sqlSessionTemplate.selectList("goods.sql.selectGoodsSortAll");
        return list;
    }

    @Override
    public Integer getSortCount(GoodsType goodsType) {
        Integer count = sqlSessionTemplate.selectOne("goods.sql.getSortCount",goodsType);
        return count;
    }
    @Override
    public Integer getInfoCount(GoodsInfo goodsInfo) {
        Integer count = sqlSessionTemplate.selectOne("goods.sql.getInfoCount",goodsInfo);
        return count;
    }


    @Override
    public Integer updateGoodsSort(GoodsType goodsType) {
        Integer flag = sqlSessionTemplate.update("goods.sql.updateGoodsSort",goodsType);
        return flag;
    }
    @Override
    public Integer updateGoodsInfo(GoodsInfo goodsInfo) {
        Integer flag = sqlSessionTemplate.update("goods.sql.updateGoodsInfo",goodsInfo);
        return flag;
    }

    @Override
    public Integer deleteGoodsSort(String id) {
        Integer flag = sqlSessionTemplate.delete("goods.sql.deleteGoodsSort",id);
        return flag;
    }
    @Override
    public Integer deleteGoodsInfo(String[] id) {
        Integer flag = sqlSessionTemplate.delete("goods.sql.deleteGoodsInfo",id);
        return flag;
    }

    @Override
    public Integer updateGoodsInfoNum(GoodsInfo goodsInfo) {
        System.out.println("servicew");

        Integer flag = sqlSessionTemplate.update("goods.sql.updateGoodsInfoNum",goodsInfo);
        System.out.println("servicewj");
        return flag;
    }
}
