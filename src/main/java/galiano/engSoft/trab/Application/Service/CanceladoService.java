package galiano.engSoft.trab.Application.Service;

import galiano.engSoft.trab.Application.Domain.Entity.CanceladosEntity;

import java.util.List;

public interface CanceladoService {
    List<CanceladosEntity> findAllCancelados();

    void saveCancelado(CanceladosEntity cancelado);

    CanceladosEntity findCanceladoById(Long id);

    void updateCanceladoById(Long id, CanceladosEntity cancelado);

    void deleteById(Long id);
}
