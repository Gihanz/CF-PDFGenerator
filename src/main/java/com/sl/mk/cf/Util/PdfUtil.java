package com.sl.mk.cf.Util;

public class PdfUtil {
	
	/*============================= New Loan Granting =============================*/
	
	public static String[] FacilityInfo = {"Reference Number","Loan Amount (Rs)","Peroid Of Loan (Month)","Rate Of Intrest (%)","Service Charges","Proposed Service Charge","Purpose Of Loan","Detailed Loan Purpose","Repayment Mode","Repayment Type"};
	public static String[] Facilitydetails = {"ReferenceNumber","LoanAmount","PeriodOfLoan","RateofInterest","ServiceCharge","UserEnteredServiceCharge","PurposeOftheLoan","DetailLoanPurpose","RepaymentMode","RepaymentType"};
	
	public static String[] InitialChargesInfo = {"Legal charges (Rs)","Stamp duty (Rs)","Stamp duty on mortgage bonds (Rs)","Individual crib charges (Rs)","Company crib charges (Rs)","Fund transfer fees (Rs)","RMV charges (Rs)","Other charges (Rs)"};
	public static String[] InitialChargesdetails = {"IC_LegalCharges","IC_StampDuty","IC_StampDutyOnMortgageBonds","IC_IndividualCribCharges","IC_CompanyCribCharges","IC_FundTransferFees","IC_RMVCharges","IC_OtherCharges"};

	public static String[] RepayInfo = {"Installment Number","Number of Installments","Interest Portion (Rs)","Capital Portion (Rs)","Installment Value (Rs)","Outstanding (Rs)"};
	public static String[] RepayDetails = {"RT_InstallementNo","RT_NoOfInstallments","RT_CapitalPortion","RT_InterestPortion","RT_Installementvalue","RT_Outstanding"};
	
	public static String[] ClientInfo = {"Business Ownership Structure","NIC / BR No","Name of Business","Business Sector","Business Subsector","Date of Registration","Registered Address (line 1)","Registered Address (line 2)","Registered Address (line 3)","City","Postal Code","Operating Address (line 1)","Operating Address (line 2)","Operating Address (line 3)","Operating City","Operating Postal Code","Contact Person","Mobile No","Residence No","Office No","Fax No","Email"};
	public static String[] ClientDetails = {"Ownership","BRNo","BusinessName","BusinessSector","BusinessSubsector","DateofRegistration","BusinessApplicant_Address1","BusinessApplicant_Address2","BusinessApplicant_Address3","BusinessApplicant_City","BusinessApplicant_PostalCode","BusinessApplicant_OperatingAdd1","BusinessApplicant_OperatingAdd2","BusinessApplicant_OperatingAdd3","BusinessApplicant_OperatingCity","BusinessApplicant_OperatingPostalCode","BusinessApplicant_ContactPerson","BusinessApplicant_Mobile","BusinessApplicant_Residence","BusinessApplicant_Office","BusinessApplicant_Fax","BusinessApplicant_Email"};
	
	public static String[] soleprop = {"NIC","Status","DOB","Title","Initials","Full Name","Designation"};
	public static String[] solepropVal = {"NICNumber","BlackListedClient","DateofBirth","Title","Initials","FullName","ClientDesignation"};
	
	public static String[] soleprop2 = {"Address1","Address2","Address3","City","Postal Code","Mobile No","Land No","Office","Email","Relationship to Client"};
	public static String[] solepropVal2 = {"Address1","Address2","Address3","City","PostalCode","Mobile","LandNo","Office","Email","RelationshiptoClient"};
	
	public static String[] soleprop3 = {"Assets Owned"};
	public static String[] solepropVal3 = {"AssetsOwned"};
	
	public static String[] OwnerInfo = {"NIC/BR No","Name of Business","Constitution","Date of Registration","Description of Business"};
	public static String[] OwnerDetails = {"OtherCompanies_BRNumber","OtherCompanies_NameoftheBusiness","OtherCompanies_Constitution","OtherCompanies_DateofRegistration","OtherCompanies_DescriptionofBusiness"};
	
	public static String[] ExposureInfo = {"NIC/BR No","Contact No","Type of Facility","Status","Amount Financed (Rs)","Stock Balance (Rs)","Renatal Arrears (Rs)","Renatals in Arrears (Rs)"};
	public static String[] ExposureDetails = {"EE_NICNumber","EE_ContractNo","EE_TypeofFacility","EE_Status","EE_AmountFinanced","EE_StockBalance","EE_RentalArrears","EE_RentalsInArrears"};
	
