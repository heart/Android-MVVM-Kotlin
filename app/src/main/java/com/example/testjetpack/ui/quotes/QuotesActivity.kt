package com.example.testjetpack.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testjetpack.R
import com.example.testjetpack.data.Quote
import com.example.testjetpack.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initUI()
    }

    private fun initUI() {
        val factory = InjectorUtils.provideQuotesViewmodelFactory()
        val viewModel = ViewModelProvider(this, factory).get(QuoteViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer {
            val stringBuilder = StringBuilder()
            it.forEach{q->
                stringBuilder.append("$q\n\n")
            }
            tv_quotes.text = stringBuilder.toString()
        })

        add_quote_button.setOnClickListener{
            val quote = Quote(edittext_quote.text.toString(), edittext_author.text.toString())
            viewModel.addQuote(quote)
            edittext_quote.setText("")
            edittext_author.setText("")
        }
    }

}
