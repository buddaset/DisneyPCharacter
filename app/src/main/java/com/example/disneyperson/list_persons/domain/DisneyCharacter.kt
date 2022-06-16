package com.example.disneyperson.list_persons.domain



interface DisneyPersonDomain {

    fun <T>  map(mapper: Mapper<T>): T

    class Base(
    private val id: Int,
    private val name: String,
    private val imageUrl: String
    ) : DisneyPersonDomain {

        override fun <T> map(mapper: Mapper<T>): T  = mapper.map(id, name, imageUrl)
    }

    interface Mapper<T> {

        fun map(id: Int, name: String, imageUrl: String) : T

    }
}