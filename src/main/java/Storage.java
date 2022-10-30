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
	public abstract void setStorageSize(int bytes);
	public abstract void create(String name, String path);
	public abstract void create(String name, String path, int maxFiles);
	public abstract void setMaxFiles(String path, int maxFiles);
	public abstract void create(String name, String path, String pattern);
	public abstract void uploadFile(String destination, String filePath) throws InvalidConstraintException;
	public abstract void uploadFiles(String source, String destination,  String... files) throws InvalidConstraintException;
	public abstract void delete(String path);
	public abstract void moveFile(String destination, String... sources) throws InvalidConstraintException, FileNotFoundException;
	public abstract void moveFiles(Collection<String> files, String path, String pathGoal) throws InvalidConstraintException;
	public abstract void download(String path, String pathGoal);
	public abstract void rename(String newName, String path);
	public abstract long getStorageByteSize();

	//  operacije pretrazivanja
	public abstract Collection<String> searchFilesInDirectory(String directoryPath);
	// trazi u poddirektorijumima trenutnog direktorijuma
	public abstract Collection<String> searchFilesInAllDirectories(String directoryPath);
	public abstract Collection<String> searchFilesInDirectoryAndBelow(String directoryPath);
	public abstract Collection<String> searchFilesWithExtension(String extension);
	public abstract Collection<String> searchFilesThatContain(String fileName);
	public abstract boolean searchIfFilesExist(String path, String... fileNames);
	public abstract String searchFile(String fileName);
	public abstract Date getCreationDate(String path);
	public abstract Date getModificationDate(String path);
	public abstract Collection<String> searchByNameSorted(String fileName, Boolean rast);
	public abstract Collection<String> searchByDirectoryDateRange(Date start, Date end, String directoryPath);

}
