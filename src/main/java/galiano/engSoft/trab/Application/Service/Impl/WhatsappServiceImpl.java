package galiano.engSoft.trab.Application.Service.Impl;

import galiano.engSoft.trab.Application.Domain.Entity.WhatsappEntity;
import galiano.engSoft.trab.Application.Domain.Repository.WhatsappRepository;
import galiano.engSoft.trab.Application.Service.WhatsappService;
import galiano.engSoft.trab.Application.Service.UtilsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WhatsappServiceImpl implements WhatsappService {
    private final WhatsappRepository whatsappRepository;
    private final UtilsService utilsService;

    @Override
    public List<WhatsappEntity> findAllWhatsappMensagens() {
        return whatsappRepository.findAll();
    }

    @Override
    public void saveWhatsapp(WhatsappEntity whatsapp) {
        whatsappRepository.save(whatsapp);
    }

    @Override
    public WhatsappEntity findWhatsappById(Long id) {
        return whatsappRepository.findById(id).orElse(null);
    }

    @Override
    public void updateWhatsappById(Long id, WhatsappEntity whatsapp) {
        WhatsappEntity whatsappEncontrado = whatsappRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mensagem não encontrada"));
        whatsappEncontrado.setMensagemEnviada(whatsapp.getMensagemEnviada());
        whatsappEncontrado.setHoraDaMensagem(whatsapp.getHoraDaMensagem());
        whatsappEncontrado.setClienteEnviada(whatsapp.getClienteEnviada());

        whatsappRepository.save(whatsappEncontrado);
    }

    @Override
    public void deleteById(Long id) {
        whatsappRepository.deleteById(id);
    }
}
