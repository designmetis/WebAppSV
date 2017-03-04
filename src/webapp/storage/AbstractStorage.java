package webapp.storage;


import webapp.WebAppException;
import webapp.model.Resume;

import java.util.logging.Logger;

abstract public class AbstractStorage implements IStorage{

    protected Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void save(Resume r) {
        logger.info("Save resume with uuid " + r.getUuid());

        doSave(r);

    }

    protected abstract void doSave(Resume r);
}
