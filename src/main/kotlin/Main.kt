package parking

fun main() {
    val parkingLot = mutableListOf(1)
    val commandArgs = readln().split(" ")
    if (commandArgs.first() == "park") {
        println("${commandArgs.last()} car parked in spot 2.")
    } else {
        val spot = commandArgs[1]
        if (parkingLot.contains(spot.toInt())) {
            parkingLot.remove(spot.toInt())
            println("Spot $spot is free.")
        } else {
            println("There is no car in spot $spot.")
        }
    }
}