package io.kaitoshy.demo.api.interfaces;

import io.kaitoshy.demo.api.dto.Account;

public interface AccountService {
    Account getAccountByUsername(String username);
}
