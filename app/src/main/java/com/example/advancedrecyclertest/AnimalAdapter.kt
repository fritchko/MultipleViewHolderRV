package com.example.advancedrecyclertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.advancedrecyclertest.databinding.ItemList2Binding
import com.example.advancedrecyclertest.databinding.ItemList3Binding
import com.example.advancedrecyclertest.databinding.ItemListBinding

class AnimalAdapter(val animalList: List<AnimalData>) : Adapter<AnimalViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return animalList[position].type.ordinal
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val enumAnimals = Animals.values().find { it.ordinal == viewType }

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

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val model = animalList[position]

        when (holder) {
            is CatViewHolder -> holder.onBindCat(model as AnimalData.Cat)
            is DogViewHolder -> holder.onBindDog(model as AnimalData.Dog)
            is MouseViewHolder -> holder.onBindMouse(model as AnimalData.Mouse)
        }
    }
}


open class AnimalViewHolder(mView: View) : ViewHolder(mView)

class CatViewHolder(val binding: ItemList2Binding) : AnimalViewHolder(binding.root) {
    fun onBindCat(model: AnimalData.Cat) {
        binding.animalNameTv.text = model.catName
        binding.animalAgeTv.text = model.catAge.toString()
        binding.animalBreedTv.text = model.catBreed
    }
}

class DogViewHolder(val binding: ItemList3Binding) : AnimalViewHolder(binding.root) {
    fun onBindDog(model: AnimalData.Dog) {
        binding.animalNameTv.text = model.dogName
        binding.animalAgeTv.text = model.dogAge.toString()
        binding.animalBreedTv.text = model.dogBreed
    }
}

class MouseViewHolder(val binding: ItemListBinding) : AnimalViewHolder(binding.root) {
    fun onBindMouse(model: AnimalData.Mouse) {
        binding.animalNameTv.text = model.mouseName
        binding.animalAgeTv.text = model.mouseAge.toString()
        binding.animalBreedTv.text = model.mouseBreed
    }
}

enum class Animals {
    CAT, DOG, MOUSE
}


