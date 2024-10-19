/*
 ******************************* Copyright (c)*********************************\
 **
 **                 (c) Copyright 2017, King, china
 **                          All Rights Reserved
 **
 **                              By(King)
 **
 **------------------------------------------------------------------------------
 */
package com.xgr.alipay;


import com.alipay.sdk.app.EnvUtils;
import com.xgr.easypay.base.IPayInfo;

/**
 * 文 件 名: AlipayInfoImpli
 * 创 建 人: King
 * 创建日期: 2017/2/13 17:05
 * 邮   箱: mikey1101@163.com
 * 博   客: www.smilevenus.com
 * 描述 ：包含支付宝支付类型和支付信息
 */
public class AlipayInfoImpli implements IPayInfo {

    private EnvUtils.EnvEnum envEnum;

    private String orderInfo;

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public EnvUtils.EnvEnum getEnvEnum() {
        return envEnum;
    }

    public void setEnvEnum(EnvUtils.EnvEnum envEnum) {
        this.envEnum = envEnum;
    }
}
