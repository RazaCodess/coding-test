package com.health.service;

import com.health.vo.DependentVO;


public interface DependentService {

    public int addNewDependent(int eid, DependentVO dependentVO);

    int deleteDependent( int did);

    int updateDependent( int did,DependentVO dependentVO);
}