	public static String[] ExposureOtherInfo = {"Total Stock Balanace (Rs)","Comment"};
	public static String[] ExposureOtherDetails = {"Total","EE_Comments"};

	public static String[] PersonalGuarantorsInfo = {"NIC","Status","DOB","Title","Initials","Full Name","Address1","Address2","Address3","City","Postal Code"};
	public static String[] PersonalGuarantorsDetails = {"Guarantors_NIC","Guarantors_BlackListedClient","Guarantors_DateofBirth","Guarantors_Title","Guarantors_Initials","Guarantors_FullName","Guarantors_Address1","Guarantors_Address2","Guarantors_Address3","Guarantors_City","Guarantors_PostalCode"};
	
	public static String[] PersonalGuarantorsInfo2 = {"Mobile No","Land No","Office","Relationship to Client","Occupation","Monthli Net Income (Rs)","Average Monthly Bank Transactions (Rs)"};
	public static String[] PersonalGuarantorsDetails2 = {"Guarantors_Mobile","Guarantors_Residence","Guarantors_Office","Guarantors_RelationshiptoClient","Guarantors_Occupation","Guarantors_MonthlyNetIncome","Guarantors_AverageMonthlyBankTransactions"};
	
	public static String[] PersonalGuarantorsInfo3 = {"Assets Owned"};
	public static String[] PersonalGuarantorsDetails3 = {"Guarantors_AssetsOwned"};
	
	public static String[] promissoryNoteInfo = {"Promissory note value (Rs)","Comment"};
	public static String[] promissoryNoteDetails = {"PromissoryNoteValue","Promissory_Comments"};

	public static String[] MovInfo = {"Registration No","Engine number","Chassis number","Make","Model","Value (Rs)","Comment"};
	public static String[] MovDetails = {"MortgageoverVehicles_RegistrationNumber","MortgageoverVehicles_EngineNumber","MortgageoverVehicles_ChassisNumber","MortgageoverVehicles_Make","MortgageoverVehicles_Model","MortgageoverVehicles_Value","MortgageoverVehicles_Comments"};
	
	public static String[] pDChequesInfo = {"Number of PD Cheques"};
	public static String[] pDChequesDetails = {"NumberofPDcheques"};
	
	public static String[] MopInfo = {"Deed number","Address","Extent","Estimated value (Rs)","Market value (Rs)","Forced value (Rs)","Comment"};
	public static String[] MopDetails = {"MortgageoverProperty_DeedNumber","MortgageoverProperty_Address","MortgageoverProperty_Extent","MortgageoverProperty_EstimatedValue","MortgageoverProperty_MarketValue","MortgageoverProperty_ForcedSalevalue","MortgageoverProperty_Comments"};
	
	public static String[] aeAssInfo = {"Registration number","Chassis no","Engine no","Make","Model","Contract number","Market value (Rs)","Forced value (Rs)","Comment"};
	public static String[] aeAssDetails = {"AssignmentofExistingAssets_RegistrationNumber","AssignmentofExistingAssets_ChassisNo","AssignmentofExistingAssets_EngineNo","AssignmentofExistingAssets_Make","AssignmentofExistingAssets_Model","AssignmentofExistingAssets_ContractNumber","AssignmentofExistingAssets_Marketvalue","AssignmentofExistingAssets_ForcedSalevalue","AssignmentofExistingAssets_Comments"};
	
	public static String[] podvInfo = {"Chassis no","Engine no","Make","Model","Vehicle value (Rs)","Comment"};
	public static String[] podvDetails = {"Podv_ChassisNo","Podv_EngineNo","Podv_Make","Podv_Model","Podv_VehicleValue","Podv_Comments"};
	
	public static String[] momInfo = {"Serial Number","Make","Model","Market value (Rs)","Forced value (Rs)","Comment"};
	public static String[] momDetails = {"MOM_SerialNumber","MOM_Make","MOM_Model","MOM_MarketValue","MOM_ForcedValue","MOM_Comments"};
	
	public static String[] lodInfo = {"Deposit Number","Branch","Certificate Number","Fixed Deposit Amount (Rs)","Period","Maturity Date","Comment"};
	public static String[] lodDetails = {"LOD_DepositNumber","LOD_Branch","LOD_CertificateNumber","LOD_FixedDepositAmount","LOD_Period","LOD_MaturityDate","LOD_Comments"};
	
	public static String[] mortgageOfStocksInfo = {"Stock value (Rs)","Location","Comments"};
	public static String[] mortgageOfStocksDetails = {"MortgageofStocks_Stockvalue","MortgageofStocks_Location","MortgageofStocks_Comments"};
	
