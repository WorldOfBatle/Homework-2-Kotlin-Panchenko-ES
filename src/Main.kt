import java.util.Scanner
import kotlin.random.Random

fun main() {
    println("Игра «Угадай число»")

    val scanner = Scanner(System.`in`)
    playGame(scanner)
}

private fun playGame(scanner: Scanner) {
    val secretNumber = Random.nextInt(0, 11)
    var attemptsLeft = 3

    println("Компьютер загадал число от 0 до 10.")

    while (attemptsLeft > 0) {
        println("Осталось попыток: $attemptsLeft")
        print("Введите ваше число: ")
        val userNumber = scanner.nextInt()

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