import java.util.Arrays;
import java.util.PriorityQueue;

public class HireWorkersLC857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[][] workers = new double[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new double[]{(double) (wage[i]) / quality[i], (double) quality[i]};
        }
        Arrays.sort(workers, ((o1, o2) -> Double.compare(o1[0], o2[0])));
        PriorityQueue<Double> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o2,o1));
        double ans = Double.MAX_VALUE;
        double sum = 0;
        for (double[] worker : workers) {
            sum += worker[1];
            queue.add(worker[1]);
            System.out.println(queue+" "+queue.peek());
            if (queue.size() > K)
                sum -= queue.poll();
            System.out.println(sum);
            if (queue.size() == K)
            {
                ans = Math.min(ans, sum * worker[0]);
                System.out.println(ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        HireWorkersLC857 l = new HireWorkersLC857();
        System.out.println(l.mincostToHireWorkers(new int[]{10,20,5},new int[]{70,50,30},2));
    }
}
