import java.util.Scanner
import kotlin.random.Random

fun main() {
    println("Игра «Угадай число»")

    val scanner = Scanner(System.`in`)
    var repeatGame = 1

    while (repeatGame == 1) {
        playGame(scanner)

        println("Повторить игру еще раз? 1 - да/0 - нет")
        repeatGame = readNumber(scanner, 0, 1)
    }

    println("Спасибо за игру!")
}

private fun playGame(scanner: Scanner) {
    val secretNumber = Random.nextInt(0, 11)
    var attemptsLeft = 3

    println("Компьютер загадал число от 0 до 10.")

    while (attemptsLeft > 0) {
        println("Осталось попыток: $attemptsLeft")
        print("Введите ваше число: ")
        val userNumber = readNumber(scanner, 0, 10)

        attemptsLeft--

        if (userNumber == secretNumber) {
            println("Вы угадали! Загаданное число: $secretNumber")
            return
        } else if (userNumber < secretNumber) {
            println("Загаданное число больше.")
        } else {
            println("Загаданное число меньше.")
        }
    }

    println("Вы проиграли. Загаданное число: $secretNumber")
}

private fun readNumber(scanner: Scanner, minValue: Int, maxValue: Int): Int {
    while (true) {
        if (scanner.hasNextInt()) {
            val number = scanner.nextInt()
            scanner.nextLine()

            if (number >= minValue && number <= maxValue) {
                return number
            }

            println("Введите число от $minValue до $maxValue.")
        } else {
            scanner.nextLine()
            println("Нужно ввести целое число.")
        }

        print("Повторите ввод: ")
    }
}