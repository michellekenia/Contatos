package br.com.zup.Contato.contatos;

import br.com.zup.Contato.contatos.dtos.ContatoDTO;
import br.com.zup.Contato.contatos.exceptions.ContatoNaoEncontradoException;
import br.com.zup.Contato.contatos.exceptions.EmailJaCadastradoException;
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

    public void verificarContatoRepetido(String emailRepetido) {

        for (ContatoDTO contatoRepetido : contatos) {
            if (contatoRepetido.getEmail().equals(emailRepetido))

                throw new EmailJaCadastradoException("Esse email já está cadastrado");
        }
    }

}
