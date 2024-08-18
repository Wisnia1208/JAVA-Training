

public class Functions {

    public static int[] FindBrackets (String s){
        int FirstBracket,LastBracket,pointer;
        FirstBracket = s.indexOf("(");
        pointer = FirstBracket;
        LastBracket = s.indexOf(")");
        if(LastBracket == -1 && FirstBracket == -1){
            return new int[]{FirstBracket,LastBracket};
        }
        if(LastBracket < FirstBracket){
            System.out.println("Źle wprowadzone działanie - domknięcie nawiasu bez otwarcia");
            return new int[]{0,0};
        }

        do{
            pointer = s.indexOf("(",pointer+1);
            if(pointer!=-1) {
                LastBracket = s.indexOf(")",LastBracket+1);
            }else if(pointer >= LastBracket){
                System.out.println("Źle wprowadzone działanie - otwarcie nawiasu bez domknięcia");
                return new int[]{0,0};
            }
        }while (pointer!=-1);

        return new int[]{FirstBracket,LastBracket};
    }

    public static int FindSignL (String s, int fromIndex){
        char[] signs = new char[]{'^','*','/','+','-'};
        for(int i=fromIndex-1;i<0;i--){
            for(int j : signs){
                if(s.charAt(i) == signs[j]){
                    return i;
                }
            }
        }
        return 0;
    }

    public static int FindSignR (String s, int fromIndex){
        char[] signs = new char[]{'^','*','/','+','-'};
        int length = s.length();
        for(int i=fromIndex+1;i>length;i++){
            for(int j : signs){
                if(s.charAt(i) == signs[j]){
                    return i;
                }
            }
        }
        return length;
    }

    public static Float GetFloat(int begin, int end, String s){
        float output;
        try{
            output = Float.parseFloat(s.substring(begin,end));
        }catch (NumberFormatException err){
            System.out.println("Błąd odczytywania Float");
            return 0.0f;
        }
        return output;
    }

}
