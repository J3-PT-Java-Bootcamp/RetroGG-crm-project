package crm.application.Leads.ConvertLeadToOpportunity;

import crm.domain.Account.Account;
import crm.domain.Account.AccountRepository;
import crm.domain.Lead.LeadNotFoundException;
import crm.domain.Lead.LeadRepository;
import crm.domain.Opportunity.Opportunity;
import crm.domain.Opportunity.OpportunityRepository;

public final class ConvertLeadToOpportunityUseCase {

    private final LeadRepository leadRepository;
    private final AccountRepository accountRepository;
    private final OpportunityRepository opportunityRepository;

    public ConvertLeadToOpportunityUseCase(LeadRepository leadRepository, AccountRepository accountRepository, OpportunityRepository opportunityRepository) {
        this.leadRepository = leadRepository;
        this.accountRepository = accountRepository;
        this.opportunityRepository = opportunityRepository;
    }

    public void run(ConvertLeadToOpportunityRequest request) throws LeadNotFoundException {
        var lead = this.leadRepository.findById(request.leadId());
        if (lead.isEmpty()) {
            throw new LeadNotFoundException(request.leadId());
        }
        var opportunity = Opportunity.createFromLead(
                lead.get(),
                request.quantity(),
                request.productType());
        var account = Account.create(
                lead.get().getCompanyName(),
                request.companyIndustry(),
                request.numberOfEmployees(),
                request.companyCity(),
                request.companyCountry()
        );
        account.addContact(opportunity.getDecisionMaker());
        account.addOpportunity(opportunity);
        this.accountRepository.save(account);
        this.opportunityRepository.save(opportunity);
        this.leadRepository.remove(lead.get());
    }
}

