package com.labanta.servidorlocal.controllers;

import com.labanta.servidorlocal.DTO.GeoLocationResponse;
import com.labanta.servidorlocal.DTO.LoginRequestDTO;
import com.labanta.servidorlocal.DTO.RegistroRequestDTO;
import com.labanta.servidorlocal.Model.Utilizador;
import com.labanta.servidorlocal.Service.AuthService;
import com.labanta.servidorlocal.Service.EmailService;
import com.labanta.servidorlocal.Service.GeoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final GeoService geoService;
    private final EmailService emailService;

    public AuthController(AuthService authService,
                          GeoService geoService,
                          EmailService emailService
    ) {
        this.authService = authService;
        this.geoService = geoService;
        this.emailService = emailService;
    }
    //registrar servicos
    @Operation(
              summary =  "registrar todos os servicos",
                description = "Rota para registrar todos os servicos")

    @PostMapping("/registar")
    public ResponseEntity<?> registar(
            @RequestBody RegistroRequestDTO dados) {

        authService.registarUtilizador(dados);

        return ResponseEntity.ok("utilizador registrado com sucesso");
    }

    // efetuar login
    @Operation(
            summary = "fazer login",
            description = "rota para fazer login")
    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequestDTO dados,
            HttpServletRequest request
    ) {

        String token = authService.login(dados);

        return ResponseEntity.ok(token);
    }

    //alerta-login
    @Operation(
            summary = "alerta de segurança",
            description = " rota de alerta de segurança ao fazer login"
    )
    @PostMapping("/alerta-login")
    public ResponseEntity<?> AlertaLogin(
            @RequestParam String email,
            HttpServletRequest request
    ) {

        try {

            // IP do utilizador
            String ip = request.getRemoteAddr();

            System.out.println("IP recebido: " + ip);

            // Localizar IP
            GeoLocationResponse localizacao =
                    geoService.LocalizarIp(ip);

            if (localizacao != null) {

                String cidade = localizacao.getCity();
                String pais = localizacao.getCountry_name();

                System.out.println("Cidade: " + cidade);
                System.out.println("País: " + pais);

                // Enviar email
                emailService.enviarAlertaSegurança(
                        email,
                        cidade,
                        pais
                );
                return ResponseEntity.ok(
                        "Alerta de segurança enviado com sucesso!"
                );
            }
            return ResponseEntity.ok(
                    "Não foi possível localizar o IP."
            );
        } catch (Exception e) {

            return ResponseEntity.internalServerError().body(
                    "Erro ao processar alerta de login: "
                            + e.getMessage()
            );
        }
    }
}

