package com.my_crm.mapper;

import com.my_crm.domain.User;
import com.my_crm.dto.UserDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;

//@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDto);
    List<UserDTO> userToUserDTOList(List<User> userList);
}
