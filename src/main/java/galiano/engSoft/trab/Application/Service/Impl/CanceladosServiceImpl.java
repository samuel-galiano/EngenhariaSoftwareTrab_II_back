package galiano.engSoft.trab.Application.Service.Impl;

import galiano.engSoft.trab.Application.Domain.Entity.CanceladosEntity;
import galiano.engSoft.trab.Application.Domain.Repository.CanceladoRepository;
import galiano.engSoft.trab.Application.Service.CanceladoService;
import galiano.engSoft.trab.Application.Service.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CanceladosServiceImpl implements CanceladoService {
    private final CanceladoRepository canceladoRepository;
    private final UtilsService utilsService;

    @Override
    public List<CanceladosEntity> findAllCancelados() {
        return canceladoRepository.findAll();
    }

    @Override
    public void saveCancelado(CanceladosEntity cancelado) {
        canceladoRepository.save(cancelado);
    }

    @Override
    public CanceladosEntity findCanceladoById(Long id) {
        return canceladoRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCanceladoById(Long id, CanceladosEntity cancelado) {
        CanceladosEntity canceladoEncontrado = canceladoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cancelamento não encontrado"));
        canceladoEncontrado.setClienteId(cancelado.getClienteId());
        canceladoEncontrado.setData_cancelamento(cancelado.getData_cancelamento());
        canceladoEncontrado.setMotivo(cancelado.getMotivo());

        canceladoRepository.save(canceladoEncontrado);
    }

    @Override
    public void deleteById(Long id) {
        canceladoRepository.deleteById(id);
    }
}
