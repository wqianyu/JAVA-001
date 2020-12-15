package io.kaitoshy.rpcfx.demo.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Inquiry {
     private Long id;
     private String code;
     private String title;
     private String buyerName;
}
