package pet.projects.vktask.tool.exception;

public class ClientAlreadyRegisteredException extends RuntimeException {

    public ClientAlreadyRegisteredException() {
    }

    public ClientAlreadyRegisteredException(String message) {
        super(message);
    }

    public ClientAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientAlreadyRegisteredException(Throwable cause) {
        super(cause);
    }

}
