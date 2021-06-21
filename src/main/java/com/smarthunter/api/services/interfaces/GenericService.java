package com.smarthunter.api.services.interfaces;

import com.smarthunter.api.contracts.requests.UserRequest;
import com.smarthunter.api.exceptions.ResourceNotFoundException;
import com.smarthunter.api.utils.Convertible;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericService<T extends Convertible<Response>, Response, Request extends Convertible<T>, ID> {

    JpaRepository<T, ID> getRepository();

    default Response save(Request request) {
        var result = request.convert();
        return getRepository().save(result).convert();
    }

    default Page<Response> findAll(Pageable pageable) {
        var list = getRepository().findAll(pageable);
        return list.map(Convertible::convert);
    }

    default Response findById(ID id) {
        var result = getRepository().findById(id).orElseThrow(ResourceNotFoundException::new);
        return result.convert();
    }

    default Response updateById(ID id, Request request) {
        String[] ignoreProperties = {
                "id",
                "registerDate",
                "perfis",
                "enrolledCourses",
                "lessons"
        };

        var result = getRepository().findById(id).orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(request.convert(), result, ignoreProperties);
        return getRepository().save(result).convert();
    }

    default void deleteById(ID id) {
        getRepository().deleteById(id);
    }
}
