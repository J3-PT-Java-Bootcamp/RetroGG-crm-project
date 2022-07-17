package crm.domain.Lead;

public class LeadNotFoundException extends Exception {
    public LeadNotFoundException(Integer id) {
        super(String.format("Lead with id: %d not found", id));
    }
}
