package com.intesasanpaolo.bear.tit0.engine.service;

import com.intesasanpaolo.bear.tit0.engine.model.drools.IOUT;
import com.intesasanpaolo.bear.tit0.engine.model.drools.OUT_list;
import com.intesasanpaolo.bear.tit0.engine.model.json.JsonDealObject;
import com.intesasanpaolo.bear.tit0.engine.model.json.JsonTableObject;

import org.kie.api.runtime.KieContainer;

import java.util.Collection;

public interface CalculateEngineService {

  KieContainer setupDrools(String ctrlId);

  Collection<OUT_list> processElement(
      KieContainer kieContainer, JsonTableObject controlData, JsonTableObject outputData)
      throws Exception;
  
  Collection<IOUT> processElement(KieContainer kieContainer, JsonDealObject inputData) throws Exception;
}
