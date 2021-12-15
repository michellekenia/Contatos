package br.com.zup.Contato.produto;

import br.com.zup.Contato.contatos.dtos.ContatoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private List<ProdutoDTO> produtos = new ArrayList<>();

    public void cadastrarProdutos(ProdutoDTO produto) {
        produtos.add(produto);
    }

}
