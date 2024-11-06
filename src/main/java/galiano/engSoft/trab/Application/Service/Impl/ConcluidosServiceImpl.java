package galiano.engSoft.trab.Application.Service.Impl;

import galiano.engSoft.trab.Application.Domain.Entity.ConcluidosEntity;
import galiano.engSoft.trab.Application.Domain.Repository.ConcluidoRepository;
import galiano.engSoft.trab.Application.Service.ConcluidoService;
import galiano.engSoft.trab.Application.Service.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConcluidosServiceImpl implements ConcluidoService {
    private final ConcluidoRepository concluidoRepository;
    private final UtilsService utilsService;

    @Override
    public List<ConcluidosEntity> findAllConcluidos() {
        return concluidoRepository.findAll();
    }

    @Override
    public void saveConcluido(ConcluidosEntity concluido) {
        concluidoRepository.save(concluido);
    }

    @Override
    public ConcluidosEntity findConcluidoById(Long id) {
        return concluidoRepository.findById(id).orElse(null);
    }

    @Override
    public void updateConcluidoById(Long id, ConcluidosEntity concluido) {
        ConcluidosEntity concluidoEncontrado = concluidoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Concluído não encontrado"));
        concluidoEncontrado.setClienteId(concluido.getClienteId());
        concluidoEncontrado.setAvaliacao(concluido.getAvaliacao());
        concluidoEncontrado.setValorPago(concluido.getValorPago());
        concluidoEncontrado.setData(concluido.getData());

        concluidoRepository.save(concluidoEncontrado);
    }

    @Override
    public void deleteById(Long id) {
        concluidoRepository.deleteById(id);
    }
}
