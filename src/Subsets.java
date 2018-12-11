import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Character>> subsetsWithDup2(char[] chars) {
        Arrays.sort(chars);
        List<List<Character>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int begin = 0;
        for(int i = 0; i < chars.length; i++){
            //切换到新的数字
            if(i == 0 || chars[i] != chars[i - 1]) begin = 0;
            //保存当前的位置，遇到重复数字可以给已经加了N个数字的组合再加上一个并保存
            int size = result.size();
            for(int j = begin; j < size; j++){
                List<Character> cur = new ArrayList<>(result.get(j));
                cur.add(chars[i]);
                result.add(cur);
            }
            begin = size;
        }
        return result;
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        System.out.println(s.subsetsWithDup2(new char[]{'a','a','b','c','b'}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        int begin = 0;
        for(int i = 0; i < nums.length; i++){
            //切换到新的数字
            if(i == 0 || nums[i] != nums[i - 1]) begin = 0;
            //保存当前的位置，遇到重复数字可以给已经加了N个数字的组合再加上一个并保存
            int size = result.size();
            for(int j = begin; j < size; j++){
                List<Integer> cur = new ArrayList<Integer>(result.get(j));
                cur.add(nums[i]);
                result.add(cur);
            }
            begin = size;
        }
        return result;
    }
}
