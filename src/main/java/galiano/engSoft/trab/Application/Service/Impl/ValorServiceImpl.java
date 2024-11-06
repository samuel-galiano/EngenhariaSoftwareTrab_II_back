package galiano.engSoft.trab.Application.Service.Impl;

import galiano.engSoft.trab.Application.Domain.Entity.ValorEntity;
import galiano.engSoft.trab.Application.Domain.Repository.ValorRepository;
import galiano.engSoft.trab.Application.Service.ValorService;
import galiano.engSoft.trab.Application.Service.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ValorServiceImpl implements ValorService {
    private final ValorRepository valorRepository;
    private final UtilsService utilsService;

    @Override
    public List<ValorEntity> findAllValores() {
        return valorRepository.findAll();
    }

    @Override
    public void saveValor(ValorEntity valor) {
        valorRepository.save(valor);
    }

    @Override
    public ValorEntity findValorById(Long id) {
        return valorRepository.findById(id).orElse(null);
    }

    @Override
    public void updateValorById(Long id, ValorEntity valor) {
        ValorEntity valorEncontrado = valorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Valor não encontrado"));
        valorEncontrado.setProcedimento(valor.getProcedimento());
        valorEncontrado.setValor(valor.getValor());
        valorEncontrado.setTempoMedia(valor.getTempoMedia());

        valorRepository.save(valorEncontrado);
    }

    @Override
    public void deleteById(Long id) {
        valorRepository.deleteById(id);
    }
}
