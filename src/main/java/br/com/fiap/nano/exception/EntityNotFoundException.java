package br.com.fiap.nano.exception;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException() {
        super("Entidade não encontrado");
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
