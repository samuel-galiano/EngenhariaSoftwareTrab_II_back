package galiano.engSoft.trab.Application.Rest.DTOs;

import galiano.engSoft.trab.Application.Domain.Entity.ClienteEntity;
import galiano.engSoft.trab.Application.Service.ClienteService;
import galiano.engSoft.trab.Application.Service.Impl.UtilsServiceImpl;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {
    public Long id;
    public String nome;
    public String telefone;
    public String statusString;

    public ClienteDTO(ClienteEntity cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        if(cliente.getStatus_id() == 1) this.statusString =  "Ativo";
        if(cliente.getStatus_id() == 2) this.statusString = "Cancelado";
        if(cliente.getStatus_id() == 3) this.statusString = "Em Análise";
    }
}
