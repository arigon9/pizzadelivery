package com.example.pizzadelivery

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {
    private val selectedItems = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val pizzaList = listOf(
            Pizza("Cheese $10.99"),
            Pizza("Pepperoni $12.99"),
            Pizza("Margherita $10.99"),
            Pizza("Hawaiian $11.99"),
            Pizza("Spaghetti $12.99"),
            Pizza("Caesar Salad $9.99"),
            Pizza("Soup of the day $4.99")
        )

        val pizzaRecyclerView: RecyclerView = findViewById(R.id.pizzaRecyclerView)
        pizzaRecyclerView.layoutManager = LinearLayoutManager(this)

        val pizzaAdapter = PizzaAdapter(pizzaList, object : PizzaAdapter.OnItemClickListener {
            override fun onItemClick(pizza: Pizza) {
                Toast.makeText(this@MenuActivity, "Selected: ${pizza.name}", Toast.LENGTH_SHORT).show()
                selectedItems.clear()
                selectedItems.add(pizza.name)
            }
        })

        pizzaRecyclerView.adapter = pizzaAdapter

        val nextButton: Button = findViewById(R.id.menuNextButton)
        nextButton.setOnClickListener {
            if (selectedItems.isNotEmpty()) {
                val intent = Intent(this, OrderActivity::class.java)
                intent.putStringArrayListExtra("selectedItems", ArrayList(selectedItems))
                startActivity(intent)
            } else {
                Toast.makeText(this@MenuActivity, "Please select a pizza", Toast.LENGTH_SHORT).show()
            }
        }

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}
