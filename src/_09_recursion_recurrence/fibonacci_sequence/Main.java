package _09_recursion_recurrence.fibonacci_sequence;

import static _09_recursion_recurrence.fibonacci_sequence.FibonacciSequence.bottomUpFibonacci;
import static _09_recursion_recurrence.fibonacci_sequence.FibonacciSequence.fibonacci;
import static _09_recursion_recurrence.fibonacci_sequence.FibonacciSequence.memoizationFibonacci;

public class Main {
    public static void main(String[] args) {
        System.out.println(fibonacci(1, 1, 1));
        System.out.println(fibonacci(5));
        System.out.println(bottomUpFibonacci(5000));
        System.out.println(memoizationFibonacci(5000));
    }
}
