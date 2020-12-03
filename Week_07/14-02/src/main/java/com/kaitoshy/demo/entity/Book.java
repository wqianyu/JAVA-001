package com.kaitoshy.demo.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author kaito
 * @createDate 2020/12/4 00:18
 */
@Data
@Builder
public class Book {
    private Long id;
    private String name;
    private String isbn;
}
