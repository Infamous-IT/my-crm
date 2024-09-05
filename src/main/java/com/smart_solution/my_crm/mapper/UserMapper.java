package com.smart_solution.my_crm.mapper;

import com.smart_solution.my_crm.domain.User;
import com.smart_solution.my_crm.dto.UserDTO;
import org.mapstruct.Mapper;
//import org.mapstruct.MappingConstants;

import java.util.List;

//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDto);
    List<UserDTO> userToUserDTOList(List<User> userList);
}
