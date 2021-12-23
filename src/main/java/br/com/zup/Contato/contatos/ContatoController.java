package br.com.zup.Contato.contatos;

import br.com.zup.Contato.contatos.dtos.ContatoDTO;
import br.com.zup.Contato.contatos.dtos.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarcontato(@RequestBody @Valid ContatoDTO contato, ProdutoDTO produto) {
        contatoService.cadastrarContato(contato,produto);
    }

    @GetMapping("/{email}")
    public ContatoDTO buscarContatoPeloEmail (@PathVariable String email) {
        return contatoService.buscarContatoNaLista(email);
    }

    @GetMapping
    public List<ContatoDTO> exibirContatos() {
        return contatoService.retornarTodosOsContatos();
    }

    @PutMapping("/{email}")
    public ContatoDTO atualizarContato(@PathVariable String email, @RequestBody ContatoDTO contatoDTO, ProdutoDTO produtoDTO) {

        return contatoService.atualizarListaDeContatos(email, contatoDTO, produtoDTO);
    }

}
