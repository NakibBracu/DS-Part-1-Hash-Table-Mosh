import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CharFinder {
    //popular interview question
    // Find first non repeated character from a given String.
    // String = "a green apple"
    // So, for the given example it is 'g'
    // This is a good exercise for hashmap
    // a green apple from this we build hashmap
    // a = 2
    //   = 2
    // g = 1 etc for the whole string and return the first character with an occurance of 1
    public char findFirstNonRepeatingChar(String str){
        Map<Character,Integer> map = new HashMap<>();
        var chars = str.toCharArray();
        for(char ch:chars){//full string iterated using chararray
            //if character is got multiple times then count value will be incremented by 1 otherwise it will set to 0
            var count = map.containsKey(ch)? map.get(ch):0;
            map.put(ch,count+1);

        }
       // System.out.println(map);
        // now check if it had only one occourance
        for (char ch :chars){
            if(map.get(ch)==1)
                return ch;
        }
        return Character.MIN_VALUE;// if all characters are repeated.
    }
    public char findfirstRepeatedCharacter(String str){
    // We can solve this using set, cause set willnot contain any repeated value
        java.util.Set<Character> set = new HashSet<>();
        for(char ch:str.toCharArray()){//covert string to chararray
            if(set.contains(ch))//check if it is already in the set if it already exist then immidiately return it and thats our first repeated character
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }

}
