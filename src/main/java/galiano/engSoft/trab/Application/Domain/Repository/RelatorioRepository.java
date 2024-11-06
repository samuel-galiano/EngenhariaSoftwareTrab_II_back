package galiano.engSoft.trab.Application.Domain.Repository;

import galiano.engSoft.trab.Application.Domain.Entity.RelatorioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatorioRepository extends JpaRepository<RelatorioEntity, Long> {
}
