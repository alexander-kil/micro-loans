/*
 * Copyright (c) 2021. Kilico
 * @author Alexander.Kill@gmail.com
 */

package com.kilico.loans.treasury;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.Optional;

public interface CrudService<T, I> {
    List<T> list();

    Optional<T> get(I id);

    T update(T entity) throws OperationNotSupportedException;

    T add(T entity) throws OperationNotSupportedException;

    void delete(I id) throws OperationNotSupportedException;
}
