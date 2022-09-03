package inha.capstone.ppanggeure.service;


import inha.capstone.ppanggeure.entity.Role;

import java.util.List;

public interface RoleService {

    Role getRole(long id);

    List<Role> getRoles();

    void createRole(Role role);

    void deleteRole(long id);
}