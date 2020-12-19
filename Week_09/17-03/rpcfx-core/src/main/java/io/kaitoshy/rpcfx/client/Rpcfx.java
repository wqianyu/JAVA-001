package io.kaitoshy.rpcfx.client;


public interface Rpcfx {
    public <T> T create(final Class<T> serviceClass, final String url);
}
