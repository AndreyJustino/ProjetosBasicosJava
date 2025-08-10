package stringToNumberPhone;

/*Write a function that accepts an array of 10 integers (between 0 and 9),
 that returns a string of those numbers in the form of a phone number.

 Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"

 */

class Kata {
    private static String buildPart(int[] arr, int start, int end){
        //stringBuilder melhor que string para manipular strings de forma mais eficiente
        //para manipular strings mais vezes
        StringBuilder text = new StringBuilder();

        //concaternar valores dentro de uma string
        for(int i = start; i < end; i++){
            text.append(arr[i]);
        }

        return text.toString();
    }

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder result = new StringBuilder("(");

        result.append(buildPart(numbers, 0, 3));

        result.append(") ");

        result.append(buildPart(numbers, 3, 6));

        result.append("-");

        result.append(buildPart(numbers, 6, 10));

        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        var teste = Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0});

        System.out.println(teste);
    }
}
