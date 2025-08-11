package service;

import java.util.List;

/**
 * @param <D>  - DTO object. Obektni haqida malumot uchun.
 * @param <CD> - CREATE DTO. Obektni yasash uchun kerakli malumotlar jamlangan tur
 * @param <UD> - UPDATE DTO. Obektni o'zgartirish uchun kerakli malumotlar jamlangan tur
 * @param <K>  - id turi
 */
public interface CrudService<D, CD, UD, K> {

    void create(CD dto);

    D update(UD dto, K id);

    D get(K id);

    List<D> getAll();

    void delete(K id);
}
