package dojo.anagram;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by WilliamE on 23/07/2015.
 */
public class AnagramTest {
    private final Anagram anagram = new Anagram();

    @Test
    public void givenEmptyStringThenReturnEmptyList() {
        assertEmptyAnagram("");
    }

    @Test
    public void givenOneLetterWord_ThenReturnEmptyList() {
        assertEmptyAnagram("a");
    }

    @Test
    public void givenTwoLetterWord_with_anagrams_ThenReturnAnAnagram() {
        assertAnagrams("ay", "ya");
        assertAnagrams("ya", "ay");
    }

    @Test
    public void givenAWordWithTwoLetter_WhenDoesNotHaveAnagrams_ThenReturnEmpty() {
        assertEmptyAnagram("ey");
    }

    @Test
    public void givenAWordWithThreeLetters_WhenHaveOneAnagram_ThenReturnAnAnagram() {
        assertAnagrams("los","sol");
    }

    private void assertAnagrams(String word, String... expected) {
        List<String> anagrams= anagram.findAnagrams(word);
        Assert.assertThat(anagrams, CoreMatchers.hasItems(expected));
    }

    private void assertEmptyAnagram(String word) {
        List<String> anagrams= anagram.findAnagrams(word);
        Assert.assertEquals(0, anagrams.size());
    }

}
