package _09_recursion_recurrence.distance_of_a_ball;

public class DistanceOfABall {

    // 공의 이동 거리(반복 순차 방식)

    /**
     * 지면으로부터 높이 h 만큼 떨어진 곳에서 공을 낙하시킨다.
     * 공은 한 번 튕겨져 나올 때마다 기존 높이의 1/2만큼 튀어 오른다고 할 때,
     * 공이 튀어 오르는 높이가 1 미만이 될 때까지 공이 이동한 거리의 총합을 구해보자.
     *
     * 높이 16인 곳에서 처음 낙하를 시작한다면?
     * h_1 = 16   a_1 = 16    S_1 = a_1
     * h_2 = 8    a_2 = 16    S_2 = S_1 + a_2
     * h_3 = 4    a_3 = 8     S_3 = S_2 + a_3
     * h_4 = 2    a_4 = 4     S_4 = S_3 + a_4
     *
     * h_n = 1    a_n = 2     S_n = S_(n-1) + a_n
     */

    public static int totalDistance(int h, int distance) {
        // TODO : 공이 튀어 오르는 높이 h가 1 미만이 되는 경우 중단
        if (1 > h) {
            return distance;
        }
        // TODO : 처음 낙하를 시작하는 경우 낙하 높이 만큼 이동하기 때문에 an은 h,
        // TODO : 첫 낙하 이후로는 튀어 오른 높이 만큼 다시 낙하하므로 이동 거리는 2*h
        int an = (distance == 0) ? h : 2*h;
        int totalDistance = distance + an;

        return totalDistance(h / 2, totalDistance);
    }

    public static int totalDistance(int h) {
        if (h == 1) {
            return h;
        }

        return h + (h / 2) + totalDistance(h / 2);
    }

    // f(h) = 3/2h + f(h/2)

    // f(n) = f(n-1) + f(n-2) (n=1 : 1, n=2 : 1)

    public static int bottomUpDistance(int h) {
        int totalDistance = 0;

        while (h >= 1) {
            totalDistance += h + (h / 2);
            h = h / 2;
        }
        return totalDistance + h;
    }

}
