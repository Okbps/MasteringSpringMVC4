package masterSpringMvc.error;

/**
 * Created by Aspire on 01.04.2017.
 */
public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String message) {
        super(message);
    }
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
