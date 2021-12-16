package br.com.zup.Contato.contatos;

import br.com.zup.Contato.contatos.dtos.ContatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarcontato(@RequestBody @Valid ContatoDTO contato) {
        contatoService.cadastrarContato(contato);
    }

    @GetMapping("/{e-mail}")
    public ContatoDTO buscarContatoPeloEmail (@PathVariable String email) {
        return contatoService.buscarContatoNaLista(email);
    }

}
