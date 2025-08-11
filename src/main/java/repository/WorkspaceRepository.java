package repository;


import entity.Workspace;

import java.util.List;
import java.util.Optional;

public interface WorkspaceRepository extends CrudRepository<Workspace, String> {

    Optional<Workspace> findById(String id);

    List<Workspace> findAll();

    /**
     * @param entity bu saqlanoyatgan object malumotlari
     * @return saqlangandan keyingi holarti
     */
    Workspace save(Workspace entity);

    void delete(Workspace entity);
}
