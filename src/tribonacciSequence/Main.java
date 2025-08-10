package tribonacciSequence;

/*
    Well met with Fibonacci bigger brother, AKA Tribonacci.
    As the name may already reveal, it works basically like a Fibonacci, but summing
    the last 3 (instead of 2) numbers of the sequence to generate the next. And, worse part
    of it, regrettably I won't get to hear non-native Italian speakers trying to pronounce it :(
    So, if we are to start our Tribonacci sequence with [1, 1, 1] as a starting input
    (AKA signature), we have this sequence:

    [1, 1 ,1, 3, 5, 9, 17, 31, ...]

    But what if we started with [0, 0, 1] as a signature? As starting with [0, 1] instead of
    [1, 1] basically shifts the common Fibonacci sequence by once place, you may be tempted to
    think that we would get the same sequence shifted by 2 places, but that is not the case and
    we would get:

    [0, 0, 1, 1, 2, 4, 7, 13, 24, ...]

    Well, you may have guessed it by now, but to be clear: you need to create a
    fibonacci function that given a signature array/list, returns the first n elements -
    signature included of the so seeded sequence.

    Signature will always contain 3 numbers; n will always be a non-negative number; if n == 0,
    then return an empty array (except in C return NULL) and be ready for anything else which
    is not clearly specified ;)

    If you enjoyed this kata more advanced and generalized version of it can be found in the
    Xbonacci kata

    [Personal thanks to Professor Jim Fowler on Coursera for his awesome classes that I really
    recommend to any math enthusiast and for showing me this mathematical curiosity too with his
    usual contagious passion :)]

*/

import java.util.*;
import java.util.stream.Collectors;

class Xbonacci {

    public static double[] tribonacci(double[] s, int n) {

        if (n == 0) return new double[0]; //se n for 0 retorna lista vazia []
        if (n <= 3) return Arrays.copyOf(s, n); //se for menor ou igual retorna os primeiros N elementos de S

        //transformando um array fixo primitivo em um arrayList
        ArrayList<Double> lista = Arrays.stream(s).boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        //enquanto o tamanho da lista for menor que a quantidade numeros que o usuario quer na
        //lista continuar fazendo a interação
        while(lista.size() < n){
            //o objetivo é somar sempre os ultimas 3 numeros e adicionar a soma desses 3 na ultima posicao

            //verifico o tamanho da lista e tiro 3 para pegar o index antes do penultimo
            //assim posso somar esse index mais ou dois a seguir
            int index = lista.size() - 3;

            double total = 0; //variavel em que vai ser acumulado o calculo

            //vou passar pela lista a partir do index do antipenultimo e somar até
            //chegar no ultimo valor da lista
            for (int i = index; i < lista.size(); i++) {
                total += lista.get(i);
            }

            //adicionar o valor acumulado no ultimo index do arrayList
            lista.add(total);

        }

        //transformando o arrayList em lista fixa
        double[] array = lista.stream()
                .mapToDouble(Double::doubleValue)
                .toArray();

        return array;
    }
}

public class Main {
    public static void main(String[] args) {
        var list = Xbonacci.tribonacci(new double []{1,1,1},10); //1,1,1,3,5,9,17,31,57,105

        for (double value : list){
            System.out.println(value);
        }
    }
}
