package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.entity.Car;

public interface CarDAO extends JpaRepository<Car, Integer> {
}
