package galiano.engSoft.trab.Application.Service;

import galiano.engSoft.trab.Application.Domain.Entity.ValorEntity;

import java.util.List;

public interface ValorService {
    List<ValorEntity> findAllValores();

    void saveValor(ValorEntity valor);

    ValorEntity findValorById(Long id);

    void updateValorById(Long id, ValorEntity valor);

    void deleteById(Long id);
}
