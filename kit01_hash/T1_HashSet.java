package kit01_hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class T1_HashSet {


    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};
        SolutionHashT1 solution = new SolutionHashT1();
        int result = solution.solution(nums);
        System.out.println("result = " + result);


        /**
         * Set Example
         */
        // HashSet 인스턴스 생성
        Set<String> set = new HashSet<>();

        // 데이터 추가
        set.add("apple");
        set.add("banana");
        set.add("cherry");
        set.add("banana"); // 중복된 데이터는 추가되지 않음

        // 데이터 출력
        System.out.println(set); // [banana, cherry, apple]

        // 데이터 검색
        System.out.println(set.contains("banana")); // true
        System.out.println(set.contains("grape")); // false

        // 데이터 삭제
        set.remove("cherry");
        System.out.println(set); // [banana, apple]

        // 데이터 개수 확인
        System.out.println(set.size()); // 2

        // set간 교집합, 합집합, 차집합 연산
        Set<String> set1 = new HashSet<>();
        set1.add("apple");
        set1.add("orange");

        Set<String> set2 = new HashSet<>();
        set2.add("banana");
        set2.add("apple");

        // 교집합
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println(intersection); // [apple]

        // 합집합
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println(union); // [apple, orange, banana]

        // 차집합
        Set<String> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println(difference); // [orange]


    }
}


class SolutionHashT1 {
    public int solution(int[] nums) {
        Set<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return collect.size() >= nums.length / 2 ? nums.length / 2 : collect.size();
    }
}