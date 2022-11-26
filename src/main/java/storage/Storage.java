package storage;

import exceptions.InvalidConstraintException;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Date;

public abstract class Storage {
	protected String fileName;

	protected StorageConstraint storageConstraint;
	public StorageConstraint getStorageConstraint() { return storageConstraint;	}
	//init path name [--size n] [--max-files n] [--banned-extensions list=.exe,.jpg,.zip]
	//open path
	//create storage-path [--max-files n]
	//create [--expand] regex
	//set-max-files path max-files
	//upload local-path storage-path
	//move storage-path storage-path
	//delete storage-path
	//download storage-path local-path
	//rename storage-path new-name
	//get-storage-size
	//byte-quota [--set n] [--get]
	//ls path
	//search rezultat treba da se zapamti u neki result set
	//search --global name
	//search --recursive pocetni
	//search path --extension extension...
	//search path --in-name substring
	//search path --exists file...
	//search --for name
	//na poslednji result set se primenjuju sorteri i filteri
	//filter --by-date modify/create/access start-date end-date
	//filter --by-size min-size max-size
	//sort --by-name ascending/descending
	//sort --by-date  modify/create/access ascending/descending
	//sort --by-size ascending/descending
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
	public abstract void download(String destination, String... sources);
	public abstract void rename(String newName, String path);
	public abstract long getStorageByteSize();
	public abstract void setSizeQuota(long bytes);
	public long getSizeQuota() {
		return storageConstraint.getByteSizeQuota();
	}

	//  operacije pretrazivanja
	public abstract Collection<FileMetaData> searchFilesInDirectory(String path);
	// trazi u poddirektorijumima trenutnog direktorijuma
	public abstract Collection<FileMetaData> searchFilesInAllDirectories(String path);
	//todo dodati pocetni direktorijum
	public abstract Collection<FileMetaData> searchFilesInDirectoryAndBelow(String path);
	public abstract Collection<FileMetaData> searchFilesWithExtension(String path, String extension);
	public abstract Collection<FileMetaData> searchFilesThatContain(String path, String substring);
	public abstract boolean searchIfFilesExist(String path, String... fileNames);
	public abstract Collection<String> searchFile(String fileName);
	public abstract Collection<FileMetaData> searchByNameSorted(String fileName, boolean rastuce);
	public abstract Collection<FileMetaData> searchByDirectoryDateRange(Date startDate, Date endDate, DateType sortDateType, String path);

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
