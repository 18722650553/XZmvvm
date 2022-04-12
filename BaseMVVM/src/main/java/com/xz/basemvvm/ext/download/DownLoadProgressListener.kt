package com.xz.basemvvm.ext.download

/**
 * @ClassName: DownLoadProgressListener
 * @Author: 于学智
 * @Description:
 * @CreateDate: 2022/4/12 11:53
 * @Version: 1.0
 * @E-mail:18722650553@139.com
 * @Link:https://github.com/18722650553
 */
interface DownLoadProgressListener {

    /**
     * 下载进度
     * @param key url
     * @param progress  进度
     * @param read  读取
     * @param count 总共长度
     * @param done  是否完成
     */
    fun onUpdate(key: String, progress: Int, read: Long, count: Long, done: Boolean)
}

interface OnDownLoadListener : DownLoadProgressListener {

    //等待下载
    fun onDownLoadPrepare(key: String)

    //下载失败
    fun onDownLoadError(key: String, throwable: Throwable)

    //下载成功
    fun onDownLoadSuccess(key: String, path: String, size: Long)

    //下载暂停
    fun onDownLoadPause(key: String)
}