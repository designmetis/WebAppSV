package webapp.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import webapp.WebAppException;
import webapp.model.Contact;
import webapp.model.ContactType;
import webapp.model.Resume;

import java.util.Arrays;

import static org.junit.Assert.*;


public class ArrayStorageTest{
    private Resume R1, R2, R3;

    private ArrayStorage storage = new ArrayStorage();


    @BeforeClass
    public static void beforeClass() {
        // the same as static {}
    }

    @Before
    public void before() {
        R1 = new Resume("Полное имя1", "location1");
        R1.addContact(new Contact(ContactType.MAIL, "mail@mail.ru"));
        R1.addContact(new Contact(ContactType.PHONE, "1111111111"));
        R2 = new Resume("Полное имя2", null);
        R2.addContact(new Contact(ContactType.SKYPE, "Skype2"));
        R2.addContact(new Contact(ContactType.PHONE, "2222222222"));
        R3 = new Resume("Полное имя3", null);
        storage.clear();
        storage.save(R3);
        storage.save(R1);
        storage.save(R2);

    }


    @org.junit.Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @org.junit.Test
    public void save() throws Exception {

    }

    @org.junit.Test
    public void update() throws Exception {
        R2.setFullname("updated N2");
        assertEquals(R2, storage.load(R2.getUuid()));
    }

    @org.junit.Test
    public void load() throws Exception {
        assertEquals(R1, storage.load(R1.getUuid()));
        assertEquals(R2, storage.load(R2.getUuid()));
        assertEquals(R3, storage.load(R3.getUuid()));
    }

    @org.junit.Test(expected = WebAppException.class)
    public void testDeleteNotFound() throws Exception {
        storage.load("dummy");
    }

    @org.junit.Test
    public void delete() throws Exception {
        storage.dalete(R1.getUuid());
        assertEquals(2, storage.size());
    }

    @org.junit.Test
    public void getSorted() throws Exception {
        Resume[] src = new Resume[]{R1, R2, R3};
        Arrays.sort(src);
        assertArrayEquals(src, storage.getSorted().toArray());
    }

    @org.junit.Test
    public void size() throws Exception {

        Assert.assertEquals(3, storage.size());
    }

}