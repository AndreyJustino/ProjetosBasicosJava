package firstNonRepeatingCharacter;

/*
    Write a function named first_non_repeating_letter† that takes a string input,
    and returns the first character that is not repeated anywhere in the string.

    For example, if given the input 'stress', the function should return 't',
    since the letter t only occurs once in the string, and occurs first in the string.

    As an added challenge, upper- and lowercase letters are considered the same character,
    but the function should return the correct case for the initial letter. For example, the
    input 'sTreSS' should return 'T'.
*/

class Kata {
    public static String firstNonRepeatingLetter(String s){
        String original = s;
        String lowerCase = s.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);

            if (lowerCase.indexOf(c) == lowerCase.lastIndexOf(c)) {
                return String.valueOf(original.charAt(i));
            }
        }

        return "";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Kata.firstNonRepeatingLetter("moon-men"));
    }
}
