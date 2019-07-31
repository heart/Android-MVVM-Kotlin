package com.example.testjetpack.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testjetpack.data.QuoteRepository

class QuoteViewmodelFactory( private  val quoteRepository: QuoteRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T:ViewModel?> create(modelClass: Class<T>):T{
        return QuoteViewModel(quoteRepository) as T
    }
}