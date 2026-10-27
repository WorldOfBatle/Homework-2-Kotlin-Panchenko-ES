import java.util.Scanner
import kotlin.random.Random

fun main() {
    println("Игра «Угадай число»")

    val scanner = Scanner(System.`in`)
    playGame(scanner)
}

private fun playGame(scanner: Scanner) {
    val secretNumber = Random.nextInt(0, 11)

    println("Компьютер загадал число от 0 до 10.")
    print("Введите ваше число: ")
    val userNumber = scanner.nextInt()

    println("Вы ввели: $userNumber")
    println("Загаданное число: $secretNumber")
}