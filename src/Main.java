import java.util.HashMap;
import java.util.Map;
// This main class has very basic implementation using built in methods in Hash Map
public class Main {
    public static void main(String[] args) {
        // Key : employee Number (Integer)
        // Value: Name (String)
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"Rakib");// adding items method
        map.put(2,"Sadman");
        map.put(3,"Nabik");
        map.put(3,"Abrar");// this will override value of key ==> 3
        // in interview they ask if map can store both key and value as null
        // So, it can store both null value in map
        map.put(4,null);
        map.put(null,null);
        map.remove(null);// it will remove the values where keys are assigned null
        var value = map.get(3);// it will return a String as our key value pair is <Integer,String>
        System.out.println(map.containsKey(3));// O(1) ==> fixed address for storing and retriving  the value
        System.out.println(map.containsValue("Nabik"));//O(n) ==> iterate whole array and compare value with each keys
        System.out.println(value);// it will give Abrar
        System.out.println(map);
        for(var item :map.entrySet())// print key value pair
            System.out.print(item+" ");
        System.out.println();
        for(var item :map.keySet())// print the keys only
            System.out.println(item+" ");

    }
}
