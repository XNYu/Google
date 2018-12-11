public class Triangle {
    public int max(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if(mid==0||mid==nums.length-1)
                break;
            if (nums[mid - 1] < nums[mid] && nums[mid]>nums[mid+1])
                    return nums[mid];
            if (nums[mid - 1] < nums[mid]) {
                start = mid + 1;
            }
            else
                end = mid - 1;
        }
        return -1;
    }

    public boolean isT(int[] nums) {
        if(nums.length==0||nums.length==1||nums[1] < nums[0])
            return false;
        boolean asd = true;
        for (int i = 0; i < nums.length-1; i++) {
            if (asd) {
                if (nums[i] > nums[i + 1])
                    asd = false;
            } else {
                if(nums[i]<nums[i+1])
                    return false;
            }
        }
        if(asd)
            return false;
        return true;
    }

    public int[] sort(int[] num) {
        int a = 0, b = num.length - 1;
        int[] ans = new int[num.length];
        int index = 0;
        while (a <= b && num[a] <= num[a + 1] && num[b] < num[b - 1]) {
            if (num[a] <= num[b]) {
                ans[index++] = num[a++];
            } else {
                ans[index++] = num[b--];
            }
        }
        while (num[a] <= num[a + 1]) {
            ans[index++] = num[a++];
        }
        while (num[b] > num[b + 1]) {
            ans[index++] = num[b--];
        }
        for(int i:ans)
            System.out.print(i+" ");
        return ans;
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        System.out.println(t.max(new int[]{1,2,3,4,5,6,4,3,1}));
        System.out.println(t.isT(new int[]{}));
        t.sort(new int[]{1,2,3,4,5,5,3,1});
    }
}
