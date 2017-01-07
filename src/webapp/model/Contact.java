package webapp.model;


import java.util.List;

public class Contact {
    private final ContactType type;
    private final String value;

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }

    public ContactType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    static class OrganizationSection extends Section{

        private List<Organization> values;

    }
}
