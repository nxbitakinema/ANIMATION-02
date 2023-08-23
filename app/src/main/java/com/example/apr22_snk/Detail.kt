package com.example.apr22_snk

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class DetailState {
    COLLAPSED,
    EXPANDED
}

enum class ButtonState {
    DEFAULT,
    LOADING,
    LOADED
}

@Composable
fun Detail(
    carouselDataModel: CarouselDataModel = CarouselDataModel.listOfShoe.first(),
    viewModel: MainViewModel,
) {
    var currentState by remember { mutableStateOf(DetailState.COLLAPSED) }
    val buttonState by remember { viewModel.buttonState }

    val context = LocalContext.current

    LaunchedEffect(key1 = currentState) {
        currentState = DetailState.EXPANDED
        val activity = context as Activity
        activity.window.statusBarColor = carouselDataModel.color.toArgb()

        viewModel.cartFlow.collect {
            if (it) {
                context.startActivity(CartActivity2.intent(context))
            }
        }
    }


    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp)
            ) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .graphicsLayer {
                        translationX = 180f
                        translationY = -350f
                    }
                    .background(shape = CircleShape, color = Color.Red))
                ToolbarDetail(carouselDataModel, viewModel)
                Image(
                    painter = painterResource(id = carouselDataModel.resId),
                    contentDescription = "shoe photo",
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .align(Alignment.Center)
                        .rotate(330f)
                )
                LazyRow(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(8.dp)
                ) {
                    items(4) { _ ->
                        Image(
                            painter = painterResource(id = carouselDataModel.resId),
                            contentDescription = "shoe photo",
                            modifier = Modifier
                                .padding(8.dp)
                                .background(
                                    color = Color.LightGray.copy(.4f),
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .width(80.dp)
                                .height(60.dp)
                                .padding(8.dp)  // padding inside
                        )
                    }
                }
            }
            Divider(thickness = 1.dp)
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = carouselDataModel.description,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = carouselDataModel.price,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .background(
                                color = Color.LightGray.copy(.4f),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(4.dp)
                    )
                }
                Text(
                    text = carouselDataModel.aboutProduct,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    fontSize = 16.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "more detail",
                    color = Color.Gray,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    textDecoration = TextDecoration.Underline
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                ) {
                    Text(text = "size")
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "UK")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "USA")
                }
                LazyRow {
                    items(5) { _ ->
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .background(
                                    color = Color.LightGray.copy(.4f),
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .width(50.dp)
                                .height(40.dp)
                                .padding(4.dp)  // padding inside
                        ) {
                            Text(
                                text = "11.5",
                                color = Color.Gray,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.align(Alignment.Center)
                            )
                            Spacer(modifier = Modifier.height(60.dp))
                        }
                    }
                }
                Button(
                    onClick = { viewModel.changeButtonState() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    if (buttonState == ButtonState.DEFAULT) {
                        Text(text = "add to bag")
                    } else {
                        Text(text = "go to cart")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Pv_Detail() {
    Detail(viewModel = MainViewModel())
}