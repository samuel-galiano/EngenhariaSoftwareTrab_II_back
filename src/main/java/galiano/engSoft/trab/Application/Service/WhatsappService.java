package galiano.engSoft.trab.Application.Service;

import galiano.engSoft.trab.Application.Domain.Entity.WhatsappEntity;

import java.util.List;

public interface WhatsappService {
    List<WhatsappEntity> findAllWhatsappMensagens();

    void saveWhatsapp(WhatsappEntity whatsapp);

    WhatsappEntity findWhatsappById(Long id);

    void updateWhatsappById(Long id, WhatsappEntity whatsapp);

    void deleteById(Long id);
}
