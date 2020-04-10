import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

// ** Eingabe der Zahl durch den User ** //
fun enterNumberUser(randomMaster: MutableList<Int>) {
    val numberUser = mutableListOf<Int>()
    val scanner = Scanner(System.`in`)
    var number = 0
    var counter = 0
    println("*******************************************************************************************")
    println("*** Gib vier Zahlen von 0 - 9 einzeln ein um das Spiel zu beginnen (keine Buchstaben!): ***")
    println("*******************************************************************************************")

    do {
        try {
            number = scanner.nextInt()
        } catch (e: Exception) {
            println("Bitte nur Zahlen eingeben!")
            break
        }
        if (number in 0..9) {
            numberUser.add(counter, number)
            counter++
            println("Aktuelle Zahl lautet $numberUser")
        } else {
            println("Die Zahlen dürfen nicht kleiner als 0 und nicht größer als 9 sein, bitte nochmal eingeben!")
        }
    } while (numberUser.size < 4)
    userWin(numberUser, randomMaster)
    checkUserWin(numberUser, randomMaster)
}

fun userWin(
    numberUser: MutableList<Int>,
    randomMaster: MutableList<Int>
) {
    // ** Wenn die Eingabe des Users mit der Zufallszahl übereinstimmt ** //
    if (numberUser == randomMaster) {
        println("\n\n**********************************************************************")
        println("**********************************************************************")
        println("* Du hast die Zahl erraten! Glückwunsch! Du hast das Spiel gewonnen! *")
        println("**********************************************************************")
        println("**********************************************************************\n\n")
        exitProcess(0)
    }
}

fun checkUserWin(
    numberUser: MutableList<Int>,
    randomMaster: MutableList<Int>
) {
    var correct = 0
    val incorrect = 4
    var badPos = 0
    val checked = BooleanArray(4)
    val used = BooleanArray(4)

    // ** Überprüfung der Eingabe wie viele Zahlen richtig sind ** //
    for (i in 0 until 4) {
        if (numberUser[i] == randomMaster[i]) {
            correct++
            checked[i] = true
            used[i] = true
        }
    }

    // ** Überprüfung der Eingabe wie viele Zahlen richtig sind aber an falschen Positionen** //
    for (i in 0 until 4) {
        if (checked[i]) continue
        for (j in 0 until 4) {
            if (j == i || used[j]) continue
            if (numberUser[i] == randomMaster[j]) {
                used[j] = true
                badPos++
            }
        }
    }
    println("**************************************************")
    println("* Richtige Nummern an richtigen Positionen:    $correct *")
    println("* Richtige Nummern an falschen Positionen:     $badPos *")
    print("* Falsche Nummern an falschen Positionen:      ")
    print(incorrect - correct - badPos)
    println(" *")
    println(
        "**************************************************" +
                ""
    )
    println("\nNeuer Versuch? y/n")
    val userInput = readLine()
    if (userInput == "y") {
        numberUser.clear()
    } else {
        println("\nDanke für´s Mitspielen")
        exitProcess(0)
    }
}

fun gameLoop() {
    val rndm1 = (0..9).random()
    val rndm2 = (0..9).random()
    val rndm3 = (0..9).random()
    val rndm4 = (0..9).random()
    val randomMaster = mutableListOf(rndm1, rndm2, rndm3, rndm4)
    println(randomMaster)
    while (true) {
        enterNumberUser(randomMaster)
    }
}

fun main() {
    gameLoop()
}

