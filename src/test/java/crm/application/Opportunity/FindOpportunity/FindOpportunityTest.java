package crm.application.Opportunity.FindOpportunity;

import crm.application.Crm.Crm;
import crm.domain.Opportunity.*;
import crm.infrastructure.persistence.Opportunity.InMemoryOpportunityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FindOpportunityTest {

  OpportunityRepository repository = new InMemoryOpportunityRepository();
  Opportunity opportunity;
  Contact contact;

  UUID id;

  @BeforeEach
  void setUp() {

    id = UUID.randomUUID();

    contact = new Contact(id, "932000000", "Arturito");
    opportunity = new Opportunity(id, contact, 10, ProductType.HYBRID, OpportunityStatus.OPEN);

    repository.save(opportunity);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void test_find_oportunity_by_id(){

    assertEquals(id, repository.findById(id).get().getId());

  }

  @Test
  void test_should_not__find_opportunity_with_unknown_id() {
    assertTrue(this.repository.findById(UUID.randomUUID()).isEmpty());
  }

}