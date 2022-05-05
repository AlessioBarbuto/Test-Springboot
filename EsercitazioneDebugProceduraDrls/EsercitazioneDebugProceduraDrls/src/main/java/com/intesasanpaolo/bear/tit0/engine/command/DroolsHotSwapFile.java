package com.intesasanpaolo.bear.tit0.engine.command;

import com.intesasanpaolo.bear.tit0.engine.connector.jpaoracle.DtRulesRepository;
import com.intesasanpaolo.bear.tit0.engine.model.bean.DtRulesBean;
import com.intesasanpaolo.bear.tit0.engine.model.entity.DtRules;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RefreshScope
public class DroolsHotSwapFile {

  @Autowired private DtRulesRepository dtRulesRepository;

  @Autowired private Mapper mapper;

  public DtRulesBean getFileInfo(String ctrlId) {

    DtRulesBean droolsFile = new DtRulesBean();

    List<DtRules> dtRulesEntity = dtRulesRepository.findMyIdCtrlAndDtEndIsNull(ctrlId);

    mapper.map(dtRulesEntity.get(0), droolsFile);

    return droolsFile;
  }

//  public List<DtRulesBean> getAllRules() {
//    DtRulesBean droolsFile;
//    List<DtRulesBean> rulesBeans = new ArrayList<>();
//    List<DtRules> dtRulesEntity = dtRulesRepository.findAllRules();
//    for (DtRules dtRulesItem : dtRulesEntity) {
//      droolsFile = new DtRulesBean();
//      mapper.map(dtRulesItem, droolsFile);
//      rulesBeans.add(droolsFile);
//    }
//    return rulesBeans;
//  }

//  public List<DtRulesBean> getAllRulesSimulator() {
//    DtRulesBean droolsFile;
//    List<DtRulesBean> rulesBeans = new ArrayList<>();
//    List<DtRules> dtRulesEntity = dtRulesRepository.findAllByFlTypeIsS();
//    for (DtRules dtRulesItem : dtRulesEntity) {
//      droolsFile = new DtRulesBean();
//      mapper.map(dtRulesItem, droolsFile);
//      rulesBeans.add(droolsFile);
//    }
//    return rulesBeans;
//  }

//  public List<DtRulesBean> getAllRulesProduction() {
//    DtRulesBean droolsFile;
//    List<DtRulesBean> rulesBeans = new ArrayList<>();
//    List<DtRules> dtRulesEntity = dtRulesRepository.findAllByFlTypeIsP();
//    for (DtRules dtRulesItem : dtRulesEntity) {
//      droolsFile = new DtRulesBean();
//      mapper.map(dtRulesItem, droolsFile);
//      rulesBeans.add(droolsFile);
//    }
//    return rulesBeans;
//  }
}
