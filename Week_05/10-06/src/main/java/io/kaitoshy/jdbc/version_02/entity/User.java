package io.kaitoshy.jdbc.version_02.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author kaito
 * @createDate 2020/11/19 00:05
 */
@Data
@Builder
public class User {
    private Long id;
    private String userName;
    private Integer age;
}
