package io.kaitoshy.rpcfx.demo.provider.compact;


import io.kaitoshy.rpcfx.demo.api.interfaces.AccountService;
import io.kaitoshy.rpcfx.demo.api.interfaces.InquiryService;
import io.kaitoshy.rpcfx.demo.provider.resolver.DemoResolver;
import io.kaitoshy.rpcfx.demo.provider.service.AccountServiceImpl;
import io.kaitoshy.rpcfx.demo.provider.service.InquiryServiceImpl;
import io.kaitoshy.rpcfx.server.RpcfxInvoker;
import io.kaitoshy.rpcfx.server.RpcfxResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanWired {
    @ConditionalOnClass(RpcfxInvoker.class)
    @Bean
    public RpcfxInvoker createInvoke(@Autowired RpcfxResolver resolver) {
        return new RpcfxInvoker(resolver);
    }

    @Bean
    public AccountService createAccountService() {
        return new AccountServiceImpl();
    }

    @Bean
    public InquiryService createInquiryService() {
        return new InquiryServiceImpl();
    }

    @Bean
    public RpcfxResolver createResolver(){
        return new DemoResolver();
    }
}
