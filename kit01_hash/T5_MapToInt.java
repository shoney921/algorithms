package kit01_hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class T5_MapToInt {
    public static void main(String[] args) {
        String[] input = {"classic", "pop", "classic", "classic", "pop"};
        int[] ints = {500, 600, 150, 800, 2500};

        SolutionHashT5 sol = new SolutionHashT5();
        sol.solution(input, ints);
    }
}

class SolutionHashT5 {
    public int[] solution(String[] genres, int[] plays) {
        List<List<String>> totalList = new ArrayList<>();
        HashMap<String, Integer> genresCnt = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalList.add(List.of(genres[i], String.valueOf(plays[i])));
            genresCnt.put(genres[i], genresCnt.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<List<String>> collect = totalList.stream()
                .sorted((x, y) -> Integer.parseInt(y.get(1)) - Integer.parseInt(x.get(1)))
                .sorted((x, y) -> genresCnt.get(y.get(0)) - genresCnt.get(x.get(0)))
                .collect(Collectors.toList());

        String preStr = "";
        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        for (List<String> strings : collect) {
            if (preStr.equals(strings.get(0))) {
                cnt++;
            }
            else {
                cnt = 1;
                preStr = strings.get(0);
            }

            if (cnt <= 2) {
                int index = totalList.indexOf(strings);
                result.add(index);
                totalList.set(index, List.of("done", ""));
            }
        }
        System.out.println("totalList = " + totalList);
        System.out.println("genresCnt = " + genresCnt);
        System.out.println("result = " + result);
        return result.stream().mapToInt(s -> s).toArray();
    }
}