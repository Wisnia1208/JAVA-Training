import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            Scanner skaner = new Scanner(System.in);
            String tekst = skaner.nextLine();

            String[] stos = tekst.split(" +");

            Float x = CalculateONP.calculate(stos);
            System.out.println(x);
    }
}