package com.example.poo.parsing

object DataManager {
    val matchList = mutableListOf<Match>()
    var matchIndex = 0

    fun addDay(day : Match){
        matchList.add(day)
    }
    fun getCurrentDay():Match = matchList[matchIndex]

    fun getNextDay(): Match {
        if (matchIndex < 30 ){
            matchIndex++}
        return matchList[matchIndex]
    }

    fun getPreviousDay(): Match {
        if (matchIndex > 0 ){
            matchIndex--}
        return matchList[matchIndex]
    }
}