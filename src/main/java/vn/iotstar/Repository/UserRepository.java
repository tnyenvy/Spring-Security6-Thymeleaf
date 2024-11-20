package vn.iotstar.Repository;

import java.util.Optional;

import javax.management.relation.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.iotstar.Entity.Product;
import vn.iotstar.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
 @Query("SELECT u FROM Users u WHERE u.username = :username")
 public Users getUserByUsername(@Param("username") String username);
Optional<Users> findByEmail(String email);
Optional<Users> findByUsernameOrEmail(String username, String email);
Optional<Users> findByUsername(String username);
Boolean existsByUsername(String username);
Boolean existsByEmail(String email);
}
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
@Query("SELECT u FROM Role u WHERE u.name = :name")
public Role getUserByName(@Param("name") String name);
Optional<Role> findByName(String name);
}
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
