package Semestr4.test;

public class Palindrome {
    public static boolean isPalindrome(String word) {
        int l = word.length();

        for (int i = 0; i < word.length() / 2; i++)
            if (word.charAt(i) != word.charAt(l - 1 - i))
                return false;
        return true;
    }
}
