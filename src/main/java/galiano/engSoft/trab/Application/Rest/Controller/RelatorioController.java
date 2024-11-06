package galiano.engSoft.trab.Application.Rest.Controller;

import galiano.engSoft.trab.Application.Domain.Entity.RelatorioEntity;
import galiano.engSoft.trab.Application.Service.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
@RequiredArgsConstructor
public class RelatorioController {
    private final RelatorioService relatorioService;

    @GetMapping
    public List<RelatorioEntity> findAllRelatorios() {
        return relatorioService.findAllRelatorios();
    }

    @GetMapping("/{id}")
    public RelatorioEntity findRelatorioById(@PathVariable Long id) {
        return relatorioService.findRelatorioById(id);
    }

    @PostMapping
    public void saveRelatorio(@RequestBody RelatorioEntity relatorio) {
        relatorioService.saveRelatorio(relatorio);
    }

    @PutMapping("/{id}")
    public void updateRelatorioById(@PathVariable Long id, @RequestBody RelatorioEntity relatorio) {
        relatorioService.updateRelatorioById(id, relatorio);
    }

    @DeleteMapping("/{id}")
    public void deleteRelatorioById(@PathVariable Long id) {
        relatorioService.deleteById(id);
    }
}
