package com.collagemedia.kotlinexample.model

/*
 * Created by Gia An Bee on 6/2/2017.
 */
class StudentModel {
    var id: Int = 0
    var name: String? = null
    var image: Int = 0
    var birthday: String? = null


    constructor() {

    }

    constructor(id: Int, image: Int, name: String, birthday: String) {
        this.id = id
        this.name = name
        this.image = image
        this.birthday = birthday
    }

}