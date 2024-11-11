package galiano.engSoft.trab.Application.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "whatsapp")
public class WhatsappEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagemEnviada;
    private String horaDaMensagem;
    private Long clienteEnviada;
}
