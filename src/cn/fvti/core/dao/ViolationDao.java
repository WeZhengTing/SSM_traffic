package cn.fvti.core.dao;

import cn.fvti.core.pojo.Violation;

import java.util.List;

public interface ViolationDao {
    public List<Violation> selectViolationList(Violation violation);
    public Violation vgetuid(Integer vid);
    public int updateviolation (Violation violation);
    public int insertviolation(Violation violation);
}
