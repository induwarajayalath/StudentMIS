/**
 * Created by hasithagamage on 5/13/17.
 */
public class MyException extends  RuntimeException{
    private final String errorCode;

    public MyException(String errorCode, String message, Throwable t) {
        super(message, t);
        this.errorCode = errorCode;
    }

    public MyException(String errorCode, String message) {
        this(errorCode, message, null);
    }

    public String getErrorCode() {
        return errorCode;
    }

}
