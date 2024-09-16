package com.my_crm.service;

import com.my_crm.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserDTO> get();
    UserDTO update(UUID id, UserDTO userDTO);
    UserDTO create(UserDTO userDTO);
    UserDTO get(UUID id);
    void delete(UUID id);
}
