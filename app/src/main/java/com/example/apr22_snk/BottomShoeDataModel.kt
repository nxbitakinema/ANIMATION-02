package com.example.apr22_snk

data class BottomShoeDataModel(
    val name: String,
    val price: String,
    val image: Int
) {
    companion object {
        val list = listOf(
            BottomShoeDataModel("Under Armour Phantom", "₹33000", R.drawable.armour_phantom),
            BottomShoeDataModel("Under Armour 109", "₹19000", R.drawable.under_1031),
            BottomShoeDataModel("Adidas Neo", "₹15000", R.drawable.shoe_101),
            BottomShoeDataModel("Roadster", "₹2300", R.drawable.roaster_100),
        )
    }
}


