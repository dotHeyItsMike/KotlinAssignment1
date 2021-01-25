package com.assignmentone

import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.assignmentone.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var numb: Count = Count()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnToast.setOnClickListener {
            showToast()
        }
        if (savedInstanceState == null) {
            binding.count = numb
        } else {
            binding.count = numb
        }
        binding.btnCountUp.setOnClickListener {
            countUp()
        }
        binding.btnCountDown.setOnClickListener {
            countDown()
        }
    }
    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)

        val num : String = numb.num
        outState.putString("Num", num)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val num : String = savedInstanceState.getString("Num", "10")
        numb.num = num
        binding.count = numb
    }

    private fun showToast(){
        Toast.makeText(applicationContext,"Hello ".plus(binding.textView.text.toString()),Toast.LENGTH_SHORT).show()
    }
    private fun countUp(){
        binding.apply {
            var temp = numb.num.toInt()
            temp += 1
            numb.num = temp.toString()
            binding.count = numb
        }
    }
    private fun countDown(){
        binding.apply {
            var temp = numb.num.toInt()
            temp -= 1
            numb.num = temp.toString()
            binding.count = numb
        }
    }

}
