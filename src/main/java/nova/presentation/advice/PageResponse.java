package nova.presentation.advice;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@Builder
public class PageResponse {
    private Integer code;
    private List data;
    private Map<String, Object> meta;
}