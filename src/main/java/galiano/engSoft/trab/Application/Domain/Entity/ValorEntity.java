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
@Table(name = "valores")
public class ValorEntity {
    @Id
    private Long id;
    private String procedimento;
    private Double valor;
    private String tempoMedia;
}