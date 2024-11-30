package br.paulocalderan.fileprocessor.domain.user.repository;

import br.paulocalderan.fileprocessor.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
