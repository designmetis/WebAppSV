package webapp.storage;


import webapp.model.Resume;

import java.util.Collection;

public interface IStorage {

    void clear();

    void save(Resume resume);

    void update(Resume resume);

    Resume load(String uuid);

    void dalete(String uuid);

    Collection<Resume> getSorted();

    int size();

}
