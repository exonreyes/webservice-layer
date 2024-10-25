package nova.common;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApiPageResponse extends Pagination {
    private final Object data;
    private final int code;

    public ApiPageResponse(long currentPage, long totalPages, long items, long totalItems, Object data, int code) {
        super(currentPage, totalPages, items, totalItems);
        this.data = data;
        this.code = code;
    }
}