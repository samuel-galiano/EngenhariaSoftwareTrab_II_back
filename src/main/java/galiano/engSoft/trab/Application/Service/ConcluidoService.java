package galiano.engSoft.trab.Application.Service;

import galiano.engSoft.trab.Application.Domain.Entity.ConcluidosEntity;

import java.util.List;

public interface ConcluidoService {
    List<ConcluidosEntity> findAllConcluidos();

    void saveConcluido(ConcluidosEntity concluido);

    ConcluidosEntity findConcluidoById(Long id);

    void updateConcluidoById(Long id, ConcluidosEntity concluido);

    void deleteById(Long id);
}
