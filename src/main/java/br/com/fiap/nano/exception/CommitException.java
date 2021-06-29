package br.com.fiap.nano.exception;

public class CommitException extends Exception {
    public CommitException() {
        super("Erro ao fazer commit");
    }

    public CommitException(String message) {
        super(message);
    }
}
