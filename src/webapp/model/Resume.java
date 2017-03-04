package webapp.model;


import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {

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

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
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
        return Objects.hash(uuid, fullname, location, homePage, contacts, sections);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Resume other = (Resume) obj;
        return Objects.equals(this.uuid, other.uuid)
                && Objects.equals(this.fullname, other.fullname)
                && Objects.equals(this.location, other.location)
                && Objects.equals(this.homePage, other.homePage)
                && Objects.equals(this.contacts, other.contacts)
                && Objects.equals(this.sections, other.sections);
    }

    @Override
    public int compareTo(Resume o) {
        return fullname.compareTo(o.fullname);
    }
}
