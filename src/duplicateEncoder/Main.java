package duplicateEncoder;

/*
    The goal of this exercise is to convert a string to a new
    string where each character in the new string is "(" if that
    character appears only once in the original string, or ")" if
    that character appears more than once in the original string.
    Ignore capitalization when determining if a character is a duplicate.

    "din"      =>  "((("
    "recede"   =>  "()()()"
    "Success"  =>  ")())())"
    "(( @"     =>  "))(("

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class DuplicateEncoder {
    static String encode(String word){
        StringBuilder result = new StringBuilder();

        //corto a palavra em partes e transforme em uma lista
        List<String> pieces = Arrays.stream(word.toLowerCase().split("")).collect(Collectors.toList());

        List<String> copia = new ArrayList<>(pieces);

        int count = 0;
        //interando sobre a copia para não ter o erro java.util.ConcurrentModificationException
        //que ocorre quando se intera e altera uma lista ao mesmo tempo
        // então intero sobre uma copia e altero a original
        for (String value : copia){

            //verifico se o valor existe dentro da lista
            //se existir removo ele
            if(pieces.contains(value)) {
                pieces.remove(value);

                //verifico denovo se existe, se existir ja adiciono o ) que se pede
                //no exercicio caso acha iguais dentro da mesma palavra
                //depois adiciono a letra removida no seu lugar devolta
                if(pieces.contains(value)){
                    result.append(")");
                    pieces.add(count, value);
                    // )
                }else{
                    //se não existir outro igual adiciono o ( que se pede no exercicio
                    //e adiciono o valor no seu lugar denovo
                    result.append("(");
                    pieces.add(count, value);
                    // (
                }
            }

            count++;
        }

        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(DuplicateEncoder.encode("Ovo"));
    }
}
