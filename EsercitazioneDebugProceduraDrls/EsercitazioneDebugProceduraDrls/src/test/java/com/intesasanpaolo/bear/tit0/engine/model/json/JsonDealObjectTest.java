package com.intesasanpaolo.bear.tit0.engine.model.json;

import static org.junit.Assert.assertNotNull;

import java.io.StringReader;
import java.sql.ResultSet;

import org.h2.tools.Csv;
import org.junit.Test;

import com.intesasanpaolo.bear.tit0.engine.model.drools.IN;
import com.intesasanpaolo.bear.tit0.engine.model.json.structure.DealKondorStructure;
import com.intesasanpaolo.bear.tit0.engine.model.json.structure.DealMurexStructure;
import com.intesasanpaolo.bear.tit0.engine.utils.PojoTestUtils;

public class JsonDealObjectTest {

	

	@Test
	public void testLoad() throws Exception {
		PojoTestUtils.validate(DealKondorStructure.class);
		JsonDealObject j = new JsonDealObject();
//		ResultSet resultSetMock = Mockito.mock(ResultSet.class);
//		
//		Mockito.when(resultSetMock.getString("trade_date")).thenReturn("03-10-2011");
//		Mockito.when(resultSetMock.getString("trade_time")).thenReturn("12:24:56");
//		Mockito.when(resultSetMock.getString("expr_date")).thenReturn("03-19-2011");
//		Mockito.when(resultSetMock.getString("symbol")).thenReturn("VIX1");
//		Mockito.when(resultSetMock.getDouble("trade_price")).thenReturn(Double.valueOf("20.96"));
//		Mockito.when(resultSetMock.getString("contract_month")).thenReturn("1");
//		Mockito.when(resultSetMock.getString("trade_time_thou")).thenReturn("165");
//		Mockito.when(resultSetMock.getMetaData()).thenReturn(2);
//
//		//Mockito.doReturn(resultSetMock).when(callableStatementMock).executeQuery();
//		Mockito.when(resultSetMock.next()).thenReturn(true).thenReturn(false);
		
		String csvResults =
				"2313120,,30-11-2021 00:00:00,30-11-2021 15:07:07,15:07:07,30-11-2021 00:00:00,Y,MM,Repo,REPO,B,PCT,MX_REPO,AT0000A1XML2,,30753044.38,18000,,170.436,,u089823,CAVAGNERA ELENA,LIVE,EUR,,,,01-12-2021 00:00:00,02-12-2021 00:00:00,F,-0.51,,,,N,O,MX REPO CIB,01,,,39218735,DCTFG,MONTETITOL,2313120,2313120,,2313120,2313120,,0,30-11-2021 00:00:00,CAVAGNERA,MMF503932-0-20211130GC,,,,,,BT,BT_INTRA-MATCH,,25-02-2022 17:12:33, KONDOR\n"+
				"2313123,,30-11-2021 00:00:00,30-11-2021 15:17:15,15:17:15,30-11-2021 00:00:00,N,MM,Repo,REPO,B,PCT,24815211,IT0005421703,,3141974.7,3000,,104.28,,u093037,LEOPIZZI PAOLO,LIVE,EUR,,,,01-12-2021 00:00:00,02-12-2021 00:00:00,F,-0.54,,,,Y,B,01CASSA DI C,01,ITALIAN CORPORATE CUSTOMERS,,,DCTFG,MONTETITOL,2313123,2313123,,2313123,2313123,,0,01-12-2021 00:00:00,LEOPIZZI,RTF503966-0-20211130,,,,0002481521189000,,BT,BT_INTRA-MATCH,,25-02-2022 17:12:33,KONDOR\n";
			
			ResultSet rs = new Csv().read(new StringReader(csvResults), new String[] {"ID_DEAL","COD_USAGE","DT_BOOKING","DT_TRADE","TMS_TRADE","DT_RIF","FL_INTERNAL","COD_MFAMILY","COD_MGROUP","COD_MTYPE","COD_BUY_SELL","COD_FOLDER","PARTY_ID","INSTRUMENT_ID","AMOUNT","AMOUNT_REPO","PRINCIPAL","PRINCIPAL2","RATE","DES_COMMENT","ID_TRADER","DES_TRADER","STATUS","COD_BASE_CCY","COD_QUOTED_CCY","QTY_SPOT_BASE_CCY","QTY_SPOT_QUOTED_CCY","DT_VALUE","DT_MATURITY","RATE_TYPE","RATE_REPO","SUM_DEROGHE","FL_REVOLVING","AMORTIZED_MODE","PARTY_IS_BANK","PARTY_CATEGORY","PARTY_DESCRIPTION","COD_SOA","COD_CLASS","COD_TYPOLOGY","ID_DEAL_FE_MIRROR","COD_DIVISION","CLEARING_CENTER_NAME","ID_CONTRACT_INTERNAL_FE","ID_CONTRACT_MASTER_FE","ID_CONTRACT_PARENT_FE","ID_CONTRACT_ROOT_FE","ID_DEAL_MASTER_FE","ID_DEAL_ORIGIN_PACKAGE","ID_DEAL_PARENT_FE","DT_LAST_EVT","LAST_USER","COD_DOWNLOAD_KEY","RATE_FLOATING","COD_CCY_1_INTEREST_RATE","COD_CCY_2_INTEREST_RATE","COD_NDG","SPREAD","BT_MLT","OPER_TYPE","CDG_TYPE","TMS_INS","SOURCE"});
			
		
		j.load(rs);
		j.getDealList();
		DealKondorStructure d = (DealKondorStructure) j.getDealList(0);
		j.getRow(0);
		d.getAmortizedMode();
		d.getAmount();
		d.getAmountRepo();
		d.getClearingCenterName();
		d.getCodBaseCcy();
		d.getCodBuySell();
		d.getCodCcy1InterestRate();
		d.getCodCcy1InterestRate();
		d.getCodCcy2InterestRate();
		d.getCodClass();
		d.getCodDivision();
		d.getCodDownloadKey();
		d.getCodFolder();
		d.getCodMfamily();
		d.getCodMgroup();
		d.getCodMtype();
		d.getCodQuotedCcy();
		d.getCodSoa();
		d.getCodTypology();
		d.getCodUsage();
		d.getData("DT_BOOKING");
		d.getDataTime("DT_TRADE");
		d.getDesComment();
		d.getDesTrader();
		d.getDtBooking();
		d.getDtLastEvt();
		d.getDtMaturity();
		d.getDtRif();
		d.getDtTrade();
		d.getDtValue();
		d.getFlInternal();
		d.getFlRevolving();
		d.getIdContractInternalFe();
		d.getIdContractMasterFe();
		d.getIdContractParentFe();
		d.getIdContractRootFe();
		d.getIdDeal();
		d.getIdDealFeMirror();
		d.getIdDealMasterFe();
		d.getIdDealOriginPackage();
		d.getIdDealParentFe();
		d.getIdTrader();
		d.getInstrumentId();
		d.getJson();
		d.getLastUser();
		d.getNumber("PRINCIPAL");
		d.getOperType();
		d.getPartyCategory();
		d.getPartyDescription();
		d.getPartyId();
		d.getPartyIsBank();
		d.getPrincipal();
		d.getPrincipal2();
		d.getQtySpotBaseCcy();
		d.getQtySpotQuotedCcy();
		d.getRate();
		d.getRateFloating();
		d.getRateRepo();
		d.getRateType();
		d.getSpread();
		d.getStatus();
		d.getString("COD_MFAMILY");
		d.getSumDeroghe();
		d.getTmsIns();
		d.getTmsTrade();
		
		
			}

