package LambdaExpressions1_1.task1;

import java.util.function.Predicate;

public class MainTask1 {
    public static void main(String[] args) {
        Calculator calculator = Calculator.instance.get();

        int a = calculator.plus.apply(1, 2);
        // Ошибака - деление на 0
//        int b = calculator.minus.apply(1, 1);

        // Исправление
        int b = calculator.minus.apply(2, 1);

        int c = calculator.devide.apply(a, b);
        System.out.println("Исправленное задание:");
        calculator.println.accept(c);

        System.out.println();

        c = calculator.multiply.apply(a, b);
        System.out.println("Произвдение:");
        calculator.println.accept(c);

        System.out.println();

        int powExample = calculator.pow.apply(a);
        System.out.println("Возведение в степень:");
        calculator.println.accept(powExample);

        System.out.println();

        int d = calculator.minus.apply(1, 2);
        int absExample = calculator.abs.apply(d);
        System.out.println("Модуль числа:");
        calculator.println.accept(absExample);

        System.out.println();

        System.out.println("Положительное число:");
        System.out.println(calculator.isPositive.test(d));
    }
}
