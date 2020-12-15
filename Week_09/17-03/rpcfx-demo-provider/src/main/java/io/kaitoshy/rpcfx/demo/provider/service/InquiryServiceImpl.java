package io.kaitoshy.rpcfx.demo.provider.service;

import io.kaitoshy.rpcfx.demo.api.dto.Inquiry;
import io.kaitoshy.rpcfx.demo.api.interfaces.InquiryService;

public class InquiryServiceImpl implements InquiryService {
    @Override
    public Inquiry getInquiryById(Long id) {
        return Inquiry.builder().buyerName("apache tokyo-clod ctd").code("n0780").build();
    }
}
