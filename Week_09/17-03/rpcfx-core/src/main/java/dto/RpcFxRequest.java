package dto;

import lombok.Data;

/**
 * @author kaito
 * @createDate 2020/12/14 23:38
 */
@Data
public class RpcFxRequest {
    private String serviceClass;
    private String method;
    private Object[] params;
}
