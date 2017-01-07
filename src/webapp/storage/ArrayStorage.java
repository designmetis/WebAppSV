package webapp.storage;


import webapp.model.Resume;

import java.util.Collection;

public class ArrayStorage implements IStorage {

    public static final int LIMIT = 100;
    private Resume[] array = new Resume[LIMIT];
    int idx = 0;



    @Override
    public void clear() {

    }

    @Override
    public void save(Resume r) {

        for (int i = 0; i < LIMIT; i++) {
            Resume resume = array[i];
            if (resume != null) {
                if (r.equals(resume)) {
                    throw new IllegalStateException("Already present");
                }
            }
        }

        for (int i = 0; i < LIMIT; i++) {
            if (array[i] == null) {
                array[i] = r;
            }
        }
    }

    @Override
    public void update(Resume resume) {

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
}
