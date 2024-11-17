package galiano.engSoft.trab.Application.Rest.Controller;

import galiano.engSoft.trab.Application.Domain.Entity.HoraMarcadaEntity;
import galiano.engSoft.trab.Application.Domain.Entity.RelatorioEntity;
import galiano.engSoft.trab.Application.Domain.Repository.HoraMarcadaRepository;
import galiano.engSoft.trab.Application.Domain.Repository.RelatorioRepository;
import galiano.engSoft.trab.Application.Rest.DTOs.HoraMarcadaDTO;
import galiano.engSoft.trab.Application.Service.HoraMarcadaService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horasMarcadas")
@RequiredArgsConstructor
public class HoraMarcadaController {
    private final HoraMarcadaService horaMarcadaService;
    private final RelatorioRepository relatorioRepository;
    private final HoraMarcadaRepository horaMarcadaRepository;

    @GetMapping
    public List<HoraMarcadaDTO> findAllHorasMarcadas() {
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

    @PutMapping("/conclui/{id}")
    public void concluiServico(@PathVariable Long id) {
        RelatorioEntity relatorio = relatorioRepository.findById(1L).orElseThrow(null);
        relatorio.setProcedimentosConcluidos(relatorio.getProcedimentosConcluidos() + 1);

        horaMarcadaRepository.deleteById(id);
        relatorioRepository.save(relatorio);
    }
}
