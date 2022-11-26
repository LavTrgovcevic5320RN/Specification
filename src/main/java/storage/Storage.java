package storage;

import exceptions.InvalidConstraintException;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Date;
/**
 * Klasa i njene podklase sluze da korisnik moze da radi
 * sa direktorijumima i fajlovima
 *
 * @author Lav Trgovcevic RN 53/20 i Stevan Ille RN 32/20
 */
public abstract class Storage {
	protected StorageConstraint storageConstraint;

	/**
	 *	Get motoda za StorageConstraint
	 * @return	StorageConstraint
	 */
	public StorageConstraint getStorageConstraint() { return storageConstraint;	}

	/**
	 * Incijalizujemo direktorijum na odredjenoj putanju da bi mogli unutar tog direktorijuma da kreiramo nove direktorijume i premestamo, brisemo, itd.
	 *
	 * @param path	putanja na koju zelimo da inicijalizujemo direktorijum
	 * @param storageName	naziv skladista
	 * @param size	velicina skladista
	 * @param MaxFiles	maksimalni broj poddirektorijuma koji trenutni direktorijum moze da ima
	 * @param bannedExtensions	zabranjene ekstenzije
	 */
	public abstract void initialiseDirectory(String path, String storageName, int size, int MaxFiles, String... bannedExtensions);

	/**
	 * Metoda koja ako je izvorni direktorijum inicijalizovan tj. postoji od pre potrebno da samo
	 * otvori izvorni direktorijum na zadatoj putanji da bi moglo dalje da se radi nad direktorijumom
	 *
	 * @param path putanju na kojoj se otvara direktorijum
	 */
	public abstract void openDirectory(String path);

	/**
	 * Metoda kojom se kreiraju direktorijumi
	 *
	 * @param name	naziv direktorijuma
	 * @param path	putanja do direktorijuma
	 */
	public abstract void create(String name, String path);

	/**
	 * Metoda kojom se kreiraju direktorijuma
	 *
	 * @param name	naziv direktorijuma
	 * @param path	putanja do direktorijuma
	 * @param maxFiles maksimalni broj poddirektorijuma koji trenutni direktorijum moze da ima
	 */
	public abstract void create(String name, String path, int maxFiles);

	/**
	 * Metoda kojom se podesava maksimalni dozvoljen broj poddirektorijuma odredjenog direktorijuma
	 *
	 * @param path
	 * @param maxFiles maksimalni broj poddirektorijuma koji trenutni direktorijum moze da ima
	 */
	public abstract void setMaxFiles(String path, int maxFiles);

	/**
	 * Metoda kojom se kreiraju direktorijumi sa nekim sablonom
	 *
	 * @param path	putanja na kojoj se kreiraju direktorijumi
	 * @param pattern sablon pomocu koga se kreiraju direktorijumi
	 */
	public abstract void createExpanded(String path, String pattern);

	/**
	 * Metoda kojom se upload-uju direktorijumi u druge direktorijume
	 *
	 * @param  destination	putanja na kojoj ce se upload-ovati fajlovi
	 * @param  files 		fajlovi koji se upload-uju
	 * @throws InvalidConstraintException
	 */
	public abstract void uploadFiles(String destination, String... files) throws InvalidConstraintException;

	/**
	 * Metoda kojom se brisu direktorijumi i poddirektorijumi
	 *
	 * @param path	putanja direktorijuma koji zelimo da obrisemo
	 */
	public abstract void delete(String path);

	/**
	 * Metoda kojom se upload-uju direktorijumi u druge direktorijume
	 *
	 * @param destination	putanja na koju ce se premestiti fajlovi
	 * @param sources 		relativna putanja fajlova koji se premestaju
	 */
	public abstract void moveFiles(String destination, String... sources) throws InvalidConstraintException, FileNotFoundException;

	/**
	 * Metoda kojom se preuzimaju direktorijumi na putanju van izvornog direktorijuma
	 *
	 * @param destination	putanja na koju ce se preuzeti fajlovi koja je van izvornog direktorijuma
	 * @param sources 		relativna putanja fajlova koji se preuzimaju
	 */
	public abstract void download(String destination, String... sources);

	/**
	 * Metoda kojom se menja naziv odredjenog direktorijuma sa novim nazivom
	 *
	 * @param newName	novi naziv fajla
	 * @param path 		relativna putanja fajla koji se preimenuje
	 */
	public abstract void rename(String newName, String path);

	/**
	 * Getter metoda kojom se dobija byte velicina direktorijuma
	 *
	 */
	public abstract long getStorageByteSize();

	/**
	 * Setter metoda kojom se postavlja nova maksimalna velicina skladista u bajtovima
	 * @param bytes nova velicina skladista u bajtovima
	 */
	public abstract void setSizeQuota(long bytes);

	/**
	 * Getter metoda kojom se dobija maks byte velicina direktorijuma
	 *
	 */
	public long getSizeQuota() {
		return storageConstraint.getByteSizeQuota();
	}

	/**
	 * Metoda kojom pretrazujemo samo u trenutnom direktorijumu na pocetnoj dubini
	 *
	 * @param path putanja na kojoj pretrazujemo
	 * @return kolekcija fajlova dobijenih iz pretrage
	 */
	public abstract Collection<FileMetaData> searchFilesInDirectory(String path);


	/**
	 * Metoda kojom pretrazujemo samo u svim direktorijumu i poddirektorijumima
	 *
	 * @param path putanja na kojoj pretrazujemo
	 * @return kolekcija fajlova dobijenih iz pretrage
	 */
	public abstract Collection<FileMetaData> searchFilesInDirectoryAndBelow(String path);

	/**
	 * Metoda kojom pretrazujemo u svim direktorijumu i poddirektorijumima fajlove sa odredjenom ekstenzijom
	 *
	 * @param path putanja na kojoj pretrazujemo
	 * @return kolekcija fajlova dobijenih iz pretrage
	 */
	public abstract Collection<FileMetaData> searchFilesWithExtension(String path, String extension);

	/**
	 * Metoda kojom pretrazujemo u svim direktorijumu i poddirektorijumima koji sadrze odredjeni substring
	 *
	 * @param path putanja na kojoj pretrazujemo
	 * @return kolekcija fajlova dobijenih iz pretrage
	 */
	public abstract Collection<FileMetaData> searchFilesThatContain(String path, String substring);

	/**
	 * Metoda kojom pretrazujemo u svim direktorijumu i poddirektorijumima da li odredjeni fajl postoji
	 *
	 * @param path putanja na kojoj pretrazujemo
	 * @return kolekcija fajlova dobijenih iz pretrage
	 */
	public abstract boolean searchIfFilesExist(String path, String... fileNames);

	/**
	 * Metoda kojom pretrazujemo fajl u svim direktorijumu i poddirektorijumima
	 *
	 * @param fileName ime fajla koji trazimo
	 * @return kolekcija fajlova dobijenih iz pretrage
	 */
	public abstract Collection<String> searchFile(String fileName);
	public abstract Collection<FileMetaData> searchByNameSorted(String fileName, boolean rastuce);
	public abstract Collection<FileMetaData> searchByDirectoryDateRange(Date startDate, Date endDate, DateType sortDateType, String path);

}
