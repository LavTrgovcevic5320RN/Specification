package storage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileMetaData opisuje fajl koji se nalazi unutar skladista.
 */
public class FileMetaData {
    private String name;
    private String fullPath;
    private Date lastModified;
    private Date lastAccessed;
    private Date created;
    private long byteSize;
    private Type type;
    public enum Type {
        DIRECTORY,
        FILE
    }

    public FileMetaData(String name, String fullPath) {
        this.name = name;
        this.fullPath = fullPath;
    }

    public FileMetaData(String name, String fullPath, Date lastModified, Date lastAccessed, Date created, long byteSize, Type type) {
        this.name = name;
        this.fullPath = fullPath;
        this.lastModified = lastModified;
        this.lastAccessed = lastAccessed;
        this.created = created;
        this.byteSize = byteSize;
        this.type = type;
    }

    @Override
    public String toString() {
       return fullPath;
    }

    private static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    public String fullInfo() {
        return String.format("%s Modified:%s, Accessed:%s, Created:%s, %dB, %s", name, format.format(lastModified), format.format(lastAccessed), format.format(created), byteSize, type.toString());
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

    public Date getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(Date lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public void setByteSize(long byteSize) {
        this.byteSize = byteSize;
    }

    public void setType(Type type) {
        this.type = type;
    }
}