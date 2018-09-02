package spring.ku.boot.query;

import lombok.Data;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public abstract class BasePage implements Pageable {

    private int pageNumber = 1;

    private int pageSize = 20;

    @Override
    public int getPageNumber() {
        return this.pageNumber;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public int getOffset() {
        return (this.pageNumber -1) * this.pageSize;
    }

    @Override
    public Sort getSort() {
        return new Sort("id");
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
