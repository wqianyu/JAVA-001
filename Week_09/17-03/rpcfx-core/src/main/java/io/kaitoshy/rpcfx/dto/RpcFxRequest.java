package io.kaitoshy.rpcfx.dto;

import lombok.Data;

/**
 * @author kaito
 */
@Data
public class RpcFxRequest {
    private String serviceClass;
    private String method;
    private Object[] params;
}
