package inha.capstone.ppanggeure.service;

import inha.capstone.ppanggeure.dto.AccountDto;
import inha.capstone.ppanggeure.entity.Account;

import java.util.List;


public interface UserService {

    void createUser(AccountDto accountDto);

    void modifyUser(AccountDto accountDto);

    List<Account> getUsers();

    AccountDto getUser(Long id);

    void deleteUser(Long idx);
}
