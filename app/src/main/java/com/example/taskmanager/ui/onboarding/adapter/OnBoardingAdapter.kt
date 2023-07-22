package com.example.taskmanager.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.taskmanager.databinding.ItemOnBoardingBinding
import com.example.taskmanager.model.OnBoarding



class OnBoardingAdapter(private val onClick:()-> Unit): Adapter<OnBoardingAdapter.OnBoardingViewHolder>(){

    private val data = arrayListOf<OnBoarding>(
        OnBoarding("Вкусная еда","У нас в заведении - вкусная еда, приготовленная с любовью и заботой.", "https://e7.pngegg.com/pngimages/380/291/png-clipart-hamburger-fast-food-restaurant-junk-food-kfc-cartoon-french-fries-food-orange.png"),
        OnBoarding("Бесплатная доставка", "Мы рады предложить нашим клиентам услугу бесплатной доставки.", "https://e7.pngegg.com/pngimages/94/325/png-clipart-pizza-delivery-graphics-food-delivery-motorcycle-cartoon-logo-motorcycle-cartoon.png"),
        OnBoarding("Удобная оплата", "У нас предоставлена легкая и удобная система оплаты для вашего удобства.", "https://creazilla-store.fra1.digitaloceanspaces.com/cliparts/3229460/easy-payment-clipart-md.png")
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemOnBoardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnBoardingBinding):ViewHolder(binding.root){
        fun bind(onBoarding: OnBoarding){

            Glide.with(binding.ivBoard).load(onBoarding.image).into(binding.ivBoard)
            binding.tvTitle.text = onBoarding.title
            binding.tvDesk.text = onBoarding.desc

            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.skip.isVisible = adapterPosition != data.lastIndex
            binding.btnStart.setOnClickListener{
                onClick()
            }
            binding.skip.setOnClickListener{
                onClick()
            }
        }

    }
}