package galiano.engSoft.trab.Application.Rest.Controller;

import galiano.engSoft.trab.Application.Domain.Entity.ConcluidosEntity;
import galiano.engSoft.trab.Application.Service.ConcluidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concluidos")
@RequiredArgsConstructor
public class ConcluidoController {
    private final ConcluidoService concluidoService;

    @GetMapping
    public List<ConcluidosEntity> findAllConcluidos() {
        return concluidoService.findAllConcluidos();
    }

    @GetMapping("/{id}")
    public ConcluidosEntity findConcluidoById(@PathVariable Long id) {
        return concluidoService.findConcluidoById(id);
    }

    @PostMapping
    public void saveConcluido(@RequestBody ConcluidosEntity concluido) {
        concluidoService.saveConcluido(concluido);
    }

    @PutMapping("/{id}")
    public void updateConcluidoById(@PathVariable Long id, @RequestBody ConcluidosEntity concluido) {
        concluidoService.updateConcluidoById(id, concluido);
    }

    @DeleteMapping("/{id}")
    public void deleteConcluidoById(@PathVariable Long id) {
        concluidoService.deleteById(id);
    }
}
