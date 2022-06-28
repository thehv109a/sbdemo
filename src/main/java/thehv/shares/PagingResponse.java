package thehv.shares;

import lombok.Data;

@Data
public class PagingResponse {
    private Object content;
    private long totalPages;
    private long totalElements;
    private long numberOfElements;
    private long page;
    private long pageSize;
    private long number;

    public PagingResponse(Object content) {
        this.content = content;
    }

    public PagingResponse(Object content, long numberOfElements, long totalElements, long page, long pageSize) {
        this.content = content;
        this.numberOfElements = numberOfElements;
        this.totalElements = totalElements;
        this.page = page;
        this.pageSize = pageSize;
        long totalPages = totalElements / pageSize;
        this.number = page;
        if (totalElements % pageSize == 0) {
            this.totalPages = totalPages;
        } else {
            this.totalPages = totalPages + 1;
        }
    }
}