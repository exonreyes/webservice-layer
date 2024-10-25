package nova.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EntityException extends RuntimeException {
    private final String code;

    public EntityException(String code, String message) {
        super(message);
        this.code = code;
    }
}
