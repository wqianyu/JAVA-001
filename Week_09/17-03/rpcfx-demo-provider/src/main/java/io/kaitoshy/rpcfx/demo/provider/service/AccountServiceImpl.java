package io.kaitoshy.rpcfx.demo.provider.service;

import io.kaitoshy.rpcfx.demo.api.dto.Account;
import io.kaitoshy.rpcfx.demo.api.interfaces.AccountService;


public class AccountServiceImpl implements AccountService {

    @Override
    public Account getAccountByUsername(String username) {
        return Account.builder().id(1111111L).phone("151****6649").username(username).build();
    }
}
