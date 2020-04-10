/*

import java.lang.Exception
import java.lang.IndexOutOfBoundsException
import java.util.*

fun main() {

    val scanner = Scanner(System.`in`)
    val numberMaster = mutableListOf(1, 2, 3, 4)
    val rndm = (0..9).random()
    val randomMaster = mutableListOf(rndm, rndm, rndm, rndm)
    var counter = 0
    var number: Int
    var correct = 0
    val incorrect = 4
    var badPos = 0
    val checked = BooleanArray(4)
    val used = BooleanArray(4)
    val numberUser = mutableListOf<Int>()

    println("Gib vier Zahlen von 0 - 9 einzeln ein um das Spiel zu beginnen (keine Buchstaben!): ")

    // ** Eingabe der Zahl durch den User ** //
    try {
        while (numberUser.size < 4) {
            number = scanner.nextInt()
            if (number in 0..9) {
                numberUser.add(counter, number)
                counter++
                println("Aktuelle Zahl lautet $numberUser")
            } else {
                println("Die Zahlen dürfen nicht kleiner als 0 und nicht größer als 9 sein, bitte nochmal eingeben!")
            }
        }
    } catch (e: InputMismatchException) {
        println("Bitte nur Zahlen eingeben!")
    } catch (e: IndexOutOfBoundsException) {
        println("...")
    } catch (e: Exception) {
        println("Bitte nur Zahlen eingeben!")
    }


    // ** Wenn die Eingabe des Users mit der Zufallszahl übereinstimmt ** //
    if (numberUser == randomMaster) {
        println("Du hast die Zahl erraten! Glückwunsch! Du hast das Spiel gewonnen!")
    }

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
                break
            }
        }
    }

    // ** Ausgabe Ergebnis ** //
    println("Richtige Nummern an richtigen Positionen: $correct")
    println("Richtige Nummern an falschen Positionen: $badPos")
    print("Falsche Nummern: ")
    print(incorrect - correct)
}
*/