package app;

import java.util.Arrays;
import java.util.Random;


public class Main {

    static int[] arrayNums;
    static int loopIndex;
    static int negativeNumbersSum;
    static int evenNumbersCount;
    static int oddNumbersCount;
    static int leastNumber;
    static int leastNumberPosition;
    static int biggestNumber;
    static int biggestNumberPosition;
    static double averageNumber = 0.0;
    static int averageItemCount = 0;
    static int firstNegativeNumbersPosition = -1;


    public static void main(String[] args) {

        //Створення масиву, ініціалізація Random
        arrayNums = new int[20];
        Random rnd = new Random();

        //Присвоєння випадкових чисел і зміна знаку випадковим способом
        for (loopIndex = 0; loopIndex < arrayNums.length; loopIndex++) {
            arrayNums[loopIndex] = rnd.nextInt(100) + 1;
            if (rnd.nextBoolean()) arrayNums[loopIndex] = Math.negateExact(arrayNums[loopIndex]);
        }

        leastNumberPosition = 1;
        leastNumber = arrayNums[leastNumberPosition-1];
        biggestNumberPosition = 1;
        biggestNumber = arrayNums[biggestNumberPosition-1];

        //Перевірка масиву
        //Якщо в масиві кілька найбільших або найменших елементів номер той який перший попався
        for (loopIndex = 0; loopIndex < arrayNums.length; loopIndex++) {

            if (arrayNums[loopIndex] < 0) negativeNumbersSum += arrayNums[loopIndex];

            if ((arrayNums[loopIndex] % 2) == 0) evenNumbersCount++;
            else oddNumbersCount++;

            if (arrayNums[loopIndex] < leastNumber) {
                leastNumber = arrayNums[loopIndex];
                leastNumberPosition = loopIndex + 1;
            }

            if (arrayNums[loopIndex] > biggestNumber) {
                biggestNumber = arrayNums[loopIndex];
                biggestNumberPosition = loopIndex + 1;
            }
        }

        //Обчислення середнього арифметичного
        for (loopIndex = 0; loopIndex < arrayNums.length; loopIndex++)
            if (arrayNums[loopIndex] < 0) {
                firstNegativeNumbersPosition = loopIndex;
                break;
            }
        for (loopIndex = firstNegativeNumbersPosition + 1; loopIndex < arrayNums.length; loopIndex++) {
            averageNumber += arrayNums[loopIndex];
            averageItemCount++;
        }
        if (averageItemCount > 0) averageNumber /= averageItemCount;


        //Вивід
        System.out.println("Елементи масиву: " + Arrays.toString(arrayNums));
        System.out.println("Сума від'ємних чисел: " + negativeNumbersSum);
        System.out.println("Кількість парних чисел: " + evenNumbersCount);
        System.out.println("Кількість непарних чисел: " + oddNumbersCount);
        System.out.println("Найменший елемент: " + leastNumber + " (з індексом " + leastNumberPosition + ")");
        System.out.println("Найбільший елемент: " + biggestNumber + " (з індексом " + biggestNumberPosition + ")");

        if ((firstNegativeNumbersPosition >= 0) && (firstNegativeNumbersPosition < (arrayNums.length-1)))
            System.out.printf("Середнє арифметичне чисел після першого від'ємного числа: %.2f", averageNumber);

        if (firstNegativeNumbersPosition == (arrayNums.length-1))
            System.out.printf("Неможливо обчислити середнє арифмтичне елементів масиву. Перше від'єме число останній елемент масиву");

        if (firstNegativeNumbersPosition <0)
            System.out.println("Від'ємні числа в масиві не знайдені");
    }
}

