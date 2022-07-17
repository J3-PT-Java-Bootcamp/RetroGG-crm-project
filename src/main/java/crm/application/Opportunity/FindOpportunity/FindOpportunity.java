package crm.application.Opportunity.FindOpportunity;

import crm.application.Shared.UUIDRequest;
import crm.domain.Opportunity.Opportunity;
import crm.domain.Opportunity.OpportunityNotFoundException;
import crm.domain.Opportunity.OpportunityRepository;

public final class FindOpportunity {
    private final OpportunityRepository opportunityRepository;

    public FindOpportunity(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public Opportunity run(UUIDRequest request) throws OpportunityNotFoundException {
        var opportunity = this.opportunityRepository.findById(request.id());
        if (opportunity.isEmpty()) {
            throw new OpportunityNotFoundException(request.id());
        }
        return opportunity.get();
    }
}
