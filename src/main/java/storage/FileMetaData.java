package storage;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * FileMetaData opisuje fajl koji se nalazi unutar skladista.
 */
public class FileMetaData {
    private String name;
    private String fullPath;
    private Date lastModified;
    private Date created;
    private long byteSize;
    private Type type;
    private long byteSizeQuota = 2L * 1024 * 1024 * 1024;
    private List<String> illegalExtensions = new ArrayList<>();
    private Integer maxNumberOfFiles = 5;
    public enum Type {
        DIRECTORY,
        FILE
    }

    public FileMetaData(String name, String fullPath) {
        this.name = name;
        this.fullPath = fullPath;
    }

    public FileMetaData(String name, String fullPath, Date lastModified, Date created, long byteSize, Type type) {
        this.name = name;
        this.fullPath = fullPath;
        this.lastModified = lastModified;
        this.created = created;
        this.byteSize = byteSize;
        this.type = type;
    }

    public String getFullPath() {
        return fullPath;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public Date getCreated() {
        return created;
    }

    public long getByteSize() {
        return byteSize;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setByteSize(long byteSize) {
        this.byteSize = byteSize;
    }

    public void setType(Type type) {
        this.type = type;
    }

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

    public Integer getMaxNumberOfFiles() {
        return maxNumberOfFiles;
    }

    public void setMaxNumberOfFiles(Integer maxNumberOfFiles) {
        this.maxNumberOfFiles = maxNumberOfFiles;
    }
}