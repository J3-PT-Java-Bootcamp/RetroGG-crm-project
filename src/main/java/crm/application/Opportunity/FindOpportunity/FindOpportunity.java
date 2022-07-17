package crm.application.Opportunity.FindOpportunity;

import crm.domain.Opportunity.Opportunity;
import crm.domain.Opportunity.OpportunityNotFoundException;
import crm.domain.Opportunity.OpportunityRepository;

public class FindOpportunity {
    private final OpportunityRepository opportunityRepository;

    public FindOpportunity(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    public Opportunity run(FindOpportunityRequest request) throws OpportunityNotFoundException {
        var opportunity = this.opportunityRepository.findById(request.id());
        if (opportunity.isEmpty()) {
            throw new OpportunityNotFoundException(request.id());
        }
        return opportunity.get();
    }
}
