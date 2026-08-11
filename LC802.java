// 1. Define a Custom Exception with Code 802
public class CustomBusinessException extends Exception {
    private final int errorCode;

    public CustomBusinessException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

// 2. Throw and Handle Code 802
public class ErrorHandlerExample {

    public static void validateRequest(boolean isValid) throws CustomBusinessException {
        if (!isValid) {
            // Throwing custom code 802 (e.g., Invalid Session / Database Timeout)
            throw new CustomBusinessException(802, "ERR_802: Operation failed due to custom backend error.");
        }
    }

    public static void main(String[] args) {
        try {
            validateRequest(false);
        } catch (CustomBusinessException e) {
            if (e.getErrorCode() == 802) {
                System.err.println("Handled Error 802: " + e.getMessage());
                // Add fallback or retry logic here
            }
        }
    }
}