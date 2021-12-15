package br.com.zup.Contato.contatos;

import br.com.zup.Contato.contatos.dtos.ContatoDTO;
import br.com.zup.Contato.contatos.exceptions.ContatoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContatoService {

    private List<ContatoDTO> contatos = new ArrayList<>();

    public void cadastrarContato(ContatoDTO contato) {

        contatos.add(contato);

    }

    public ContatoDTO buscarContatoNaLista(String email) {

        for (ContatoDTO contatoVerificado : contatos) {
            if (contatoVerificado.getEmail().equalsIgnoreCase(email)) ;
            return contatoVerificado;
        }

       throw new ContatoNaoEncontradoException("Esse contato não exite");

    }

}
