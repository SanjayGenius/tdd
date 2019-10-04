package org.java.training.tdd.repository;

import org.java.training.tdd.model.StudentNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  NameRepository extends JpaRepository<StudentNames, Long>{

}
