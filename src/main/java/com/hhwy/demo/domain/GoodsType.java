package com.hhwy.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * 商品类别
 * @author 王阳
 * @create 2020-03-28-9:43
 */
@Component
public class GoodsType extends Paging{
    private String id;
    private String type_name;
    private String type_code;
    private Integer enable_flag;
    private String create_user;
    private Timestamp create_time;
    private String update_user;
    private Timestamp update_time;

    @Override
    public String toString() {
        return "GoodsType{" +
                "id='" + id + '\'' +
                ", type_name='" + type_name + '\'' +
                ", type_code='" + type_code + '\'' +
                ", enable_flag=" + enable_flag +
                ", create_user='" + create_user + '\'' +
                ", create_time=" + create_time +
                ", update_user='" + update_user + '\'' +
                ", update_time=" + update_time +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public Integer getEnable_flag() {
        return enable_flag;
    }

    public void setEnable_flag(Integer enable_flag) {
        this.enable_flag = enable_flag;
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
