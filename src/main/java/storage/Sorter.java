package storage;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<FileMetaData> ret = null;
        if(sortDateType == null) {
            ret = toSort.stream().sorted(Comparator.comparing(FileMetaData::getName)).collect(Collectors.toList());
            if(ascending) Collections.reverse(ret);
        } else switch(sortDateType) {
            case ACCESS -> ret = toSort.stream().sorted(Comparator.comparing(FileMetaData::getLastAccessed)).collect(Collectors.toList());
            case CREATE -> ret = toSort.stream().sorted(Comparator.comparing(FileMetaData::getCreated)).collect(Collectors.toList());
            case MODIFY -> ret = toSort.stream().sorted(Comparator.comparing(FileMetaData::getLastModified)).collect(Collectors.toList());
        }
        //if(ascending) Collections.reverse(ret);
        return ret;
    }
}
