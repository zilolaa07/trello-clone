package uz.pdp.dto.repository;

import uz.pdp.dto.model.entity.AuthUser;

import java.util.List;
import java.util.Optional;

public interface AuthUserRepository extends CrudRepository<AuthUser, String>{
    Optional<AuthUser> findById(String username);

    List<AuthUser> findAll();

    /**
     * @param entity bu saqlanoyatgan object malumotlari
     * @return saqlangandan keyingi holarti
     */
    AuthUser save(AuthUser entity);

    void delete(AuthUser entity);
}