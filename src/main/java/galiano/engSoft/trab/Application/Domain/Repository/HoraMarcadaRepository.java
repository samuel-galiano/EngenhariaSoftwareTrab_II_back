package galiano.engSoft.trab.Application.Domain.Repository;

import galiano.engSoft.trab.Application.Domain.Entity.HoraMarcadaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoraMarcadaRepository extends JpaRepository<HoraMarcadaEntity, Long> {
}
