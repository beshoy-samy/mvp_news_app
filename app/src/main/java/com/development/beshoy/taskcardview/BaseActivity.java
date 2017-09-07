package com.development.beshoy.taskcardview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by bisho on 07-Sep-17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);



    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initView(savedInstanceState);
    }

    /**
     * @return layout resource id
     */
    protected abstract int getLayoutResId();

    protected abstract void initView(Bundle savedInstanceState);

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
