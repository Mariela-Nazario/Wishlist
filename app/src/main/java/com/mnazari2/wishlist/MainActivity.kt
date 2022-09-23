package com.mnazari2.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var f_items: MutableList<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button2)
        val itemName = findViewById<View>(R.id.item_name) as EditText
        val itemPrice = findViewById<View>(R.id.price) as EditText
        val itemURL = findViewById<View>(R.id.url) as EditText
          f_items = ArrayList()
        val  Rv = findViewById<RecyclerView>(R.id.Rv)

        val adapter = itemAdapter(f_items)


        button.setOnClickListener{

            val name = itemName.text.toString()
            val p = itemPrice.text.toString()
            val u = itemURL.text.toString()
            val ite = Item(name, p, u)
            f_items.add(ite)
            adapter.notifyDataSetChanged();
            itemName.text.clear()
            itemPrice.text.clear()
            itemURL.text.clear()

        }
        Rv.adapter = adapter
        Rv.layoutManager = LinearLayoutManager(this)

    }
}