package com.intesasanpaolo.bear.tit0.engine.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.intesasanpaolo.bear.tit0.engine.model.entity.WtRunDeal;
import com.intesasanpaolo.bear.tit0.engine.model.json.JsonDealObject;
import com.intesasanpaolo.bear.tit0.engine.model.json.structure.CurveStructure;
import com.intesasanpaolo.bear.tit0.engine.model.json.structure.IDealStructure;


public interface DvDealService {

  JsonDealObject getData(String dateControl, String operType) throws Exception;
  void deleteData(String dateControl, String ctrlId) throws Exception;
  CurveStructure getCurve(String codAsset, String ccy, Date dtRif) throws Exception ;
  void saveAll(List<WtRunDeal> wtRunDeals ) throws Exception;
  CurveStructure getCurve(String codAsset, String codType, String ccy, Date dtRif) throws Exception ;
  Collection<IDealStructure> getExternalDeal(String source, Date dtRif, String codFolder, String codMtype, String codMgroup, String codBuySell, String partyId) throws Exception;
}
