package LAB_3

data class Car(
    val id: Int,
    val type: CarTypes,
    val passengers: PassengerTypes,
    val isDining: Boolean,
    val consumption: Int
)