package io.kaitoshy.rpcfx.demo.provider.facade;

import dto.RpcFxRequest;
import dto.RpcFxResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kaito
 * @createDate 2020/12/14 23:17
 */
@Controller
@RequestMapping("/rpc")
public class RootPathApi {
    @GetMapping("/")
    public RpcFxResponse invoke(RpcFxRequest rpcFxRequest) {
        return null;
    }
}
