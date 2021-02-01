import java.util.LinkedList;

public class HashTable {
    private class Entry{
        // Entry object will be added in the specified index's LinkedList
        private int key;
        private String value;
        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry>[] entries = new LinkedList[5];
    public void put(int key,String value){
//        var entry = getEntry(key);
//        if(entry!=null){
//            entry.value = value;//updating the value if update needed
//            return;
//        }
//        // below 2 lines will check if bucket need to create or not
//        // if bucket needs to create it will be created
//        // then it will add the entry by calling constructor
//        getOrCreateBucket(key).add(new Entry(key, value));

        var index = hash(key);//get the index
        if(entries[index]==null){// if no entries happened before in that specified index
            entries[index]= new LinkedList<>();// make new LinkedList there
        }
        var bucket = entries[index];// as this is use many times (for refactor)
        for(var entry:bucket){// This loop is only for updating value if same key found
            if(entry.key==key){
                entry.value=value;
                return;
            }
        }
        // below line are for always entries with new keys to be added at the end of the list (list at the specified index)
        bucket.addLast(new Entry(key, value));

    }
    public String get(int key){
        // This below 2 line is very simple
        // check the entry found or not.
        // if found , then return the value of the entry , otherwise return null.
        var entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    /*
    var index = hash(key);//Find the specific index for the given key where data may be stored
    var bucket = entries[index];// easy to realise when we renamed it bucket (also in put)
    if(bucket!=null){//if no Linkedlist is created in the specific index then we don't need to iterate there
        for (var entry:bucket){
            if(entry.key==key)
                return entry.value;
        }
    }
    return null;
    */
    }
    private int hash(int key){
        return Math.abs(key% entries.length);// it will return positive value
    }
    public void remove(int key){
        // below 3 lines logic is very simple
        // 1. find the entry,
        // 2. return null if entry not found
        // 3. but if found , find the bucket where the entry exists, then remove the entry from the bucket.
        var entry = getEntry(key);
        if(entry == null)
            throw new IllegalStateException();
        getBucket(key).remove();
        /*
        // as we refactor and make our code simple , we don't have to write code like below
        var index = hash(key);//get the index
        var bucket = entries[index];//renamed as bucket so we can iterate and remove the key value pair
        if(bucket == null)
            throw new IllegalStateException();
        for(var entry: bucket){
            if(entry.key == key){
                bucket.remove(entry);
                return;
            }
        }
        throw new IllegalStateException();// If key is not found anywhere
        */
    }
    private LinkedList<Entry> getOrCreateBucket(int key){
        // find the index using hash key
        // if no linkedlist is created in the index then create a linkedlist and return.
        // otherwise it just return the linkedlist that created before.
        var index = hash(key);
        var bucket = entries[index];
        if(bucket==null)
            entries[index] = new LinkedList<>();

        return bucket;
    }
    private LinkedList<Entry> getBucket(int key){
        /*var index = hash(key);// storing the index
        var bucket = entries[index];
        return bucket;
         */
        // for upper logic below one line is enough
        return entries[hash(key)];
        //method return type is LinkedList<Entry> cause in the index data stored in linkedlist and class type is Entry.
    }
    private Entry getEntry(int key){
        /*
        var index = hash(key);// storing the index
        var bucket = entries[index];// easier to understand
        // as we developed getBucket method we do not have to write code like this
        */
        var bucket = getBucket(key);//find the linkedlist where key,value pair is stored.
        if(bucket !=null){// if bucket is not null then we have to iterate through the bucket (list) , if found as same key then return the entry
            for(var entry:bucket){
                if (entry.key == key)
                    return entry;
            }
        }
        return null;// if no such entry with the give key found, then only return null
    }
}