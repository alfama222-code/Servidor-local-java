package com.labanta.servidorlocal.Service;

import com.labanta.servidorlocal.Model.ServicoModel;
import com.labanta.servidorlocal.exception.ServicoNaoEncontradoExeption;
import com.labanta.servidorlocal.repository.ServicoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private  final ServicoRepository repositorio;

    private static final Logger log =
            LoggerFactory.getLogger(ServicoService.class);

    public ServicoService(ServicoRepository repositorio) {
        this.repositorio = repositorio;
    }




    // Guardar um serviço
    public ServicoModel save(ServicoModel servico) {
        return repositorio.save(servico);
    }

    // Pesquisar serviços pelo título
    public List<ServicoModel> pesquisarServicos(String termo) {
        return repositorio.findByTituloContainingIgnoreCase(termo);
    }

    // Aplicar desconto
    public List<ServicoModel> aplicarDescontoEmAtivos(Double percentagem) {
        return null;
    }

    // Listar serviços
    public  Page<ServicoModel> listarServicos(Pageable pageable) {
        return repositorio.findAll(pageable);
    }
    //criar servico
    public ServicoModel criarServico(ServicoModel servico) {
        return  repositorio.save(servico);
    }
    public ServicoModel buscarServicoPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ServicoNaoEncontradoExeption(
                        "O serviço com ID " + id + " não existe no catálogo."
                ));
    }
}