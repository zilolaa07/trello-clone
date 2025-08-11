package service;

public abstract class AbstractService<M, R, V> {
    protected final M mapper;
    protected final R repository;
    protected final V validator;

    public AbstractService(M mapper, R repository, V validator) {
        this.mapper = mapper;
        this.repository = repository;
        this.validator = validator;
    }
}
