package crm.domain.crm;

import crm.domain.Company.Company;
import crm.domain.Lead.Lead;
import crm.domain.Opportunity.Opportunity;

import java.util.ArrayList;
import java.util.Scanner;

public class Crm {

  private static ArrayList<Lead> leadsList;
  private ArrayList<Opportunity> opportunitiesList;
  private ArrayList<Company> companiesList;

  static Scanner scanner = new Scanner(System.in);

  public Crm() {
    leadsList = new ArrayList<>();
    opportunitiesList = new ArrayList<>();
    companiesList = new ArrayList<>();
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

  public static void newLead(){
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

  public static void newLead(Lead oneLead){
    leadsList.add(oneLead);
  }




}
