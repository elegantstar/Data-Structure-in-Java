package _10_recursion_divide_and_conquer;

public class SumValues {
    /**
     *  재귀 - 분할 관점
     *  점화식 관점에서도 분할 병합 방식이 있고, 유사한 부분이 있으나 분할 관점을 조금 더 나눈 것으로 생각할 수 있다.
     *  '큰 문제를 작은 문제로 분할 후 작은 문제를 해결해 큰 문제를 해결하는 방식'
     *
     *  배결의 값 더하기
     *  {4, 2, 5, 1, 5, 3, 1, 2} 의 배열이 있을 때 배열을 반씩 쪼개어 분할하고, 분할한 값들을 순차적으로 더해 나가며 최종적인 결과값을 도출한다.
     *
     *  {4, 2, 5, 1}     {5, 3, 1, 2}
     *  {4, 2} {5, 1}    {5, 3}  {1, 2}
     *  {4} + {2} + {5} + {1} + {5} + {3} + {1} + {2}
     *     {6}     +     {6}           {8}     +     {3}
     *           {12}            +            {11}
     *                          {23}
     *
     * 분할 방식
     * 중앙값 = (앞 인덱스 + 마지막 인덱스) / 2
     * 좌편 sum(앞 인덱스, 중앙값)
     * 우편 sum(중앙값 + 1, 마지막 인덱스)
     *
     * 중단 조건
     * startIndex == endIndex
     */

    public static int sum(int[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return arr[startIndex];
        }
        int middleIndex = (startIndex + endIndex) / 2;
        return sum(arr, startIndex, middleIndex) + sum(arr, middleIndex + 1, endIndex);
    }
}
