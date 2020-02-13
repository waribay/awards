package com.waribay.award.Models

class AwardsModel {

    private var type   : String? = null
    private var poin   : Int = 0
    private var name   : String? = null
    private var image  : Int = 0

    fun getName(): String {
        return name.toString()
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getType(): String {
        return type.toString()
    }

    fun setType(type: String) {
        this.type = type
    }

    fun getPoin(): Int {
        return poin
    }

    fun setPoin(poin: Int) {
        this.poin = poin
    }

    fun getImage(): Int {
        return image
    }

    fun setImage(image: Int) {
        this.image = image
    }

}