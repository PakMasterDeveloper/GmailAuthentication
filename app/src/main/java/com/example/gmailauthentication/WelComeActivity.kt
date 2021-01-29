package com.example.gmailauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.gmailauthentication.databinding.ActivityWelComeBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth

class WelComeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelComeBinding
    private lateinit var firebaseauth:FirebaseAuth
    private lateinit var googleSign:GoogleSignInAccount
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWelComeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseauth= FirebaseAuth.getInstance()
        GoogleSignIn.getLastSignedInAccount(this).also {
            if (it != null) {
                googleSign = it
                binding.WelText.append(googleSign.displayName)
                binding.WelText.append("\n"+googleSign.email)
            }
        }
        binding.SignOutButton.setOnClickListener(View.OnClickListener {
            firebaseauth.signOut()
           startActivity(Intent(this,MainActivity::class.java))
        })
    }
}