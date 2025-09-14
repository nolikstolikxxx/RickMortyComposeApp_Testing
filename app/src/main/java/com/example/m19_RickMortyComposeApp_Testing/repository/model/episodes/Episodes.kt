package com.example.m19_RickMortyComposeApp_Testing.repository.model.episodes

import com.google.gson.annotations.SerializedName

data class Episodes(
    @SerializedName("episodes") val episodes: ArrayList<Episode>
)