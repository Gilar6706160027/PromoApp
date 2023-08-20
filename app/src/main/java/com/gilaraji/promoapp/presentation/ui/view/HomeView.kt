package com.gilaraji.promoapp.presentation.ui.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gilaraji.promoapp.domain.models.PromoModels

@Composable
fun HomeScreen(
    listTran: SnapshotStateList<PromoModels>,
    onClick: (PromoModels) -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {
        Toolbar()
        ItemList(listTran) {
            onClick(it)
        }
    }


}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Toolbar(){
    Surface(
    ) {
        Column() {
            TopAppBar(title = { Text(text = "List Promo") })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemList(
    listTran: SnapshotStateList<PromoModels>,
    onClick: (PromoModels) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        content = {

            items(listTran) { item ->
                ListItem(item){
                    onClick(it)
                }
            }

        }
    )
}
@Preview(showBackground = true)
@Composable
fun ListItem(item: PromoModels, onClick: (PromoModels) -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onClick(item)
            },
        color = MaterialTheme.colorScheme.surface,

        ) {
        CardQRView(modifier = Modifier.padding(top = 8.dp, end = 16.dp, start = 16.dp)
            , data = item)
    }
}

@Preview(showBackground = true)
@Composable
fun CardQRView(modifier: Modifier, data: PromoModels?) {

    Column(modifier = modifier) {
        Surface(
            // Adjust the size of the box as needed
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color.Gray),
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier
                            .weight(1f),
                        textAlign = TextAlign.Center,
                        text = "${data?.nama}",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace
                        )
                    )
                }

                Text(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    text = "Count: ${data?.count}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace
                    )
                )
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp),
                    text = "${data?.publishedAt}",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace
                    )
                )
            }
        }
    }
}


