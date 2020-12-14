package io.kaitoshy.demo.api.dto;

import lombok.Data;

@Data
public class Account {
    private Long id;
    private String username;
    private String trueName;
    private String phone;
    private Integer type;
}
