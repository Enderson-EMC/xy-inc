package br.com.xy.camada.frente.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * Controller Advice -> Interceptador
 * para toda vez q acontecer uma exceção
 * */
@RestControllerAdvice
public class ErroDeValidacaoHandler {

	/*Ajuda na internacionalização de mensagens de erro*/
	@Autowired
	private MessageSource messageSource;
	
	/*
	 * Quando houver exceção dentro de algum controller
	 * Pega todas as exceções do tipo MethodArgumentNotValidException
	 * 
	 * @ResponseStatus fala para devolver 400, senão o metodo devolve 200 por padrão
	 * 
	 * LocaleContextHolder.getLocale() -> descobre o local atual q o usuario informar
	 * */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDto> handle( MethodArgumentNotValidException exc) {
		
		List<ErroDeFormularioDto> lista = new ArrayList<>();
		List<FieldError> fieldErrors = exc.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormularioDto dto = new ErroDeFormularioDto(e.getField(), mensagem);
			lista.add(dto);
		});
	
		return lista;
		
	}
	
}
