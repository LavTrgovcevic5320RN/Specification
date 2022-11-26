package storage;

public class StorageManager {
    private static Storage storage;

    public static void registerStorage(Storage st){
        storage = st;
    }

    public static Storage getStorage(String path){
        storage.setFileName(path);
        return storage;
    }
}
