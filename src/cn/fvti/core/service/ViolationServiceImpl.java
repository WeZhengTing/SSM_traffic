package cn.fvti.core.service;

import cn.fvti.common.utils.Page;
import cn.fvti.core.dao.ViolationDao;
import cn.fvti.core.pojo.Violation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("violationService")
@Transactional
public class ViolationServiceImpl implements ViolationService {
    @Autowired
    private ViolationDao violationDao;
    public Page<Violation> findViolationList (Integer cid){
        Violation violation=new Violation();
        List<Violation> violations=violationDao.selectViolationList(violation);
        Page<Violation> result=new Page<>();
        result.setRows(violations);
        return result;
    }


    @Override
    public  Violation vgetuid(Integer vid){
        Violation violation=violationDao.vgetuid(vid);
        return violation;
    }

    @Override
    public int updateviolation (Violation violation){
        return violationDao.updateviolation(violation);
    }

    @Override
    public int insertviolation(Violation violation){
        return violationDao.insertviolation(violation);
    }

}
