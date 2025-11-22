package com.trenchesdeveloper.shielddoc.repository;

import com.trenchesdeveloper.shielddoc.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository extends JpaRepository<UserEntity, Integer> {
}
