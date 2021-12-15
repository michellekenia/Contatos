package br.com.zup.Contato.contatos;

import br.com.zup.Contato.contatos.dtos.ContatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarcontato(@RequestBody ContatoDTO contato) {
        contatoService.cadastrarContato(contato);
    }

}
