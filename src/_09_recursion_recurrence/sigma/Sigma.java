package _09_recursion_recurrence.sigma;

public class Sigma {

    // 시그마(반복 순차 방식) : 재귀 호출 방식이 아닌 하나의 반복문으로도 해결 가능

    /**
     * S = ∑ n (n = 1 -> n = 5)
     * S_n+1 = S_n + f(n)
     * n이 5를 초과하면 중단!
      */
    public static int f(int n) {
        return n;
    }

    // 매개변수에 결과를 넘겨주는 방법
    public static int sigma(int n, int sum) {
        // TODO : n이 5를 초과하면 중단되도록 중단 조건 설정
        if (5 < n) {
            return sum;
        }
        // TODO : n이 1일 때는 초항이 되도록 f(n)을 호출, 1이 아닐 때는 기존 합과 n번 째 항의 합을 nextSum 값을 저장.
        int nextSum = (1 == n) ? f(n) : sum + f(n);
        // TODO : 다음 연산을 수행하기 위해 sigma 메서드를 재귀적으로 호출.
        return sigma(n + 1, nextSum);
    }

    // TopDown : 1부터 n까지의 합.
    // S_n = n + S_n-1 (S_1 = 1)
    public static int sigma(int n) {
        if (n == 1) {
            return n;
        }
        return n + sigma(n-1); // n + (n-1) + sigma(n-2)
    }

    //bottom-up
    public static int bottomUpSigma(int n) {
        int sum = 1;
        for (int i = 1; i < n; i++) {
            sum += i;
        }

        return sum;
    }
}
