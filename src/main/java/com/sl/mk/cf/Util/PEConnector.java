package com.sl.mk.cf.Util;





public class PEConnector
{/*
  private String uname = null;
  private String password = null;
  private String cp = null;
  private String ceuri = null;
  private String jaaspath = null;
  public static Logger log = Logger.getLogger(PEConnector.class);
  
  public PEConnector()
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
  
  public Map<String, Object> getWorkObjectByWobNum(String WobNum, String rost)
  {
    Map<String, Object> obj = new HashMap<String, Object>();
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

    	VWRoster roster = vwSession.getRoster(rost);
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
      VWDataField[] ss = vwStepElement.getDataFields(767, 1);
      log.info("Retrived Field  Legnth is" + ss.length);
      
      for (int i = 0; i < ss.length; i++)
      {
        log.trace("Name" + ss[i].getName());
        log.trace("value" + ss[i].getStringValue());
        if ((ss[i].getValue() instanceof Double)) {
          obj.put(ss[i].getName(), (Double)ss[i].getValue());
        } else if ((ss[i].getValue() instanceof Boolean)) {
          obj.put(ss[i].getName(), (Boolean)ss[i].getValue());
        } else if ((ss[i].getValue() instanceof Float)) {
          obj.put(ss[i].getName(), (Float)ss[i].getValue());
        } else if ((ss[i].getValue() instanceof String)) {
          obj.put(ss[i].getName(), ss[i].getStringValue());
        } else if ((ss[i].getValue() instanceof Date)) {
          obj.put(ss[i].getName(), ss[i].getValue().toString());
        } else if ((ss[i].getValue() instanceof Integer)) {
          obj.put(ss[i].getName(), (Integer)ss[i].getValue());
        } else if ((ss[i].getValue() instanceof String[])) {
          obj.put(ss[i].getName(), (String[]) ss[i].getValue());
        } else if ((ss[i].getValue() instanceof Integer[])) {
          obj.put(ss[i].getName(), (Integer[]) ss[i].getValue());
        } else if ((ss[i].getValue() instanceof Date[])) {
          obj.put(ss[i].getName(), (Date[]) ss[i].getValue());
        } else if ((ss[i].getValue() instanceof Double[])) {
          obj.put(ss[i].getName(), (Double[]) ss[i].getValue());
        } else if ((ss[i].getValue() instanceof Float[])) {
          obj.put(ss[i].getName(), (Float[]) ss[i].getValue());
        }else if ((ss[i].getValue() instanceof Boolean[])) {
          obj.put(ss[i].getName(), (Boolean[]) ss[i].getValue());
        }else {
          log.info("Key Not Avilable " + ss[i].getName());
        }
      }
      obj.put("F_StepName", vwStepElement.getStepName());
      obj.put("F_WobNum", vwStepElement.getWorkObjectNumber());
      obj.put("F_CreateTime", vwStepElement.getLaunchDate());
      obj.put("F_Originator", vwStepElement.getOriginator());

    }
    catch (Exception e)
    {
  e.fillInStackTrace();
  
      log.error("Error Occured While Getting WorkObject");
    }
    finally
    {
      disconnect(vwSession);
    }
    System.out.println(obj);
    return obj;
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
  
  public static void main(String[] args)
  {
    PEConnector ss = new PEConnector();
    ss.getWorkObjectByWobNum("6A38E70C4717FB4DBC6D2661B942D5CC", "BusinessLoanRoster");
  }
*/}

