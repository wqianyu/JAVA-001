package io.kaitoshy.rpcfx.demo.api.interfaces;

import io.kaitoshy.rpcfx.demo.api.dto.Account;

public interface AccountService {
    Account getAccountByUsername(String username);
}
