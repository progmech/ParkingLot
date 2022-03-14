package parking

data class Car(val number: String, val color: String, val spot: Int)

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
                val car = Car(inputArgs[1], inputArgs.last(), freeSpotIndex + 1)
                parkingLot[freeSpotIndex] = car
                println("${car.color} car parked in spot ${car.spot}.")
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
            "reg_by_color" -> {
                if (parkingLot.isEmpty()) {
                    println("Sorry, a parking lot has not been created.")
                    continue
                }
                val color = inputArgs.last().uppercase()
                val regByColor = parkingLot.filter { it?.color?.uppercase() == color }.map { it?.number }
                if (regByColor.isEmpty()) {
                    println("No cars with color $color were found.")
                } else {
                    println(regByColor.joinToString())
                }
            }
            "spot_by_color" -> {
                if (parkingLot.isEmpty()) {
                    println("Sorry, a parking lot has not been created.")
                    continue
                }
                val color = inputArgs.last().uppercase()
                val spotByColor = parkingLot.filter { it?.color?.uppercase() == color }.map { it?.spot }
                if (spotByColor.isEmpty()) {
                    println("No cars with color $color were found.")
                } else {
                    println(spotByColor.joinToString())
                }
            }
            "spot_by_reg" -> {
                if (parkingLot.isEmpty()) {
                    println("Sorry, a parking lot has not been created.")
                    continue
                }
                val number = inputArgs.last()
                val spotByReg = parkingLot.filter { it?.number?.contains(number) == true }.map { it?.spot }
                if (spotByReg.isEmpty()) {
                    println("No cars with registration number $number were found.")
                } else {
                    println(spotByReg.joinToString())
                }
            }
        }
    } while (command != "exit")
}

fun createParkingLot(parkingLotSize: Int): Array<Car?> {
    println("Created a parking lot with $parkingLotSize spots.")
    return arrayOfNulls(parkingLotSize)
}


