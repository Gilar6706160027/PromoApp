package com.gilaraji.promoapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gilaraji.promoapp.domain.utils.toJson
import com.gilaraji.promoapp.domain.models.PromoModels
import com.gilaraji.promoapp.presentation.ui.view.PromoViewModel
import com.gilaraji.promoapp.presentation.ui.theme.AplikasiMobileAppPromoTheme
import com.gilaraji.promoapp.presentation.ui.view.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: PromoViewModel = viewModel()

            AplikasiMobileAppPromoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val dataList = remember { mutableStateListOf<PromoModels>() }
                    viewModel.getData().observe(this@MainActivity) { it ->
                        it.data?.let {
                            dataList.addAll(it)
                        }
                    }

                    HomeScreen(listTran = dataList) {
                        val i = Intent(this, ItemViewActivity::class.java)
                        i.putExtra("selectedItem", it.toJson())
                        startActivity(i)
                    }
                }
            }
        }
    }
}

