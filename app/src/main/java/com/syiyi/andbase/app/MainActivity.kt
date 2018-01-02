package com.syiyi.andbase.app

import android.widget.Toast
import com.syiyi.andbase.R
import com.syiyi.andbase.app.inject.DaggerMainComponent
import com.syiyi.andbase.app.inject.MainModule
import com.syiyi.andbase.bean.HomeBean
import com.syiyi.base.mvp.BaseActivity
import com.syiyi.base.mvp.IPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun inject() {
        DaggerMainComponent
                .builder()
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }

    override fun initView() {
        tv.setOnClickListener {
            presenter.getData()
        }
    }

    override fun getPresenter(): IPresenter {
        return presenter
    }

    override fun showData(data: HomeBean) {
        Toast.makeText(this, data.toString(), Toast.LENGTH_LONG).show()
    }

}