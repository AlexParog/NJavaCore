package LambdaExpressions1_1.task1;

import java.util.function.*;

// Supplier<T> не принимает никаких аргументов, но возвращает объект типа T
public class Calculator implements Supplier {

    public static Supplier<Calculator> instance = Calculator::new;

    // Принимает в качестве параматра два объекта типа T,
    // выполняет над ними бинарную операцию и возвращает результат в виде объекта типа T
    public BinaryOperator<Integer> plus = (x, y) -> x + y;
    public BinaryOperator<Integer> minus = (x, y) -> x - y;
    public BinaryOperator<Integer> multiply = (x, y) -> x * y;
    public BinaryOperator<Integer> devide = (x, y) -> x / y;

    // Принимает в качестве параматра объект типа T,
    // выполняет над ними операции и возвращает результат в виде объекта типа T
    public UnaryOperator<Integer> pow = x -> x * x;
    public UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    public Predicate<Integer> isPositive = x -> x > 0;

    // Consumer<T> выполняет некоторое дейтсвие над объектом типа T,
    // ничего не возвращая
    public Consumer<Integer> println = System.out::println;

    @Override
    public Object get() {
        return instance;
    }
}
