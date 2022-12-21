package cn.fvti.core.service;

import cn.fvti.core.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    public List<BaseDict> findBaseDictByTypeCode(String typecode);
}
