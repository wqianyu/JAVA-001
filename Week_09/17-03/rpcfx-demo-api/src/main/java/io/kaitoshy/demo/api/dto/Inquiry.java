package io.kaitoshy.demo.api.dto;

import lombok.Data;

@Data
public class Inquiry {
     private Long id;
     private String code;
     private String title;
     private String buyerName;
}
