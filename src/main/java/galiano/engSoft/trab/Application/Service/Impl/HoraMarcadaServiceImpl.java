package galiano.engSoft.trab.Application.Service.Impl;

import galiano.engSoft.trab.Application.Domain.Entity.HoraMarcadaEntity;
import galiano.engSoft.trab.Application.Domain.Repository.HoraMarcadaRepository;
import galiano.engSoft.trab.Application.Service.HoraMarcadaService;
import galiano.engSoft.trab.Application.Service.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HoraMarcadaServiceImpl implements HoraMarcadaService {
    private final HoraMarcadaRepository horaMarcadaRepository;
    private final UtilsService utilsService;

    @Override
    public List<HoraMarcadaEntity> findAllHorasMarcadas() {
        return horaMarcadaRepository.findAll();
    }

    @Override
    public void saveHoraMarcada(HoraMarcadaEntity horaMarcada) {
        horaMarcadaRepository.save(horaMarcada);
    }

    @Override
    public HoraMarcadaEntity findHoraMarcadaById(Long id) {
        return horaMarcadaRepository.findById(id).orElse(null);
    }

    @Override
    public void updateHoraMarcadaById(Long id, HoraMarcadaEntity horaMarcada) {
        HoraMarcadaEntity horaMarcadaEncontrada = horaMarcadaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hora marcada não encontrada"));
        horaMarcadaEncontrada.setClienteId(horaMarcada.getClienteId());
        horaMarcadaEncontrada.setHoraMarcada(horaMarcada.getHoraMarcada());
        horaMarcadaEncontrada.setDiaMarcado(horaMarcada.getDiaMarcado());
        horaMarcadaEncontrada.setValorId(horaMarcada.getValorId());

        horaMarcadaRepository.save(horaMarcadaEncontrada);
    }

    @Override
    public void deleteById(Long id) {
        horaMarcadaRepository.deleteById(id);
    }
}
