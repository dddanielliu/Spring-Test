package com.example.springtest.catfact;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.springtest.Query;

@Service
public class CatFactService implements Query<Integer, CatFactDTO>{

    private final RestTemplate restTemplate;
    private final String url = "https://contact.ninja/fact";
    private String MAX_LENGTH = "max_length";

    public CatFactService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<CatFactDTO> execute(Integer input) {
        URI uri = UriComponentsBuilder
            .fromUriString(url)
            .queryParam(MAX_LENGTH, input)
            .build()
            .toUri();

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<CatFactResponse> response = restTemplate.exchange(uri, HttpMethod.GET, entity, CatFactResponse.class);
            CatFactDTO catFactDTO = new CatFactDTO(response.getBody().getFact());
            return ResponseEntity.ok(catFactDTO);

            // CatFactResponse response = restTemplate.getForObject("https://contact.ninja/fact?max_length=" + input, CatFactResponse.class);
            // CatFactDTO catFactDTO = new CatFactDTO(response.getFact());
            // return ResponseEntity.ok(catFactDTO);
        } catch (Exception e) {
            throw new RuntimeException("Cat Facts API is down");
        }

    }

}
