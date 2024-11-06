package galiano.engSoft.trab.Application.Rest.Controller;

import galiano.engSoft.trab.Application.Domain.Entity.ValorEntity;
import galiano.engSoft.trab.Application.Service.ValorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/valores")
@RequiredArgsConstructor
public class ValorController {
    private final ValorService valorService;

    @GetMapping
    public List<ValorEntity> findAllValores() {
        return valorService.findAllValores();
    }

    @GetMapping("/{id}")
    public ValorEntity findValorById(@PathVariable Long id) {
        return valorService.findValorById(id);
    }

    @PostMapping
    public void saveValor(@RequestBody ValorEntity valor) {
        valorService.saveValor(valor);
    }

    @PutMapping("/{id}")
    public void updateValorById(@PathVariable Long id, @RequestBody ValorEntity valor) {
        valorService.updateValorById(id, valor);
    }

    @DeleteMapping("/{id}")
    public void deleteValorById(@PathVariable Long id) {
        valorService.deleteById(id);
    }
}
