package io.kaitoshy.kafka.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Foo2 {
    private String foo;

    @Override
    public String toString() {
        return "Foo2 [foo=" + this.foo + "]";
    }
}
