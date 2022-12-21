package cn.fvti.core.dao;

import cn.fvti.core.pojo.Cars;

public interface CarDao {
    public int findCarByCno(String cno);
    public int updateCar(Cars cars);
    public int createcar(Cars cars);
    public int finduidByCid(Integer cid);
}
