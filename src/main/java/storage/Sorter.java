package storage;

import java.util.Collection;

public class Sorter {
    private DateType sortDateType = null;
    private boolean ascending = true;
    // Sortira po nazivu u zavisnosti od prosledjenog smera
    public Sorter(boolean ascending) {
        this.ascending = ascending;
    }
    public Sorter(DateType sortDateType, boolean ascending) {
        this.sortDateType = sortDateType;
        this.ascending = ascending;
    }

    public Collection<FileMetaData> applySorter(Collection<FileMetaData> toSort) {
        return null;
    }
}
