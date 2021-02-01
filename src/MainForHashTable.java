public class MainForHashTable {
    public static void main(String[] args) {
    HashTable table = new HashTable();
    table.put(6,"A");//6 % 5 = 1
    table.put(8,"B");//8 % 5 = 3
    table.put(11,"C");// 11 % 5 = 1
    table.put(6,"A+");
    table.remove(6);
    }
}
