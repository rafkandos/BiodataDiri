package com.example.biodatadiri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var edtName : EditText? = null
    var spinnerGender : Spinner? = null
    var edtEmail : EditText? = null
    var edtTelp : EditText? = null
    var edtAlamat : EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edtName)
        spinnerGender = findViewById(R.id.spinnerGender)
        edtEmail = findViewById(R.id.edtEmail)
        edtTelp = findViewById(R.id.edtTelp)
        edtAlamat = findViewById(R.id.edtAddress)

        btnSave.setOnClickListener { validasiInput() }
    }

    private fun goToProfilActivity() {
        val intent = Intent(this, ProfilActivity::class.java)
        startActivity(intent)
    }

    //variabel global
    private var namaInput : String = ""
    private var emailInput : String = ""
    private var telpInput : String = ""
    private var alamatInput : String = ""
    private var genderInput : String = ""

    private fun validasiInput(){
        namaInput = edtName?.text.toString()
        emailInput = edtEmail?.text.toString()
        telpInput = edtTelp?.text.toString()
        alamatInput = edtAddress.text.toString()
        genderInput = spinnerGender?.selectedItem.toString()

        when{
            namaInput.isEmpty() -> edtName?.error = "Nama tidak boleh kosong"
            genderInput.equals("Pilih Jenis Kelamin", ignoreCase = true) -> tampilToast("Jenis Kelamin harus dipilih")
            emailInput.isEmpty() -> edtEmail?.error = "Email tidak boleh kosong"
            telpInput.isEmpty() -> edtTelp?.error = "Telp tidak boleh kosong"
            alamatInput.isEmpty() -> edtAlamat?.error = "Alamat tidak boleh kosong"

            else -> {
                tampilToast("Navigasi ke halaman profil")
                goToProfilActivity()
            }
        }
    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}