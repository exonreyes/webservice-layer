package nova.presentation.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class ValidationErrorResponse {
    private Integer code;
    private String message;
    private Map<String, String> errors;
}