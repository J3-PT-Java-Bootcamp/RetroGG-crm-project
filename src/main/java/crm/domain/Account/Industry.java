package crm.domain.Account;

public enum Industry {
    PRODUCE("produce"),
    ECOMMERCE("ecommerce"),
    MANUFACTURING("manufacturing"),
    MEDICAL("medical"),
    OTHER("other");

    private final String industry;

    public String getIndustry() {
        return this.industry;
    }

    private Industry(String industry) {
        this.industry = industry;
    }

    public static Industry fromString(String text) throws IndustryNotFoundException {
        for (Industry b : Industry.values()) {
            if (b.industry.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new IndustryNotFoundException(text);
    }
}
