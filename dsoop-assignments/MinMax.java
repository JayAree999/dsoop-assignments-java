public class MinMax {
    public static double minMaxAverage(int[] numbers) {
        // your code goes here
        int i ;

        int myMin = numbers[0];
        int myMax = numbers[1];


        if (numbers.length % 2 == 0) {
            if (numbers[0] > numbers[1]) {
                myMax = numbers[0];
                myMin = numbers[1];
            }
            else {
                myMin = numbers[0];
                myMax = numbers[1];
            }

            i=2;
        }


        else {
            myMin = numbers[0];
            myMax = numbers[0];

            i = 1;

        }
        while (i < numbers.length - 1) {
            if (numbers[i] > numbers[i + 1]) {

                if (numbers[i] > myMin) {
                    myMax = numbers[i];
                }
                if (numbers[i + 1] < myMin) {
                    myMin = numbers[i + 1];
                }
            }

            else {

                if (numbers[i + 1] > myMax) {
                    myMax = numbers[i + 1];
                }
                if (numbers[i] < myMin) {
                    myMin = numbers[i];
                }
            }
            i += 2;

        }
        return(myMin + myMax)/2.0;


    }


        public static void main(String[]args){
        int[] i= {1000, 11, 445, 1, 330, 3000};
            System.out.println(minMaxAverage(i));


        }

}
