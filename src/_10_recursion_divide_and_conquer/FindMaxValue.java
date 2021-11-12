package _10_recursion_divide_and_conquer;

public class FindMaxValue {
    /**
     * 정렬되지 않은 1차원 배열에서 최댓값을 구하는 것은 순차적으로 배열에 접근하여 큰 값을 찾아내는 방법으로도 가능하다.
     * 그러나 '배열의 값 더하기'와 유사하게 배열을 가장 작은 단위로 쪼갠 후 큰 값을 찾아내는 방식으로도 접근할 수 있다.
     *
     * 분할 방식
     * 중앙값 = (앞 인덱스 + 마지막 인덱스) / 2
     * 좌편 max(앞 인덱스, 중앙값)
     * 우편 max(중앙값 + 1, 마지막 인덱스)
     *
     * 중단 조건
     * startIndex == endIndex
     */

    public static int max(int[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return arr[startIndex];
        }
        int middleIndex = (startIndex + endIndex) / 2;
        int leftValue = max(arr, startIndex, middleIndex);
        int rightValue = max(arr, middleIndex + 1, endIndex);

        return Math.max(leftValue, rightValue);
    }
}
