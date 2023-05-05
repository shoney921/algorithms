package kit01_hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T3_Hash {


    public static void main(String[] args) {
        SolutionHashT3 sol = new SolutionHashT3();

        String[] input = {"115", "115234", "2424"};

        sol.solution(input);
    }

}

class SolutionHashT3 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        List<String> collect = Arrays.stream(phone_book).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        System.out.println("collect = " + collect);

        String preStr = "";
        for (String s : collect) {

        }

        String test = "132323114";
        boolean contains = test.contains("114");
        System.out.println("contains = " + contains);
        String tt = "132";
        boolean matches = test.matches("^132");
        System.out.println("matches = " + matches);

        return answer;
    }
}
