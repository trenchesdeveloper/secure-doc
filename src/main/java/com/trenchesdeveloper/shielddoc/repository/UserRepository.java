package com.trenchesdeveloper.shielddoc.repository;

import com.trenchesdeveloper.shielddoc.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository extends JpaRepository<User, Integer> {
}
