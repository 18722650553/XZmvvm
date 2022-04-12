package com.xz.basemvvm.base.activity

import android.view.View
import androidx.databinding.ViewDataBinding
import com.xz.basemvvm.base.viewmodel.BaseViewModel
import com.xz.basemvvm.ext.inflateBindingWithGeneric

/**
 * @ClassName: BaseVmDbActivity
 * @Author: 于学智
 * @Description:包含ViewModel 和Databind ViewModelActivity基类，把ViewModel 和Databind注入进来了
 * 需要使用Databind的清继承它
 * @CreateDate: 2022/4/12 11:53
 * @Version: 1.0
 * @E-mail:18722650553@139.com
 * @Link:https://github.com/18722650553
 */
abstract class BaseVmDbActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmActivity<VM>() {

    override fun layoutId() = 0
    lateinit var mDatabind: DB

    /**
     * 创建DataBinding
     */
    override fun initDataBind(): View? {
        mDatabind = inflateBindingWithGeneric(layoutInflater)
        return mDatabind.root
    }
}