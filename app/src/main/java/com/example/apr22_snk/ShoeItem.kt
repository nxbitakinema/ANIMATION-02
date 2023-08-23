package com.example.apr22_snk

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShoeItem(
    shoe: CarouselDataModel,
    pageOffset: Float,
    viewModel: MainViewModel
) {
    Box(
        modifier = Modifier
            .padding(top = 10.dp)
            .clickable { viewModel.screenState.value = MainViewModel.UiState.Details(shoe) }
    ) {
        Box(
            modifier = Modifier
                .height(280.dp)
                .width(210.dp)
                .background(color = Color.LightGray, RoundedCornerShape(16.dp))
                .padding(end = 16.dp)
        ) {
            Row(
                modifier = Modifier.padding(top = 12.dp, start = 12.dp)
            ) {
                Column {
                    Text(
                        text = shoe.title,
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = shoe.description,
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = shoe.price,
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .height(330.dp)
                .width(220.dp)
        ) {
            Image(
                painter = painterResource(id = shoe.resId),
                contentDescription = "shoe",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(Alignment.Center)
                    .rotate(330f)
                    .size(320.dp)
            )
        }
    }
}