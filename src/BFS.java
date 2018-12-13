import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {
    public void func(int[][] grid, int x,int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        int[][] directions = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        int[][] distance = new int[m][n];
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int dis = distance[point[0]][point[1]];
            for (int[] d : directions) {
                int[] nPoint = new int[]{point[0] + d[0], point[1] + d[1]};
                int nx = nPoint[0];
                int ny = nPoint[1];
                if(nx<0||ny<0||nx==m||ny==n||visited[nx][ny])
                    continue;
                distance[nPoint[0]][nPoint[1]] = dis + 1;
                queue.add(nPoint);
                visited[nx][ny] = true;
            }
            print(distance);
            System.out.println();
        }
    }

    public void print(int[][] grid) {
        for (int[] d : grid) {
            for (int m : d) {
                System.out.print(m+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BFS b = new BFS();
        int[][] grid = new int[4][4];
        b.func(grid, 2, 2);
    }
}
