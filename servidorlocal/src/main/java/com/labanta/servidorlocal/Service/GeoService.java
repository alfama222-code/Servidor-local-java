package com.labanta.servidorlocal.Service;

import com.labanta.servidorlocal.DTO.GeoLocationResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoService {

    private final RestTemplate restTemplate = new RestTemplate();

    public GeoLocationResponse LocalizarIp(String ip) {

        String url = "https://ipapi.co/" + ip + "/json/";

        try {

            return restTemplate.getForObject(
                    url,
                    GeoLocationResponse.class
            );

        } catch (HttpClientErrorException.TooManyRequests e) {

            System.out.println("⚠️ IPAPI: Limite de pedidos atingido.");

            return new GeoLocationResponse(
                    "Desconhecida",
                    "Desconhecido"
            );

        } catch (Exception e) {

            System.out.println("❌ Erro ao localizar IP: " + e.getMessage());

            return new GeoLocationResponse(
                    "Desconhecida",
                    "Desconhecido"
            );
        }
    }
}