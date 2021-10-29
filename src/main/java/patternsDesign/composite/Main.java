package patternsDesign.composite;

public class Main {
    public static void main(String[] args) {
        PulpoComposite dir = new PulpoComposite("Pulpo Enorme");
        String result = dir.logic();
        System.out.println("result = " + result);
    }
}
