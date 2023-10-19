package com.example.smart_appointment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.smart_appointment.databinding.ActivityRegistrationBinding
import com.example.smart_appointment.view.MainActivity
import com.google.android.material.datepicker.MaterialDatePicker

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    var datePicker: MaterialDatePicker<*>? = null
    private lateinit var mBinding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegistrationBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)

        //Binding
        mBinding.btnLogin.setOnClickListener {
            // Perform the navigation to the next activity here
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //Date Picker
        val builder: MaterialDatePicker.Builder<*> = MaterialDatePicker.Builder.datePicker()
        builder.setTitleText("Select Your DOB")
        datePicker = builder.build()
        datePicker!!.addOnPositiveButtonClickListener { mBinding.registrationLayout.textInputDOB.setText(datePicker!!.headerText) }

    }

    private fun validateFullName(): Boolean{
        var errorMessage: String? = null
        val value: String = mBinding.registrationLayout.textInputName.toString()
        if(value.isEmpty()){
            errorMessage = "Full Name is Required"
        }
        if(errorMessage != null){
            mBinding.registrationLayout.textInputName.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }
    private fun validateEmail() : Boolean{
        var errorMessage: String? = null
        val value: String = mBinding.registrationLayout.textInputEmailRegisterEdit.toString()
        if(value.isEmpty()){
            errorMessage = "Email is Required"
        }else if(Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMessage = "Email is Invalid"
        }
        if(errorMessage != null){
            mBinding.registrationLayout.textInputEmailRegister.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }
    private fun validatePassword():Boolean{
        var errorMessage: String? = null
        val value: String = mBinding.registrationLayout.textInputPasswordEdit.toString()
        if(value.isEmpty()){
            errorMessage = "Password is Required"
        }else if(value.length<8){
            errorMessage = "Password Must be 8 characters long"
        }
        if(errorMessage != null){
            mBinding.registrationLayout.textInputPassword.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }
    private fun validatePhoneNumber(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.registrationLayout.textInputPhoneNoEdit.toString()
        if(value.isEmpty()){
            errorMessage = "Phone Number is Required"
        }else if(value.length<10){
            errorMessage = "Phone Number is Invalid"
        }
        if(errorMessage != null){
            mBinding.registrationLayout.textInputPhoneNo.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }
    private fun validateDisease(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.registrationLayout.textInputMedicalHistoryEdit.toString()
        Log.d("value",value)
        if(value.isEmpty()){
            errorMessage = "Write NA if no previous Disease history"
        }
        if(errorMessage != null){
            mBinding.registrationLayout.textInputMedicalHistory.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }


    override fun onClick(view: View?) {
        TODO("Not yet implemented")
    }

}