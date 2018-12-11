public class 收集糖果 {
    public int func(int[][] grid) {
        int[][] endpoint = new int[grid.length][2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1)
                {
                    endpoint[i][0] = j;
                    break;
                }
            }
            for (int j = grid[0].length-1; j >=0 ; j--) {
                if(grid[i][j]==1)
                {
                    endpoint[i][1] = j;
                    break;
                }
            }
        }
        int leftSteps = 0;
        int rightSteps = 0;
        int preL = 0;
        int preR = 0;
        for(int[] ends:endpoint){
            if(ends[0]==ends[1])
            {
                leftSteps++;
                rightSteps++;
                continue;
            }
            int[] leftResults = cal(preL, ends);
            int[] rightResults = cal(preR, ends);
            leftSteps = Math.min(leftSteps + leftResults[0], rightSteps + rightResults[0]);
            rightSteps = Math.min(leftSteps + leftResults[1], rightSteps + rightResults[1]);
            preL = ends[0];
            preR = ends[1];
        }
        return Math.min(leftSteps, rightSteps);
    }

    public int[] cal(int pre, int[] ends) {
        int left = ends[0];
        int right = ends[1];
        int len = right - left;
        if (pre < left) {
            return new int[]{2 * len + left - pre, right - pre};
        } else if (pre < right) {
            return new int[]{len + right - pre, len + pre - left};
        } else {
            return new int[]{pre - left, 2 * len + pre - right};
        }
    }
}
