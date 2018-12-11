package Design;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class FreqStack {
    private volatile int value;
    class Pair {
        int id,freq, num;

        public Pair(int id, int num, int freq) {
            this.id = id;
            this.freq = freq;
            this.num = num;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if(!(obj instanceof Pair))
                return false;
            Pair pair = (Pair) obj;
            return pair.num == this.num;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(num);
        }
    }

    public FreqStack() {
        value = 0;
    }

    HashMap<Integer, Integer> freqMap = new HashMap<>();
    PriorityQueue<Pair> queue = new PriorityQueue<>(((o1, o2) -> {
        if(o1.freq==o2.freq){
            return o2.id-o1.id;}
        return o2.freq - o1.freq;
    }));

    public void push(int[] pair) {
        int num = pair[0];
        int freq = pair[1];
        Pair p = new Pair(value++, num, freq);
        if (freqMap.containsKey(num)) {
            int newFreq = freqMap.get(num) + freq;
            p.freq = newFreq;
            freqMap.put(num, newFreq);
            queue.remove(p);
            queue.add(p);
        } else {
            freqMap.put(num, freq);
            queue.add(p);
        }
    }

    public int[] pop() {
        Pair p = queue.poll();
        freqMap.remove(p.num);
        return new int[]{p.num, p.freq};
    }

    public static void main(String[] args) {
        FreqStack f = new FreqStack();
        f.push(new int[]{2, 3});
        f.push(new int[]{3,4});
        f.push(new int[]{2,4});
        f.push(new int[]{3, 3});
        int[] ans = f.pop();
        System.out.println(ans[0] + "," + ans[1]);
        ans = f.pop();
        System.out.println(ans[0] + "," + ans[1]);
    }

}
