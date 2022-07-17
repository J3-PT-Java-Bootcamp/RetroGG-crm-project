package crm.domain.Crm;

import crm.domain.Company.Company;
import crm.domain.Lead.Lead;
import crm.domain.Opportunity.Opportunity;

import java.util.*;

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

  public void start() {
    this.printWelcome();
    String inputCommand;
    boolean exit = false;
    do {
      System.out.print("Command: ");
      inputCommand = scanner.nextLine().toLowerCase();
      Command command = Command.fromString(inputCommand);
        switch (command) {
          case HELP -> printHelp();
          case EXIT -> exit = true;
          default -> System.out.println("Unavailable command. Type --help to show available commands.");
        }
    } while (!exit);
    printQuit();
  }

  private void printQuit() {
    System.out.println("Saving all changes...");
    System.out.println("CRM has been shut down");
  }

  private void printWelcome() {
    System.out.println("Welcome to the CRM. You can start managing your customers.");
    System.out.println("Type " + Command.HELP.getCommand() +" to show the available commands.");
  }
  private void printHelp() {
    System.out.println("""
            Commands list
            ================================
            \tconvert <<lead-id>> \t-\tIf lead with id is found, convert lead to opportunity.
            """);
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
