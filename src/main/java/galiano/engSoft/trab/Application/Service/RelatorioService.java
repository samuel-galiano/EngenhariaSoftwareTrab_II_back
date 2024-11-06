package galiano.engSoft.trab.Application.Service;

import galiano.engSoft.trab.Application.Domain.Entity.RelatorioEntity;

import java.util.List;

public interface RelatorioService {
    List<RelatorioEntity> findAllRelatorios();

    void saveRelatorio(RelatorioEntity relatorio);

    RelatorioEntity findRelatorioById(Long id);

    void updateRelatorioById(Long id, RelatorioEntity relatorio);

    void deleteById(Long id);
}
