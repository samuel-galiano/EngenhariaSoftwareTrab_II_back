package galiano.engSoft.trab.Application.Service;

import galiano.engSoft.trab.Application.Domain.Entity.HoraMarcadaEntity;
import galiano.engSoft.trab.Application.Rest.DTOs.HoraMarcadaDTO;

import java.util.List;

public interface HoraMarcadaService {
    List<HoraMarcadaDTO> findAllHorasMarcadas();

    void saveHoraMarcada(HoraMarcadaEntity horaMarcada);

    HoraMarcadaEntity findHoraMarcadaById(Long id);

    void updateHoraMarcadaById(Long id, HoraMarcadaEntity horaMarcada);

    void deleteById(Long id);
}
