package com.gilaraji.promoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.gson.Gson
import com.gilaraji.promoapp.domain.models.PromoModels
import com.gilaraji.promoapp.presentation.ui.theme.AplikasiMobileAppPromoTheme
import com.gilaraji.promoapp.presentation.ui.view.DataItemView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Get the JSON data from the intent
            val selectedItemJson = intent.getStringExtra("selectedItem")

            // Convert JSON to Item object
            val selectedItem = Gson().fromJson(selectedItemJson, PromoModels::class.java)
            AplikasiMobileAppPromoTheme {
                Column(modifier = Modifier.padding(8.dp)) {
                    DataItemView(selectedItem)
                }

            }
        }
    }
}

