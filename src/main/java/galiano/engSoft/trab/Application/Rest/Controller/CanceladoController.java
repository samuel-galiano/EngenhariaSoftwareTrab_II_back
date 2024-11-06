package galiano.engSoft.trab.Application.Rest.Controller;

import galiano.engSoft.trab.Application.Domain.Entity.CanceladosEntity;
import galiano.engSoft.trab.Application.Service.CanceladoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cancelados")
@RequiredArgsConstructor
public class CanceladoController {
    private final CanceladoService canceladoService;

    @GetMapping
    public List<CanceladosEntity> findAllCancelados() {
        return canceladoService.findAllCancelados();
    }

    @GetMapping("/{id}")
    public CanceladosEntity findCanceladoById(@PathVariable Long id) {
        return canceladoService.findCanceladoById(id);
    }

    @PostMapping
    public void saveCancelado(@RequestBody CanceladosEntity cancelado) {
        canceladoService.saveCancelado(cancelado);
    }

    @PutMapping("/{id}")
    public void updateCanceladoById(@PathVariable Long id, @RequestBody CanceladosEntity cancelado) {
        canceladoService.updateCanceladoById(id, cancelado);
    }

    @DeleteMapping("/{id}")
    public void deleteCanceladoById(@PathVariable Long id) {
        canceladoService.deleteById(id);
    }
}
