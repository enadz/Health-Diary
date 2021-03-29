package ssst.healthdiary.backend.services;

import org.hl7.fhir.dstu3.model.DomainResource;

import java.util.Optional;

public interface BaseResourceService<T extends DomainResource> {

    Optional<T> get(String resourceId);

    T save(T resource);

    void update(T resource);

    void delete(String resourceId);

}
