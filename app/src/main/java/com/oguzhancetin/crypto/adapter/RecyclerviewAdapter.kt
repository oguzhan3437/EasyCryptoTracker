package com.oguzhancetin.crypto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.oguzhancetin.crypto.R
import com.oguzhancetin.crypto.databinding.CrptoItemviewcardBinding

import com.oguzhancetin.crypto.model.Crypto

class RecyclerviewAdapter(val clickListener: ItemClickListener) : ListAdapter<Crypto,RecyclerviewAdapter.CryptoItemViewHolder>(DiffUtil){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoItemViewHolder {
        return CryptoItemViewHolder.createCurrencyItemViewHolder(parent)
    }


    override fun onBindViewHolder(holder: CryptoItemViewHolder, position: Int) {
        holder.bind(position,clickListener)


    }

    fun CryptoItemViewHolder.bind(position: Int,clickListener: ItemClickListener){
        binding.currentCrypto = getItem(position)
        binding.clicListener = clickListener

    }


    class CryptoItemViewHolder(var binding: CrptoItemviewcardBinding) : RecyclerView.ViewHolder(binding.root){
        companion object{
            fun createCurrencyItemViewHolder(parent:ViewGroup) : CryptoItemViewHolder {
               val binding: CrptoItemviewcardBinding = DataBindingUtil.inflate(LayoutInflater
                   .from(parent.context),R.layout.crpto_itemviewcard,parent,false)

                return CryptoItemViewHolder(binding)
            }
        }
    }

}


object DiffUtil : DiffUtil.ItemCallback<Crypto>() {
    override fun areItemsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
       return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Crypto, newItem: Crypto): Boolean {
        return oldItem.price == newItem.price
    }

}

class ItemClickListener(val clickListener: (crypto:Crypto)-> Unit){
    fun onClicked(crypto: Crypto){
        clickListener(crypto)
    }
}



