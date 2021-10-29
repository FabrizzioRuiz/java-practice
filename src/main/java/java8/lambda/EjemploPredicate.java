package java8.lambda;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        //PREDICATE devuelve un boolean
        Predicate<Integer> test = num -> num > 10;
        boolean resultado = test.test(7);
        System.out.println("resultado = " + resultado);

        Predicate<String> test2 = role -> role.equals("ROLE_ADMIN");
        boolean resultado2 = test2.test("ROLE_USER");
        System.out.println("resultado2 = " + resultado2);


        BiPredicate<String, String> test3 = String::equals; // (a, b) -> a.equals(b);
        boolean resultado3 = test3.test("fabri","fabri");
        System.out.println("resultado3 = " + resultado3);


    }
}
