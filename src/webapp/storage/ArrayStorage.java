package webapp.storage;


import webapp.WebAppException;
import webapp.model.Resume;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrayStorage implements IStorage {

    public static final int LIMIT = 100;
    private Resume[] array = new Resume[LIMIT];
    private int size = 0;

    // protected Logger LOGGER = Logger.getLogger(getClass().getName());
    private static Logger LOGGER = Logger.getLogger(ArrayStorage.class.getName());



    @Override
    public void clear() {
        LOGGER.info("Delete all resumes");
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public void save(Resume r) throws WebAppException {

        LOGGER.info("Save resume with uuid " + r.getUuid());
        int idx = getIndex(r.getUuid());

/*            try {
                throw new WebAppException("Resume " + r.getUuid()+ "already exist", r);
            } catch (WebAppException e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }*/

        if (idx != -1)  throw new WebAppException("Resume " + r.getUuid()+ "already exist", r);
        array[size++] = r;

    }


    @Override
    public void update(Resume r) throws WebAppException {
        LOGGER.info("Update resume with " + r.getUuid());
        int idx = getIndex(r.getUuid());

        if (idx == -1)  throw new WebAppException("Resume " + r.getUuid()+ "not exist", r);
        array[idx] = r;
    }

    @Override
    public Resume load(String uuid) {
        return null;
    }

    @Override
    public void dalete(String uuid) {

    }

    @Override
    public Collection<Resume> getSorted() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < LIMIT; i++) {
            if (array[i] != null) {
                if (array[i].getUuid().equals(uuid)) {
                    return i;
                }
            }
        }
        return -1;
    }



}
