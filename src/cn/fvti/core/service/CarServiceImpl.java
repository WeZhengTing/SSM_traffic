package cn.fvti.core.service;

import cn.fvti.core.dao.CarDao;
import cn.fvti.core.pojo.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("carService")
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carsDao;
    public int findCarByCno(String cno){
        return carsDao.findCarByCno(cno);
    }

    public int createcar(Cars cars){
        return carsDao.createcar(cars);
    }

    public int updateCar(Cars cars){return carsDao.createcar(cars);}

    public int finduidByCid(Integer cid){ return carsDao.finduidByCid(cid);}
}
