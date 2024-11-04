package br.com.fiap.exceptions;

public class ClienteNaoEncontradoException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
