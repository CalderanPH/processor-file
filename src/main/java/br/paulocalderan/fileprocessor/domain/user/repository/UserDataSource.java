package br.paulocalderan.fileprocessor.domain.user.repository;

import br.paulocalderan.fileprocessor.domain.user.User;
import br.paulocalderan.fileprocessor.domain.user.dto.UserDTO;
import br.paulocalderan.fileprocessor.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDataSource {

    private final UserRepository repository;
    private final UserMapper userMapper;

    public UserDataSource(UserRepository repository, UserMapper userMapper) {
        this.repository = repository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> fetchAllUser() {
        List<User> users = repository.findAll();
        return userMapper.toDTOList(users);
    }

    public void saveAll(List<UserDTO> userDTOS) {
        repository.saveAll(userMapper.toEntityList(userDTOS));
    }
}
