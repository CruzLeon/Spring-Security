package com.courses.study.springsecurity.persistence;

import com.courses.study.springsecurity.persistence.entity.Product;
import com.courses.study.springsecurity.persistence.entity.UserSecondProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserSecondProject, Integer> {
    Optional<UserSecondProject> findByUsername(String userName);
}
