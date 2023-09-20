package com.example.advancedrecyclertest

/**
 * Ho una Data Class contenente i vari item della recycler view.
 * Nell'Adapter, in fondo ho creato una ENUM CLASS chiamata ANIMALS
 * Dove scrivo i TIPI di animali che ho. Il costruttore della SEALED
 * dovrà poi contenere quella ENUM CLASS (così ogni ANIMALE avrà un TIPO, in questo caso)
 */


sealed class AnimalData(val type: Animals) {

    data class Cat(
        val catName: String,
        val catAge: Int,
        val catBreed: String
    ) : AnimalData(Animals.CAT)

    /**
     * Qui sopra, creo la data class che ESTENDE la SEALED, Quindi DEVE contenere un TIPO
     * In questo caso Cat, ESTENDE AnimalData e nel suo costruttore metto il tipo (Animals.CAT)
     */


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

