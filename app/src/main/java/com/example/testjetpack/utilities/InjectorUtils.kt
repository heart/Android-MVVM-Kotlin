package com.example.testjetpack.utilities

import com.example.testjetpack.data.FakeDatabase
import com.example.testjetpack.data.QuoteRepository
import com.example.testjetpack.ui.quotes.QuoteViewmodelFactory

object InjectorUtils {
    fun provideQuotesViewmodelFactory(): QuoteViewmodelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuoteViewmodelFactory(quoteRepository)
    }
}