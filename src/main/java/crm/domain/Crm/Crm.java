package crm.domain.Crm;

import crm.application.CreateLead.CreateLeadRecord;
import crm.application.CreateLead.CreateLeadUseCase;
import crm.domain.Company.Company;
import crm.domain.Lead.ILeadRepository;
import crm.domain.Lead.Lead;
import crm.domain.Opportunity.Opportunity;
import crm.infrastructure.Lead.InMemoryLeadRepository;

import java.util.*;

public class Crm {

  private final Scanner scanner = new Scanner(System.in);

  private final CreateLeadUseCase createLeadUseCase;

  public Crm() {
    ILeadRepository leadsRepository = new InMemoryLeadRepository();
    this.createLeadUseCase = new CreateLeadUseCase(leadsRepository);
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
          case CREATE_LEAD -> createLead();
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

  public void createLead(){
    System.out.println("Name: ");
    String name = scanner.nextLine();

    System.out.println("Phone: ");
    String phone = scanner.nextLine();

    System.out.println("Email: ");
    String email = scanner.nextLine();

    System.out.println("Company: ");
    String company = scanner.nextLine();
    var request = new CreateLeadRecord(name, phone, email, company);
    this.createLeadUseCase.run(request);
  }

}
