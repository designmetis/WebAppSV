package webapp.model;


import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Resume {

    private String uuid;
    private String fullname;
    private String location;
    private String homePage;

    private List<Contact> contacts = new LinkedList<>();
    private List<Section> sections = new LinkedList<>();


    public Resume(String fullname, String location) {
        this(UUID.randomUUID().toString(), fullname, location);
    }

    public Resume(String uuid, String fullname, String location) {
        this.uuid = uuid;
        this.fullname = fullname;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }


    public String getUuid() {
        return uuid;
    }

    public String getLocation() {
        return location;
    }

    public String getHomePage() {
        return homePage;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Section> getSections() {
        return sections;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
