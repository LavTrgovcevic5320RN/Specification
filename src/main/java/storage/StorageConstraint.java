package storage;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class StorageConstraint implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private long byteSizeQuota = 2L * 1024 * 1024 * 1024;
    private List<String> illegalExtensions = new ArrayList<>();
    private HashMap<String, Integer> maxNumberOfFiles = new HashMap<>();

    public long getByteSizeQuota() {
        return byteSizeQuota;
    }
    public void setByteSizeQuota(long byteSizeQuota) {
        this.byteSizeQuota = byteSizeQuota;
    }
    public List<String> getIllegalExtensions() {
        return illegalExtensions;
    }
    public void setIllegalExtensions(List<String> illegalExtensions) {
        this.illegalExtensions = illegalExtensions;
    }
    public HashMap<String, Integer> getMaxNumberOfFiles() {
        return maxNumberOfFiles;
    }
    public void setMaxNumberOfFiles(HashMap<String, Integer> maxNumberOfFiles) {
        this.maxNumberOfFiles = maxNumberOfFiles;
    }
}
