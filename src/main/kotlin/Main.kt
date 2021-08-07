import java.util.*

fun main() {
    // Получение параметра n
    print("Введите n: ")
    val n = Scanner(System.`in`).nextInt()

    // Генерация и сортировка
    val resultArray = sortArrayList(generateArrays(n))

    // Вывод результата
    println("Массивы после сортировки:")
    resultArray.forEachIndexed { index, ints ->
        println("$index. ${ints.contentToString()}")
    }
}

fun sortArrayList(arrayList: Array<Array<Int>>): Array<Array<Int>> {
    // Сортируем все массивы, а массивы с нечетными индексами дополнительно переворачиваем
    arrayList.forEachIndexed { index, ints ->
        ints.sort()
        if (index % 2 != 0)
            ints.reverse()
    }

    return arrayList
}

fun generateArrays(n: Int): Array<Array<Int>> {
    // Массив флагов рамером 3n для размеров генерируемых массивов
    val flagsArray: Array<Boolean> = Array(3 * n) { false }

    // Массив массивов
    val arrayList: Array<Array<Int>> = Array(n) {
        Array(getSize(flagsArray)) { (0..100).random() }
    }

    return arrayList
}

// Возвращает случайное число без повтора при помощи массива флагов
fun getSize(flagsArray: Array<Boolean>): Int {
    // От 2х чтобы не было массивов размеров 0
    var size = (2..flagsArray.size).random() - 1

    while (flagsArray[size])
        size = (2..flagsArray.size).random() - 1

    flagsArray[size] = true
    return size
}