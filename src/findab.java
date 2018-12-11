import java.util.HashMap;

public class findab {
    public static int Solution(String s1, String s2){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i);
            }
        }
        int count = 0;
        int i = 0;
        while(i < s1.length()){
            char c = s1.charAt(i);
            if(!map.containsKey(c)){
                break;
            }else{
                int indexS2 = map.get(c); // 1
                i++;
                indexS2++;
                while(i < s1.length() && indexS2 < s2.length()){
                    char s1c = s1.charAt(i);
                    char s2c = s2.charAt(indexS2);
                    if(s1c == s2c){
                        i++;
                        indexS2++;
                    }
                    else break;
                }
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        findab f = new findab();
        Solution("abc", "ababc");
    }
}
