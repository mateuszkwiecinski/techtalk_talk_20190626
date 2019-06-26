package pls.help.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import pls.help.presentation.databinding.ActivityLibraryBinding

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityLibraryBinding>(this, R.layout.activity_library)
        binding.btnInLibrary.setOnClickListener { onBackPressed() }
    }
}
