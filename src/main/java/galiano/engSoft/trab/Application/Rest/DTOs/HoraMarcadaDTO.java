package galiano.engSoft.trab.Application.Rest.DTOs;

import galiano.engSoft.trab.Application.Domain.Entity.ClienteEntity;
import galiano.engSoft.trab.Application.Domain.Entity.HoraMarcadaEntity;
import galiano.engSoft.trab.Application.Domain.Entity.ValorEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HoraMarcadaDTO {
    public Long id;
    public ClienteEntity cliente;
    public String horaMarcada;
    public String diaMarcado;
    public ValorEntity valor;
}
