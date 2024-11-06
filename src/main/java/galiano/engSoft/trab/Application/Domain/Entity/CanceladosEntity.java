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
@Table(name = "cancelados")
public class CanceladosEntity {
    @Id
    private Long id;
    private Long clienteId;
    private String data;
    private String motivo;
}
