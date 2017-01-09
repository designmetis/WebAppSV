package webapp.storage;


import webapp.WebAppException;
import webapp.model.Resume;

import java.util.Collection;

public interface IStorage {

    void clear();

    void save(Resume resume) throws WebAppException;

    void update(Resume resume) throws WebAppException;

    Resume load(String uuid);

    void dalete(String uuid);

    Collection<Resume> getSorted();

    int size();

}
