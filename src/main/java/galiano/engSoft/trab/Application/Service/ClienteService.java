package galiano.engSoft.trab.Application.Service;

import galiano.engSoft.trab.Application.Domain.Entity.ClienteEntity;
import galiano.engSoft.trab.Application.Rest.DTOs.ClienteDTO;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> findAllClientes();

    void saveCliente(ClienteEntity cliente);

    ClienteDTO findClienteById(Long id);

    void updateClienteById(Long id, ClienteEntity cliente);

    void deleteById(Long id);
}
