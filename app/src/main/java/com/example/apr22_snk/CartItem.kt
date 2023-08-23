package com.example.apr22_snk

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CartItem(
    cartDataModel: CartDataModel,
    onRemove: (CartDataModel) -> Unit
) {

    // val itemCount = remember { mutableStateOf(1) }

    Box(
        modifier = Modifier
            .padding(start = 10.dp)
            .fillMaxWidth()
            .animateContentSize()
            .padding(start = 16.dp, end = 8.dp, top = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .background(
                        Color.LightGray,
                        shape = RoundedCornerShape(30.dp)
                    )
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = cartDataModel.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
                Text(
                    text = "BATH ${cartDataModel.price}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_remove),
                        contentDescription = "remove"
                    )
                    Text(
                        text = "BAHT ${cartDataModel.quantity}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = "add"
                    )
                }
            }
        }
        Image(
            painter = painterResource(id = cartDataModel.image),
            contentDescription = "shoe select image",
            modifier = Modifier
                .size(150.dp)
                .rotate(25f)
                .offset(x = (-5).dp, y = (-5).dp)
        )
    }
}