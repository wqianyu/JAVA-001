package io.kaitoshy.rpcfx.demo.consumer;


import io.kaitoshy.rpcfx.client.Rpcfx;
import io.kaitoshy.rpcfx.client.http.proxy.ServiceProxy;
import io.kaitoshy.rpcfx.demo.api.dto.Account;
import io.kaitoshy.rpcfx.demo.api.dto.Inquiry;
import io.kaitoshy.rpcfx.demo.api.interfaces.AccountService;
import io.kaitoshy.rpcfx.demo.api.interfaces.InquiryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class RpcfxDemoConsumerApplication implements CommandLineRunner {

    private final static String PRC_URL = "http://localhost:8090/rpc/";

    public static void main(String[] args) {
        SpringApplication.run(RpcfxDemoConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ServiceProxy proxy = new ServiceProxy();
        AccountService userService = proxy.create(AccountService.class, PRC_URL);
        Account user = userService.getAccountByUsername("aaaaa");
        log.info("account name is 'aaaaa' from server: {}" , user.getPhone());

        InquiryService inquiryService = proxy.create(InquiryService.class, PRC_URL);
        Inquiry order = inquiryService.getInquiryById(2222L);
        log.info("inquiry title={}, buyers_name={}", order.getTitle(), order.getBuyerName());
    }
}
