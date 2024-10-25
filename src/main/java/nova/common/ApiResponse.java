package nova.common;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public final class ApiResponse {
    private Object data;
    private String code;
    private String message;
}

