package Isograms;

import java.util.HashSet;
import java.util.Set;

class isogram {
    public static boolean  isIsogram(String str) {
        str = str.toLowerCase();

        Set<String> vistos = new HashSet<>();


        for (String value : str.split("")){

            //verifica se o valor da lista criada por str.split
            //esta dentro da outra lista chamada "visto"
            // lista do tipo Set só aceita valores unicos
            if (vistos.contains(value)){
                return false;

            }

            vistos.add(value);
        }

        return true;
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println(isogram.isIsogram("aba"));
    }
}
