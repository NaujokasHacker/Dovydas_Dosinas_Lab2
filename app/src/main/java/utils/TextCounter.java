package utils;

public class TextCounter {
    public static String getCharsCount(String input){
        return String.valueOf(input.length());
    }

    public static String getWordsCount(String input){

        if (input == null || input.isEmpty()) {
            return null;
        }
        String[] words = input.split("\\s+");
        return String.valueOf(words.length);
    }
}
