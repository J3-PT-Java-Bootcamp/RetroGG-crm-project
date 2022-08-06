package crm.application.Leads.ConvertLeadToOpportunity;

import crm.application.Crm.Crm;
import crm.application.Leads.CreateLead.CreateLeadRequest;
import crm.application.Opportunity.FindOpportunity.FindOpportunity;
import crm.domain.Account.Industry;
import crm.domain.Lead.Lead;
import crm.domain.Lead.LeadNotFoundException;
import crm.domain.Opportunity.ProductType;
import crm.infrastructure.persistence.Opportunity.InMemoryOpportunityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertLeadToOpportunityUseCaseTest {

    Crm crm;
    ConvertLeadToOpportunityRequest request;
    Lead l1;

    @BeforeEach
    void setup(){
        crm = new Crm();
        crm.getLeadsRepository().findAll().clear();
        l1 = new Lead("Luis", "666444222", "a@a.com",
                "Maderas Alfonso");
        crm.getLeadsRepository().save(l1);
        request = new ConvertLeadToOpportunityRequest(1, ProductType.HYBRID,
                1, Industry.PRODUCE,1, "Oslo","Norway");
    }

    @Test
    void test_run() throws LeadNotFoundException {
        crm.getConvertLeadToOpportunityUseCase().run(request);
        int sizeOfTheList = crm.getOpportunityRepository().getOpportunities().size();
        assertEquals(1, sizeOfTheList);
    }
}