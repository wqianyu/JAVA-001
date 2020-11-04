package io.github.kimmking.gateway.router;

import java.util.List;
import java.util.Random;

/**
 * @author kaito
 * @createDate 2020/11/4 22:22
 */
public class HttpEndpointRouterImpl implements HttpEndpointRouter{
    @Override
    public String route(List<String> endpoints) {
        if (endpoints == null || endpoints.size() == 0) {
            return "";
        }

        return randomRouter(endpoints);
    }

    /**
     * 随机模式
     * @param endpoints
     * @return
     */
    private String randomRouter(List<String> endpoints) {
        int size = endpoints.size();
        Random random = new Random();
        int index = random.nextInt(size);
        System.out.println("随机路由：总共有"+ size +"个路由，当前下标为："+ index + ",地址为:" + endpoints.get(index));
        return endpoints.get(index);
    }


}
