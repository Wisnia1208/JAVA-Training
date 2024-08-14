import java.util.EmptyStackException;
import java.util.Stack;

public class CalculateONP {

    public static Float calculate(String[] eq){

        Stack<Float> stos = new Stack<Float>();
        for (String s : eq) {
            if (s.charAt(0) <= 57 && s.charAt(0) >= 48) {
                try{
                    stos.push(Float.parseFloat(s));
                } catch (NumberFormatException err){
                    System.out.println("Zły input");
                    return 0.0f;
                }

            }
            else{
                Float a,b;
                try{
                    a = stos.pop();
                    b = stos.pop();
                } catch (EmptyStackException err){
                System.out.println("Błąd stosu - nieprawidłowa notacja");
                return 0.0f;
            }
                switch (s) {
                    case "+":
                        stos.push(a + b);
                        break;
                    case "-":
                        stos.push(a - b);
                        break;
                    case "*":
                        stos.push(a * b);
                        break;
                    case "/":
                        stos.push(a / b);
                        break;
                    case "^":
                        stos.push((float) Math.pow(a,b));
                        break;
                    default:
                        System.out.println("Nieprawidłowa wartość: " + s);
                        return 0.0f;
                }
            }
        }
        if(stos.size()==1){
            return stos.pop();
        } else {
            System.out.println("Błąd stosu - za mało działań");
            return 0.0f;
        }

    }
}
