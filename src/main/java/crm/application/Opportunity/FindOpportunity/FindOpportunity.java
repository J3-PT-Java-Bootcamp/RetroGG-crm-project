package crm.application.Opportunity.FindOpportunity;

import crm.domain.Opportunity.Opportunity;
import crm.domain.Opportunity.OpportunityNotFoundException;
import crm.domain.Opportunity.OpportunityRepository;

import java.util.UUID;

public final class FindOpportunity {
    private final OpportunityRepository opportunityRepository;

    public FindOpportunity(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public Opportunity run(UUID id) throws OpportunityNotFoundException {
        var opportunity = this.opportunityRepository.findById(id);
        if (opportunity.isEmpty()) {
            throw new OpportunityNotFoundException(id);
        }
        return opportunity.get();
    }
}
