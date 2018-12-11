public class BinarySearch {
    public static int find(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            } else {
                if(nums[mid]<target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6, 7, 8, 9};
        System.out.println(find(nums,1));
    }
}
