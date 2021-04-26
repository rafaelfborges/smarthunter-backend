package com.smarthunter.api.services.interfaces;

import com.smarthunter.api.exceptions.ResourceNotFoundException;
import com.smarthunter.api.util.Convertible;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public interface GenericService <T extends Convertible<ResponseDTO>, ResponseDTO, RequestDTO, ID> {

    JpaRepository<T, ID> getRepository();

    ResponseDTO save(RequestDTO request);

    default List<ResponseDTO> findAll() {
        var list = getRepository().findAll();
        return list.stream().map(Convertible::convertResponse).collect(Collectors.toList());
    }

    default ResponseDTO findById(ID id) {
        var result = getRepository().findById(id).orElseThrow(ResourceNotFoundException::new);
        return result.convertResponse();
    }

    default ResponseDTO updateById(ID id, RequestDTO request) {
        var result = getRepository().findById(id).orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(request, result);
        return getRepository().save(result).convertResponse();
    }

    default void deleteById(ID id) {
        getRepository().deleteById(id);
    }
}
