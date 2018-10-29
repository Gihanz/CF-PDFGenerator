package com.sl.mk.cf.PDFGenerator;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.sl.mk.cf.Util.PdfUtil;

public class PDFService {


/*============================= New Loan Granting =============================*/
	
	public void createFacilityTab(Map<String, Object> data, Document document) throws DocumentException
	{
		PdfPTable facilitytable = new PdfPTable(3);
		facilitytable.addCell(addHeader(" ~ Facility Information ~"));
		singleFieldTable(facilitytable,PdfUtil.FacilityInfo,PdfUtil.Facilitydetails,data);
		PdfPTable facilitytable2 = new PdfPTable(3);
		facilitytable2.addCell(addSubHeader("Initial Charges"));
		singleFieldTable(facilitytable2,PdfUtil.InitialChargesInfo,PdfUtil.InitialChargesdetails,data);
		PdfPTable repaymentData =multiValueTable(PdfUtil.RepayInfo,PdfUtil.RepayDetails,data);

		facilitytable.setWidthPercentage(100); //Width 100%
		facilitytable.setWidths(new float[]{2f,0.3f,5f});//Column Width
		facilitytable.setSpacingBefore(20f);//Space before table		
		facilitytable.setSpacingAfter(10f);
		document.add(facilitytable);
		
		facilitytable2.setWidthPercentage(100); //Width 100%
		facilitytable2.setWidths(new float[]{3f,0.3f,4f});//Column Width
		facilitytable2.setSpacingBefore(20f);//Space before table		
		facilitytable2.setSpacingAfter(10f);
		document.add(facilitytable2);
		document.add(repaymentData);
		document.newPage();
		
	}
	

	public void createClientInfoTab(Map<String, Object> data, Document document) throws DocumentException
	{
		PdfPTable clientInfoTab = new PdfPTable(3);
		clientInfoTab.addCell(addHeader(" ~ Client Information ~"));
		singleFieldTable(clientInfoTab,PdfUtil.ClientInfo,PdfUtil.ClientDetails,data);
		PdfPTable clientInfoTab2 = new PdfPTable(3);
		clientInfoTab2.addCell(addSubHeader("Sole Proprietor / Partner / Director Details"));
		PdfPTable solePropTab  =multiValueTable(PdfUtil.soleprop,PdfUtil.solepropVal,data);
		PdfPTable solePropTab2  =multiValueTable(PdfUtil.soleprop2,PdfUtil.solepropVal2,data);
		PdfPTable solePropTab3  =multiValueTable(PdfUtil.soleprop3,PdfUtil.solepropVal3,data);
		
		clientInfoTab.setWidthPercentage(100); //Width 100%
		clientInfoTab.setWidths(new float[]{2f,0.3f,5f});//Column Width
		clientInfoTab.setSpacingBefore(20f);//Space before table		
		clientInfoTab.setSpacingAfter(10f);
		document.add(clientInfoTab);
		clientInfoTab2.setWidthPercentage(100); //Width 100%
		clientInfoTab2.setWidths(new float[]{4f,0.3f,5f});//Column Width
		clientInfoTab2.setSpacingBefore(20f);//Space before table		
		//clientInfoTab2.setSpacingAfter(10f);
		document.add(clientInfoTab2);
		document.add(solePropTab);
		document.add(solePropTab2);
		document.add(solePropTab3);
	//	document.newPage();
		
	}
	
	public void createOtherCompaniesInfoTab(Map<String, Object> data, Document document) throws DocumentException
	{
		PdfPTable otherCopaniesTab = new PdfPTable(3);
		otherCopaniesTab.addCell(addHeader(" ~ Other Companies Owned By Client ~"));
		
		PdfPTable other  =multiValueTable(PdfUtil.OwnerInfo,PdfUtil.OwnerDetails,data);
		
		otherCopaniesTab.setWidthPercentage(100); //Width 100%
		otherCopaniesTab.setWidths(new float[]{2f,0.3f,5f});//Column Width
		otherCopaniesTab.setSpacingBefore(20f);//Space before table		
		otherCopaniesTab.setSpacingAfter(10f);
		document.add(otherCopaniesTab);
		document.add(other);
	//	document.newPage();
		
	}
	
