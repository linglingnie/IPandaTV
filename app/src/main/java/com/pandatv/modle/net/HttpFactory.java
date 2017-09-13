package com.pandatv.modle.net;


import com.pandatv.base.IBaseHttp;

/**
 * Created by chj on 2017/8/21.
 */

public class HttpFactory {

    public static IBaseHttp createOK(){
        return OkBaseHttpImpl.getInstance();
    }

    public  static IBaseHttp createRetrofit(){
        return RetrofitImpl.getInstance();
    }



}
