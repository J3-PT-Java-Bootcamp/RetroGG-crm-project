package crm.application.Leads.FindAll;

import crm.application.Crm.Crm;
import crm.application.Leads.CreateLead.CreateLeadRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindAllLeadsTest {

    Crm crm;
    CreateLeadRequest request;
    FindAllLeads findAllLeads;

    @BeforeEach
    void setup(){
        crm = new Crm();
        findAllLeads = new FindAllLeads(crm.getLeadsRepository());
        crm.getLeadsRepository().findAll().clear();
        request = new CreateLeadRequest("Luis", "666555444", "llll@hotmail.com",
                "Incorporation Inc.");
        crm.getCreateLeadUseCase().run(request);
        request = new CreateLeadRequest("Ana", "111222333", "aaaa@hotmail.com",
                "Business Bus.");
        crm.getCreateLeadUseCase().run(request);
    }

    @Test
    void run() {
        int size = findAllLeads.run().size();
        assertEquals(2, size);
    }
}