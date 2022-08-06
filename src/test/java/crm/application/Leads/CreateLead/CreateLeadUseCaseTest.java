package crm.application.Leads.CreateLead;

import crm.application.Crm.Crm;
import crm.application.Leads.ConvertLeadToOpportunity.ConvertLeadToOpportunityRequest;
import crm.domain.Account.Industry;
import crm.domain.Lead.Lead;
import crm.domain.Opportunity.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateLeadUseCaseTest {

    Crm crm;
    CreateLeadRequest request;

    @BeforeEach
    void setup(){
        crm = new Crm();
        crm.getLeadsRepository().findAll().clear();
        request = new CreateLeadRequest("Luis", "666555444", "llll@hotmail.com",
                "Incorporation Inc.");
    }

    @Test
    void run() {
        crm.getCreateLeadUseCase().run(request);
        int size = crm.getLeadsRepository().findAll().size();
        assertEquals(1, size);
    }
}