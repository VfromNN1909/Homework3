package ru.vlasoff.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import ru.vlasoff.homework3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // ключ для бандла
    companion object {
        private const val TEXT_VIEW_TEXT_KEY = "KEY"
    }
    // лениво инициализирем binding
    private val binding: ActivityMainBinding by lazy {
        val tempBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tempBinding.root)
        tempBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // вешаем слушатель на кнопку
        binding.button.setOnClickListener {
            binding.textView.text = binding.editText.text
        }
    }
    // сохраняем строку
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_VIEW_TEXT_KEY, binding.textView.text.toString())
    }
    // восстанавливаем после пересоздания активности
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getString(TEXT_VIEW_TEXT_KEY)?.let {
            binding.textView.text = it
        }
    }
}