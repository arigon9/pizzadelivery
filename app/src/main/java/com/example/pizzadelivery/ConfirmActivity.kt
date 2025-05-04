package com.example.pizzadelivery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        val selectedItems = intent.getStringArrayListExtra("selectedItems")
        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val phone = intent.getStringExtra("phone")
        val email = intent.getStringExtra("email")

        val orderSummary = StringBuilder()
        selectedItems?.forEach {
            orderSummary.append("$it\n")
        }

        val confirmText: TextView = findViewById(R.id.confirmText)
        confirmText.text = "Thank you, Your order has been placed."

        val orderSummaryText: TextView = findViewById(R.id.orderSummaryText)
        orderSummaryText.text = """
            Order Details:
            $orderSummary

            Name: $name
            Address: $address
            Phone: $phone
            Email: $email
        """.trimIndent()

        val reviewOrderButton: Button = findViewById(R.id.reviewOrderButton)
        reviewOrderButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
