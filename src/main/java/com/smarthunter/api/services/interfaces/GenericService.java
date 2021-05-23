package com.smarthunter.api.services.interfaces;

import com.smarthunter.api.exceptions.ResourceNotFoundException;
import com.smarthunter.api.utils.Convertible;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericService<T extends Convertible<Response>, Request extends Convertible<T>, Response, ID> {

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
        var result = getRepository().findById(id).orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(request, result);
        return getRepository().save(result).convert();
    }

    default void deleteById(ID id) {
        getRepository().deleteById(id);
    }
}
