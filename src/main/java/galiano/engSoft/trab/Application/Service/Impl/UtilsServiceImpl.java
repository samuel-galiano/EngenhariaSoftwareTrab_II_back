package galiano.engSoft.trab.Application.Service.Impl;

import galiano.engSoft.trab.Application.Domain.Entity.ClienteEntity;
import galiano.engSoft.trab.Application.Domain.Repository.ClienteRespository;
import galiano.engSoft.trab.Application.Domain.Repository.HoraMarcadaRepository;
import galiano.engSoft.trab.Application.Domain.Repository.ValorRepository;
import galiano.engSoft.trab.Application.Rest.DTOs.HoraMarcadaDTO;
import galiano.engSoft.trab.Application.Service.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UtilsServiceImpl implements UtilsService {

    private final HoraMarcadaRepository horaMarcadaRepository;
    private final ValorRepository valorRepository;
    private final ClienteRespository clienteRespository;

    @Override
    public String takeNumberAndReturnStatusString(Long statusID) {
        if(statusID == 1) return "Ativo";
        if(statusID == 2) return "Cancelado";
        if(statusID == 3) return "Em Análise";
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error ocurred on convert cliente.status_id to string; UtilsServiceImpl[13 - 16 line]");
    }


}
