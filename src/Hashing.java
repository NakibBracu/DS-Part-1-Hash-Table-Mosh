import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Hashing {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(167546,"Rakib");
        //Now we have a limited array of 100 items
        // so we can't declare a an array of 167546 (not needed)
        // We can use hashing
        // though the key value is represented using a big int value we can simplify it using mod

        System.out.println(hash(167546));
        //output for 167546 is 46 for hash method that means
        // if we want to save the key value pair in an array of 100 it should be in the 46th index
        Map<String,String> map1 = new HashMap<>();
        map1.put("1234567-A","Rakib");
        System.out.println(map1);
        System.out.println(hashString("1234567-A"));
        Map<Integer,String> rakibul = new HashMap<>();
        rakibul.put(1,"Ra*765kib");
        //items[1]=Ra*765kib;
        System.out.println(hashString("Ra*765kib"));
        //{1,Ra*765kib}
    }
    public static int hash(int number){
        return number%100;
    }
    public static int hashString(String key){
        int hash = 0;
        for(var ch:key.toCharArray())
            hash+=ch;// this is an implicit casting
        //as all the characters are represented by a number
        // though we add an integer with an character but character is coverted
        // to an integer and added with hash which is also an integer
        return hash%100;
    }
}