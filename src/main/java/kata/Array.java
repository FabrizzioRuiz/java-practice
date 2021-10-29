package kata;

public class Array {
    public static int[] arrayDiff(int[] a, int[] b) {
        int w = b.length;
        if(w > 0){
            int[] temp = new int[a.length];
            int cont = 0;
            for (int i = 0; i < a.length; i++){
                for(int filtro: b){
                    if (a[i] == filtro) {
                        cont++;
                        temp = new int[a.length - cont];
                        for (int index = 0; index < i;){
                            temp[index] = a[index];
                            break;
                        }
                        for (int j = i; j < a.length - 1 ; j++){
                                temp[j]=a[j+1];
                        }
                        break;
                    }
                }
            }
            a = temp.clone();
        }
        return a;
    }
}
