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

    public void cadastrarContato(ContatoDTO contato) {
        contatos.add(contato);

    }

    private List<ProdutoDTO> produtos = new ArrayList<>();

    public void cadastrarProdutos(ProdutoDTO produto) {
        produtos.add(produto);
    }

    public ContatoDTO buscarContatoNaLista(String email) {

        for (ContatoDTO contatoVerificado : contatos) {
            if (contatoVerificado.getEmail().equalsIgnoreCase(email)) ;
            return contatoVerificado;
        }

        throw new ContatoNaoEncontradoException("Esse contato não exite");

    }

    public void verificarContatoRepetido(String emailRepetido) {

        for (ContatoDTO contatoRepetido : contatos) {
            if (contatoRepetido.getEmail().equals(emailRepetido))

                throw new EmailJaCadastradoException("Esse email já está cadastrado");
        }
    }


    public void verificarSeProdutoExiste(int id) {
        for (ProdutoDTO produtoVerificado : produtos) {
            if (produtoVerificado.getId() == id) {
                throw new ProdutoJaCadastradoException("Esse produto já foi cadastrado");
            }
        }

    }

    public void atualizarListaDeProdutos(String email, ContatoDTO contatoDTO) {

        ContatoDTO buscarContato = buscarContatoNaLista(email);
        for (ProdutoDTO novoProduto : contatoDTO.getProdutos()) {
            buscarContato.getProdutos().add(novoProduto);
        }

    }

}
