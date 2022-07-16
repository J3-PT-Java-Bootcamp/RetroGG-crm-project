package crm.domain.crm;

import crm.domain.Lead.Lead;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrmTest {

  @BeforeEach
  void setUp() {

  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void test_newLead_receive_lead() {
    Crm oneCrm = new Crm();

    Lead otherLead = new Lead("elena", "9999", "elena@gmail.com", "GrandCompany");
    Crm.newLead(otherLead);

    assertEquals("elena", oneCrm.getLeadsList().get(0).getName());
    System.out.println(oneCrm.getLeadsList().get(0).getName());
  }
}