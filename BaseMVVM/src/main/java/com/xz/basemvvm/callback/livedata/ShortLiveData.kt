package com.xz.basemvvm.callback.livedata

import androidx.lifecycle.MutableLiveData

/**
 * @ClassName: ShortLiveData
 * @Author: 于学智
 * @Description:自定义的Short类型 MutableLiveData 提供了默认值，避免取值的时候还要判空
 * @CreateDate: 2022/4/12 11:53
 * @Version: 1.0
 * @E-mail:18722650553@139.com
 * @Link:https://github.com/18722650553
 */
class ShortLiveData : MutableLiveData<Short>() {
    override fun getValue(): Short {
        return super.getValue() ?: 0
    }
}