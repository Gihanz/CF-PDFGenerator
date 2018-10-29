package com.sl.mk.cf.Util;

import java.io.InputStream;
import java.util.Properties;

import javax.security.auth.Subject;



public class DocumentUtil {/*
	
	private String uname = null;
	private String password = null;
	private String cp = null;
	private String ceuri = null;
	private String jaaspath = null;
	public static Logger log = Logger.getLogger(PEConnector.class);

    public static ObjectStore objectStore = null;

    public static Domain domain = null;
    public static Connection connection = null;

    public DocumentUtil()
    {
      try
      {
        PropertyReader pr = new PropertyReader();
        Properties prop = pr.loadPropertyFile();
        this.uname = prop.getProperty("USERNAME");
        this.password = prop.getProperty("PASSWORD");
        this.ceuri = prop.getProperty("CEURI");
        this.cp = prop.getProperty("CONNECTION");
        this.jaaspath = prop.getProperty("JAAS_PATH");
        System.out.println("Properties from Connection file is Uname is " + this.uname + " Password is " + this.password + " CE URI " + this.ceuri + " Connection point " + this.cp);
      }
      catch (Exception e)
      {
        System.out.println("Error Occured while initiating connector class");
      }
    }

    public static void main(String[] args)
    {
    	DocumentUtil ss=new DocumentUtil();
        ss.initialize();
        
        addDocumentWithPath("/FNB", "C:\\Users\\Administrator\\Desktop\\Sample.txt.txt",
                "text/plain", "NNN", "Document");
        
        File file = new File("C:\\Users\\gihanli\\Documents\\eclipse workpace CF Plugins\\PDFGenerator\\HelloWorld.pdf");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ss.addDocumentWithStream("/Business Loan/Documents", fis, "application/pdf", "My New Doc by gihan", "Document","6A38E70C4717FB4DBC6D2661B942D5CC");
    }

    public void initialize()
    {

        connection = Factory.Connection.getConnection(ceuri);
        Subject sub = UserContext.createSubject(connection, uname,password,"FileNetP8WSI");
        UserContext.get().pushSubject(sub);
        domain = Factory.Domain.getInstance(connection, null);
        objectStore = Factory.ObjectStore.fetchInstance(domain, "P8OBJST01", null);
        System.out.println("objectStore : " + objectStore.get_DisplayName());
    }

    public static void addDocumentWithPath(String folderPath, String filePath,
            String mimeType, String docName, String docClass) {

        Folder folder = Factory.Folder.fetchInstance(objectStore,
                folderPath, null);

        System.out.println("\n\n Folder ID: " + folder.get_Id());
        // Document doc = Factory.Document.createInstance(os, classId);

        Document doc = CEUtil.createDocWithContent(new File(filePath), mimeType, 
                objectStore, docName, docClass);

        doc.save(RefreshMode.REFRESH);

        doc = CEUtil.createDocNoContent(mimeType, objectStore, docName, docClass);
        doc.save(RefreshMode.REFRESH);
        CEUtil.checkinDoc(doc);
        ReferentialContainmentRelationship rcr = CEUtil.fileObject(objectStore, doc, folderPath);
        rcr.save(RefreshMode.REFRESH);

    }

    public void addDocumentWithStream(String folderPath,
            InputStream inputStream, String mimeType, 
            String docName, String docClass, String WobNum) {

        Folder folder = Factory.Folder.fetchInstance(objectStore,
                folderPath, null);

        System.out.println("Folder ID : " + folder.get_Id());
        // Document doc = Factory.Document.createInstance(os, classId);

        Document doc = Factory.Document.createInstance(objectStore, null);

        ContentElementList contEleList = Factory.ContentElement.createList();
        ContentTransfer ct = Factory.ContentTransfer.createInstance();

        ct.setCaptureSource(inputStream);
        ct.set_ContentType(mimeType);
        ct.set_RetrievalName(docName);
        contEleList.add(ct);

        doc.set_ContentElements(contEleList);
        doc.getProperties().putValue("DocumentTitle", docName);

        doc.set_MimeType(mimeType);
        doc.checkin(AutoClassify.AUTO_CLASSIFY, CheckinType.MAJOR_VERSION);
        doc.save(RefreshMode.REFRESH);

        ReferentialContainmentRelationship rcr = folder.file(doc,
                AutoUniqueName.AUTO_UNIQUE, docName, 
                DefineSecurityParentage.DO_NOT_DEFINE_SECURITY_PARENTAGE);
        rcr.save(RefreshMode.REFRESH);
        System.out.println("Version Series ID : "+doc.get_VersionSeries().get_Id());
        
        //rcr.get
        

        doc.save(RefreshMode.REFRESH);

        doc = CEUtil.createDocNoContent(mimeType, objectStore, docName, docClass);

        CEUtil.checkinDoc(doc);
        ReferentialContainmentRelationship rcr = CEUtil.fileObject(objectStore, doc, folderPath);
        rcr.save(RefreshMode.REFRESH);
        
        VWSession vwSession = null;
        Connection conn = Factory.Connection.getConnection(ceuri);
        Subject subject = UserContext.createSubject(conn, uname, password, "FileNetP8WSI");
        System.out.println("Subject Created");
        UserContext uc = UserContext.get();
        uc.pushSubject(subject);
        System.out.println(">>>>>>>>>>>>>>>>>>>>> "+uname+" - "+password+" - "+cp);
        try
        {   	
        	System.setProperty("java.security.auth.login.config", jaaspath);
     
        	vwSession = new VWSession();
        	vwSession.setBootstrapCEURI(ceuri);
        	vwSession.logon(uname, password, cp);
        	
        	System.out.println("Is Logged to CE : "+vwSession.isLoggedOn());

        	VWRoster roster = vwSession.getRoster("BusinessLoanRoster");
        	System.out.println(roster);
            roster.setBufferSize(1);
            Object[] queryMin = new Object[5];
            Object[] queryMax = new Object[5];
            queryMin[0] = WobNum;
            queryMax[0] = WobNum;
            
            VWRosterQuery query = roster.createQuery("F_WobNum", queryMin, queryMax, 100, null, null, 1);
          
          log.info("queries returned for this Query  " + query.fetchCount());
          System.out.println("fetchCount : "+query.fetchCount());
          
          VWWorkObject vwStepElement = (VWWorkObject)query.next();
          
          VWStepElement stepElement1 = vwStepElement.fetchStepElement();
          stepElement1.doLock(true);
         // VWAttachment[] vwattach = (VWAttachment[]) stepElement1.getParameterValue("LoanDocuments");
          VWParameter[] ss =stepElement1.getParameters(VWFieldType.FIELD_TYPE_ATTACHMENT, VWStepElement.FIELD_USER_DEFINED);
          VWAttachment[] finalatt=null;
          
          for(VWParameter qwe : ss)
          {
        	  
        	  if(qwe.getName().equalsIgnoreCase("LoanDocuments"))
        	  {
        		   finalatt = (VWAttachment[]) qwe.getValue();
        	  }
          }
          VWAttachment settingAttachments[]=new VWAttachment[finalatt.length+1]; 
          int j=0;
          for(VWAttachment attach: finalatt)
          {
          	settingAttachments[j]=attach;
          	j++;
          } 
          VWAttachment myattach = new VWAttachment();
          
          settingAttachments[j]=myattach;
        //  vwattach[3] = new VWAttachment();
          myattach.setId(doc.get_VersionSeries().get_Id().toString());    /// this should be document version series id after uploading document to CE
          myattach.setLibraryName("P8OBJST01");
          myattach.setLibraryType(VWLibraryType.LIBRARY_TYPE_CONTENT_ENGINE);
          myattach.setAttachmentDescription("Case Details Document");
          myattach.setType(VWAttachmentType.ATTACHMENT_TYPE_DOCUMENT);
          
          //finalatt[0]=myattach;
          stepElement1.setParameterValue("LoanDocuments", settingAttachments, false);
          stepElement1.doSave(true);
        }catch (Exception e)
        {
        	e.fillInStackTrace();
        	log.error("Error Occured While Getting WorkObject");
        }finally
        {
            disconnect(vwSession);
        }
 
    }
    
    public void disconnect(VWSession session)
    {
      if (log.isDebugEnabled()) {
        log.debug("> disconnect PE");
      }
      if ((session != null) && (session.isLoggedOn()))
      {
        log.info("Inside PE Logging OFF");
        session.logoff();
        session = null;
      }
      if (log.isDebugEnabled()) {
        log.debug("< disconnected PE Successfully");
      }
    }

    public ObjectStore getObjecctStore()
    {
        if (objectStore != null) {
            return objectStore;
        }

        // Make connection.
        com.filenet.api.core.Connection conn = Factory.Connection
                .getConnection(ceuri);
        Subject subject = UserContext.createSubject(conn,uname, password, null);
        UserContext.get().pushSubject(subject);

        try {
            // Get default domain.
            Domain domain = Factory.Domain.getInstance(conn, null);


            // Get object stores for domain.
            objectStore = Factory.ObjectStore.fetchInstance(domain, "TARGET",
                    null);

            System.out.println("Connection to Content Engine successful !!");
        } finally {
            UserContext.get().popSubject();
        }

        return objectStore;

    }

*/}