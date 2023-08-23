package com.example.apr22_snk

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToolbarDetail(
    carouselDataModel: CarouselDataModel = CarouselDataModel.listOfShoe.first(),
    viewModel: MainViewModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_right_arrow),
            contentDescription = "icon back to home",
            modifier = Modifier
                .rotate(180f)
                .size(24.dp)
                .clickable { viewModel.onBackClick() }
        )
        Text(
            text = carouselDataModel.title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
        Image(
            painter = painterResource(id = R.drawable.ic_heart),
            contentDescription = "icon add to favorite",
            modifier = Modifier.size(24.dp)
        )
    }
}

