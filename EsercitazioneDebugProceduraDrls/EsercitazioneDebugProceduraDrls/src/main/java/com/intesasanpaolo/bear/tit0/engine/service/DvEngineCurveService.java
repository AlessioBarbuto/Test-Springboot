package com.intesasanpaolo.bear.tit0.engine.service;

import java.util.List;

import com.intesasanpaolo.bear.tit0.engine.model.api.SogliaControllo;
import com.intesasanpaolo.bear.tit0.engine.model.json.JsonTableObject;

public interface DvEngineCurveService {

  JsonTableObject getData(String dateControl, String ctrlId, String tmsData, String inOrOut)
      throws Exception;
  
  JsonTableObject getRangeData(String codAsset,String dateControl, String ctrlId, String depth, String inOrOut) throws Exception;
  
  void getOutput(JsonTableObject jsonTableObject, String idCtrl, String dateSoglia, String dateControl, String codAsset, String tmsData, List<SogliaControllo> soglieInput)
	      throws Exception;

}
