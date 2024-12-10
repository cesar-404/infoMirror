package br.com.infomirror.service;

import br.com.infomirror.model.User;
import br.com.infomirror.model.controller.FinalUserDto;
import br.com.infomirror.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(FinalUserDto userDto) {
        var user = new User();
        BeanUtils.copyProperties(userDto, user);
        return userRepository.save(user);
    }
}
