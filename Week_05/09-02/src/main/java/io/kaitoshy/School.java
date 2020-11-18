package io.kaitoshy;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author kaito
 * @createDate 2020/11/17 17:34
 */

@Component
@Data
public class School {
    @Value("222")
    private String address;
    @Value("江古田高中")
    private String name;
}
