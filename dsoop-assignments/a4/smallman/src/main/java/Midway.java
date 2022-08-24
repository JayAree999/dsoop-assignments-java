import java.util.Arrays;

public class Midway {
    public static long stepsRemaining(int[] diskPos) {
        int sum = 1;
        int l = diskPos.length;
        while (l > 0) {
            sum *= 2;
            l--;
        }
        return sum - 1 - hanoi_helper(diskPos, 0, 1, 2);
    }

    public static long hanoi_helper(int[] disks, int f, int t, int a) {
        if (disks.length == 1) {
            if (disks[0] == f) return 0;
            else return 1;

        } else {
            if (disks[disks.length - 1] == f) {
                return hanoi_helper(Arrays.copyOfRange(disks, 0, disks.length - 1), f, a, t);
            } else {
                int sum = 1;
                int l = disks.length - 1;
                while (l > 0) {
                    sum *= 2;
                    l--;
                }
                return sum + hanoi_helper(Arrays.copyOfRange(disks, 0, disks.length - 1), a, t, f);
            }
        }
    }
}