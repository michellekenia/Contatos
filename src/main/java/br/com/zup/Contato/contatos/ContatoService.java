package br.com.zup.Contato.contatos;

import br.com.zup.Contato.contatos.dtos.ContatoDTO;
import br.com.zup.Contato.contatos.dtos.ProdutoDTO;
import br.com.zup.Contato.contatos.exceptions.ContatoNaoEncontradoException;
import br.com.zup.Contato.contatos.exceptions.EmailJaCadastradoException;
import br.com.zup.Contato.contatos.exceptions.ProdutoJaCadastradoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContatoService {

    private List<ContatoDTO> contatos = new ArrayList<>();
    private List<ProdutoDTO> produtos = new ArrayList<>();

    public void cadastrarContato(ContatoDTO contatoCadastro, ProdutoDTO produtoCadastro) {

        try {
            verificarContatoRepetido(contatoCadastro.getEmail());
        } catch (EmailJaCadastradoException exception) {
            exception.getMessage();
        }
        try {
            verificarSeProdutoExiste(produtoCadastro.getNomeDoProduto());
        } catch (ProdutoJaCadastradoException exception) {
            exception.getMessage();
        }
        contatos.add(contatoCadastro);


    }


    public ContatoDTO buscarContatoNaLista(String emailBusca) {

        for (ContatoDTO contatoVerificado : contatos) {
            if (contatoVerificado.getEmail().equalsIgnoreCase(emailBusca)) ;
            return contatoVerificado;
        }

        throw new ContatoNaoEncontradoException("Esse contato não existe.");

    }

    public void verificarContatoRepetido(String emailRepetido) {

        for (ContatoDTO contatoRepetido : contatos) {
            if (contatoRepetido.getEmail().equals(emailRepetido))

                throw new EmailJaCadastradoException("Esse email já foi cadastrado.");
        }
    }


    public void verificarSeProdutoExiste(String produtoNaLista) {


        for (ProdutoDTO produtoVerificado : produtos) {
            if (produtoVerificado.getNomeDoProduto().equals(produtoNaLista)) {
                throw new ProdutoJaCadastradoException("Esse produto já foi cadastrado.");
            }
        }

    }

    public ContatoDTO atualizarListaDeContatos(String emailRecebido, ContatoDTO contatoRecebido, ProdutoDTO produtoRecebido) {
        ContatoDTO atualizarContato = buscarContatoNaLista(emailRecebido);
        atualizarContato.setEmail(contatoRecebido.getEmail());
        atualizarContato.setNome(contatoRecebido.getNome());
        atualizarContato.setTelefone(contatoRecebido.getTelefone());

        atualizarListaDeProdutos(emailRecebido, contatoRecebido);
        return atualizarContato;
    }

    public List<ProdutoDTO> atualizarListaDeProdutos(String email, ContatoDTO contatoDTO) {
        ContatoDTO buscarContato = buscarContatoNaLista(email);
        for (ProdutoDTO novoProduto : contatoDTO.getProdutos()) {
            buscarContato.getProdutos().add(novoProduto);
        }

        return buscarContato.getProdutos();
    }

    public List<ContatoDTO> retornarTodosOsContatos () {
        return contatos;
    }

}
