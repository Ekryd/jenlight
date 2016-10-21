package af;

/**
 * Created by ekrbj on 2014-06-17.
 */
public enum Status {
    OK("stable", "back to normal"), FAIL ("still failing", "failure", "broken", "started to fail"), ABORTED("aborted");

    private String[] messages;

    private Status(String... messages) {
        this.messages = messages;
    }

    public static Status getStatus(String message) {
        for (Status status : values()) {
            if (status.matchMessage(message)) {
                return status;
            }
        }
        System.err.printf("This was not good, unknown message : '%s', this must be a failure%n", message);
        return FAIL;
    }

    private boolean matchMessage(String message) {
        for (String statusMessage : messages) {
            if (message.contains(statusMessage)) {
                return true;
            }
        }
        return false;
    }
}
