package getTheMiddleCharacter;

/*
    You are going to be given a non-empty string. Your job is to return the middle character(s) of the string.

    If the string's length is odd, return the middle character.
    If the string's length is even, return the middle 2 characters.

*/

class Kata {
    public static String getMiddle(String word) {
        String result = "";

        if (word.length() % 2 == 0){
            result = String.valueOf(word.charAt(word.length() / 2 - 1)).concat(String.valueOf(word.charAt(word.length() / 2)));
        }else{
            result = String.valueOf(word.charAt(word.length() / 2));
        }

        return result;
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println(Kata.getMiddle("bala"));
    }
}
