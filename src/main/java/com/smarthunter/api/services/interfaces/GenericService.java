package com.smarthunter.api.services.interfaces;

import com.smarthunter.api.exceptions.ResourceNotFoundException;
import com.smarthunter.api.utils.Convertible;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public interface GenericService<T extends Convertible<Response>, Response, Request extends Convertible<T>, ID> {

    JpaRepository<T, ID> getRepository();

    default Response save(Request request) {
        var result = request.convert();
        return getRepository().save(result).convert();
    }

    default List<Response> findAll() {
        var list = getRepository().findAll();
        return list.stream().map(Convertible::convert).collect(Collectors.toList());
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
