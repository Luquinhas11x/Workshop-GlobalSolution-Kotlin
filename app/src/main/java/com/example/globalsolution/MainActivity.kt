package com.example.globalsolution

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globalsolution.adapter.BeachAdapter
import com.example.globalsolution.model.Beach
import com.example.globalsolution.ui.theme.GlobalSolutionTheme
import com.example.globalsolution.viewmodel.BeachViewModel

class MainActivity : ComponentActivity() {
    val viewModel: BeachViewModel by viewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val beachAdapter = BeachAdapter()

        recyclerView.adapter = beachAdapter

        val button = findViewById<Button>(R.id.btnIncluir)
        val editName = findViewById<EditText>(R.id.etName)
        val editCity = findViewById<EditText>(R.id.etCity)
        val editState = findViewById<EditText>(R.id.etState)

        button.setOnClickListener {
            val name = editName.text.toString()
            val city = editCity.text.toString()
            val state = editState.text.toString()

            if (name.isBlank() || city.isBlank() || state.isBlank()) {
                // Handle error, e.g., show a Toast message
                return@setOnClickListener
            }

            viewModel.addItem(name, city, state)

            editName.text.clear()
            editCity.text.clear()
            editState.text.clear()
        }

        viewModel.itemsLiveData.observe(this) { items ->
            beachAdapter.updateItems(items)
        }
    }
}