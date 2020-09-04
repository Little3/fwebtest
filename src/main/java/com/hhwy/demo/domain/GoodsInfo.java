package com.hhwy.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hhwy.business.market.annotation.PropertyAnnotation;
import com.hhwy.business.market.util.ConstantsStatus;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * 商品信息
 * @author 王阳
 * @create 2020-03-28-9:47
 */
@Component
public class GoodsInfo extends Paging{
    private String id;
    private String type_code;
    private String goods_name;
    private String goods_code;
    private Integer num;
    private String unit;
    private String img_id;
    private String imgname;
    private String create_user;
    private Timestamp create_time;
    private String update_user;
    private Timestamp update_time;

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "id='" + id + '\'' +
                ", type_code='" + type_code + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", goods_code='" + goods_code + '\'' +
                ", num=" + num +
                ", unit='" + unit + '\'' +
                ", img_id='" + img_id + '\'' +
                ", imgname='" + imgname + '\'' +
                ", create_user='" + create_user + '\'' +
                ", create_time=" + create_time +
                ", update_user='" + update_user + '\'' +
                ", update_time=" + update_time +
                '}';
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public String getImg_id() {
        return img_id;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_code() {
        return goods_code;
    }

    public void setGoods_code(String goods_code) {
        this.goods_code = goods_code;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }
}
