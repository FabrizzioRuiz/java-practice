package kata;

public class SquareDigit {
    public int squareDigits(int n) {
        if (n != 0) {
            String split = String.valueOf(n);
            String[] arr = split.split("");
            StringBuilder resultString = new StringBuilder();
            for (String s : arr) {
                int raiz = (int) Math.pow(Double.parseDouble(s), 2.0);
                resultString.append(raiz);
            }
            return Integer.parseInt(resultString.toString());
        }
        return 0;
    }
}
