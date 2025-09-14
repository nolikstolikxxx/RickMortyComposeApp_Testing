package com.example.m19_RickMortyComposeApp_Testing.repository.model.locations

data class Info(
    val count: Int? = null ,
    val next: String? = null ,
    val pages: Int? = null ,
    val prev: Any? = null
) {
    fun getPrevPage() = getPageFrom(prev.toString())
    fun getNextPage() = getPageFrom(next)

    private fun getPageFrom(url: String?): Int? =
        if (url != null && PageUrl.REGEX matches url) {
            url.substringAfter(PageUrl.PREFIX).toInt()
        } else {
            null
        }

    private object PageUrl {
        const val HTTPS = "https://"
        const val PREFIX = "page="
        val REGEX = "$HTTPS[\\wT./]+\\?$PREFIX\\d+".toRegex()
    }
}