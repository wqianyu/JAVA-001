package io.kaitoshy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kaito
 * @createDate 2020/11/17 22:07
 */
@Configuration
public class TransportUtil {

    @Bean(name = "bus")
    public Bus Bus() {
        Bus bus = new Bus();
        bus.setStation("longXiangQiao");
        bus.setLine("Line 1");
        return bus;
    }
}
