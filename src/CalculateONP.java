import java.util.EmptyStackException;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public abstract class CalculateONP {

    public static Float calculate(String input){
        String[] eq = input.split(" +");
        Stack<Float> stos = new Stack<>();
        for (String s : eq) {

            if (s.charAt(0) <= 57 && s.charAt(0) >= 48) {
                try{
                    stos.push(Float.parseFloat(s));
                } catch (NumberFormatException err){
                    System.out.println("Nieprawidłowe dane wejściowe");
                    return 0.0f;
                }
            }
            else{
                if(s.length()>1){
                    System.out.println("Nieprawidłowe dane wejściowe");
                    return 0.0f;
                }
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

    public static String writeONP(String input){
        //zadanie to zrobić tłumacz z normalnego zapisu do ONP

        Pattern pattern = Pattern.compile("[^0-9+\\-*/^\\s.]|(?<!\\d)\\.(?!\\d)|\\.(?=\\D)");
        Matcher matcher = pattern.matcher(input);

        // Znajdowanie i wypisywanie niedozwolonych znaków
        if (matcher.find()) {
            System.out.println("Znaleziony niedozwolony znak: " + matcher.group());
            return "error";
        }

        input = input.replaceAll("\\s+", "");
        String output = "";


        output = Recursive(input,output);


        return output;
    }

    static String Recursive(String s, String output){
        if(s.isEmpty()){
            System.out.println("XD");
        }else{
            output+="*"+Recursive(s.substring(0,s.length()-1),output);;
            //output =

        }
        return output;
    }

    /*String RecursiveWriteONP(String s){
        int[] indexes = Functions.FindBrackets(s);
        int[] notFound = new int[] {-1,-1};
        if(indexes == notFound){
            //funkcja
        }else{
            RecursiveWriteONP(s.substring(indexes[0]+1,indexes[1]-1));
        }
    }

    String write(String s){
        String output = "";
        while(s.length()>0){
            if(s.indexOf("^")!=-1){
                int indexOfPower = s.indexOf("^");
                output = Functions.GetFloat(Functions.FindSignL(s,indexOfPower)+1,indexOfPower,s)+" "+Functions.GetFloat(indexOfPower+1, Functions.FindSignR(s,indexOfPower), s)+output+ " ^";
                s = s.substring(0,Functions.FindSignL(s,indexOfPower)+1));//zjebane po całosći pozdarwiam
            }
        }
    }
    */

}
