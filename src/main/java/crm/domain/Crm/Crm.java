package crm.domain.Crm;

import crm.domain.Company.Company;
import crm.domain.Lead.Lead;
import crm.domain.Opportunity.Opportunity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Crm {

  private final Set<Lead> leadsList;
  private final ArrayList<Opportunity> opportunitiesList;
  private final ArrayList<Company> companiesList;

  private final Scanner scanner = new Scanner(System.in);

  public Crm() {
    leadsList = new HashSet<>();
    opportunitiesList = new ArrayList<>();
    companiesList = new ArrayList<>();
  }

  public Set<Lead> getLeadsList() {
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
    String name = scanner.nextLine();

    System.out.println("Phone: ");
    String phone = scanner.nextLine();

    System.out.println("Email: ");
    String email = scanner.nextLine();

    System.out.println("Company: ");
    String company = scanner.nextLine();

    Lead oneLead = new Lead(name, phone, email, company);
    leadsList.add(oneLead);
  }

  public void newLead(Lead oneLead){
    leadsList.add(oneLead);
  }

}
