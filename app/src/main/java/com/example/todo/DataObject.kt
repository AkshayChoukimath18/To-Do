package com.example.todo

object DataObject {
    var list = mutableListOf<CardInfo>()

    fun setData(title : String, priority: String){
        list.add(CardInfo(title, priority))
    }

    fun getData(): List<CardInfo>{
        return list
    }

    fun deleteData(){
        list.clear()
    }
}