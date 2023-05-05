package kit01_hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T2_HashMap {

    public static void main(String[] args) {
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"eden", "kiki"};

        SolutionHashT2 sol = new SolutionHashT2();
        sol.solution(part, comp);
    }
}


class SolutionHashT2 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Arrays.stream(participant).forEach(p -> hashMap.put(p, hashMap.getOrDefault(p, 0) + 1));
        Arrays.stream(completion).forEach(c -> hashMap.put(c, hashMap.get(c) - 1));

        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
            if (stringIntegerEntry.getValue() == 1) {
                return stringIntegerEntry.getKey();
            }
        }

        return "error";
    }
}