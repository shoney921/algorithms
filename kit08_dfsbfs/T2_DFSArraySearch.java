package kit08_dfsbfs;

import java.util.Arrays;

public class T2_DFSArraySearch {


    public static void main(String[] args) {
        SolDfsBfsT2 sol = new SolDfsBfsT2();
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int solution = sol.solution(3, computers);
        System.out.println("solution = " + solution);
    }
}

class SolDfsBfsT2 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(i, computers, check);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int i, int[][] computers, boolean[] check) {
        check[i] = true;
        for (int j = 0; j < computers[i].length; j++) {
            if (computers[i][j] == 1 && !check[j]) {
                dfs(j, computers, check);
            }
        }
    }

    private static void printArray(int[][] check) {
        for (int[] ints : check) {
            for (int anInt : ints) {
                System.out.print(anInt + ", ");
            }
            System.out.println();
        }
    }
}