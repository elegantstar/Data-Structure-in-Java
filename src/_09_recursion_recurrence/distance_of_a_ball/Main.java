package _09_recursion_recurrence.distance_of_a_ball;

import static _09_recursion_recurrence.distance_of_a_ball.DistanceOfABall.bottomUpDistance;
import static _09_recursion_recurrence.distance_of_a_ball.DistanceOfABall.totalDistance;

public class Main {
    public static void main(String[] args) {
        System.out.println(totalDistance(16, 0));
        System.out.println(totalDistance(16));
        System.out.println(bottomUpDistance(16));
    }
}
