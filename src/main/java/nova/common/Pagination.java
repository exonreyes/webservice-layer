package nova.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Pagination {
    private long page;
    private long pageCount;
    private long rows;
    private long totalElements;

}
