package br.com.infomirror.service;

import br.com.infomirror.model.AddressDto;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.*;

class ViaCepServiceTest {

    private MockWebServer mockWebServer;
    private ViaCepService service;

    @BeforeEach
    void setUp() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        WebClient.Builder webClientBuilder = WebClient.builder()
                .baseUrl(mockWebServer.url("/").toString());
        service = new ViaCepService(webClientBuilder);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockWebServer.shutdown();
    }

    @Test
    void getAddressSuccess() {
        String mockResponseBody = """
                {
                    "cep": "01001-000",
                    "logradouro": "Praça da Sé",
                    "bairro": "Sé",
                    "localidade": "São Paulo",
                    "uf": "SP",
                    "estado": "São Paulo"
                }
                """;
        mockWebServer.enqueue(new MockResponse()
                .setBody(mockResponseBody)
                .addHeader("Content-Type", "application/json"));

        AddressDto addressDto = service.getAddress("01001000");

        assertAll("Should match",
                () -> assertEquals("01001-000", addressDto.cep()),
                () -> assertEquals("Praça da Sé", addressDto.logradouro()),
                () -> assertEquals("Sé", addressDto.bairro()),
                () -> assertEquals("São Paulo", addressDto.localidade()),
                () -> assertEquals("SP", addressDto.uf()),
                () -> assertEquals("São Paulo", addressDto.estado()));
    }

}