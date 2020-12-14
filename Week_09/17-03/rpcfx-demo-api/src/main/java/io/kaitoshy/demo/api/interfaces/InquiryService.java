package io.kaitoshy.demo.api.interfaces;

import io.kaitoshy.demo.api.dto.Inquiry;

public interface InquiryService {
    Inquiry getOrderById(Long id);
}
