package com.example.tutorial05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tutorial05.models.FormData
import com.example.tutorial05.models.validations.validationResult

class MainActivity : AppCompatActivity() {

    lateinit var edtStudentId: EditText
    lateinit var spnTear: Spinner
    lateinit var spnSemester:Spinner
    lateinit var cbAgree: CheckBox
    lateinit var tvYear: TextView
    lateinit var tvSemester:TextView
    private var count = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtStudentId = findViewById(R.id.edtStudentId)
        tvYear = findViewById(R.id.tvYear)
        spnTear = findViewById(R.id.spnTear)
        tvSemester = findViewById(R.id.tvSemester)
        spnSemester = findViewById(R.id.spnSemester)
        cbAgree = findViewById(R.id.cbAgree)
    }

    fun displayAlert(title:String, message:String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which ->
            // Do something when the "OK" button is clicked
            Toast.makeText(this, "Hello,",Toast.LENGTH_LONG).show()
        }
        val dialog = builder.create()
        dialog.show()
    }

    fun btnConfirmClicked(v: View){
        val myForm = FormData(
            edtStudentId.text.toString(),
            spnTear.selectedItem.toString(),
            spnSemester.selectedItem.toString(),
            cbAgree.isChecked
        )

        val studentIdValidation = myForm.validateStudentId()
        val spnTearValidation = myForm.validateYear()
        val spnSemesterValidation = myForm.validateSemester()
        val cbAgreeValidation = myForm.validateAgreement()

        when(studentIdValidation){
            is validationResult.Valid ->{
                count ++
            }
            is validationResult.Invalid ->{
                edtStudentId.error = studentIdValidation.errorMessage
            }
            is validationResult.Empty ->{
                edtStudentId.error = studentIdValidation.errorMessage
            }
        }

        when(spnTearValidation){
            is validationResult.Valid ->{
                count ++
            }
            is validationResult.Invalid ->{
                val tv:TextView = spnTear.selectedView as TextView
                tv.error =""
                tv.text = spnTearValidation.errorMessage
            }
            is validationResult.Empty ->{
                val tv: TextView = spnTear.selectedView as TextView

                tv.error =""
                tv.text = spnTearValidation.errorMessage
            }
        }


        when(spnSemesterValidation){
            is validationResult.Valid ->{
                count ++
            }
            is validationResult.Invalid ->{
                val tv:TextView = spnSemester.selectedView as TextView
                tv.error =""
                tv.text = spnSemesterValidation.errorMessage
            }
            is validationResult.Empty ->{
                val tv:TextView = spnSemester.selectedView as TextView
                tv.error =""
                tv.text = spnSemesterValidation.errorMessage
            }
        }

        when(cbAgreeValidation){
            is validationResult.Valid ->{
                count ++
            }
            is validationResult.Invalid ->{
                displayAlert("Error", cbAgreeValidation.errorMessage)
            }
            is validationResult.Empty ->{
            }
        }

        if(count==4){
            displayAlert("Success","You have successfully registered")
        }

    }

    fun btnCancelClicked(view: View) {
        // Handle the cancel button click here
        // This function will be called when the "Cancel" button is clicked
        // Implement any cancel-related logic you want here
        Toast.makeText(this, "cancel,",Toast.LENGTH_LONG).show()
    }

}


