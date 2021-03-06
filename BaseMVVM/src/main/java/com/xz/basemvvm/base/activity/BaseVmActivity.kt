package com.xz.basemvvm.base.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.xz.basemvvm.base.viewmodel.BaseViewModel
import com.xz.basemvvm.ext.getVmClazz
import com.xz.basemvvm.network.manager.NetState
import com.xz.basemvvm.network.manager.NetworkStateManager
import com.xz.basemvvm.ext.utils.notNull

/**
 * @ClassName: BaseVmActivity
 * @Author: 于学智
 * @Description: ViewModelActivity基类，把ViewModel注入进来了
 * @CreateDate: 2022/4/12 11:53
 * @Version: 1.0
 * @E-mail:18722650553@139.com
 * @Link:https://github.com/18722650553
 */
abstract class BaseVmActivity<VM : BaseViewModel> : AppCompatActivity() {

    lateinit var mViewModel: VM
    abstract fun layoutId(): Int
    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun showLoading(message: String = "请求网络中...")
    abstract fun dismissLoading()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBind().notNull(
            {
                setContentView(it)
            },
            {
                setContentView(layoutId())
            }
        )
        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        mViewModel = createViewModel()
        registerUiChange()
        initView(savedInstanceState)
        createObserver()
        NetworkStateManager.instance
            .mNetworkStateCallback
            .observeInActivity(
                this,
                Observer {
                    onNetworkStateChanged(it)
                }
            )
    }

    /**
     * 网络变化监听 子类重写
     */
    open fun onNetworkStateChanged(netState: NetState) {}

    /**
     * 创建viewModel
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVmClazz(this))
    }

    /**
     * 创建LiveData数据观察者
     */
    abstract fun createObserver()

    /**
     * 注册UI 事件
     */
    private fun registerUiChange() {
        //显示弹窗
        mViewModel.loadingChange
            .showDialog
            .observeInActivity(
                this,
                Observer {
                    showLoading(it)
                }
            )
        //关闭弹窗
        mViewModel.loadingChange
            .dismissDialog
            .observeInActivity(
                this,
                Observer {
                    dismissLoading()
                }
            )
    }

    /**
     * 将非该Activity绑定的ViewModel添加 loading回调 防止出现请求时不显示 loading 弹窗bug
     * @param viewModels Array<out BaseViewModel>
     */
    protected fun addLoadingObserve(vararg viewModels: BaseViewModel) {
        viewModels.forEach { viewModel ->
            //显示弹窗
            viewModel.loadingChange
                .showDialog
                .observeInActivity(
                    this,
                    Observer {
                        showLoading(it)
                    }
                )
            //关闭弹窗
            viewModel.loadingChange
                .dismissDialog
                .observeInActivity(
                    this,
                    Observer {
                        dismissLoading()
                    }
                )
        }
    }

    /**
     * 供子类BaseVmDbActivity 初始化Databinding操作
     */
    open fun initDataBind(): View? {
        return null
    }
}