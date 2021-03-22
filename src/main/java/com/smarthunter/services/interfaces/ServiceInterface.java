package com.smarthunter.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceInterface<T, S> {

    T save(S t);

    Page<T> findAll(Pageable pageable);

    T findById(Long id);

    T findByName(String name);

    T updateById(Long id, S t);

    void deleteById(Long id);
}
