package com.syiyi.andbase.app.main

import android.widget.Toast
import com.syiyi.andbase.R
import com.syiyi.andbase.app.main.inject.DaggerMainComponent
import com.syiyi.andbase.app.main.inject.MainModule
import com.syiyi.andbase.bean.HomeBean
import com.syiyi.andbase.bean.HomeTab
import com.syiyi.base.ex.toastLong
import com.syiyi.base.ex.toastShort
import com.syiyi.base.image.ImageLoader
import com.syiyi.base.mvp.BaseActivity
import com.syiyi.base.mvp.IPresenter
import com.syiyi.base.net.CookieHelper
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {
    override fun showData2(it: HomeTab) {
        Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
    }

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
//        ImageLoader.load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516180778&di=31dd712c9c83a9d90acfd1d5784b4ec5&imgtype=jpg&er=1&src=http%3A%2F%2Fpic29.nipic.com%2F20130529%2F7487939_203247209175_2.jpg"
//                , radius = 0.5F
//                , imageView = image)
        tv.setOnClickListener {
            val value = CookieHelper.getCookieValue("p.lrlz.com", "MPHPSESSID")
            if (value != null)
                toastShort(value)
        }
    }

    override fun getPresenter(): IPresenter {
        return presenter
    }

    override fun showData(data: HomeBean) {
        Toast.makeText(this, data.toString(), Toast.LENGTH_LONG).show()
    }

    override fun showError(code: Int, message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}