	public void createExistingExposure(Map<String, Object> data, Document document) throws DocumentException
	{
		PdfPTable existingE = new PdfPTable(3);
		existingE.addCell(addHeader(" ~ Exisiting Exposure ~"));
		
		PdfPTable ee  =multiValueTable(PdfUtil.ExposureInfo,PdfUtil.ExposureDetails,data);
		PdfPTable existingE2 = new PdfPTable(3);
		singleFieldTable(existingE2,PdfUtil.ExposureOtherInfo,PdfUtil.ExposureOtherDetails,data);
		
		existingE2.setWidthPercentage(100); //Width 100%
		existingE2.setWidths(new float[]{2f,0.3f,5f});//Column Width
		existingE2.setSpacingBefore(20f);//Space before table		
		existingE2.setSpacingAfter(10f);
		existingE.setWidthPercentage(100); //Width 100%
		existingE.setWidths(new float[]{2f,0.3f,5f});//Column Width
		existingE.setSpacingBefore(20f);//Space before table		
		existingE.setSpacingAfter(10f);
		
		document.add(existingE);
		document.add(ee);
		document.add(existingE2);
	//	document.newPage();
		
	} 
	
	public void createSecurity(Map<String, Object> data, Document document) throws DocumentException
	{
		PdfPTable securityE = new PdfPTable(3);
		securityE.addCell(addHeader(" ~ Security ~"));
		
		securityE.setWidthPercentage(100); //Width 100%
		securityE.setWidths(new float[]{2f,0.3f,5f});//Column Width
		securityE.setSpacingBefore(20f);//Space before table		
		document.add(securityE);
		
		if((Boolean) data.get("Guarantors")){
			
			PdfPTable personalG = new PdfPTable(3);
			personalG.addCell(addSubHeader("Personal Guarantors"));
			PdfPTable pg  =multiValueTable(PdfUtil.PersonalGuarantorsInfo,PdfUtil.PersonalGuarantorsDetails,data);
			PdfPTable pg2  =multiValueTable(PdfUtil.PersonalGuarantorsInfo2,PdfUtil.PersonalGuarantorsDetails2,data);
			PdfPTable pg3  =multiValueTable(PdfUtil.PersonalGuarantorsInfo3,PdfUtil.PersonalGuarantorsDetails3,data);
			
			personalG.setWidthPercentage(100); //Width 100%
			personalG.setWidths(new float[]{2f,0.3f,5f});//Column Width
			personalG.setSpacingBefore(20f);//Space before table		
			document.add(personalG);
			document.add(pg);
			document.add(pg2);
			document.add(pg3);
			
		}if((Boolean) data.get("PromissoryNote")){
			
			PdfPTable promissoryNote = new PdfPTable(3);
			promissoryNote.addCell(addSubHeader("Promissory note"));
			singleFieldTable(promissoryNote,PdfUtil.promissoryNoteInfo,PdfUtil.promissoryNoteDetails,data);
			
			promissoryNote.setWidthPercentage(100); //Width 100%
			promissoryNote.setWidths(new float[]{2f,0.3f,5f});//Column Width
			promissoryNote.setSpacingBefore(20f);//Space before table		
			document.add(promissoryNote);
			
		}if((Boolean) data.get("PDCheques")){
			
			PdfPTable pDCheques = new PdfPTable(3);
			pDCheques.addCell(addSubHeader("PD cheques"));
			singleFieldTable(pDCheques,PdfUtil.pDChequesInfo,PdfUtil.pDChequesDetails,data);
			
			pDCheques.setWidthPercentage(100); //Width 100%
			pDCheques.setWidths(new float[]{2f,0.3f,5f});//Column Width
			pDCheques.setSpacingBefore(20f);//Space before table		
			document.add(pDCheques);
			
		}if((Boolean) data.get("MortgageoverVehicles")){
			
			PdfPTable movG = new PdfPTable(3);
			movG.addCell(addSubHeader("Mortgage over vehicles"));
			PdfPTable mov  =multiValueTable(PdfUtil.MovInfo,PdfUtil.MovDetails,data);
			
			movG.setWidthPercentage(100); //Width 100%
			movG.setWidths(new float[]{2f,0.3f,5f});//Column Width
			movG.setSpacingBefore(20f);//Space before table		
			document.add(movG);
			document.add(mov);
			
		}if((Boolean) data.get("MortgageoverProperty")){
			
			PdfPTable mopG = new PdfPTable(3);
			mopG.addCell(addSubHeader("Mortgage over property"));
			PdfPTable mop  =multiValueTable(PdfUtil.MopInfo,PdfUtil.MopDetails,data);
			
			mopG.setWidthPercentage(100); //Width 100%
			mopG.setWidths(new float[]{2f,0.3f,5f});//Column Width
			mopG.setSpacingBefore(20f);//Space before table		
			document.add(mopG);
			document.add(mop);
			
		}if((Boolean) data.get("AssignmentofExistingAssets")){
			
			PdfPTable assignmentExistingAssets = new PdfPTable(3);
			assignmentExistingAssets.addCell(addSubHeader("Assignment of Existing Assets"));
			PdfPTable assExistingAssets  =multiValueTable(PdfUtil.aeAssInfo,PdfUtil.aeAssDetails,data);
			
			assignmentExistingAssets.setWidthPercentage(100); //Width 100%
			assignmentExistingAssets.setWidths(new float[]{2f,0.3f,5f});//Column Width
			assignmentExistingAssets.setSpacingBefore(20f);//Space before table		
			document.add(assignmentExistingAssets);
			document.add(assExistingAssets);
			
		}if((Boolean) data.get("PledgeoverDocumentsofVehicles")){
			
			PdfPTable podvG = new PdfPTable(3);
			podvG.addCell(addSubHeader("Pledge Over Documents of Vehicles"));
			PdfPTable podv  =multiValueTable(PdfUtil.podvInfo,PdfUtil.podvDetails,data);
			
			podvG.setWidthPercentage(100); //Width 100%
			podvG.setWidths(new float[]{2f,0.3f,5f});//Column Width
			podvG.setSpacingBefore(20f);//Space before table		
			document.add(podvG);
			document.add(podv);
			
		}if((Boolean) data.get("MortgageoverMachinery")){
			
			PdfPTable momG = new PdfPTable(3);
			momG.addCell(addSubHeader("Mortgage Over Machinery"));
			PdfPTable mom  =multiValueTable(PdfUtil.momInfo,PdfUtil.momDetails,data);
			
			momG.setWidthPercentage(100); //Width 100%
			momG.setWidths(new float[]{2f,0.3f,5f});//Column Width
			momG.setSpacingBefore(20f);//Space before table		
			document.add(momG);
			document.add(mom);
			
		}if((Boolean) data.get("LienoverDeposits")){
			
			PdfPTable lodG = new PdfPTable(3);
			lodG.addCell(addSubHeader("Lien Over Deposits"));
			PdfPTable lod  =multiValueTable(PdfUtil.lodInfo,PdfUtil.lodDetails,data);
			
			lodG.setWidthPercentage(100); //Width 100%
			lodG.setWidths(new float[]{2f,0.3f,5f});//Column Width
			lodG.setSpacingBefore(20f);//Space before table		
			document.add(lodG);
			document.add(lod);
			
		}if((Boolean) data.get("MortgageofStocks")){
			
			PdfPTable mortgageOfStocks = new PdfPTable(3);
			mortgageOfStocks.addCell(addSubHeader("Mortgage of Stocks"));
			singleFieldTable(mortgageOfStocks,PdfUtil.mortgageOfStocksInfo,PdfUtil.mortgageOfStocksDetails,data);
			
			mortgageOfStocks.setWidthPercentage(100); //Width 100%
			mortgageOfStocks.setWidths(new float[]{2f,0.3f,5f});//Column Width
			mortgageOfStocks.setSpacingBefore(20f);//Space before table		
			document.add(mortgageOfStocks);
			
		}if((Boolean) data.get("AssignmentoverBookDebts")){
			
			PdfPTable abod = new PdfPTable(3);
			abod.addCell(addSubHeader("Assignment Over Book Debts"));
			singleFieldTable(abod,PdfUtil.abodInfo,PdfUtil.abodDetails,data);
			
			abod.setWidthPercentage(100); //Width 100%
			abod.setWidths(new float[]{2f,0.3f,5f});//Column Width
			abod.setSpacingBefore(20f);//Space before table		
			document.add(abod);
			
		}if((Boolean) data.get("Othercovenants")){
			
			PdfPTable otherCovenants = new PdfPTable(3);
			otherCovenants.addCell(addSubHeader("Other Covenants"));
			singleFieldTable(otherCovenants,PdfUtil.otherCovenantsInfo,PdfUtil.otherCovenantsDetails,data);
			
			otherCovenants.setWidthPercentage(100); //Width 100%
			otherCovenants.setWidths(new float[]{2f,0.3f,5f});//Column Width
			otherCovenants.setSpacingBefore(20f);//Space before table		
			document.add(otherCovenants);
			
		}

	//	document.newPage();
		
	} 

