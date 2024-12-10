package br.com.infomirror.service;

import br.com.infomirror.model.Address;
import br.com.infomirror.model.AddressDto;
import br.com.infomirror.model.User;
import br.com.infomirror.model.UserDto;
import br.com.infomirror.repository.UserRepository;
import br.com.infomirror.util.CPFUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ViaCepService viaCepService;

    @InjectMocks
    private UserService userService;

    private UserDto userDto;
    private AddressDto addressDtoMock;

    @BeforeEach
    void setUp() {
        userDto = new UserDto("Test",
                LocalDate.parse("0000-01-01") ,
                "00000000000",
                "01001000");

        addressDtoMock = new AddressDto("01001-000",
                "Praça da Sé",
                "Sé",
                "São Paulo",
                "SP",
                "São Paulo");
    }

    @Test
    void ShouldSaveUserSuccess() {
        when(viaCepService.getAddress(anyString())).thenReturn(addressDtoMock);
        var user = new User();
        BeanUtils.copyProperties(userDto, user);
        assertAll("Should match",
                () -> assertEquals(user.getUsername(), userDto.username()),
                () -> assertEquals(user.getBirthDate(), userDto.birthDate()),
                () -> assertEquals(user.getCpf(), userDto.cpf()));

        var formatedCpf = CPFUtils.format(user.getCpf());
        assertEquals("000.000.000-00", formatedCpf);

        var address = new Address();
        var addressDto = viaCepService.getAddress(userDto.cep());
        BeanUtils.copyProperties(addressDto, address);

        assertAll("Should match address",
                () -> assertEquals(address.getCep(), addressDto.cep()),
                () -> assertEquals(address.getLogradouro(), addressDto.logradouro()),
                () -> assertEquals(address.getBairro(), addressDto.bairro()),
                () -> assertEquals(address.getLocalidade(), addressDto.localidade()),
                () -> assertEquals(address.getUf(), addressDto.uf()),
                () -> assertEquals(address.getEstado(), addressDto.estado()));
    }
}