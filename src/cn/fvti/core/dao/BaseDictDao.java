package cn.fvti.core.dao;

import cn.fvti.core.pojo.BaseDict;

import java.util.List;

public interface BaseDictDao {
    public List<BaseDict> selectBaseDictByTypeCode(String typecode);
}