	public void createBusinessBackground(Map<String, Object> data, Document document) throws DocumentException
	{
		PdfPTable businessBackgroundTab = new PdfPTable(3);
		businessBackgroundTab.addCell(addHeader(" ~ Business Background ~"));
		singleFieldTable(businessBackgroundTab,PdfUtil.BusinessBackgroundTabInfo,PdfUtil.BusinessBackgroundTabDetails,data);
		
		businessBackgroundTab.setWidthPercentage(100); //Width 100%
		businessBackgroundTab.setWidths(new float[]{4f,0.3f,5f});//Column Width
		businessBackgroundTab.setSpacingBefore(20f);//Space before table		
		businessBackgroundTab.setSpacingAfter(10f);
		document.add(businessBackgroundTab);
	//	document.newPage();
		
	}
	
	public void createFinantialPerfomance(Map<String, Object> data, Document document) throws DocumentException
	{
		PdfPTable finantialPerfomance1Tab = new PdfPTable(3);
		finantialPerfomance1Tab.addCell(addHeader(" ~ Finantial Perfomance ~"));
			
			finantialPerfomance1Tab.addCell(addSubHeader("Account 1"));
			singleFieldTable(finantialPerfomance1Tab,PdfUtil.finantial1Info,PdfUtil.finantial1Details,data);
			PdfPTable finantialPerfomance1Data =multiValueTable(PdfUtil.finantialPerfomance1Info,PdfUtil.finantialPerfomance1Details,data);
			
			finantialPerfomance1Tab.setWidthPercentage(100); //Width 100%
			finantialPerfomance1Tab.setWidths(new float[]{2f,0.3f,5f});//Column Width
			finantialPerfomance1Tab.setSpacingBefore(20f);//Space before table		
			finantialPerfomance1Tab.setSpacingAfter(10f);
			document.add(finantialPerfomance1Tab);
			document.add(finantialPerfomance1Data);
			
		if(data.get("FP_NameoftheclientTwo")!=null && !data.get("FP_NameoftheclientTwo").equals("")){
			
			PdfPTable finantialPerfomance2Tab = new PdfPTable(3);
			finantialPerfomance2Tab.addCell(addSubHeader("Account 2"));
			singleFieldTable(finantialPerfomance2Tab,PdfUtil.finantial2Info,PdfUtil.finantial2Details,data);
			PdfPTable finantialPerfomance2Data =multiValueTable(PdfUtil.finantialPerfomance2Info,PdfUtil.finantialPerfomance2Details,data);
			
			finantialPerfomance2Tab.setWidthPercentage(100); //Width 100%
			finantialPerfomance2Tab.setWidths(new float[]{2f,0.3f,5f});//Column Width
			finantialPerfomance2Tab.setSpacingBefore(20f);//Space before table		
			finantialPerfomance2Tab.setSpacingAfter(10f);
			document.add(finantialPerfomance2Tab);
			document.add(finantialPerfomance2Data);
			
		}if(data.get("FP_NameoftheclientThree")!=null && !data.get("FP_NameoftheclientThree").equals("")){
			
			PdfPTable finantialPerfomance3Tab = new PdfPTable(3);
			finantialPerfomance3Tab.addCell(addSubHeader("Account 3"));
			singleFieldTable(finantialPerfomance3Tab,PdfUtil.finantial3Info,PdfUtil.finantial3Details,data);
			PdfPTable finantialPerfomance3Data =multiValueTable(PdfUtil.finantialPerfomance3Info,PdfUtil.finantialPerfomance3Details,data);
			
			finantialPerfomance3Tab.setWidthPercentage(100); //Width 100%
			finantialPerfomance3Tab.setWidths(new float[]{2f,0.3f,5f});//Column Width
			finantialPerfomance3Tab.setSpacingBefore(20f);//Space before table		
			finantialPerfomance3Tab.setSpacingAfter(10f);
			document.add(finantialPerfomance3Tab);
			document.add(finantialPerfomance3Data);
			
		}if(data.get("FP_NameoftheclientFour")!=null && !data.get("FP_NameoftheclientFour").equals("")){
			
			PdfPTable finantialPerfomance4Tab = new PdfPTable(3);
			finantialPerfomance4Tab.addCell(addSubHeader("Account 4"));
			singleFieldTable(finantialPerfomance4Tab,PdfUtil.finantial4Info,PdfUtil.finantial4Details,data);
			PdfPTable finantialPerfomance4Data =multiValueTable(PdfUtil.finantialPerfomance4Info,PdfUtil.finantialPerfomance4Details,data);
			
			finantialPerfomance4Tab.setWidthPercentage(100); //Width 100%
			finantialPerfomance4Tab.setWidths(new float[]{2f,0.3f,5f});//Column Width
			finantialPerfomance4Tab.setSpacingBefore(20f);//Space before table		
			finantialPerfomance4Tab.setSpacingAfter(10f);
			document.add(finantialPerfomance4Tab);
			document.add(finantialPerfomance4Data);
			
		}if(data.get("FP_NameoftheclientFive")!=null && !data.get("FP_NameoftheclientFive").equals("")){
			
			PdfPTable finantialPerfomance5Tab = new PdfPTable(3);
			finantialPerfomance5Tab.addCell(addSubHeader("Account 5"));
			singleFieldTable(finantialPerfomance5Tab,PdfUtil.finantial5Info,PdfUtil.finantial5Details,data);
			PdfPTable finantialPerfomance5Data =multiValueTable(PdfUtil.finantialPerfomance5Info,PdfUtil.finantialPerfomance5Details,data);
			
			finantialPerfomance5Tab.setWidthPercentage(100); //Width 100%
			finantialPerfomance5Tab.setWidths(new float[]{2f,0.3f,5f});//Column Width
			finantialPerfomance5Tab.setSpacingBefore(20f);//Space before table		
			finantialPerfomance5Tab.setSpacingAfter(10f);
			document.add(finantialPerfomance5Tab);
			document.add(finantialPerfomance5Data);
			
		}

		PdfPTable averageTab = new PdfPTable(3);
		averageTab.addCell(addSubHeader("Current Account transaction summery (last 6 months)"));
		singleFieldTable(averageTab,PdfUtil.averageInfo,PdfUtil.averageDetails,data);
		
		PdfPTable businessIncomeTab = new PdfPTable(3);
		businessIncomeTab.addCell(addSubHeader("Business Income"));
		singleFieldTable(businessIncomeTab,PdfUtil.businessIncomeInfo,PdfUtil.businessIncomeDetails,data);

		averageTab.setWidthPercentage(100); //Width 100%
		averageTab.setWidths(new float[]{3f,0.3f,4f});//Column Width
		averageTab.setSpacingBefore(20f);//Space before table		
		averageTab.setSpacingAfter(10f);
		document.add(averageTab);
		
		businessIncomeTab.setWidthPercentage(100); //Width 100%
		businessIncomeTab.setWidths(new float[]{3f,0.3f,4f});//Column Width
		businessIncomeTab.setSpacingBefore(20f);//Space before table		
		businessIncomeTab.setSpacingAfter(10f);
		document.add(businessIncomeTab);
	//	document.newPage();
		
	}
	
