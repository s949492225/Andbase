package com.syiyi.andbase.api

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.syiyi.andbase.app.MainContract
import com.syiyi.andbase.app.MainPresenter
import org.junit.ClassRule
import org.junit.Test

/**
 *
 * Created by songlintao on 2017/12/25.
 */
class MainPresenterTest {
    companion object {
        @ClassRule
        @JvmField
        var sSchedulersOverrideRule = TestSchedulerRule()
    }

    @Test
    fun getData() {
        val view: MainContract.View = mock()
        val presenter = MainPresenter(view)
        presenter.onAttach()
        verify(view).showData(any())
    }
}