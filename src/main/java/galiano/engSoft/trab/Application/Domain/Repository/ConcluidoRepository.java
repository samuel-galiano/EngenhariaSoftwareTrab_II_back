package galiano.engSoft.trab.Application.Domain.Repository;

import galiano.engSoft.trab.Application.Domain.Entity.ConcluidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcluidoRepository extends JpaRepository<ConcluidosEntity, Long> {
}
