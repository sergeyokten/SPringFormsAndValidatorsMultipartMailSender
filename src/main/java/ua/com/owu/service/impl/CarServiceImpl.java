package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.owu.dao.CarDAO;
import ua.com.owu.entity.Car;
import ua.com.owu.service.CarService;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDAO carDAO;
    public void save(Car car) {
        carDAO.save(car);
    }
}
