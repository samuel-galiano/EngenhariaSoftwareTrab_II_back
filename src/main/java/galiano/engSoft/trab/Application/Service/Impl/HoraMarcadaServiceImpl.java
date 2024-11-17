package galiano.engSoft.trab.Application.Service.Impl;

import galiano.engSoft.trab.Application.Domain.Entity.HoraMarcadaEntity;
import galiano.engSoft.trab.Application.Domain.Entity.RelatorioEntity;
import galiano.engSoft.trab.Application.Domain.Repository.ClienteRespository;
import galiano.engSoft.trab.Application.Domain.Repository.HoraMarcadaRepository;
import galiano.engSoft.trab.Application.Domain.Repository.RelatorioRepository;
import galiano.engSoft.trab.Application.Domain.Repository.ValorRepository;
import galiano.engSoft.trab.Application.Rest.DTOs.HoraMarcadaDTO;
import galiano.engSoft.trab.Application.Service.HoraMarcadaService;
import galiano.engSoft.trab.Application.Service.RelatorioService;
import galiano.engSoft.trab.Application.Service.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HoraMarcadaServiceImpl implements HoraMarcadaService {
    private final HoraMarcadaRepository horaMarcadaRepository;
    private final ValorRepository valorRepository;
    private final ClienteRespository clienteRespository;
    private final RelatorioRepository relatorioRepository;
    private final UtilsService utilsService;

    @Override
    public List<HoraMarcadaDTO> findAllHorasMarcadas() {
        return horaMarcadaRepository.findAll()
                .stream()
                .map(hr -> HoraMarcadaDTO
                        .builder()
                        .id(hr.getId())
                        .valor(valorRepository.findById(hr.getValorId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "valor id nao encontrado")))
                        .cliente(clienteRespository.findById(hr.getClienteId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cliente id nao encontrado")))
                        .diaMarcado(hr.getDiaMarcado())
                        .horaMarcada(hr.getHoraMarcada())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void saveHoraMarcada(HoraMarcadaEntity horaMarcada) {
        horaMarcadaRepository.save(horaMarcada);
    }

    @Override
    public HoraMarcadaEntity findHoraMarcadaById(Long id) {
        return horaMarcadaRepository.findById(id).orElse(null);
    }

    @Override
    public void updateHoraMarcadaById(Long id, HoraMarcadaEntity horaMarcada) {
        HoraMarcadaEntity horaMarcadaEncontrada = horaMarcadaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hora marcada não encontrada"));
        horaMarcadaEncontrada.setClienteId(horaMarcada.getClienteId());
        horaMarcadaEncontrada.setHoraMarcada(horaMarcada.getHoraMarcada());
        horaMarcadaEncontrada.setDiaMarcado(horaMarcada.getDiaMarcado());
        horaMarcadaEncontrada.setValorId(horaMarcada.getValorId());

        horaMarcadaRepository.save(horaMarcadaEncontrada);
    }

    @Override
    public void deleteById(Long id) {
        RelatorioEntity relatorio = relatorioRepository.findById(1L).orElseThrow(null);
        relatorio.setProcedimentosCancelados(relatorio.getProcedimentosCancelados() + 1);
        relatorioRepository.save(relatorio);
        horaMarcadaRepository.deleteById(id);
    }
}
