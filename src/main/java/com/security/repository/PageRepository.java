package com.security.repository;

import com.security.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PageRepository extends JpaRepository<Page,Long> {

    @Query(value = "select * from Page where name is not null",nativeQuery = true)
    public List<Page> getAllByName();
}
