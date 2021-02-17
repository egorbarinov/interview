package com.egorbarinov.demorepository.repository;

public class PersonRepository<Person> extends RepositoryImpl<Person, Integer>{


    public PersonRepository(Class<Person> typeClass) {
        super(typeClass);

    }

    @Override
    public Person findById(Class<Person> entity, Integer id) {
        return super.findById(entity, id);
    }

    @Override
    public void save(Person entity) {
        save(entity);
    }

    @Override
    public void delete(Person entity) {
        super.delete(entity);
    }
}
