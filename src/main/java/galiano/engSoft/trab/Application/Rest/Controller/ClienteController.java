package galiano.engSoft.trab.Application.Rest.Controller;

import galiano.engSoft.trab.Application.Domain.Entity.ClienteEntity;
import galiano.engSoft.trab.Application.Domain.Repository.ClienteRespository;
import galiano.engSoft.trab.Application.Rest.DTOs.ClienteDTO;
import galiano.engSoft.trab.Application.Service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> findAllClientes() {
        return clienteService.findAllClientes();
    }

    @GetMapping("/{id}")
    public ClienteDTO findClienteById(@PathVariable Long id) {
        return clienteService.findClienteById(id);
    }

    @PostMapping
    public void saveCliente(@RequestBody ClienteEntity cliente) {
        clienteService.saveCliente(cliente);
    }

    @PutMapping("/{id}")
    public void updateClienteById(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
        clienteService.updateClienteById(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteClienteById(@PathVariable Long id) {
        clienteService.deleteById(id);
    }
}
