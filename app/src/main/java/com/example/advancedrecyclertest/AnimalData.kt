package com.example.advancedrecyclertest

sealed class AnimalData(val type: Animals) {

    data class Cat(
        val catName: String,
        val catAge: Int,
        val catBreed: String
    ) : AnimalData(Animals.CAT)

    data class Dog(
        val dogName: String,
        val dogAge: Int,
        val dogBreed: String
    ) : AnimalData(Animals.DOG)

    data class Mouse(
        val mouseName: String,
        val mouseAge: Int,
        val mouseBreed: String
    ) : AnimalData(Animals.MOUSE)

}

