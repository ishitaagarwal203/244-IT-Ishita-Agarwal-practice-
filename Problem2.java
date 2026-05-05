package problems;
import java.util.*;

public class Problem2 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        // Step 1: Check same remainder
        int rem = A[0] % K;
        for (int i = 1; i < n; i++) {
            if (A[i] % K != rem) {
                System.out.println(-1);
                return;
            }
        }

        // Step 2: Normalize array
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = (A[i] - rem) / K;
        }

        // Step 3: Sort to find median
        Arrays.sort(B);
        int median = B[n / 2];
         // Step 4: Calculate operations
        long operations = 0;
        for (int i = 0; i < n; i++) {
            operations += Math.abs(B[i] - median);
        }

        System.out.println(operations);
    }
}
