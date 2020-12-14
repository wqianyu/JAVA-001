package dto;

import lombok.Data;

/**
 * @author kaito
 * @createDate 2020/12/14 23:34
 */
@Data
public class RpcFxResponse {
    private Integer code;
    private Exception exception;
    private Object data;
}
