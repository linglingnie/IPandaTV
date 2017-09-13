package com.pandatv.modle.dataModel;


import com.pandatv.config.Urls;
import com.pandatv.entity.PandaHome;
import com.pandatv.modle.net.callback.NetWorkCallBack;

/**
 * Created by xingge on 2017/7/26.
 */

public class PandaHomeModelImpl implements IPandaHomeModel {



    @Override
    public void loadHomeList(NetWorkCallBack<PandaHome> callback) {
        iHttp.get(Urls.PANDAHOME,null,callback);
    }
}
