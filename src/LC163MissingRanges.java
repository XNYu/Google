import java.util.ArrayList;
import java.util.List;

public class LC163MissingRanges {
    public List<String> findMissingRanges2(int[] A, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        long pre = Long.valueOf(lower) - 1;
        for(int i = 0 ; i <= A.length  ; i++){
            long after = i == A.length ? upper + 1 : A[i];
            if(pre + 2 == after){
                result.add(String.valueOf(pre + 1));
            }else if(pre + 2 < after){
                result.add(String.valueOf(pre + 1) + "->" + String.valueOf(after - 1));
            }
            pre = after;
        }
        return result;
    }

    public static void main(String[] args) {
        LC163MissingRanges l = new LC163MissingRanges();
        System.out.println(l.findMissingRanges2(new int[]{2147483647},-2147483648,2147483647));

    }
}
