package com.kareem.data.models

data class PageInfoModel(
    var pageNumber: Int,
    var hasNext: Boolean
) {
    companion object {
        fun init(): PageInfoModel = PageInfoModel(pageNumber = 1, hasNext = true)
    }
}