package com.xz.basemvvm.network.manager

import com.xz.basemvvm.callback.livedata.event.EventLiveData

/**
 * @ClassName: NetworkStateManager
 * @Author: 于学智
 * @Description: 网络变化管理者
 * @CreateDate: 2022/4/12 11:53
 * @Version: 1.0
 * @E-mail:18722650553@139.com
 * @Link:https://github.com/18722650553
 */
class NetworkStateManager private constructor() {

    val mNetworkStateCallback = EventLiveData<NetState>()

    companion object {
        val instance: NetworkStateManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkStateManager()
        }
    }

}