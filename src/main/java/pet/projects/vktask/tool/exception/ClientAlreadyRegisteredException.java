package pet.projects.vktask.tool.exception;

public class ClientAlreadyRegisteredException extends Exception {

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
