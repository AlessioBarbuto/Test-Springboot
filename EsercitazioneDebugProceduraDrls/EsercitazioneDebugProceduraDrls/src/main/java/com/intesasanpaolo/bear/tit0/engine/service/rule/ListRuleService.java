package com.intesasanpaolo.bear.tit0.engine.service.rule;

import com.intesasanpaolo.bear.config.LoggerUtils;
import com.intesasanpaolo.bear.service.BaseService;
import com.intesasanpaolo.bear.tit0.engine.connector.jpaoracle.DtRulesRepository;
import com.intesasanpaolo.bear.tit0.engine.model.entity.DtRules;
import com.intesasanpaolo.bear.tit0.engine.resource.RuleResource;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ListRuleService extends BaseService {

  private static final Logger log = LoggerUtils.getLogger(ListRuleService.class);

  @Autowired private DtRulesRepository dtRulesRepository;
  @Autowired private Mapper mapper;

  public List<RuleResource> run() throws SQLException, IOException {

    List<RuleResource> ruleResources = new ArrayList<>();
    List<DtRules> listRules = dtRulesRepository.findAllRules();
    RuleResource ruleResource;
    for (DtRules ruleItem : listRules) {
      ruleResource = new RuleResource();
      mapper.map(ruleItem, ruleResource);
      ruleResources.add(ruleResource);
    }
    return ruleResources;
  }
}
