package com.syiyi.andbase.bean

/**
 *
 * Created by mac on 16/12/12.
 */


data class HomeTab(val tabs: List<TabsBean>) {

    data class TabsBean(val special_id: Int,
                        val name: String)
}
