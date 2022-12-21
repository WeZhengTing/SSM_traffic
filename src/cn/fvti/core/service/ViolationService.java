package cn.fvti.core.service;

import cn.fvti.common.utils.Page;
import cn.fvti.core.pojo.Violation;

public interface ViolationService {
    public Page<Violation> findViolationList(Integer cid);
    public Violation vgetuid (Integer vid);
    public int updateviolation (Violation violation);
    public int insertviolation(Violation violation);
}
