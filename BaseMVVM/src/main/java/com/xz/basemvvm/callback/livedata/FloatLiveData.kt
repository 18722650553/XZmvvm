package com.xz.basemvvm.callback.livedata

import androidx.lifecycle.MutableLiveData

/**
 * @ClassName: FloatLiveData
 * @Author: 于学智
 * @Description:自定义的Float类型 MutableLiveData 提供了默认值，避免取值的时候还要判空
 * @CreateDate: 2022/4/12 11:53
 * @Version: 1.0
 * @E-mail:18722650553@139.com
 * @Link:https://github.com/18722650553
 */
class FloatLiveData(value: Float = 0f) : MutableLiveData<Float>(value) {
    override fun getValue(): Float {
        return super.getValue()!!
    }
}