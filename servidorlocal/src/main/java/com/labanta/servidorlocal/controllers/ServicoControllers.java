package com.labanta.servidorlocal.controllers;

import com.labanta.servidorlocal.Model.ServicoModel;
import com.labanta.servidorlocal.Service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/servicos")

public class ServicoControllers {
    private final ServicoService servicoService;
    private final ExchangeService exchangeService;
    private final EmailService emailService;
    private final FileStorageService fileStorageService;


    public ServicoControllers(ServicoService servicoService ,ExchangeService exchangeService,EmailService emailService  ,FileStorageService fileStorageService) {
        this.servicoService = servicoService;
        this.emailService = emailService;
        this.exchangeService = exchangeService;
        this.fileStorageService = fileStorageService;
    }

    // Listar todos os serviços
    @Operation(
            summary = "listar todos os servicos ",
            description = "Rota para listar todos os servicos existentes na plataforma"
    )
    @GetMapping
    public Page<ServicoModel> listarServicos(
            @PageableDefault(page = 0,
                    size = 10,
                    sort = "id",
                    direction = Sort.Direction.DESC
            )

            Pageable pageable ) {

        return servicoService.listarServicos(pageable);
    }

    // Pesquisar serviços pelo título
    @Operation(
        summary = "Pesquisar todos so servicos",
        description = "Rota para pesquisar todos os servicos"
    )
    @GetMapping("/pesquisa")
    public List<ServicoModel> pesquisarServicos(@RequestParam String termo) {
        return servicoService.pesquisarServicos(termo);
    }

     //criar servico
     @Operation(
             summary = "criar um novo servico",
             description = " Rota para criar um novo servico"
     )
    @SecurityRequirement(name = "BearerAuth")
    @PostMapping
    public ServicoModel criarServico(
            @RequestBody ServicoModel servico) {

        return servicoService.criarServico(servico);
    }

    // buscar orcamento por id
    @Operation(
            summary = "pedir orcamento  por id",
            description = "Rota para pedir  orcamento por id"
    )
    @SecurityRequirement(name ="BearerAuth")
    @PostMapping("/{id}/orcamento")
    public String pedirOrcamento(
            @PathVariable Long id,
            @RequestParam String emailDestino,
            @RequestParam(defaultValue = "CVE") String moeda) {

        // 1. Ir à Base de Dados buscar o Serviço
        ServicoModel servico = servicoService.buscarServicoPorId(id);

        // 2. Ir à Internet converter o preço (Aula 16)
        Double precoConvertido = exchangeService.converterPreco(servico.getPreco(), moeda);

        // 3. Enviar o resultado para o Gmail do cliente (Aula 15)
        emailService.enviarOrcamentoPorEmail(emailDestino, servico.getTitulo(), precoConvertido, moeda);

        return "Orçamento calculado e enviado com sucesso para " + emailDestino + "!";
    }

    @Operation(
            summary = "Carregar capa de servico",
            description = "rota para caregar capas de servico com base no id "

    )

    @SecurityRequirement(name = "BearerAuth")
    @PostMapping(value = "/{id}/imagens",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file,
            @PathVariable Long id
    ) {
        ServicoModel servico = servicoService.buscarServicoPorId(id);
        String fileUpload = fileStorageService.storeImage(file);
        servico.setImagemCapa(fileUpload);
        servicoService.criarServico(servico);

        return ResponseEntity.ok("fecheiro Carregado com sucesso:" + fileUpload);
    }
}




