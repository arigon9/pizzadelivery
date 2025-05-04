package com.example.pizzadelivery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val selectedItems = intent.getStringArrayListExtra("selectedItems")
        val orderSummaryText = selectedItems?.joinToString("\n") ?: "No items selected"
        val orderSummaryTextView: TextView = findViewById(R.id.orderSummaryTextView)
        orderSummaryTextView.text = "Your Order:\n$orderSummaryText"

        val nextButton: Button = findViewById(R.id.orderNextButton)
        nextButton.setOnClickListener {
            val name = findViewById<EditText>(R.id.customerName).text.toString()
            val address = findViewById<EditText>(R.id.customerAddress).text.toString()
            val phone = findViewById<EditText>(R.id.customerPhone).text.toString()
            val email = findViewById<EditText>(R.id.customerEmail).text.toString()

            val intent = Intent(this, ConfirmActivity::class.java)
            intent.putStringArrayListExtra("selectedItems", ArrayList(selectedItems ?: listOf()))
            intent.putExtra("name", name)
            intent.putExtra("address", address)
            intent.putExtra("phone", phone)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}
