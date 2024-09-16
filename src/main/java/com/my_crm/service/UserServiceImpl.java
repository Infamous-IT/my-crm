package com.my_crm.service;

import com.my_crm.domain.User;
import com.my_crm.dto.UserDTO;
import com.my_crm.mapper.UserMapper;
import com.my_crm.repo.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> get() {
        return userMapper.userToUserDTOList(userRepository.findAll());
    }

    @Override
    @Transactional
    public UserDTO update(UUID id, UserDTO userDTO) {
        User existingUser  = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        userMapper.updateUserFromDTO(userDTO, existingUser);
        User updatedUser = userRepository.save(existingUser);
        return userMapper.userToUserDTO(updatedUser);
    }

    @Override
    @Transactional
    public UserDTO create(UserDTO userDTO) {
        User user = userMapper.userDTOToUser(userDTO);
        User createdUser = userRepository.save(user);
        return userMapper.userToUserDTO(createdUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO get(UUID id) {
        User user = userRepository.getReferenceById(id);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id " + id + "was not found.");
        }

        return userMapper.userToUserDTO(user);
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }
}