	public static String[] abodInfo = {"Value of book debts","Comments"};
	public static String[] abodDetails = {"Valueofbookdebts","AOBD_Comments"};
	
	public static String[] otherCovenantsInfo = {"Comments"};
	public static String[] otherCovenantsDetails = {"Othercovenants_Comments"};
	
	public static String[] BusinessBackgroundTabInfo = {"Year of Commencement of Business","Industry Experience","Business Type","No. of Branches/Factories/Outlets","Involvement of Family Members","Description of Location","Description of Buildings","Description of Products /Services offered","Availability of infrastructure","Description of the equipment and machinery in use","Value of stocks","Insurance Of premises/machinery/Stocks","Current level of production/ Customers serviced","Limitations of current processes","Raw Material Used","Purchase of Raw Materials/Supplies","Credit period offered by the suppliers","Total value of creditors","Total value of debtors","Distribution and Delivery of Products","Any other details","Names and description of main buyers/market","Market Share","Competitive advantage of the company","Credit Period offered to Buyers","Names of the competitors","Availability of substitutes","Selling Price","Management details","Succession plan","Total No. of employees","Office","Factory","Management Risk","Business Risk","Credit Risk","Market Risk","Environmental Risk"};
	public static String[] BusinessBackgroundTabDetails = {"YearofCommencementofBusiness","IndustryExperience","BusinessType","NoofBranches","InvolvementofFamilyMembers","DescriptionofLocation","DescriptionofBuildings","DescriptionofProducts","Availabilityofinfrastructure","Descriptionoftheequipment","ValueofStocks","InsuranceOfpremises","Currentlevelofproduction","BB_Limitationsofcurrentprocesses","BB_RawMaterialUsed","BB_PurchaseofRawMaterials","BB_Creditperiodofferedbythesuppliers","BB_Totalvalueofcreditors","BB_Totalvalueofdebtors","BB_DistributionandDeliveryofProducts","BB_Anyotherdetails","BB_Descriptionofmainbuyers","BB_MarketShare","BB_Competitiveadvantageofthecompany","BB_CreditPeriodofferedtoBuyers","BB_Namesofthecompetitors","BB_Availabilityofsubstitutes","BB_SellingPrice","BB_Managementdetails","BB_Successionplan","BB_TotalNoofemployees","BB_Office","BB_Factory","BB_ManagementRisk","BB_BusinessRisk","BB_CreditRisk","BB_MarketRisk","BB_EnvironmentalRisk"};
	
	public static String[] finantial1Info = {"Name of Client","A/C No","Name of Bank"};
	public static String[] finantial1Details = {"FP_Nameoftheclient","FP_ACNo","FP_NameoftheBank"};
		
	public static String[] finantialPerfomance1Info = {"Month","Opening Balance","Deposits (Rs)","Withdrawals (Rs)","Closing Balance"};
	public static String[] finantialPerfomance1Details = {"FP_Month","FP_OpeningBalance","FP_Deposits","FP_Withdrawals","FP_ClosingBalance"};

	public static String[] finantial2Info = {"Name of Client","A/C No","Name of Bank"};
	public static String[] finantial2Details = {"FP_NameoftheclientTwo","FP_ACNoTwo","FP_NameoftheBankTwo"};
		
	public static String[] finantialPerfomance2Info = {"Month","Opening Balance","Deposits (Rs)","Withdrawals (Rs)","Closing Balance"};
	public static String[] finantialPerfomance2Details = {"FP_MonthTwo","FP_OpeningBalanceTwo","FP_DepositsTwo","FP_WithdrawalsTwo","FP_ClosingBalanceTwo"};

	public static String[] finantial3Info = {"Name of Client","A/C No","Name of Bank"};
	public static String[] finantial3Details = {"FP_NameoftheclientThree","FP_ACNoThree","FP_NameoftheBankThree"};
		
	public static String[] finantialPerfomance3Info = {"Month","Opening Balance","Deposits (Rs)","Withdrawals (Rs)","Closing Balance"};
	public static String[] finantialPerfomance3Details = {"FP_MonthThree","FP_OpeningBalanceThree","FP_DepositsThree","FP_WithdrawalsThree","FP_ClosingBalanceThree"};

	public static String[] finantial4Info = {"Name of Client","A/C No","Name of Bank"};
	public static String[] finantial4Details = {"FP_NameoftheclientFour","FP_ACNoFour","FP_NameoftheBankFour"};
		
