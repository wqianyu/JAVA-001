package io.kaitoshy.rpcfx.demo.api.interfaces;

import io.kaitoshy.rpcfx.demo.api.dto.Inquiry;

public interface InquiryService {
    Inquiry getInquiryById(Long id);
}
