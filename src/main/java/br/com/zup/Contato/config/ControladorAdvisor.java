package br.com.zup.Contato.config;

import br.com.zup.Contato.contatos.exceptions.ContatoNaoEncontradoException;
import br.com.zup.Contato.contatos.exceptions.EmailJaCadastradoException;
import br.com.zup.Contato.contatos.exceptions.ProdutoJaCadastradoException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

public class ControladorAdvisor {

    @RestControllerAdvice
    public class ControllerAdvisor {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)

        public List<MensagemDeErro> manipularErrosDeValidacao(MethodArgumentNotValidException exception) {
            List<MensagemDeErro> erros = new ArrayList<>();
            for (FieldError fieldError : exception.getFieldErrors()) {
                MensagemDeErro erroValidacao = new MensagemDeErro(exception.getMessage(), fieldError.getDefaultMessage());
                erros.add(erroValidacao);

            }
            return erros;
        }

        @ExceptionHandler(ContatoNaoEncontradoException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public MensagemDeErro manipularExcecaoDeContatoNaoEncontrado(ContatoNaoEncontradoException exception) {
            return new MensagemDeErro(exception.getMessage(), "Esse contato não existe.");
        }

        @ExceptionHandler(EmailJaCadastradoException.class)
        @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
        public MensagemDeErro manipularExcecaoDeEmailJacadastrado(EmailJaCadastradoException exception) {
            return new MensagemDeErro(exception.getMessage(), "Esse email já foi cadastrado.");
        }

        @ExceptionHandler(ProdutoJaCadastradoException.class)
        @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
        public MensagemDeErro manipularExcecaoDeProdutoJacadastrado(ProdutoJaCadastradoException exception) {
            return new MensagemDeErro(exception.getMessage(), "Esse produto já foi cadastrado.");
        }
    }
}
