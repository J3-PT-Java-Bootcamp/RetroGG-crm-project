package crm.domain.Lead;

public class Lead {

    private static int NEXT_ID = 1;

    private int id;
    private final String name;
    private final String phoneNumber;
    private final String email;
    private final String companyName;

    public Lead(String name, String phoneNumber, String email, String companyName) {
        this.id = NEXT_ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        NEXT_ID++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return String.format("""
                
                %d - %s
                """, this.id, this.name);
    }
}