	public void createPayeeDetails(Map<String, Object> data, Document document) throws DocumentException
	{
		PdfPTable payeeDetailsTab = new PdfPTable(3);
		payeeDetailsTab.addCell(addHeader(" ~ Payee Details ~"));
		
		PdfPTable payee  =multiValueTable(PdfUtil.PayeeInfo,PdfUtil.PayeeDetails,data);
		
		payeeDetailsTab.setWidthPercentage(100); //Width 100%
		payeeDetailsTab.setWidths(new float[]{2f,0.3f,5f});//Column Width
		payeeDetailsTab.setSpacingBefore(20f);//Space before table		
		payeeDetailsTab.setSpacingAfter(10f);
		document.add(payeeDetailsTab);
		document.add(payee);
	//	document.newPage();
		
	}
	
/*============================= Subsequent disbursement =============================*/
	
	public void createMADetailTab(Map<String, Object> data, Document document) throws DocumentException
	{
		PdfPTable MAtable = new PdfPTable(3);
		MAtable.addCell(addHeader(" ~ MA Details ~"));
		singleFieldTable(MAtable,PdfUtil.MAInfo,PdfUtil.MADetails,data);
		PdfPTable ExistingSDExposureData =multiValueTable(PdfUtil.ExistingSDExposureInfo,PdfUtil.ExistingSDExposureDetails,data);

		MAtable.setWidthPercentage(100); //Width 100%
		MAtable.setWidths(new float[]{2f,0.3f,5f});//Column Width
		MAtable.setSpacingBefore(20f);//Space before table		
		MAtable.setSpacingAfter(10f);
		document.add(MAtable);
		document.add(ExistingSDExposureData);
	//	document.newPage();
		
	}
	
