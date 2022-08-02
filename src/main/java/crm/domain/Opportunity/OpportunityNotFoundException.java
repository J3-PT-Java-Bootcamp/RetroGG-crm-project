package crm.domain.Opportunity;

import java.util.UUID;

public class OpportunityNotFoundException extends Exception {
    public OpportunityNotFoundException(UUID id) {
        super(String.format("Opportunity with id: %s not found", id));
    }
}
