package cn.fvti.core.service;

import cn.fvti.core.pojo.Cars;

public interface CarService {
    public int findCarByCno(String cno);
    public int updateCar(Cars cars);
    public int createcar(Cars cars);
    public int finduidByCid(Integer cid);
}
