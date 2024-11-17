package galiano.engSoft.trab.Application.Service.Impl;

import galiano.engSoft.trab.Application.Domain.Entity.RelatorioEntity;
import galiano.engSoft.trab.Application.Domain.Repository.RelatorioRepository;
import galiano.engSoft.trab.Application.Service.RelatorioService;
import galiano.engSoft.trab.Application.Service.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RelatorioServiceImpl implements RelatorioService {
    private final RelatorioRepository relatorioRepository;
    private final UtilsService utilsService;

    @Override
    public List<RelatorioEntity> findAllRelatorios() {
        return relatorioRepository.findAll();
    }

    @Override
    public void saveRelatorio(RelatorioEntity relatorio) {
        relatorioRepository.save(relatorio);
    }

    @Override
    public RelatorioEntity findRelatorioById(Long id) {
        return relatorioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id relatorio nao encontrado"));
    }

    @Override
    public void updateRelatorioById(Long id, RelatorioEntity relatorio) {
        RelatorioEntity relatorioEncontrado = relatorioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Relatório não encontrado"));
        relatorioEncontrado.setId(relatorio.getId());
        relatorioEncontrado.setDataRelatorio(relatorio.getDataRelatorio());
        relatorioEncontrado.setProcedimentosCancelados(relatorio.getProcedimentosCancelados());
        relatorioEncontrado.setProcedimentosConcluidos(relatorio.getProcedimentosConcluidos());

        relatorioRepository.save(relatorioEncontrado);
    }

    @Override
    public void deleteById(Long id) {
        relatorioRepository.deleteById(id);
    }
}
