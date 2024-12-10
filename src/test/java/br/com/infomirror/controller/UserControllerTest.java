package br.com.infomirror.controller;

import br.com.infomirror.model.Address;
import br.com.infomirror.model.User;
import br.com.infomirror.model.UserDto;
import br.com.infomirror.service.UserService;
import br.com.infomirror.service.ViaCepService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Mock
    private ViaCepService viaCepService;

    @Autowired
    private ObjectMapper objectMapper;

    private UserDto userDto;

    @BeforeEach
    void setUp() {
        userDto = new UserDto("Test",
                LocalDate.parse("2000-01-01"),
                "00000000000",
                "01001000");
    }

    @Test
    void createUser_Success() throws Exception {
        User user = new User();
        user.setUsername(userDto.username());
        user.setBirthDate(userDto.birthDate());
        user.setCpf(userDto.cpf());
        user.setAddress(new Address()); // Mocking the Address

        // Mocking the service call
        when(userService.save(any(UserDto.class))).thenReturn(user);

        mockMvc.perform(post("/api/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(status().isCreated()) // Verifying the status
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Verifying content type
                .andExpect(content().json(objectMapper.writeValueAsString(user))); // Verifying response body
    }
}