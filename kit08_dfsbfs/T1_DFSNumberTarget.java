package kit08_dfsbfs;
public class T1_DFSNumberTarget {


    public static void main(String[] args) {
        SolDfsBfsT1 sol = new SolDfsBfsT1();
//        int[] numbers = {1, 1, 1, 1, 1};
        int[] numbers = {4, 1, 2, 1};
        int solution = sol.solution(numbers, 4);
        System.out.println("solution = " + solution);
    }

}

class SolDfsBfsT1 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0,0, numbers, target);
        return answer;
    }

    private void dfs(int sum, int i, int[] numbers, int target) {
        if (i == numbers.length) {
            if (sum == target) answer++;
        } else {
            dfs(sum + numbers[i], i+1, numbers, target);
            dfs(sum - numbers[i], i+1, numbers, target);
        }
    }
}
