package galiano.engSoft.trab.Application.Rest.Controller;

import galiano.engSoft.trab.Application.Domain.Entity.WhatsappEntity;
import galiano.engSoft.trab.Application.Service.WhatsappService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/whatsappMensagens")
@RequiredArgsConstructor
public class WhatsappController {
    private final WhatsappService whatsappService;

    @GetMapping
    public List<WhatsappEntity> findAllWhatsappMensagens() {
        return whatsappService.findAllWhatsappMensagens();
    }

    @GetMapping("/{id}")
    public WhatsappEntity findWhatsappById(@PathVariable Long id) {
        return whatsappService.findWhatsappById(id);
    }

    @PostMapping
    public void saveWhatsapp(@RequestBody WhatsappEntity whatsapp) {
        whatsappService.saveWhatsapp(whatsapp);
    }

    @PutMapping("/{id}")
    public void updateWhatsappById(@PathVariable Long id, @RequestBody WhatsappEntity whatsapp) {
        whatsappService.updateWhatsappById(id, whatsapp);
    }

    @DeleteMapping("/{id}")
    public void deleteWhatsappById(@PathVariable Long id) {
        whatsappService.deleteById(id);
    }
}
