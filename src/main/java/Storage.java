import exceptions.FileException;
import exceptions.InvalidConstraintException;

import java.util.Collection;
import java.util.Date;

public interface Storage {

	//  operacije nad skladistem
	void initialiseStorage(String storageName, String path);
	void setStorageSize(int bytes);
	void setMaxNumberOfFiles(int number);
	void createDirectory(String name, String path);
	void createDirectory(String name, String path, String pattern);
	void uploadFiles(String path) throws InvalidConstraintException;
	void delete(String path);
	void moveFile(String file, String path, String pathGoal) throws InvalidConstraintException;
	void moveFiles(Collection<String> files, String path, String pathGoal) throws InvalidConstraintException;
	void download(String path, String pathGoal);
	void rename(String newName, String path);
	long getStorageByteSize();

	//  operacije pretrazivanja
	Collection<String> searchFilesInDirectory(String directoryPath);
	// ?????????????????????????????????????
	Collection<String> searchFilesInAllDirectories(String directoryPath);
	Collection<String> searchFilesInDirectoryAndBelow(String directoryPath);
	Collection<String> searchFilesWithExtension(String extension);
	Collection<String> searchFilesThatContain(String fileName);
	boolean searchIfFilesExist(String path, String... fileNames);
	String searchFile(String fileName);
	Date getCreationDate(String path);
	Date getModificationDate(String path);
	Collection<String> searchByNameSorted(String fileName, Boolean rast);
	Collection<String> searchByDirectoryDateRange(Date start, Date end, String directoryPath);

}
