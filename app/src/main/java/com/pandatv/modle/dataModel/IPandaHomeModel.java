package com.pandatv.modle.dataModel;


import com.pandatv.entity.PandaHome;
import com.pandatv.modle.net.callback.NetWorkCallBack;

/**
 * Created by xingge on 2017/7/26.
 */

public interface IPandaHomeModel extends BaseModel {

    void loadHomeList(NetWorkCallBack<PandaHome> callback);
}
