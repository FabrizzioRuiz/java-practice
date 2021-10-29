package kata;

public class Isogram {
//    public static boolean  isIsogram(String str) {
//        if (str.equals("")) return true;
//        String stream = str.toUpperCase();
//        String[] split = stream.split("");
//        for (int i = 0; i < split.length; i++){
//            String compare = split[i];
//            for (int j = i+1; j < split.length; j++){
//                if(compare.equals(split[j])){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public static boolean isIsogram(String str){
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
