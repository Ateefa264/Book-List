package com.example.library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.library.adapter.ItemRecyclerViewAdapter
import com.example.library.model.ItemModel

class MainActivity : AppCompatActivity() {
    private val itemList = ArrayList<ItemModel>()
    private lateinit var itemRecyclerViewAdapter: ItemRecyclerViewAdapter
    private lateinit var itemRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initUI()
    }

    private fun initUI() {
        itemRecyclerView = findViewById(R.id.recyclerView)
        val bookNames = arrayOf("Consequences of Capitalism", "The Communist MANIFESTO", "The Godfather", "Why Nations Fail", "On Liberty", "On The Social Contract", "The Republic", "Who Rules the World?", "A Thousand Splendid Suns", "Deliverance From the Cross", "The Running Grave")
        val authors = arrayOf("Noam Chomsky", "Karl Marx & Friedrich", "Mario Puzo", " Acemoglu &  Robinson", "John Stuart Mill", "Jean-Jacques Rousseau", "Plato", "Noam Chomsky", "Khaled Hosseini", " Sir Zafarullah Khan", "J.K. Rowling")
        val images = arrayOf(R.drawable.capitalism, R.drawable.communist, R.drawable.godfather, R.drawable.fail, R.drawable.liberty, R.drawable.contract, R.drawable.republic, R.drawable.rules, R.drawable.suns, R.drawable.cross, R.drawable.grave)

        for (i in bookNames.indices) {
            itemList.add(ItemModel(images[i], bookNames[i], authors[i]))
        }

        itemRecyclerView.layoutManager = LinearLayoutManager(this)
        itemRecyclerViewAdapter = ItemRecyclerViewAdapter(itemList)
        itemRecyclerView.adapter = itemRecyclerViewAdapter
    }
}
