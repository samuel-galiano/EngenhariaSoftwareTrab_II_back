package galiano.engSoft.trab.Application.Service.Impl;

import galiano.engSoft.trab.Application.Service.UtilsService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UtilsServiceImpl implements UtilsService {

    @Override
    public String takeNumberAndReturnStatusString(Long statusID) {
        if(statusID == 1) return "Ativo";
        if(statusID == 2) return "Cancelado";
        if(statusID == 3) return "Em Análise";
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error ocurred on convert cliente.status_id to string; UtilsServiceImpl[13 - 16 line]");
    }
}
