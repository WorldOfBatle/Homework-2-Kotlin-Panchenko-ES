import java.util.Scanner
import kotlin.random.Random

fun main() {
    println("Игра «Угадай число»")

    val scanner = Scanner(System.`in`)
    var repeatGame = 1

    while (repeatGame == 1) {
        selectDifficulty(scanner)

        println("Повторить игру еще раз? 1 - да/0 - нет")
        repeatGame = readNumber(scanner, 0, 1)
    }

    println("Спасибо за игру!")
}

private fun selectDifficulty(scanner: Scanner) {
    println()
    println("Выберите уровень сложности:")
    println("1 - Начальный: от 0 до 10, 3 попытки")
    println("2 - Обычный: от 0 до 100, 7 попыток")
    println("3 - Сложный: от 0 до 100, 5 попыток")
    print("Ваш выбор: ")

    val difficulty = readNumber(scanner, 1, 3)

    if (difficulty == 1) {
        playGame(scanner, 10, 3)
    } else if (difficulty == 2) {
        playGame(scanner, 100, 7)
    } else {
        playGame(scanner, 100, 5)
    }
}

private fun playGame(scanner: Scanner, maxValue: Int, attempts: Int) {
    val secretNumber = Random.nextInt(0, maxValue + 1)
    var attemptsLeft = attempts

    println("Компьютер загадал число от 0 до $maxValue.")

    while (attemptsLeft > 0) {
        println("Осталось попыток: $attemptsLeft")
        print("Введите ваше число: ")
        val userNumber = readNumber(scanner, 0, maxValue)

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