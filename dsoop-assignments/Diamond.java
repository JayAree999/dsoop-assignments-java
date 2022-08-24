public class Diamond {
    public static void printDiamond(int k){
        //upper half
        for (int r =0; r<k;r++) { // row
            String sharp = "";
            String dot= "";
            for (int s = 0; s < k-r; s++) { // (k-r) is sharp decreasing per row
                sharp += "#";
            }
            for (int a = 1; a<= (2*r)+1; a++ ) { // * is increasing oddly(1,3,5,7,..) so formula is 2n+1
                dot += "*";
            }

            System.out.println(sharp + dot + sharp);
        }
// lower half
        for (int r = k-1; r>0 ; r--){ //start from k's row so k-1 and row is decreasing so r--
            String sharp="";
            String dot="";
            for (int s =0; s<= k-r;s++){ //# k-r is  increasing per row
                sharp += "#";

            }
            for (int d=0; d<(2*r)-1;d++){ //2n-1 is decreasing oddly(5,3,1)
                dot += "*";
            }
            System.out.println(sharp+dot+sharp);
        }

    }





    public static void main(String[] args) {
        printDiamond(3);
    }
}
