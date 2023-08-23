package com.example.apr22_snk

data class CartDataModel(
    val id: Int,
    val name: String,
    val price: Int,
    val image: Int,
    var quantity: Int = 1,

    ) {
    companion object {
        val list = listOf(
            CartDataModel(id = 101, "Nike Air Max 270", 12000, R.drawable.adidas_1032),
            CartDataModel(id = 102, "Under Armour 109", 19000, R.drawable.under_1031),
            CartDataModel(id = 103, "Under Armour Phantom", 33000, R.drawable.armour_phantom),
            CartDataModel(id = 104, "Adidas Neo", 15000, R.drawable.shoe_101),
            CartDataModel(id = 105, "Roadster Sneaker", 2300, R.drawable.roaster_100),
        )
    }
}