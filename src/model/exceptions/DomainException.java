package model.exceptions;

/*
 * Classe Exception: O compilador exige que as excessões sejam tratadas com try/catch. Exception é serializable
 * Classe RuntimeException: O compilador não exige que as excessões sejam tratadas. O compilador não reclama caso falte o try/catch
*/


public class DomainException extends RuntimeException{
    //Versão da classe serializable, requerida por uma classe extendida por Exception
	private static final long serialVersionUID = 1L;

	//Construtor recebendo uma String para que possa ser passada uma mensagem na instanciação da classe
	public DomainException(String msg) {
		super(msg); //Passando a msg para o construtor da super classe, assim a msg ficará armazenada dentro da excessão
	}
}
