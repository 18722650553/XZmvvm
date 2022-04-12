package com.xz.basemvvm.ext.download

import androidx.lifecycle.MutableLiveData

/**
 * @ClassName: downLoadExt
 * @Author: 于学智
 * @Description:
 * @CreateDate: 2022/4/12 11:53
 * @Version: 1.0
 * @E-mail:18722650553@139.com
 * @Link:https://github.com/18722650553
 */
fun downLoadExt(downloadResultState: MutableLiveData<DownloadResultState>): OnDownLoadListener {
    return object : OnDownLoadListener {
        override fun onDownLoadPrepare(key: String) {
            //开始下载
            downloadResultState.postValue(DownloadResultState.onPending())
        }

        override fun onDownLoadError(key: String, throwable: Throwable) {
            //下载错误
            downloadResultState.postValue(DownloadResultState.onError(throwable.message ?: "下载错误"))
        }

        override fun onDownLoadSuccess(key: String, path: String, size: Long) {
            //下载成功
            downloadResultState.postValue(DownloadResultState.onSuccess(path, size))
        }

        override fun onDownLoadPause(key: String) {
            //下载暂停
            downloadResultState.postValue(DownloadResultState.onPause())
        }

        override fun onUpdate(key: String, progress: Int, read: Long, count: Long, done: Boolean) {
            //正在下载
            downloadResultState.postValue(DownloadResultState.onProgress(read, count, progress))
        }
    }
}