	public void createSDFacilityTab(Map<String, Object> data, Document document) throws DocumentException
	{
		PdfPTable facilitytable = new PdfPTable(3);
		facilitytable.addCell(addHeader(" ~ Facility Details ~"));
		singleFieldTable(facilitytable,PdfUtil.FacilitySDInfo,PdfUtil.FacilitySDdetails,data);
		PdfPTable facilitytable2 = new PdfPTable(3);
		facilitytable2.addCell(addSubHeader("Initial Charges"));
		singleFieldTable(facilitytable2,PdfUtil.InitialChargesInfo,PdfUtil.InitialChargesdetails,data);
		PdfPTable repaymentData =multiValueTable(PdfUtil.RepayInfo,PdfUtil.RepayDetails,data);

		facilitytable.setWidthPercentage(100); //Width 100%
		facilitytable.setWidths(new float[]{2f,0.3f,5f});//Column Width
		facilitytable.setSpacingBefore(20f);//Space before table		
		facilitytable.setSpacingAfter(10f);
		document.add(facilitytable);
		
		facilitytable2.setWidthPercentage(100); //Width 100%
		facilitytable2.setWidths(new float[]{3f,0.3f,4f});//Column Width
		facilitytable2.setSpacingBefore(20f);//Space before table		
		facilitytable2.setSpacingAfter(10f);
		document.add(facilitytable2);
		document.add(repaymentData);
		document.newPage();
		
	}

/*============================= Rescheduling of Loan =============================*/
	
