package io.kaitoshy.rpcfx.demo.provider.facade;

import io.kaitoshy.rpcfx.dto.RpcFxRequest;
import io.kaitoshy.rpcfx.dto.RpcFxResponse;
import io.kaitoshy.rpcfx.server.RpcfxInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kaito
 */
@Controller
@RequestMapping("/rpc")
public class RootPathApi {
    @Autowired
    private RpcfxInvoker rpcfxInvoker;

    @PostMapping("/")
    public RpcFxResponse invoke(@RequestBody  RpcFxRequest rpcFxRequest) {
         return rpcfxInvoker.invoke(rpcFxRequest);
    }
}
