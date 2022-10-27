package storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StorageConstraint {
    private long byteSizeQuota = 2L * 1024 * 1024 * 1024;
    private List<String> illegalExtensions = new ArrayList<>();
    private HashMap<String, Integer> maxNumberOfFiles = new HashMap<>();
}
