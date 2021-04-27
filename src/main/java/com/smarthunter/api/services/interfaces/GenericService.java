package com.smarthunter.api.services.interfaces;

import com.smarthunter.api.exceptions.ResourceNotFoundException;
import com.smarthunter.api.util.Convertible;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public interface GenericService<ID, T extends Convertible<ResponseDTO>, ResponseDTO, RequestDTO> {

    T getNewInstance();

    JpaRepository<T, ID> getRepository();

    default ResponseDTO save(RequestDTO request) {
        var result = getNewInstance();
        BeanUtils.copyProperties(request, result);
        return getRepository().save(result).convertToDTO();
    }

    default List<ResponseDTO> findAll() {
        var list = getRepository().findAll();
        return list.stream().map(Convertible::convertToDTO).collect(Collectors.toList());
    }

    default ResponseDTO findById(ID id) {
        var result = getRepository().findById(id).orElseThrow(ResourceNotFoundException::new);
        return result.convertToDTO();
    }

    default ResponseDTO updateById(ID id, RequestDTO request) {
        var result = getRepository().findById(id).orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(request, result);
        return getRepository().save(result).convertToDTO();
    }

    default void deleteById(ID id) {
        getRepository().deleteById(id);
    }
}
