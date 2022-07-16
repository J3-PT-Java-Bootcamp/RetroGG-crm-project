package crm.domain.crm;

import crm.domain.Company.Company;
import crm.domain.Lead.Lead;
import crm.domain.Opportunity.Opportunity;

import java.util.ArrayList;
import java.util.Scanner;

public class Crm {

  private ArrayList<Lead> leadsList;
  private ArrayList<Opportunity> opportunitiesList;
  private ArrayList<Company> companiesList;

  Scanner scanner = new Scanner(System.in);

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

  public void newLead(){
    System.out.println("Name: ");
    String name = scanner.next();

    System.out.println("Phone: ");
    String phone = "";

    System.out.println("Email: ");
    String email = "";

    System.out.println("Company: ");
    String company = "";

    Lead oneLead = new Lead(name, phone, email, company);
    leadsList.add(oneLead);
  }

}
