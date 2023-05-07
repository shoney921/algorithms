package kit03_heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class T1_PriorityQueue {

    public static void main(String[] args) {
        SolutionHeapT1 sol = new SolutionHeapT1();
        int[] s = {1, 2, 3, 9, 10, 12};

        int solution = sol.solution(s, 7);
        System.out.println("solution = " + solution);
    }
}

class SolutionHeapT1 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = Arrays.stream(scoville).boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));

        int cal = pq.peek();
        while (cal < K && pq.size() > 1) {
            cal = pq.poll() + pq.poll() * 2;
            pq.add(cal);
            answer++;
            cal = pq.peek();
        }

        return cal < K ? -1 : answer;
    }
}