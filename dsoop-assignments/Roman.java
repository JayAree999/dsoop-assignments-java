public class Roman {
    public static int romanToInt(String romanNum) {
        int total = 0;
        int prevVal = 0;

        for (int i = 0; i < romanNum.length(); i++) {
            char c = romanNum.charAt(i);

            int val = converter(c);
            System.out.println(val + "," + total + "," + prevVal);
            if (val > prevVal) {
                total += (val - 2 * prevVal);
            } else {
                total += val;
            }
            prevVal = val;
        }


        return total;
    }


    public static int converter(char romanChar) {
        switch (romanChar){
            case 'I':
                return 1;
            case 'V':
                return 5;

            case 'X':
                return 10;

            case 'L':
                return 50;

            case 'C':
                return 100;

            case 'D':
                return 500;

            case 'M':
                return 1000;


        }
        return 0;

    }

    public static void main(String[] args) {
        int ans = romanToInt("MDC" +
                "");
        System.out.println(ans);
    }
}