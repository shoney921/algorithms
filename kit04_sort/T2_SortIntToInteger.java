package kit04_sort;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T2_SortIntToInteger {


    public static void main(String[] args) {

        SolutionSortT2 sol = new SolutionSortT2();
//        int[] input = {78, 9, 89};
        int[] input = {0, 0, 0};
        String solution = sol.solution(input);
        System.out.println("solution = " + solution);


        /**
         * 이런식으로 int[] -> Integer[], String[] 로 변경가능하다.
         */
        Integer[] integers = Arrays.stream(input).boxed().toArray(x -> new Integer[x]);
        Integer[] integers2 = Arrays.stream(input).boxed().toArray(Integer[]::new);
        for (Integer integer : integers) {
            System.out.println("integer = " + integer);
        }
        String[] strings = Arrays.stream(input).mapToObj(s -> String.valueOf(s)).toArray(x -> new String[x]);
        String[] strings2 = Arrays.stream(input).mapToObj(String::valueOf).toArray(String[]::new);
        for (String s : strings2) {
            System.out.println("s = " + s);
        }
    }
}

class SolutionSortT2 {
    public String solution(int[] numbers) {
        String[] stringArr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        String[] sortedStr = Arrays.stream(stringArr)
                .sorted((a, b) -> Integer.parseInt(b + a) - Integer.parseInt(a + b))
                .toArray(String[]::new);

        return Arrays.stream(sortedStr).allMatch(s -> s.equals("0")) ? "0"
                : String.join("", sortedStr);
    }
}