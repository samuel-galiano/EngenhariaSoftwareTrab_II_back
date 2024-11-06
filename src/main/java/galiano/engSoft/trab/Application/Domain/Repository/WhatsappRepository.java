package galiano.engSoft.trab.Application.Domain.Repository;

import galiano.engSoft.trab.Application.Domain.Entity.WhatsappEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhatsappRepository extends JpaRepository<WhatsappEntity, Long> {
}
