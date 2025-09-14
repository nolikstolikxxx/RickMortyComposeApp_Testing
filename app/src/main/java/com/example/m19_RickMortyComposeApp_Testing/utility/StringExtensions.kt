package com.example.m19_RickMortyComposeApp_Testing.utility

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun List<String>.addCharactersIds():List<String>{
    return this.map {
        it.split("/").last()
    }
}
fun List<String>.getEpisodes():String{
    return this.joinToString {
        it.split("/").last()
    }
}


fun String.dateTimeConverter():String{
    val dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val dateTime = LocalDateTime.parse(this,dateTimeFormat)
    return "${dateTime.dayOfMonth} ${dateTime.month.toString().lowercase().replaceFirstChar(Char::uppercase)} " +
            "${dateTime.year}, ${dateTime.hour}:${dateTime.minute}:${dateTime.second} "

}