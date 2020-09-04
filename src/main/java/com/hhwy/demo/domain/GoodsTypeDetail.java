package com.hhwy.demo.domain;

import com.hhwy.business.market.annotation.PropertyAnnotation;
import com.hhwy.business.market.util.ConstantsStatus;
import org.springframework.stereotype.Component;

/**
 * <b>类 名 称：</b><br/>
 * <b>类 描 述：</b><br/>
 * <b>创 建 人：</b>wangyang<br/>
 * <b>修 改 人：</b>wangyang<br/>
 * <b>创建时间：</b>2020-07-17-15:57<br/>
 * <b>修改时间：</b>2020-07-17-15:57<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br />
 */
@Component
public class GoodsTypeDetail extends GoodsType{
    @PropertyAnnotation(cacheType = ConstantsStatus.CACHE_TYPE_PCODE,
            domain = ConstantsStatus.PCODE_DOMAIN_MARKET,
            key = "testwy", field = "type_code", valueFlag = 1)
    private String type_code_name;

    public String getType_code_name() {
        return type_code_name;
    }

    public void setType_code_name(String type_code_name) {
        this.type_code_name = type_code_name;
    }
}
