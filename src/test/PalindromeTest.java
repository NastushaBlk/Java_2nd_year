package test;

import Semestr4.test.Palindrome;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PalindromeTest {

    // часто сначала пишут тесты, а потом саму программу
    @Test
    public void test1() {
        //убедиться, что
        //assert Palindrome.isPalindrome("abccba")
        assertTrue(Palindrome.isPalindrome("abccba")); //тк написал через ., то сама функция будет static
        assertFalse(Palindrome.isPalindrome("abccbA"));
    }

    @Test
    public void test2() { //необязательно public, но пусть будут
        assertTrue(Palindrome.isPalindrome("pqp"));
        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test(dataProvider = "listOfPalindromes")
    public void test3(String word, Boolean isPalindrome) {
        assertEquals(
                Palindrome.isPalindrome(word),
                (boolean)isPalindrome
        );
    }

    @DataProvider
    public static Object[][] listOfPalindromes() {
        return new Object[][]{
                {"abcba", true},
                {"abcbA", false},
                {"AbcbA", true}
        };
    }
}

// toolbox jetbrains