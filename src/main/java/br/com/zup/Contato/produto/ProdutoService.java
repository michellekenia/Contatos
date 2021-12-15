package br.com.zup.Contato.produto;

import br.com.zup.Contato.produto.dtos.ProdutoDTO;
import br.com.zup.Contato.produto.exceptions.ProdutoJaCadastradoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private List<ProdutoDTO> produtos = new ArrayList<>();

    public void cadastrarProdutos(ProdutoDTO produto) {
        produtos.add(produto);
    }

    public void verificarSeProdutoExiste(int id) {
        for (ProdutoDTO produtoVerificado : produtos) {
            if (produtoVerificado.getId() == id) {
                throw new ProdutoJaCadastradoException("Esse produto já foi cadastrado");
            }
        }

    }


}