	@Test
	public void testLoad2() throws Exception {
		PojoTestUtils.validate(DealMurexStructure.class);
		JsonDealObject j = new JsonDealObject();
		String csvResults =
		
		  "45130301,45130301_MT_REPO_CORP,LIVE,31-01-2022 00:00:00,Y,MT_REPO_CORP,PURI,Repo BD,REPO,31-01-2022 18:33:01,02-02-2022 00:00:00,18:33:01,01-02-2022 00:00:00,01-02-2022 00:00:00,31-01-2022 00:00:00,-33436807.23,-0.5274,33436317.35,34294513,34.294513,EUR,B,EU 0 22APR31,,,,,,,MUREXBO,0,0,45130301,1,TRM_20220131_C0141,0,IRD,REPO,BT,,15-03-2022 18:17:09,MUREX\n"
		+ "45130302,45130302_MT_REPO_CORP,LIVE,31-01-2022 00:00:00,Y,MT_REPO_CORP,FI_HEDGE_CERT,Repo BD,REPO,31-01-2022 18:33:01,02-02-2022 00:00:00,18:33:01,01-02-2022 00:00:00,01-02-2022 00:00:00,31-01-2022 00:00:00,-9495519.72,-0.385,9495418.17,9686610,9.68661,EUR,B,UCGIM VAR 5JUL29,,,,,,,MUREXBO,0,0,45130302,1,TRM_20220131_C0139,0,IRD,REPO,BT,,15-03-2022 18:17:09,MUREX\n";
		ResultSet rs = new Csv().read(new StringReader(csvResults), new String[] {      "NB","ID_DEAL","STATUS","DT_RIF","FL_INTERNAL","COD_FOLDER","PARTY_ID","COD_DEAL_TYPE","COD_MTYPE","DT_TRADE","DT_VALUE","TMS_TRADE","DT_MATURITY","DT_UNADJUSTED","DT_BOOKING","AMOUNT","RATE","AMOUNT_REPO","AMOUNT_GLOBAL","PRINCIPAL","COD_BASE_CCY","COD_BUY_SELL","INSTRUMENT_ID","DES_COMMENT","DES_COMMENT_SOURCE1","DES_COMMENT_SOURCE2","DES_COMMENT_DESTINATION","DES_COMMENT_DESTINATION1","DES_COMMENT_DESTINATION2","ID_USER","PKG_NUMBER","ID_DEAL_PARENT_FE","ID_DEAL_MASTER_FE","ID_DEAL_VER_FE","ID_GID_FE","NB_EXT","COD_MFAMILY","COD_MGROUP","BT_MLT","OPER_TYPE","TMS_INS","SOURCE"});
		
		
		j.load(rs);
		j.getDealList();
		DealMurexStructure d = (DealMurexStructure) j.getDealList(0);
		j.getRow(0);
		d.getAmount();
		d.getCodBaseCcy();
		d.getCodBuySell();
		d.getCodFolder();
		d.getCodMfamily();
		d.getCodMgroup();
		d.getCodMtype();
		d.getDesComment();
		d.getDtBooking();
		d.getDtMaturity();
		d.getDtRif();
		d.getDtTrade();
		d.getDtValue();
		d.getFlInternal();
		d.getIdDeal();
		d.getIdDealMasterFe();
		d.getIdDealParentFe();
		d.getInstrumentId();
		d.getJson();
		d.getOperType();
		d.getPartyId();
		d.getPrincipal();
		d.getRate();
		d.getStatus();
		d.getString("COD_MFAMILY");
		d.getTmsIns();
		d.getAmount1();
		d.getAmountGlobal();
		d.getCodDealType();
		d.getCodFolder();
		d.getDesCommentDestination();
		d.getDesCommentSource();
		d.getDouble("PRINCIPAL");
		d.getDtTradeTrunc();
		d.getIdDealVerFe();
		d.getIdG();
		d.getIdUser();
		d.getMargin();
		d.getNb();
		d.getNbExt();
		d.getPayout();
		d.getPkgNumber();
		

	}
	@Test
	public void testSize() {
		JsonDealObject j = new JsonDealObject();
		assertNotNull(j.size());
	}
	
	

}
