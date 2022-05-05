package com.intesasanpaolo.bear.tit0.engine.service;

import com.intesasanpaolo.bear.tit0.engine.dto.api.ListInputDataDTO;
import com.intesasanpaolo.bear.tit0.engine.model.drools.OUT_list;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface EngineService {

  Collection<OUT_list> control(ListInputDataDTO listDataInput, String ctrlId, String instanceId)
      throws Exception;

  Collection<OUT_list> control(String dateControl, String codUser, String ctrlId, String tmsDate) throws Exception;
}
