import exceptions.InvalidConstraintException;
import storage.StorageConstraint;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Date;

public abstract class Storage {
	protected StorageConstraint storageConstraint;
	public StorageConstraint getStorageConstraint() { return storageConstraint;	}

	//  operacije nad skladistem
	public abstract void initialiseDirectory(String path, String storageName, int size, int MaxFiles, String... bannedExtensions);
	public abstract void openDirectory(String path);
	public abstract void create(String name, String path);
	public abstract void create(String name, String path, int maxFiles);
	public abstract void setMaxFiles(String path, int maxFiles);
	public abstract void createExpanded(String path, String pattern);
	public abstract void uploadFiles(String destination, String... files) throws InvalidConstraintException;
	public abstract void delete(String path);
	public abstract void moveFiles(String destination, String... sources) throws InvalidConstraintException, FileNotFoundException;
	public abstract void download(String path, String pathGoal);
	public abstract void rename(String newName, String path);
	public abstract long getStorageByteSize();
	public abstract void setSizeQuota(long bytes);
	public long getSizeQuota() {
		return storageConstraint.getByteSizeQuota();
	}

	//  operacije pretrazivanja
	public abstract Collection<String> searchFilesInDirectory(String path);
	// trazi u poddirektorijumima trenutnog direktorijuma
	public abstract Collection<String> searchFilesInAllDirectories(String path);
	public abstract Collection<String> searchFilesInDirectoryAndBelow(String path);
	public abstract Collection<String> searchFilesWithExtension(String path, String extension);
	public abstract Collection<String> searchFilesThatContain(String path, String substring);
	public abstract boolean searchIfFilesExist(String path, String... fileNames);
	public abstract String searchFile(String fileName);
	public abstract Date getCreationDate(String path);
	public abstract Date getModificationDate(String path);
	public abstract Collection<String> searchByNameSorted(String fileName, Boolean rast);
	public abstract Collection<String> searchByDirectoryDateRange(Date start, Date end, String directoryPath);

}
