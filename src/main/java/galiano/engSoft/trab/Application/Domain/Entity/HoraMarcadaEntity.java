package galiano.engSoft.trab.Application.Domain.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hora_marcada")
public class HoraMarcadaEntity {
    @Id
    private Long id;
    private Long clienteId;
    private String horaMarcada;
    private String diaMarcado;
    private Long valorId;
}
