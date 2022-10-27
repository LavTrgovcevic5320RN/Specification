package storage;

import java.util.Date;

/**
 * FileMetaData opisuje fajl koji se nalazi unutar skladista.
 */
public class FileMetaData {
    private final String fullPath;
    private final Date lastModified;
    private final Date lastAccessed;
    private final Date created;
    private final long byteSize;
    private final Type type;
    public enum Type {
        DIRECTORY,
        FILE
    }

    public FileMetaData(String fullPath, Date lastModified, Date lastAccessed, Date created, long byteSize, Type type) {
        this.fullPath = fullPath;
        this.lastModified = lastModified;
        this.lastAccessed = lastAccessed;
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

    public Date getLastAccessed() {
        return lastAccessed;
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
}