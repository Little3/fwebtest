package com.hhwy.demo.service;

import com.hhwy.demo.domain.GoodsInfo;
import com.hhwy.demo.domain.GoodsType;
import com.hhwy.demo.domain.GoodsTypeDetail;

import java.util.List;

/**
 * @author 王阳
 * @create 2020-03-28-9:54
 */
public interface GoodsService {
    /**
     * 添加货物类型
     * @return
     */
    Integer addGoodsSort(GoodsType goodsType);

    /**
     * 添加货物信息
     * @param goodsInfo
     * @return
     */
    Integer addGoodsInfo(GoodsInfo goodsInfo);

    /**
     * 查询货物类别
     * @param goodsType
     * @return
     */
    List<GoodsTypeDetail> selectGoodsSort(GoodsType goodsType);

    /**
     * 查询商品信息
     * @param goodsInfo
     * @return
     */
    List<GoodsInfo> selectGoodsInfo(GoodsInfo goodsInfo);

    /**
     * 查询所有商品类别
     * @return
     */
    List<GoodsType> selectGoodsSortAll();

    /**
     * 查询货物类别数量
     * @param goodsType
     * @return
     */
    Integer getSortCount(GoodsType goodsType);

    /**
     * 查询商品数量
     * @param goodsInfo
     * @return
     */
    Integer getInfoCount(GoodsInfo goodsInfo);

    /**
     * 修改货物类型
     * @param goodsType
     * @return
     */
    Integer updateGoodsSort(GoodsType goodsType);

    /**
     * 删除货物类型
     * @param id
     * @return
     */
    Integer deleteGoodsSort(String id);

    Integer deleteGoodsInfo(String[] id);

    Integer updateGoodsInfo(GoodsInfo goodsInfo);

    /**
     * 修改数量
     */
    Integer updateGoodsInfoNum(GoodsInfo goodsInfo);

}
