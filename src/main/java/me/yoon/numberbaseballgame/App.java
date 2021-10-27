package me.yoon.numberbaseballgame;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        List<Integer> numbers = generator.createHiddenNumbers();
        numbers.forEach(System.out::println);

        Referee referee = new Referee();
        int judgement = referee.judgement(Arrays.asList(0, 7, 6, 2), Arrays.asList(2, 0, 7, 6));
        System.out.println("judgement = " + judgement);
    }
}
