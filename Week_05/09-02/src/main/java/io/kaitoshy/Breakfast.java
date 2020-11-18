package io.kaitoshy;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @author kaito
 * @createDate 2020/11/18 09:18
 */
@Component
@Conditional(MyCondition.class)
@Data
public class Breakfast {

    @Value("${breakfast}")
    private String food;

    @Value("false")
    private boolean isHungry;
}
