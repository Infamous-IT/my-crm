package com.my_crm.controller;

import com.my_crm.dto.UserDTO;
import com.my_crm.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> get() {
        return userService.get();
    }

    @GetMapping(value = "/{id}")
    public UserDTO getById(@PathVariable UUID id) {
        return userService.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@Valid @RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return userDTO;
    }

    @PatchMapping(value = "/{id}")
    public UserDTO update(@Valid @PathVariable UUID id, @RequestBody UserDTO userDTO) {
        userService.update(id, userDTO);
        return userDTO;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }
}
