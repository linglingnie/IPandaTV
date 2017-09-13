package com.pandatv.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pandatv.R;
import com.pandatv.base.BaseFragment;


/**
 * Created by chj on 2017/8/21.
 */

public class HomeDetailFragment extends BaseFragment
{
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_livess;
    }

    @Override
    protected void initData() {
        Toast.makeText(getActivity(), "========", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void setBundle(Bundle bundle) {

    }
}
