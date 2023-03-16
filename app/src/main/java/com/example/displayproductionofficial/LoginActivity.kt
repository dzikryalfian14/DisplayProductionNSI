package com.example.displayproductionofficial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.buttonLogin)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Cek apakah username dan password sudah diisi
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Jika sudah diisi, cek apakah username dan password sesuai
                if (username == "admin" && password == "admin123") {
                    // Jika sesuai, tampilkan toast dan pindah ke HomeActivity
                    Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    // Jika tidak sesuai, tampilkan toast bahwa username atau password salah
                    Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Jika belum diisi, tampilkan toast bahwa username atau password belum diisi
                Toast.makeText(this, "Harap isi username dan password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
