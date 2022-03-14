package parking

data class Car(val number: String, val color: String)

fun main() {
    var parkingLotSize: Int
    var parkingLot: Array<Car?> = emptyArray()

    do {
        val inputArgs = readln().split(" ")
        val command = inputArgs.first()
        when (command) {
            "create" -> {
                parkingLotSize = inputArgs.last().toInt()
                parkingLot = createParkingLot(parkingLotSize)
            }
            "park" -> {
                if (parkingLot.isEmpty()) {
                    println("Sorry, a parking lot has not been created.")
                    continue
                }
                val freeSpotIndex = parkingLot.indexOfFirst { it == null }
                if (freeSpotIndex == -1) {
                    println("Sorry, the parking lot is full.")
                    continue
                }
                val car = Car(inputArgs[1], inputArgs.last())
                parkingLot[freeSpotIndex] = car
                println("${car.color} car parked in spot ${freeSpotIndex + 1}.")
            }
            "status" -> {
                if (parkingLot.isEmpty()) {
                    println("Sorry, a parking lot has not been created.")
                    continue
                }
                if (parkingLot.filterNotNull().isEmpty()) {
                    println("Parking lot is empty.")
                    continue
                }
                for (car in parkingLot.filterNotNull()) {
                    println("${parkingLot.indexOf(car) + 1} ${car.number} ${car.color}")
                }
            }
            "leave" -> {
                if (parkingLot.isEmpty()) {
                    println("Sorry, a parking lot has not been created.")
                    continue
                }
                val spot = inputArgs.last().toInt()
                parkingLot[spot - 1] = null
                println("Spot $spot is free.")
            }
        }
    } while (command != "exit")
}

fun createParkingLot(parkingLotSize: Int): Array<Car?> {
    println("Created a parking lot with $parkingLotSize spots.")
    return arrayOfNulls(parkingLotSize)
}


