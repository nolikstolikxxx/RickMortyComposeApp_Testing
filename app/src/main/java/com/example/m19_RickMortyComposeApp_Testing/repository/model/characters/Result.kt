package com.example.m19_RickMortyComposeApp_Testing.repository.model.characters

data class Result(
    val created: String? = null ,
    val episode: List<String>? = null ,
    val gender: String? = null ,
    val id: Int? = null ,
    val image: String? = null ,
    val location: Location? = null ,
    val name: String? = null ,
    val origin: Origin? = null ,
    val species: String? = null ,
    val status: String? = null ,
    val type: String? = null ,
    val url: String? = null
) {

    fun getLocationId(): Int? =

        if (Result().location?.url != null && LocationUrl.REGEX matches Result().location?.url.toString()) {
            Result().location?.url?.substringAfter(LocationUrl.PREFIX)?.toInt()
        } else null

}

private object LocationUrl {
    const val HTTPS = "https://"
    const val PREFIX = "location/"
    val REGEX = "$HTTPS[\\wT./]+/$PREFIX\\d+".toRegex()
}