import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);
        String tekst = skaner.nextLine();




        //int[] arr = Functions.FindBrackets(tekst);
        System.out.println(CalculateONP.writeONP(tekst));

        //Float x = CalculateONP.calculate(tekst);
        //System.out.println(x);
    }
}