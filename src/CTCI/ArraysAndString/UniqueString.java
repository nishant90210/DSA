package CTCI.ArraysAndString;

public class UniqueString {

    public static void main(String[] args) {

        String str = "Nishant";
        boolean[] unique = new boolean[128];
        boolean unique1 = isUnique(str, unique);
        if (unique1){
            System.out.println("UNIQUE");
        }else {
            System.out.println("NOT UNIQUE");
        }
        return;
    }

    private static boolean isUnique(String str, boolean[] unique) {
        if (str.length() > 128) {
            return false;
        }
        for (int i = 0; i < str.length(); i++){
            if (unique[str.charAt(i)]){
                return false;
            }
            unique[str.charAt(i)] = true;
        }
        return true;
    }
}