	public void createExistingLoanDetailTab(Map<String, Object> data, Document document) throws DocumentException
	{
		PdfPTable existingLoantable = new PdfPTable(3);
		existingLoantable.addCell(addHeader(" ~ Existing Loan Details ~"));
		singleFieldTable(existingLoantable,PdfUtil.existingLoanInfo,PdfUtil.existingLoanDetails,data);

		existingLoantable.setWidthPercentage(100); //Width 100%
		existingLoantable.setWidths(new float[]{2f,0.3f,5f});//Column Width
		existingLoantable.setSpacingBefore(20f);//Space before table		
		existingLoantable.setSpacingAfter(10f);
		document.add(existingLoantable);
	//	document.newPage();
		
	}
	
	public void createRLFacilityTab(Map<String, Object> data, Document document) throws DocumentException
	{
		PdfPTable facilitytable = new PdfPTable(3);
		facilitytable.addCell(addHeader(" ~ Requested Facility ~"));
		singleFieldTable(facilitytable,PdfUtil.FacilityRLInfo,PdfUtil.FacilityRLdetails,data);
		PdfPTable facilitytable2 = new PdfPTable(3);
		facilitytable2.addCell(addSubHeader("Initial Charges"));
		singleFieldTable(facilitytable2,PdfUtil.InitialChargesInfo,PdfUtil.InitialChargesdetails,data);
		PdfPTable repaymentData =multiValueTable(PdfUtil.RepayInfo,PdfUtil.RepayDetails,data);

		facilitytable.setWidthPercentage(100); //Width 100%
		facilitytable.setWidths(new float[]{3f,0.3f,5f});//Column Width
		facilitytable.setSpacingBefore(20f);//Space before table		
		facilitytable.setSpacingAfter(10f);
		document.add(facilitytable);
		
		facilitytable2.setWidthPercentage(100); //Width 100%
		facilitytable2.setWidths(new float[]{3f,0.3f,4f});//Column Width
		facilitytable2.setSpacingBefore(20f);//Space before table		
		facilitytable2.setSpacingAfter(10f);
		document.add(facilitytable2);
		document.add(repaymentData);
		document.newPage();
		
	}
	
	
	public PdfPCell addHeader(String headerName)
	{
		PdfPCell headerCell = new PdfPCell(new Phrase(headerName,FontFactory.getFont(FontFactory.defaultEncoding,18,Font.BOLDITALIC,BaseColor.WHITE)));
		headerCell.setColspan(3);
		headerCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		headerCell.setBorder(PdfPCell.NO_BORDER);
		headerCell.setBackgroundColor(new BaseColor(0, 38, 77));
		headerCell.setPaddingBottom(20f);
		headerCell.setBorderWidthBottom(10f);
		headerCell.setBorderColorBottom(BaseColor.WHITE);

		return headerCell;

	}
	
