package crm.domain.Account;

public class IndustryNotFoundException extends Exception {
    public IndustryNotFoundException(String text) {
        super(String.format("Industry %s not found.", text));
    }
}
