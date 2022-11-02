package storage;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class Filter {
    private Date startDate = new Date(Long.MIN_VALUE), endDate = new Date(Long.MAX_VALUE);
    private long minSize = -1, maxSize = Long.MAX_VALUE;
    private DateType filterDateType = null;

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
        return toFilter.stream().filter(fileMetaData -> {
            boolean ok = true;
            ok = (fileMetaData.getByteSize() >= minSize && fileMetaData.getByteSize() <= maxSize);
            Date toCompare = null;
            if (filterDateType != null) {
                switch (filterDateType) {
                    case ACCESS -> toCompare = fileMetaData.getLastAccessed();
                    case CREATE -> toCompare = fileMetaData.getCreated();
                    case MODIFY -> toCompare = fileMetaData.getLastModified();
                }
                ok &= (toCompare.after(startDate) && toCompare.before(endDate));
            }
            return ok;
        }).collect(Collectors.toList());
    }
}

