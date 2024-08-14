import java.util.EmptyStackException;
import java.util.Stack;

public class CalculateONP {

    public static Float calculate(String[] eq){

        Stack<Float> stos = new Stack<Float>();
        for (String s : eq) {
            if (s.charAt(0) <= 57 && s.charAt(0) >= 48) {
                stos.push(Float.parseFloat(s));
            }
            else{
                switch (s) {
                    case "+":
                        try{
                            Float a = stos.pop();
                            Float b = stos.pop();
                            stos.push(a + b);
                            break;
                        } catch (EmptyStackException err){
                            System.out.println("Błąd stosu - za mało liczb do działania");
                            return 0.0f;
                        }
                    case "-":
                        try{
                            Float a = stos.pop();
                            Float b = stos.pop();
                            stos.push(a - b);
                            break;
                        } catch (EmptyStackException err){
                            System.out.println("Błąd stosu - za mało liczb do działania");
                            return 0.0f;
                        }
                    case "*":
                        try{
                            Float a = stos.pop();
                            Float b = stos.pop();
                            stos.push(a * b);
                            break;
                        } catch (EmptyStackException err){
                            System.out.println("Błąd stosu - za mało liczb do działania");
                            return 0.0f;
                        }
                    case "/":
                        try{
                            Float a = stos.pop();
                            Float b = stos.pop();
                            stos.push(a / b);
                            break;
                        } catch (EmptyStackException err){
                            System.out.println("Błąd stosu - za mało liczb do działania");
                            return 0.0f;
                        }
                    case "^":
                        try{
                            Float a = stos.pop();
                            Float b = stos.pop();
                            stos.push((float) Math.pow(a,b));
                            break;
                        } catch (EmptyStackException err){
                            System.out.println("Błąd stosu - za mało liczb do działania");
                            return 0.0f;
                        }
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
