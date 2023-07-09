package web;

import java.util.List;

/**
 * https://www.youtube.com/watch?v=S5tLVsvbHBg&t=6997s
 */
public class Index {
    // 우발적 복잡성이 더 적고 이해하기 쉬운 함수형 코드
    public static void main(String[] args) {
        var numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .forEach(System.out::println);
    }
}
