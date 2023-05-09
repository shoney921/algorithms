package kit08_dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class T3_BFSFindShortRoute {

    public static void main(String[] args) {


        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        SolDfsBfsT3 sol = new SolDfsBfsT3();
        int solution = sol.solution(maps);
        System.out.println("solution = " + solution);


    }
}

class SolDfsBfsT3 {
    public int solution(int[][] maps) {
        int[] x = {0, 1, 0, -1};
        int[] y = {-1, 0, 1, 0};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            if (poll.row == maps.length - 1 && poll.col == maps[0].length - 1) return poll.dep;
            maps[poll.row][poll.col] = 0;

            for (int i = 0; i < 4; i++) {
                int rowDir = poll.row + x[i];
                int colDir = poll.col + y[i];
                if (checkFourWay(maps, rowDir, colDir)) {
                    int depth = poll.dep + 1;
                    queue.add(new Point(rowDir, colDir, depth));
                }
            }
        }
        return -1;
    }

    private static boolean checkFourWay(int[][] maps, int rowDir, int colDir) {
        return rowDir >= 0 && rowDir < maps.length && colDir >= 0 && colDir < maps[0].length && maps[rowDir][colDir] == 1;
    }

    class Point {
        int row;
        int col;
        int dep;

        public Point(int row, int col, int dep) {
            this.row = row;
            this.col = col;
            this.dep = dep;
        }
    }


    private static void printCheck(int[][] maps) {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                System.out.print(maps[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
