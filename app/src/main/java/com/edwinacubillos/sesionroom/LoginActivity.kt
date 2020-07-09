package com.edwinacubillos.sesionroom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onStart() {
        super.onStart()
        val user = mAuth.currentUser
        if (user != null)
            goToMainActivity()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bt_registro.setOnClickListener {
            goToRegistroActivity()
        }

        bt_login.setOnClickListener {
            val email = et_email.text.toString()
            val password = et_password.text.toString()
            signInWithFirebase(email, password)
        }
    }

    private fun signInWithFirebase(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(
                this
            ) { task ->
                if (task.isSuccessful) {
                    goToMainActivity()
                } else {
                    showMessage("Authentication failed")
                    Log.w("TAG", "signInWithEmail:failure", task.getException());
                }
            }
    }

    private fun showMessage(msg: String) {
        Toast.makeText(
            this, msg,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun goToRegistroActivity() {
        startActivity(Intent(this, RegistroActivity::class.java))
    }

    private fun goToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}