package com.mugerwa.icare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.core.view.isVisible
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity  : AppCompatActivity() {
    private lateinit var emailInput: EditText
    private  lateinit var  emailContainer: TextInputLayout
    private  lateinit var passwordInput: EditText
    private lateinit var passwordContainer: TextInputLayout
    private  lateinit var confirmPasswordInput: EditText
    private lateinit var confirmPasswordContainer: TextInputLayout
    private lateinit var signUpButton: Button
    private lateinit var auth: FirebaseAuth
    // ...
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        // Initialize Firebase Auth
        auth = Firebase.auth
//        binding
        emailInput=findViewById(R.id.emailLoginInput)
        emailContainer=findViewById(R.id.emailRegContainer)

        passwordInput=findViewById(R.id.passwordLoginInput)
        passwordContainer=findViewById(R.id.passwordRegContainer)

        confirmPasswordInput=findViewById(R.id.confirmpasswordRegInput)
        confirmPasswordContainer=findViewById(R.id.confirmpasswordRegContainer)
        signUpButton=findViewById(R.id.registerButton)


        emailInput.addTextChangedListener(validateRegister)
        passwordInput.addTextChangedListener(validateRegister)
        confirmPasswordInput.addTextChangedListener(validateRegister)
        var progressBar=findViewById<ProgressBar>(R.id.registerProgressBar)



        signUpButton.setOnClickListener {
            signUpButton.isEnabled=false
            progressBar.isVisible=true

            emailInput.isEnabled=false
            passwordInput.isEnabled=false
            confirmPasswordInput.isEnabled=false
//            FIREBASE
            val password=passwordInput.text.toString().trim()
            val email=emailInput.text.toString().trim()
            //            signup new users
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val intent= Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                        progressBar.isVisible=false

                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
//                        progressBar.isVisible=false
//                        signUpButton.isEnabled=true
                    }
                }
        }

//        loginf here link
        val  loginLink: TextView =findViewById(R.id.registerLink)
        loginLink.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }


    }
    private val validateRegister=object: TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val email=emailInput.text.toString().trim().lowercase()
            val password=passwordInput.text.toString().trim().lowercase()
            val confirmpassword=confirmPasswordInput.text.toString()
            fun validateEmail(): Boolean {

                if(email.isBlank()){
                    emailContainer.isErrorEnabled=true
                    emailContainer.error="Email is required"
                    signUpButton.isEnabled=false
                    return false

                }else{
                    emailContainer.isErrorEnabled=false
                    signUpButton.isEnabled=true
                    return true
                }

            }

            fun validatePassword(): Boolean {

                if (password.isBlank()) {
                    passwordContainer.isErrorEnabled = true
                    passwordContainer.error = "Password is required"
                    signUpButton.isEnabled = false
                    return false

                }else if(password.length<8){
                    passwordContainer.isErrorEnabled = true
                    passwordContainer.error = "Weak password (8-12)"
                    signUpButton.isEnabled = false
                    return false

                } else {
                    passwordContainer.isErrorEnabled = false
                    return true
                    signUpButton.isEnabled = true

                }
            }

            fun validateConfirmPassword():Boolean{
                if(confirmpassword.isBlank()){
                    confirmPasswordContainer.isErrorEnabled=true
                    confirmPasswordContainer.error="confirm password is required"
                    signUpButton.isEnabled=false
                    return false
                }else if(confirmpassword!=password){
                    confirmPasswordContainer.isErrorEnabled=true
                    confirmPasswordContainer.error="password mismatch"
                    passwordContainer.isErrorEnabled = true
                    passwordContainer.error = "Password is mismatch"
                    signUpButton.isEnabled = false
                    return false
                }else{
                    confirmPasswordContainer.isErrorEnabled=false
                    signUpButton.isEnabled=true
                    return true
                }
            }
            signUpButton.isEnabled=validateEmail()&&validatePassword()&&validateConfirmPassword()
        }

        override fun afterTextChanged(p0: Editable?) {

        }

    }


}