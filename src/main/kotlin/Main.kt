package parking

fun main() {
    val parkingLot = IntArray(20) { 0 }

    do {
        val inputArgs = readln().split(" ")
        val command = inputArgs.first()
    if (command == "park") {
        val freeSpotIndex = parkingLot.indexOfFirst { it == 0 }
        if (freeSpotIndex == -1) {
            println("Sorry, the parking lot is full.")
            continue
        }
        parkingLot[freeSpotIndex] = 1
        println("${inputArgs.last()} car parked in spot ${freeSpotIndex + 1}.")
    } else if (command == "leave") {
        val spot = inputArgs.last().toInt()
        parkingLot[spot - 1] = 0
        println("Spot $spot is free.")
    }

    } while (command != "exit")
}