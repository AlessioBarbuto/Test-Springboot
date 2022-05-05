package com.intesasanpaolo.bear.tit0.engine.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.intesasanpaolo.bear.tit0.engine.dto.DealRecordDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DtDealFilterDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.DvDetailDealDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.WtRunDealDTO;
import com.intesasanpaolo.bear.tit0.engine.dto.api.ConfigurazioniDealSearchParamDTO;
import com.intesasanpaolo.bear.tit0.engine.model.drools.IOUT;

@Service
public interface DealService {
	
  List<WtRunDealDTO> control(String dataEsecuzione, String operType, String flType);
  Collection<IOUT> control(String dateControl, String codUser, String ctrlId, String operType) throws Exception;
  List<DtDealFilterDTO> getConfigurazioni(ConfigurazioniDealSearchParamDTO configurazioniDealSearchParam);
  DtDealFilterDTO updateConfigurazioni(DtDealFilterDTO configurazione);
  DtDealFilterDTO insertConfigurazioni(DtDealFilterDTO configurazione); 
  void deleteConfigurazioni(String idConfig);
  void updateDeal(List<DealRecordDTO> listDealRecord, String dataEsecuzione);
  DvDetailDealDTO getDetailDeal(String idDeal, String dataEsecuzione, String operType, String flType);
  
}
