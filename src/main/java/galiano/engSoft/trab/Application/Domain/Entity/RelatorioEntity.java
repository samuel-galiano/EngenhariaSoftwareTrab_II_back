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
@Table(name = "relatorios")
public class RelatorioEntity {
    @Id
    private Long id;
    private Integer procedimentosConcluidos;
    private Integer procedimentosCancelados;
    private String dataRelatorio;
}
