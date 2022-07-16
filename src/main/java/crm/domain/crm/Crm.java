package crm.domain.crm;

import crm.domain.Company.Company;
import crm.domain.Lead.Lead;
import crm.domain.Opportunity.Opportunity;

import java.util.ArrayList;

public class Crm {

  private ArrayList<Lead> leadsList;
  private ArrayList<Opportunity> opportunitiesList;
  private ArrayList<Company> companiesList;

  public Crm() {
  }

  public Crm(ArrayList<Lead> leadsList, ArrayList<Opportunity> opportunitiesList, ArrayList<Company> companiesList) {
    this.leadsList = leadsList;
    this.opportunitiesList = opportunitiesList;
    this.companiesList = companiesList;
  }

  public ArrayList<Lead> getLeadsList() {
    return leadsList;
  }

  public ArrayList<Opportunity> getOpportunitiesList() {
    return opportunitiesList;
  }

  public ArrayList<Company> getCompaniesList() {
    return companiesList;
  }
}
