package com.example.advancedrecyclertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.advancedrecyclertest.databinding.ItemList2Binding
import com.example.advancedrecyclertest.databinding.ItemList3Binding
import com.example.advancedrecyclertest.databinding.ItemListBinding

/**
 * Nell'Adapter non metterò più un ViewHolder specifico ma uno Generico
 */

class AnimalAdapter(val animalList: List<AnimalData>) : Adapter<ViewHolder>() {


    /**
     * Abbiamo il metodo getItemViewType
     * Prende la lista di animali (le DATA CLASS), prende il suo TIPO (Enum class, quindi GATTO, CANE, TOPO)
     * Con ORDINAL prende quel tipo e lo trasforma in numero (GATTO = 0, CANE = 1, TOPO = 2;
     * questo è l'ordine in cui sono messi nella enum class)
     */
    override fun getItemViewType(position: Int): Int {
        return animalList[position].type.ordinal
    }


    /**
     * Instanziamo la enum class, e:
     * Con values facciamo diventare la Enum Class un Array [CAT, DOG, MOUSE]
     * Con find, basandoci sul suo valore ordinale (quindi in ordine numerico)
     * cerchiamo un valore specifico.
     *
     * Quindi, con questa stringa di codice cerchiamo il primo animale (variabile ENUM) nella classe
     * Animals (Enum CLASS) che ha lo stesso valore di quello che abbiamo dato nella Data Class.
     *
     * ES: Alla Data Class CAT abbiamo dato Animals.CAT come valore. Quindi questa stringa sarà TRUE
     * Quando Animals.Cat è = 0 (e abbiamo detto che con 'ordinal' sarebbe CAT= 0, DOG = 1, MOUSE = 2)
     * E quando il tipo della data class è dello stesso valore. Siccome abbiamo dato lo stesso valore,
     * quando usiamo una data class specifica, risulterà sempre true.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val enumAnimals = Animals.values().find { it.ordinal == viewType }

        /**
         * Dopo aver fatto questo giro usiamo un when, per dire quando il TIPO che cerchiamo è CAT/DOG/MOUSE
         * Prendi il suo ViewHolder, Prendi il suo Binding e fai l'inflate.
         *
         * Alla fine diciamo SE non trovi niente dai errore.
         */

        return when (enumAnimals) {
            Animals.CAT -> CatViewHolder(
                ItemList2Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            Animals.DOG -> DogViewHolder(
                ItemList3Binding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            Animals.MOUSE -> MouseViewHolder(
                ItemListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            null -> throw Exception("Mi scantavo")
        }
    }

    /**
     * Con getItemCount prendiamo la grandezza della lista di Animali
     */
    override fun getItemCount(): Int {
        return animalList.size
    }

    /**
     * Con val model = animalList[position] prendiamo l'elemento specifico della lista.
     * Sotto, vediamo come il binding viene effettuato direttamente nelle classi dei ViewHolder.
     * Poi diciamo semplicemente, QUANDO (il ViewHolder) è CatViewHolder allora esegui la sua funzione
     * onBind (che creiamo sempre noi sotto).
     *
     * Con model as AnimalData.Cat, diciamo al codice questo elemento è una Data Class, quella che ho creato io
     * Quella bella, bellissima che si chiama Cat
     */

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = animalList[position]

        when (holder) {
            is CatViewHolder -> holder.onBindCat(model as AnimalData.Cat)
            is DogViewHolder -> holder.onBindDog(model as AnimalData.Dog)
            is MouseViewHolder -> holder.onBindMouse(model as AnimalData.Mouse)
        }
    }

}

/**
 * Ed eccoci arrivati al ViewHolder. Non facciamo più estendere a un ViewHolder specifico,
 * ma uno generico.
 *
 * Apriamo le graffe e dentro creiamo una funzione (di norma onBind, ma possiamo chiamarla
 * come vogliamo)
 *
 * Nel costruttore della fuznione mettiamo la DATA CLASS e dentro facciamo il binding di quello
 * che abbiamo bisogno. Normalmente, quando abbiamo SOLO UN VIEWHOLDER questa cosa la facevamo
 * nella funzione onBindViewHolder usando holder.binding etc. etc.
 */

class CatViewHolder(val binding: ItemList2Binding) : ViewHolder(binding.root) {
    fun onBindCat(model: AnimalData.Cat) {
        binding.animalNameTv.text = model.catName
        binding.animalAgeTv.text = model.catAge.toString()
        binding.animalBreedTv.text = model.catBreed
    }
}

class DogViewHolder(val binding: ItemList3Binding) : ViewHolder(binding.root) {
    fun onBindDog(model: AnimalData.Dog) {
        binding.animalNameTv.text = model.dogName
        binding.animalAgeTv.text = model.dogAge.toString()
        binding.animalBreedTv.text = model.dogBreed
    }
}

class MouseViewHolder(val binding: ItemListBinding) : ViewHolder(binding.root) {
    fun onBindMouse(model: AnimalData.Mouse) {
        binding.animalNameTv.text = model.mouseName
        binding.animalAgeTv.text = model.mouseAge.toString()
        binding.animalBreedTv.text = model.mouseBreed
    }
}

/**
 * QUI CI STA LA ENUM CLASS.
 * E' semplicissima, come abbiamo detto, il primo elemento è CAT, il secondo DOG e il terzo MOUSE
 * Il metodo 'ordinal' delle enum class, guarda gli elementi e li da un numero
 * dal primo all'ultimo, partendo dallo zero (come un ARRAY ;))
 *
 * Quindi:
 * CAT = 0
 * DOG = 1
 * MOUSE = 2
 */

enum class Animals {
    CAT, DOG, MOUSE
}


