package webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import webapp.model.Contact;
import webapp.model.ContactType;
import webapp.model.Resume;

import static org.junit.Assert.*;


public class ArrayStorageTest {
    private static Resume R1, R2, R3;

    private ArrayStorage storage = new ArrayStorage();

    static {
        R1 = new Resume("Полное имя1", "location1");
        R1.addContact(new Contact(ContactType.MAIL, "mail@mail.ru"));
        R1.addContact(new Contact(ContactType.PHONE, "1111111111"));
        R2 = new Resume("Полное имя2", null);
        R2.addContact(new Contact(ContactType.SKYPE, "Skype2"));
        R2.addContact(new Contact(ContactType.PHONE, "2222222222"));
        R3 = new Resume("Полное имя3", null);

    }

    @BeforeClass
    public static void beforeClass(){
        // the same as static {}
    }

    @Before
    public void before() {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);

    }


    @org.junit.Test
    public void clear() throws Exception {

    }

    @org.junit.Test
    public void save() throws Exception {

    }

    @org.junit.Test
    public void update() throws Exception {

    }

    @org.junit.Test
    public void load() throws Exception {

    }

    @org.junit.Test
    public void dalete() throws Exception {
        storage.dalete(R1.getUuid());
        Assert.assertEquals(2, storage.size());
        Assert.assertEquals(null, storage.load(R1.getUuid()));

    }

    @org.junit.Test
    public void getSorted() throws Exception {

    }

    @org.junit.Test
    public void size() throws Exception {

        Assert.assertArrayEquals(3, storage.size());
    }

}