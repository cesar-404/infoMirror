package br.com.infomirror.service;

import br.com.infomirror.model.AddressDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ViaCepService {

    private final WebClient webClient;

    public ViaCepService(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }

    public AddressDto getAddress(String cep) {
        return webClient
                .get()
                .uri("viacep.com.br/ws/"+cep+"/json/")
                .retrieve()
                .bodyToMono(AddressDto.class)
                .block();
    }
}
