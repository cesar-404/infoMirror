package br.com.infomirror.service;

import br.com.infomirror.model.Address;
import br.com.infomirror.model.User;
import br.com.infomirror.model.UserDto;
import br.com.infomirror.repository.UserRepository;
import br.com.infomirror.util.CPFUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ViaCepService viaCepService;

    public UserService(UserRepository userRepository, ViaCepService viaCepService) {
        this.userRepository = userRepository;
        this.viaCepService = viaCepService;
    }

    public User save(UserDto userDto) {
        var user = new User();
        BeanUtils.copyProperties(userDto, user);

        var formatedCPF = CPFUtils.format(user.getCpf());
        user.setCpf(formatedCPF);

        var address = new Address();
        BeanUtils.copyProperties(viaCepService.getAddress(userDto.cep()), address);
        user.setAddress(address);

        return userRepository.save(user);
    }
}