package com.xz.basemvvm.base.activity

import android.view.View
import androidx.viewbinding.ViewBinding
import com.xz.basemvvm.base.viewmodel.BaseViewModel
import com.xz.basemvvm.ext.inflateBindingWithGeneric

/**
 * @ClassName: BaseVmVbActivity
 * @Author: 于学智
 * @Description:包含 ViewModel 和 ViewBinding ViewModelActivity基类，把ViewModel 和 ViewBinding 注入进来了
 * 需要使用 ViewBinding 的清继承它
 * @CreateDate: 2022/4/12 11:53
 * @Version: 1.0
 * @E-mail:18722650553@139.com
 * @Link:https://github.com/18722650553
 */
abstract class BaseVmVbActivity<VM : BaseViewModel, VB : ViewBinding> : BaseVmActivity<VM>() {

    override fun layoutId(): Int = 0
    lateinit var mViewBind: VB

    /**
     * 创建DataBinding
     */
    override fun initDataBind(): View? {
        mViewBind = inflateBindingWithGeneric(layoutInflater)
        return mViewBind.root

    }
}