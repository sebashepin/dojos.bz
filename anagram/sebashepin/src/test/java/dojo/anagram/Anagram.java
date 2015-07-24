package dojo.anagram;

import java.util.*;

public class Anagram {

    public static Set<String> dictonary = new HashSet<>(Arrays.asList("ya","ay","los","sol"));

    public Anagram() {
    }

    List<String> findAnagrams(String word) {
        List<String> result = new ArrayList<>();
        if (word.length() == 2) {
            String reverse = reverse(word);
            if(dictonary.contains(reverse)){
                result.add(reverse);
            }
        }else{

        }
        return result;
    }

    public String reverse(String source) {
        StringBuilder sb = new StringBuilder();
        for (int i = source.length()-1; i > -1; --i){
            sb.append(source.charAt(i));
        }
        return sb.toString();
    }
}