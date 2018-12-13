import java.util.List;
import java.util.Map;

class Soda{
    int lower, upper;
}

public class K可乐 {
    public static boolean dfs(List<Soda> sodas, int volumeLower, int volumeUpper,
                              int targetLower, int targetUpper, Map<String, Boolean> memo) {

        Boolean val = memo.get(volumeLower + "-" + volumeUpper);
        if (val != null) {
            return val;
        }

        if (volumeLower >= targetLower && volumeUpper <= targetUpper) {
            return true;
        }

        if (volumeUpper > targetUpper) {
            return false;
        }

        for (Soda soda : sodas) {
            if (dfs(sodas, volumeLower + soda.lower, volumeUpper + soda.upper, targetLower, targetUpper, memo)) {
                memo.put(volumeLower + "-" + volumeUpper, true);
                return true;
            }
        }

        memo.put(volumeLower + "-" + volumeUpper, false);
        return false;
    }
}
