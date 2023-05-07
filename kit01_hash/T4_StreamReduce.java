package kit01_hash;

import java.util.HashMap;

public class T4_StreamReduce {

    public static void main(String[] args) {

        String[][] input = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        SolutionHashT4 sol = new SolutionHashT4();
        int solution = sol.solution(input);
        System.out.println(solution);

    }
}

class SolutionHashT4 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes)
            map.put(clothe[1], map.getOrDefault(clothe[1], 1) + 1);
        return map.values().stream().reduce(1, (a, b) -> a * b) - 1;
    }
}
