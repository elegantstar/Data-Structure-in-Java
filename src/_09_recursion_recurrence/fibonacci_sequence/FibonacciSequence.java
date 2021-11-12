package _09_recursion_recurrence.fibonacci_sequence;

public class FibonacciSequence {

    /**
     * 1 1 2 3 5 8 13 21 34 55 ....
     * (n - 2)번째 값과 (n - 1)번째 값을 더하면 n번 째 값이 되는 수열.
     *
     * a_1 = 1  a_2 = 1
     * a_n = a_(n-1) + a_(n-2)
     */

    // 매개 변수에 결과값을 넘겨주는 Top-down 방식
    public static int fibonacci(int n, int twoPrevValue, int onePrevValue) {
        // TODO : n이 5를 초과할 때 중단
        if (n > 5) {
            return onePrevValue;
        }
        // TODO : n이 1 또는 2일 때 value는 1의 값을 갖고, 그 외에는 (n-2)항과 (n-1)항의 합을 갖는다.
        int value = (n == 1 || n == 2) ? 1 : twoPrevValue + onePrevValue;
        return fibonacci(n + 1, onePrevValue, value);
    }

    // n번째 항을 구하는 Top-down 방식 2 -> fibonacci 메소드를 2^(n-2)번 호출
    public static int fibonacci(int n) {
        // TODO : n이 1 또는 2일 때 1 반환
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int bottomUpFibonacci(int n) {

        int result = 1;
        int previous = 1;
        int temp;

        if (n == 1 || n == 2) {
            return 1;
        }
        for (int i = 0; i < n - 2; i++) {
            temp = result;
            result += previous;
            previous = temp;
        }
        return result;
    }

    private static long[] memory = new long [100000];
    public static long memoizationFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        } else {
            memory[n] = memoizationFibonacci(n - 1) + memoizationFibonacci(n - 2);
        }

        return memory[n];
    }
}
