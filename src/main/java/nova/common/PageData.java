package nova.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PageData<T> {
    @Setter
    private List<T> data;
    private PageInfo page;

}
