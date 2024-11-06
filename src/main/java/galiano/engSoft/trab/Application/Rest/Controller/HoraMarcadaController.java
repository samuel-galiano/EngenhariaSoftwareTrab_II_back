package galiano.engSoft.trab.Application.Rest.Controller;

import galiano.engSoft.trab.Application.Domain.Entity.HoraMarcadaEntity;
import galiano.engSoft.trab.Application.Service.HoraMarcadaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horasMarcadas")
@RequiredArgsConstructor
public class HoraMarcadaController {
    private final HoraMarcadaService horaMarcadaService;

    @GetMapping
    public List<HoraMarcadaEntity> findAllHorasMarcadas() {
        return horaMarcadaService.findAllHorasMarcadas();
    }

    @GetMapping("/{id}")
    public HoraMarcadaEntity findHoraMarcadaById(@PathVariable Long id) {
        return horaMarcadaService.findHoraMarcadaById(id);
    }

    @PostMapping
    public void saveHoraMarcada(@RequestBody HoraMarcadaEntity horaMarcada) {
        horaMarcadaService.saveHoraMarcada(horaMarcada);
    }

    @PutMapping("/{id}")
    public void updateHoraMarcadaById(@PathVariable Long id, @RequestBody HoraMarcadaEntity horaMarcada) {
        horaMarcadaService.updateHoraMarcadaById(id, horaMarcada);
    }

    @DeleteMapping("/{id}")
    public void deleteHoraMarcadaById(@PathVariable Long id) {
        horaMarcadaService.deleteById(id);
    }
}
