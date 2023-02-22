package com.example.newprojectwithroomdb

val cityList = listOf("Dhaka","Chittagong","Rajshahi","Khulna","Cox's Bazar","Sylhet","Comilla","Noakhali","Barishal")
val busTypeEconomy = "Economy"
val busTypeBusiness = "Business"

data class BusSchedule(
    val id: Long,
    val busName: String,
    val from: String,
    val to: String,
    val departureDate: String,
    val departureTime: String,
    val busType: String
)

val scheduleList = mutableListOf<BusSchedule>()