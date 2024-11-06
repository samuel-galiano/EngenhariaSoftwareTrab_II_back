package galiano.engSoft.trab.Application.Domain.Repository;

import galiano.engSoft.trab.Application.Domain.Entity.CanceladosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanceladoRepository extends JpaRepository<CanceladosEntity, Long> {
}
