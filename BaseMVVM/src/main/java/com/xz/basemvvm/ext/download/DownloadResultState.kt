package com.xz.basemvvm.ext.download

/**
 * @ClassName: DownloadResultState
 * @Author: 于学智
 * @Description:
 * @CreateDate: 2022/4/12 11:53
 * @Version: 1.0
 * @E-mail:18722650553@139.com
 * @Link:https://github.com/18722650553
 */
sealed class DownloadResultState {

    companion object {

        fun onPending(): DownloadResultState = Pending

        fun onProgress(soFarBytes: Long, totalBytes: Long, progress: Int): DownloadResultState =
            Progress(soFarBytes, totalBytes, progress)

        fun onSuccess(filePath: String, totalBytes: Long): DownloadResultState =
            Success(filePath, totalBytes)

        fun onPause(): DownloadResultState = Pause

        fun onError(errorMsg: String): DownloadResultState = Error(errorMsg)
    }

    object Pending : DownloadResultState()
    data class Progress(val soFarBytes: Long, val totalBytes: Long, val progress: Int) : DownloadResultState()

    data class Success(val filePath: String, val totalBytes: Long) : DownloadResultState()
    object Pause : DownloadResultState()
    data class Error(val errorMsg: String) : DownloadResultState()
}