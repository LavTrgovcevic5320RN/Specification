package storage;

import java.util.Collection;
import java.util.Date;

public class Filter {
    private Date startDate, endDate;
    private long minSize, maxSize;
    private DateType filterDateType;

    public Filter(long minSize, long maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    public Filter(Date startDate, Date endDate, DateType filterDateType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.filterDateType = filterDateType;
    }

    public Filter(Date startDate, Date endDate, long minSize, long maxSize, DateType filterDateType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.filterDateType = filterDateType;
    }

    public Collection<FileMetaData> applyFilter(Collection<FileMetaData> toFilter) {
        return null;
    }
}

