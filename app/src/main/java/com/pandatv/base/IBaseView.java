package com.pandatv.base;

/**
 * Created by chj on 2017/8/21.
 */

public interface IBaseView<T> {
    void showProgress();
    void dismissProgress();
    void showMessage(String msg);
    void setPresenter(T t);
}
