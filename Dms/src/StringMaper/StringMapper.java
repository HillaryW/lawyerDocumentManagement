package StringMaper;

import java.util.HashMap;

/**
 * Created by centhian on 3/4/17.
 */
public class StringMapper {

    HashMap<String,Integer> keywordMap = new HashMap<>();

    public HashMap<String, Integer> processString(String string){
        String[] stringArray = parseString(string);
        mapStringArray(stringArray);
        return keywordMap;
    }

    private String[] parseString(String text){
        text = text.toLowerCase();
        text = text.replaceAll("[!?,.():]", "");
        String[] words = text.split("\\s+");
        return words;
    }

    private void mapStringArray(String[] array){
        for (String word : array) {
            if (!word.equals("")) {
                if (keywordMap.containsKey(word)) {
                    Integer count = keywordMap.get(word);
                    count++;
                    keywordMap.replace(word, count);
                } else {
                    keywordMap.put(word, 1);
                }
            }
        }
    }


}
