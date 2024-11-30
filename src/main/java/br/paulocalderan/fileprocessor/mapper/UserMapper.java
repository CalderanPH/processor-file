package br.paulocalderan.fileprocessor.mapper;

import br.paulocalderan.fileprocessor.domain.user.User;
import br.paulocalderan.fileprocessor.domain.user.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    List<User> toEntityList(List<UserDTO> userDTOs);

    List<UserDTO> toDTOList(List<User> user);

}
