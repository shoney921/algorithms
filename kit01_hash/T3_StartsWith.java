package kit01_hash;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class T3_StartsWith {


    public static void main(String[] args) {
        SolutionHashT3 sol = new SolutionHashT3();
        String[] input = {"115234", "115", "2424", "1132425"};
        boolean solution = sol.solution(input);
        System.out.println("solution = " + solution);

        /**
         * 비교 하는 메서드 구현하는 람다식
         * 장점 : 스코프가 밖의 변수를 사용할 수 있음
         */
        List<String> collect = Arrays.stream(input).sorted((x, y) -> x.length() - y.length()).collect(Collectors.toList());
        for (String s : collect) {
//            System.out.println("s = " + s);
        }

    }

}

class SolutionHashT3 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++)
            if (phone_book[i + 1].startsWith(phone_book[i])) return false;
        return true;
    }
}
