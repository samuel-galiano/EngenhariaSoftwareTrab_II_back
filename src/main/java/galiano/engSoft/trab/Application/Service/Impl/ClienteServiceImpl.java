package galiano.engSoft.trab.Application.Service.Impl;

import galiano.engSoft.trab.Application.Domain.Entity.ClienteEntity;
import galiano.engSoft.trab.Application.Domain.Repository.ClienteRespository;
import galiano.engSoft.trab.Application.Rest.DTOs.ClienteDTO;
import galiano.engSoft.trab.Application.Service.ClienteService;
import galiano.engSoft.trab.Application.Service.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRespository clienteRespository;
    private final UtilsService utilsService;

    @Override
    public List<ClienteDTO> findAllClientes() {
        return clienteRespository.findAll().stream().map(
                c -> ClienteDTO
                        .builder()
                        .id(c.getId())
                        .nome(c.getNome())
                        .telefone(c.getTelefone())
                        .statusString(utilsService.takeNumberAndReturnStatusString(c.getStatus_id()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void saveCliente(ClienteEntity cliente) {
        clienteRespository.save(cliente);
    }

    @Override
    public ClienteDTO findClienteById(Long id) {
        return new ClienteDTO(clienteRespository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found User")));
    }

    @Override
    public void updateClienteById(Long id, ClienteEntity cliente) {
        ClienteEntity clienteEncontrado = clienteRespository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nao foi encontrado nnenhum usuario com essa ID"));
        clienteEncontrado.setNome(cliente.getNome());
        clienteEncontrado.setId(id);
        clienteEncontrado.setTelefone(cliente.getTelefone());
        clienteEncontrado.setStatus_id(cliente.getStatus_id());

        clienteRespository.save(clienteEncontrado);
    }

    @Override
    public void deleteById(Long id) {
        clienteRespository.deleteById(id);
    }
}
