public class Hidden {
    public static boolean isHidden(String s, String t) {
        String totalString = "";
        boolean isHidden=false;
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            while (i < s.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    totalString += s.charAt(i);

                    i--;

                    break;
                }
                i++;
            }

        }

        if (totalString.equals(t)) {
            isHidden=true;
        }
        return isHidden;


    }

    public static void main(String[] args) {
        System.out.println(isHidden("welcometothehotelcalifornia","melon"));
        System.out.println(isHidden("welcometothehotelcalifornia","space"));
        System.out.println(isHidden("TQ89MnQU3IC7t6","MUIC"));
        System.out.println(isHidden("VhHTdipc07","htc"));
        System.out.println(isHidden("VhHTdipc07","hTc"));
    }

}

