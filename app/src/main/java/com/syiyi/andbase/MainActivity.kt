package com.syiyi.andbase

import android.os.Bundle
import com.syiyi.andbase.bean.HomeBean
import com.syiyi.base.mvp.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(), IMainView {


    override fun createPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tv.setOnClickListener {
            presenter.getData()
        }
    }

    override fun showData(data: HomeBean) {

    }

}