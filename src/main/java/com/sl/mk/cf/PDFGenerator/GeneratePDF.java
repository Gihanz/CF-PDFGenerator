package com.sl.mk.cf.PDFGenerator;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sl.mk.cf.Util.DocumentUtil;
import com.sl.mk.cf.Util.PEConnector;

public class GeneratePDF
{
	
	public ByteArrayOutputStream nlcpGenerator(Map<String, Object> data, boolean isNL) throws FileNotFoundException, DocumentException
	{
		
		 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	      
		
		PDFService service = new PDFService();
		Document document = new Document(PageSize.A4, 36, 36, 80, 36);
		
		PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);	
		document.open();
		
		if(data.get("LoanType").equals("Subsequent Disbursement")){
			service.createMADetailTab(data, document);
			service.createSDFacilityTab(data, document);
			service.createExistingExposure(data, document);
			service.createSecurity(data, document);
				
		}else if(data.get("LoanType").equals("Reschedule of a Loan")){
			service.createExistingLoanDetailTab(data, document);
			service.createRLFacilityTab(data, document);
			service.createExistingExposure(data, document);
			service.createSecurity(data, document);
					
		}else{
			service.createFacilityTab(data, document);
			service.createClientInfoTab(data, document);
			service.createOtherCompaniesInfoTab(data, document);
			service.createExistingExposure(data, document);
			service.createSecurity(data, document);
			
			if(data.get("ClientType").equals("Non-Prime")){
				service.createBusinessBackground(data, document);
				service.createFinantialPerfomance(data, document);
			}
		}
		
		if(!data.get("LoanType").equals("Reschedule of a Loan")){
			service.createPayeeDetails(data, document);
		}
		
		document.close();
		writer.close();
		
		
		return byteArrayOutputStream;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		//GeneratePDF gp = new GeneratePDF();
		//PEConnector pecon = new PEConnector();
		
	//	Map<String, Object> mm = null ;
		//FileInputStream gihan  = gp.nlcpGenerator(pecon.getWorkObjectByWobNum("6A38E70C4717FB4DBC6D2661B942D5CC", "BusinessLoanRoster"), true);
		
		//DocumentUtil ss=new DocumentUtil();
       // ss.initialize();
      //  ss.addDocumentWithStream("/Business Loan/Documents", gihan, "application/pdf", "Credit Proposal Form", "Document","6A38E70C4717FB4DBC6D2661B942D5CC");
	}


}