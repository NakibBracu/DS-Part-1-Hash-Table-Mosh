import java.util.HashSet;

public class Set {
    public static void main(String[] args) {
        java.util.Set<Integer> set = new HashSet<>();
        int []numbers = {1,1,2,2,3,4,3,5,6,6};
        for(var num:numbers)
            set.add(num);
        System.out.println(set);
   // there are certain methods for add, delete, contains in sets
    }
}
