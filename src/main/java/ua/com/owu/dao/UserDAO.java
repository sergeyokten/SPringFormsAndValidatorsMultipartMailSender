package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.entity.User;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {


    List<User> findAllById(int id);

//    List<User> findAllByNameAndOrderByAge(String name, int age);
//
//
//    @Query("select u from User u where u.name=:name and u.id=:id")
//    User findNameId(@Param("name") String name, @Param("id") int id);
}
