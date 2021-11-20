package at.htl.linzlinien.control;

import at.htl.linzlinien.entity.Line;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class LineRepository {

    @Inject
    EntityManager em;

    /**
     * search the line in the database.
     * - when it is already persisted, return the existing line
     * - when the line.name is not found, persist the line object
     *
     * @param line
     * @return the existing location, when line.name already exists in db
     * or return the persisted line, when not found in database
     */
    @Transactional
    public Line save(Line line) {
        return null;
    }

    /**
     * use a NamedQuery "Line.findByName" to retrieve the Line by name
     * when the NoResultException is thrown, return null
     *
     * @param name
     * @return the line (with the given name) or null, when the name is not in the db
     */
    public Line findByName(String name) {
        return null;
    }

}
