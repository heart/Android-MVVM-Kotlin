package com.example.testjetpack.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.testjetpack.data.Quote
import com.example.testjetpack.data.QuoteRepository

class QuoteViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote:Quote) = quoteRepository.addQuote(quote)

}