import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC658KClosestElements {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int index = Collections.binarySearch(arr, x);
        if(index < 0) index = -(index + 1);
        int i = index - 1, j = index;
        while(k-- > 0){
            if(i<0 || (j<arr.size() && Math.abs(arr.get(i) - x) > Math.abs(arr.get(j) - x) ))j++;
            else i--;
        }
        return arr.subList(i+1, j);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        while (left < right)    {
            int mid = left + (right - left) / 2;
            System.out.println(left+","+right +" ,"+mid);
            System.out.println(arr[left]+" "+arr[right] + " " + arr[mid] + " "+arr[mid+k]);
            if (x - arr[mid] > arr[mid + k] - x)    {
                left = mid + 1;
            }   else    {
                right = mid;
            }
            System.out.println();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++)   {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        LC658KClosestElements l = new LC658KClosestElements();
        int[] nums = {0,1,2,3,4,4,4,5,5,5,6,7,9,9,10,10,11,11,12,13,14,14,15,17,19,19,22,24,24,25,25,27,27,29,30,32,32,33,33,35,36,38,39,41,42,43,44,44,46,47,48,49,52,53,53,54,54,57,57,58,59,59,59,60,60,60,61,61,62,64,66,68,68,70,72,72,74,74,74,75,76,76,77,77,80,80,82,83,85,86,87,87,92,93,94,96,96,97,98,99};
        List<Integer> list = l.findClosestElements(nums, 12, 100);
        System.out.println(list);
    }
}