	public PdfPCell addSubHeader(String subHeaderName)
	{
		PdfPCell headerCell = new PdfPCell(new Phrase(subHeaderName,FontFactory.getFont(FontFactory.defaultEncoding,12,Font.BOLDITALIC,BaseColor.WHITE)));
		headerCell.setColspan(3);
		headerCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		headerCell.setBorder(PdfPCell.NO_BORDER);
		headerCell.setBackgroundColor(new BaseColor(54,148,255));
		headerCell.setPaddingBottom(20f);
		headerCell.setBorderWidthBottom(10f);
		headerCell.setBorderColorBottom(BaseColor.WHITE);

		return headerCell;

	}

	public void singleFieldTable(PdfPTable table,String[] labels,String[] values,Map<String, Object> pedata)
	{
		int labelLength = labels.length;

		for(int i=0; i <labelLength;i++) {

			PdfPCell cell1 = new PdfPCell(new Paragraph(labels[i],FontFactory.getFont(FontFactory.defaultEncoding,10,BaseColor.WHITE)));
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell1.setBackgroundColor(BaseColor.GRAY);
			cell1.setVerticalAlignment(Element.ALIGN_TOP);
			cell1.setPaddingBottom(5f);				

			PdfPCell cell2 = new PdfPCell(new Paragraph(":",FontFactory.getFont(FontFactory.defaultEncoding,14,BaseColor.WHITE)));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setBackgroundColor(BaseColor.GRAY);
			cell2.setVerticalAlignment(Element.ALIGN_TOP);
			cell2.setBorder(PdfPCell.NO_BORDER);
			cell2.setPaddingBottom(5f);
			
			String so=String.valueOf(pedata.get(values[i]));
			if(pedata.get(values[i]) instanceof Double){
				so= String.format ("%,.2f", pedata.get(values[i]));
			}
			
			if(labels[i] == "Repayment Type"){
				if((Boolean) pedata.get("Equated")){ so = "Equated";}
				else if((Boolean) pedata.get("GracePeriod")){ so = "Grace Period";}
				else if((Boolean) pedata.get("Stepup")){ so = "Step-Up";}
				else{ so = "Bullet";}
			}

			PdfPCell cell3 = new PdfPCell(new Paragraph(so,FontFactory.getFont(FontFactory.defaultEncoding,10)));
			cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell3.setVerticalAlignment(Element.ALIGN_TOP);
			cell3.setBorder(PdfPCell.NO_BORDER);
			cell3.setBackgroundColor(new BaseColor(235, 235, 224));
			cell3.setPaddingLeft(5f);
			cell3.setPaddingBottom(5f);

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);
		}
	}
	
	public PdfPTable multiValueTable(String[] mlabels,String[] mvalues,Map<String, Object> pedata)
	{
		
		int mlabelLen = mlabels.length;

		PdfPTable repETable = new PdfPTable(mlabelLen);
		for(int j=0;j<mlabelLen;j++) {
			PdfPCell repCell1 = new PdfPCell(new Paragraph(mlabels[j],FontFactory.getFont(FontFactory.defaultEncoding,10,Font.BOLDITALIC,BaseColor.WHITE)));
			repCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			repCell1.setBackgroundColor(BaseColor.GRAY);
			repCell1.setVerticalAlignment(Element.ALIGN_TOP);
			repCell1.setBorderWidth(1f);
			repCell1.setPaddingBottom(10f);
			repETable.addCell(repCell1);
		}
		
		JSONObject al = new JSONObject(pedata);

		for(int i=0;i<((JSONArray) al.get(mvalues[0])).length();i++) {

			for(int k=0;k<mvalues.length;k++) {
				
				String soo=String.valueOf(((JSONArray) al.get(mvalues[k])).get(i));
				if(((JSONArray) al.get(mvalues[k])).get(i) instanceof Double){
					soo= String.format ("%,.2f", ((JSONArray) al.get(mvalues[k])).get(i));
				}

				PdfPCell repCell2 = new PdfPCell(new Paragraph(soo,FontFactory.getFont(FontFactory.defaultEncoding,10)));
				repCell2.setHorizontalAlignment(Element.ALIGN_RIGHT);
				repCell2.setVerticalAlignment(Element.ALIGN_TOP);
				repCell2.setBackgroundColor(new BaseColor(235, 235, 224));
				repCell2.setPaddingBottom(10f);
				repCell2.setBorderWidth(1f);
				repETable.addCell(repCell2);
				
			}
		}
		
		repETable.setWidthPercentage(100); //Width 100%
		repETable.setSpacingBefore(20f);//Space before table		
		repETable.setSpacingAfter(10f);
		return repETable;
	}
	
}
