package com.xz.basemvvm.base.viewmodel

import androidx.lifecycle.ViewModel
import com.xz.basemvvm.callback.livedata.event.EventLiveData

/**
 * @ClassName: BaseViewModel
 * @Author: 于学智
 * @Description: ViewModel的基类 使用ViewModel类，放弃AndroidViewModel，原因：用处不大 完全有其他方式获取Application上下文
 * @CreateDate: 2022/4/12 11:53
 * @Version: 1.0
 * @E-mail:18722650553@139.com
 * @Link:https://github.com/18722650553
 */
open class BaseViewModel : ViewModel() {

    val loadingChange: UiLoadingChange by lazy { UiLoadingChange() }

    /**
     * 内置封装好的可通知Activity/fragment 显示隐藏加载框 因为需要跟网络请求显示隐藏loading配套才加的，不然我加他个鸡儿加
     */
    inner class UiLoadingChange {
        //显示加载框
        val showDialog by lazy { EventLiveData<String>() }

        //隐藏
        val dismissDialog by lazy { EventLiveData<Boolean>() }
    }

}