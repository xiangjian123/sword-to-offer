package com.company.easy;

public class P1455_Check_Sentence_Prefix {
    public static void main(String[] args) {

        String str1 = "i love eating burger";
        String str2 = "burg";

        System.out.println(isPrefixOfWord(str1, str2));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            if (temp.length() < searchWord.length()) {
                continue;
            } else {
                for (int j = 0; j < searchWord.length(); j++) {
                    if (searchWord.charAt(j) != temp.charAt(j)) {
                        break;
                    }
                }
                index = i + 1;
                return index;
            }
        }

        return -1;
    }

}