	public static String[] finantialPerfomance4Info = {"Month","Opening Balance","Deposits (Rs)","Withdrawals (Rs)","Closing Balance"};
	public static String[] finantialPerfomance4Details = {"FP_MonthFour","FP_OpeningBalanceFour","FP_DepositsFour","FP_WithdrawalsFour","FP_ClosingBalanceFour"};

	public static String[] finantial5Info = {"Name of Client","A/C No","Name of Bank"};
	public static String[] finantial5Details = {"FP_NameoftheclientFive","FP_ACNoFive","FP_NameoftheBankFive"};
		
	public static String[] finantialPerfomance5Info = {"Month","Opening Balance","Deposits (Rs)","Withdrawals (Rs)","Closing Balance"};
	public static String[] finantialPerfomance5Details = {"FP_MonthFive","FP_OpeningBalanceFive","FP_DepositsFive","FP_WithdrawalsFive","FP_ClosingBalanceFive"};
	
	public static String[] averageInfo = {"Average Monthly Deposit (Rs)","Average Monthly Withdrawal (Rs)"};
	public static String[] averageDetails = {"FP_AverageMonthlyDeposits","FP_AverageMonthlyWithdrawals"};
	
	public static String[] businessIncomeInfo = {"Total Income","Cost of sales","Gross Profit","Electricity","Water","Transport","Salaries","Rent","Insurance","Living Expense","Other Expense","Total Expenses","Existing Commitments","Proposed Instalment","Net Saving","Comments related to any other income"};
	public static String[] businessIncomeDetails = {"FP_Totalincome","FP_Costofsales","FP_GrossProfit","FP_Electricity","FP_Water","FP_Transport","FP_Salaries","FP_Rent","FP_Insurance","FP_LivingExpenses","FP_Other","FP_Expenses","FP_Existingfinancialcommitments","FP_ProposedInstallment","FP_NetSaving","FP_Comments"};
	
	public static String[] PayeeInfo = {"NIC/BR No","Payment Method","Account No","Payee Name","Name of Bank","Branch","Type of Account"};
	public static String[] PayeeDetails = {"Payee_NICNumber","Payee_PaymentMethod","Payee_AccountNumber","Payee_AccountName","Payee_NameOfTheBank","Payee_Branch","Payee_AccountType"};
	
	
	/*============================= Subsequent disbursement =============================*/
	
	public static String[] MAInfo = {"Reference Number","Business Name","NIC / BR Number","MA Number","Total Amount","Validity Period","Existing SD Exposure"};
	public static String[] MADetails = {"ReferenceNumber","BusinessName","BRNo","MasterAgreementNumber","TotalLoanAmount","ValidityPeriod","ExistingExposure"};
	
	public static String[] ExistingSDExposureInfo = {"Contract No","Type of Facility","Status","Amount Financed","Stock Balance","Rental Arrears","Rentals In Arrears"};
	public static String[] ExistingSDExposureDetails = {"EE_SD_ContractNo","EE_SD_TypeofFacility","EE_SD_Status","EE_SD_AmountFinanced","EE_SD_StockBalance","EE_SD_RentalArrears","EE_SD_RentalsInArrears"};
	
	public static String[] FacilitySDInfo = {"SD Loan Amount (Rs.)","Peroid Of Loan (Month)","Rate Of Intrest (%)","Service Charges","Proposed Service Charge","Purpose Of Loan","Detailed Loan Purpose","Repayment Mode","Repayment Type"};
	public static String[] FacilitySDdetails = {"LoanAmount","PeriodOfLoan","RateofInterest","ServiceCharge","UserEnteredServiceCharge","PurposeOftheLoan","DetailLoanPurpose","RepaymentMode","RepaymentType"};
	
	
	/*============================= Rescheduling of Loan =============================*/
	
	public static String[] existingLoanInfo = {"Reference Number","Business Name","NIC / BR Number","Loan Number","MA Number","Stock Amount","Valid Till","Rescheduling Amount","Reason for Rescheduling"};
	public static String[] existingLoanDetails = {"ReferenceNumber","BusinessName","BRNo","LoanNo","MasterAgreementNumber","StockAmount","ValidityPeriod","ReschedulingAmount","ReasonForRescheduling"};
	
	public static String[] FacilityRLInfo = {"Rescheduling Loan Amount (Rs.)","Peroid Of Loan (Month)","Rate Of Intrest (%)","Service Charges","Proposed Service Charge","Repayment Mode","Repayment Type"};
	public static String[] FacilityRLdetails = {"LoanAmount","PeriodOfLoan","RateofInterest","ServiceCharge","UserEnteredServiceCharge","RepaymentMode","RepaymentType"};
	
	
}
