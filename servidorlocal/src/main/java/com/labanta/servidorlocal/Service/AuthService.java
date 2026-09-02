package com.labanta.servidorlocal.Service;

import com.labanta.servidorlocal.DTO.LoginRequestDTO;
import com.labanta.servidorlocal.DTO.RegistroRequestDTO;
import com.labanta.servidorlocal.Model.Utilizador;
import com.labanta.servidorlocal.repository.UtilizadorRepository;
import com.labanta.servidorlocal.security.JwtService;
import com.labanta.servidorlocal.exception.UtilizadorExistenteException;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final UtilizadorRepository utilizadorRepository;
    private final JwtService jwtService;
    private  final EmailService emailService;

    public AuthService(
            UtilizadorRepository utilizadorRepository,
            JwtService jwtService,
            EmailService emailService
    ) {
        this.utilizadorRepository = utilizadorRepository;
        this.jwtService = jwtService;
        this.emailService = emailService;
    }

    // REGISTAR UTILIZADOR
    public Utilizador registarUtilizador(RegistroRequestDTO dados) {

        // Verificar se o username já existe
        utilizadorRepository.findByUsername(dados.getUsername())
                .ifPresent(utilizador -> {
                    throw new UtilizadorExistenteException(
                            "Este username já está em uso, por favor escolha outro."
                    );
                });

        // Criar novo utilizador
        Utilizador utilizador = new Utilizador();

        utilizador.setUsername(dados.getUsername());
        utilizador.setPassword(dados.getPassword());
        utilizador.setEmail(dados.getEmail());


        emailService.enviarEmailBoasVindas(utilizador.getEmail(),utilizador.getUsername());
        return utilizadorRepository.save(utilizador);
    }

    // LOGIN
    public String login(LoginRequestDTO dados) {

        Utilizador utilizador = utilizadorRepository
                .findByUsername(dados.getUsername())
                .orElseThrow(() ->
                        new RuntimeException("Utilizador não encontrado"));

        if (!utilizador.getPassword().equals(dados.getPassword())) {
            throw new RuntimeException("Password incorreta");
        }

        return jwtService.gerarToken(utilizador.getUsername());
    }
}
