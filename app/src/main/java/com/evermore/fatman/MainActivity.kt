package com.evermore.fatman

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.evermore.fatman.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.info.text = getString(R.string.weight_title)

    }

    override fun onResume() {
        super.onResume()

        Handler(Looper.getMainLooper()).postDelayed(
            {
                binding.weight.requestFocus()
                binding.weight.showSoftKeyboard()
            },
            (0.5*1000).toLong()
        )

    }

    // extension function to open soft keyboard programmatically
    fun EditText.showSoftKeyboard(){
        val imm = this.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }
}