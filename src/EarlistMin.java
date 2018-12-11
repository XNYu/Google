import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class EarlistMin {

    public int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        int count = 0;
        while (i < n) {
            // If the current value is in the range of (0,length) and it's not at its correct position,
            // swap it to its correct position.
            // Else just continue;
            if (nums[i] >= 1 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }
        int k = 0;
        // Check from k=1 to see whether each index and value can be corresponding.
        while (k < n && nums[k] - 1 == k)
            k++;
        // If it breaks because of empty array or reaching the end. K must be the first missing number.
        return k + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static class ServerAllocate {
        private ConcurrentSkipListSet<Integer>  available;
        private ConcurrentHashMap.KeySetView<Integer,Boolean> allocated;
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private void fillAvailableSet() {
            int totalAllocated = allocated.size();
            for (int i = 1; i <= 10; i++) {
                available.add(totalAllocated + i);
            }
        }

        public ServerAllocate(String name) {
            available = new ConcurrentSkipListSet<>();
            allocated = ConcurrentHashMap.newKeySet();
            fillAvailableSet();
            this.name = name;
        }

        public String allocate() {
            if(available.size()==0)
                fillAvailableSet();
            int ret = available.pollFirst();
            allocated.add(ret);
            return name + ret;
        }

        public boolean deallocate(int num) {
            if (allocated.remove(num)) {
                available.add(num);
                return true;
            }
            return false; // No such server exists
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,6,2,5,3,4};
        EarlistMin m = new EarlistMin();
        System.out.println(m.firstMissingPositive(nums));
        ServerAllocate serverAllocate = new ServerAllocate("Server");
        for (int i = 0; i < 10; i++) {
            serverAllocate.allocate();
        }
        System.out.println(serverAllocate.allocate());
        System.out.println(serverAllocate.deallocate(4));
        System.out.println(serverAllocate.deallocate(3));
        System.out.println(serverAllocate.allocate());
//        TreeSet<Integer> set = new TreeSet<>();
//        set.add(2);
//        set.add(3);
//        Iterator i = set.iterator();
//        int cur = (int)i.next();
//        if(cur!=1)
//        {
//            set.add(1);
//            i = set.iterator();
//        }
//        while (i.hasNext()) {
//            int pre = (int)i.next();
//            if (cur+1 != pre) {
//                set.add(cur + 1);
//                System.out.println(cur + 1);
//                break;
//            }
//        }
//        System.out.println(set.size()+1);
    }
}
