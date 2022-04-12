package com.xz.basemvvm.callback.databind

import androidx.databinding.ObservableField

/**
 * @ClassName: ShortObservableField
 * @Author: 于学智
 * @Description:自定义的 Short 类型 ObservableField  提供了默认值，避免取值的时候还要判空
 * @CreateDate: 2022/4/12 11:53
 * @Version: 1.0
 * @E-mail:18722650553@139.com
 * @Link:https://github.com/18722650553
 */
class ShortObservableField(value: Short = 0) : ObservableField<Short>(value) {
    override fun get(): Short {
        return super.get()!!
    }
}