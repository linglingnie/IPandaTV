package com.pandatv.modle.dataModel;


import com.pandatv.base.IBaseHttp;
import com.pandatv.modle.net.HttpFactory;

/**
 * Created by xingge on 2017/7/11.
 */

public interface BaseModel {
    public static IBaseHttp iHttp = HttpFactory.createOK();
}
