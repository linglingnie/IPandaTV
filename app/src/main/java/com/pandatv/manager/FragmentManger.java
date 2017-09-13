package com.pandatv.manager;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.pandatv.app.App;
import com.pandatv.base.BaseFragment;


/**
 * Created by chj on 2017/8/20.
 */

public class FragmentManger {
    private static FragmentManger fragmentManger;
    private android.support.v4.app.FragmentManager fragmentManager;
    private BaseFragment fragment;
    private String simpleName;
    private FragmentTransaction fragmentTransaction;



    public FragmentManger() {
        getFragmentManagers();

    }

    public static FragmentManger getInstance() {
        if (fragmentManger == null) {
            synchronized (FragmentManger.class) {
                fragmentManger = new FragmentManger();
            }
        }
        return fragmentManger;
    }

    public FragmentManger getFragmentManagers() {
        fragmentManager = App.mBaseActivity.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        return this;
    }

    /**
     * @param containID     容器的id
     * @param fragmentClass fragment的实例化对象
     * @return 当前类对象, 方便使用构建者模式
     * @nest    是否是Fragment嵌套(Fragment和Fragment嵌套)
     */

    public FragmentManger start(int containID, Class<? extends BaseFragment> fragmentClass, Boolean nest) {

        getFragmentManagers();


        simpleName = fragmentClass.getSimpleName();
        fragment = (BaseFragment) fragmentManager.findFragmentByTag(simpleName);

        if (fragment == null) {

            try {
                //java动态代理
                fragment = fragmentClass.newInstance();
                //add
                fragmentTransaction.add(containID, fragment, simpleName);
                fragmentTransaction.addToBackStack(simpleName);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        if (App.lastFragment != null&!nest) {
            fragmentTransaction.hide(App.lastFragment);
        }


        fragmentTransaction.show(fragment);

        return this;

    }

    /**
     *
     * @param containID
     * @param fragmentClass
     * @return
     */
    public FragmentManger replace(int containID, Class<? extends BaseFragment> fragmentClass) {

      //  getFragmentManagers();


        simpleName= fragmentClass.getSimpleName();
        fragment = (BaseFragment) fragmentManager.findFragmentByTag(simpleName);

        if (fragment == null) {

            try {
                //java动态代理
                fragment = fragmentClass.newInstance();
                //add
                fragmentTransaction.replace(containID, fragment, simpleName);
                fragmentTransaction.addToBackStack(simpleName);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }




        fragmentTransaction.show(fragment);

        return this;
    }

    /**
     * 可以在非Fragment中给对应的Fragment传值
     *
     * @param bundle
     * @return
     */
    public FragmentManger setBundle(Bundle bundle) {
        if (bundle != null) {
            fragment.setBundle(bundle);
        }
        return this;
    }

    /**
     * 提交transaction
     * @return
     */
    public BaseFragment build() {




        App.lastFragment = fragment;
        fragmentTransaction.commit();
        int count=fragmentManager.getBackStackEntryCount();

        return fragment;
    }


}
