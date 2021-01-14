package io.kaitoshy.kafka.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Foo1 {
    private String foo;

    public Foo1(String foo) {
        this.foo = foo;
    }

    @Override
    public String toString() {
        return "Foo1 [foo=" + this.foo + "]";
    }
}
