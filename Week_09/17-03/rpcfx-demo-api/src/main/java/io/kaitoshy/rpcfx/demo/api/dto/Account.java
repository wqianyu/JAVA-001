package io.kaitoshy.rpcfx.demo.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private Long id;
    private String username;
    private String trueName;
    private String phone;
    private Integer type;
}
