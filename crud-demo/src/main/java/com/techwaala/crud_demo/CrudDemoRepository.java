package com.techwaala.crud_demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CrudDemoRepository extends JpaRepository<CrudDemo,Long> {
    Optional<CrudDemo> findCrudDemoByName(String name);
}
