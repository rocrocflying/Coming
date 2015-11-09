package entity;

public class total {

	private int id;
    private int up;
   public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	// private String wc_id;
    private String wc_title;
    private String wc_address;
    private String wc_describe;
    //private int wc_count;
    private String wc_name;
    private String wc_email;
    public String getWc_email() {
		return wc_email;
	}
	private String wc_phone;
    private String wc_QQ;
    private String wc_weix;
    private String wc_begintime;
    private String wc_finsintime;
    private String wc_date;
    //private int wc_good;
    private String wc_src;
    
	
	public String getWc_title() {
		return wc_title;
	}
	public void setWc_title(String wc_title) {
		this.wc_title = wc_title;
	}
	public String getWc_address() {
		return wc_address;
	}
	public void setWc_address(String wc_address) {
		this.wc_address = wc_address;
	}
	public String getWc_describe() {
		return wc_describe;
	}
	public void setWc_describe(String wc_describe) {
		this.wc_describe = wc_describe;
	}
	public String getWc_name() {
		return wc_name;
	}
	public void setWc_name(String wc_name) {
		this.wc_name = wc_name;
	}
	public String QQ() {
		return wc_email;
	}
	public void setWc_email(String wc_email) {
		this.wc_email = wc_email;
	}
	public String getWc_phone() {
		return wc_phone;
	}
	public void setWc_phone(String wc_phone) {
		this.wc_phone = wc_phone;
	}
	public String getWc_QQ() {
		return wc_QQ;
	}
	public void setWc_QQ(String wc_QQ) {
		this.wc_QQ = wc_QQ;
	}
	public String getWc_weix() {
		return wc_weix;
	}
	public void setWc_weix(String wc_weix) {
		this.wc_weix = wc_weix;
	}
	public String getWc_begintime() {
		return wc_begintime;
	}
	public void setWc_begintime(String wc_begintime) {
		this.wc_begintime = wc_begintime;
	}
	public String getWc_finsintime() {
		return wc_finsintime;
	}
	public void setWc_finsintime(String wc_finsintime) {
		this.wc_finsintime = wc_finsintime;
	}
	public String getWc_date() {
		return wc_date;
	}
	public void setWc_date(String wc_date) {
		this.wc_date = wc_date;
	}
	public String getWc_src() {
		return wc_src;
	}
	public void setWc_src(String wc_src) {
		this.wc_src = wc_src;
	}
	
	
	private int up_state;//参加状态，0为伟参加，1为参加，2为发起人不得参加
	
	public int getUp_state() {
		return up_state;
	}
	public void setUp_state(int up_state) {
		this.up_state = up_state;
	}
	
	private int USRID;
	private String USRNM;
	private String STNUM;
	private String PASSW;
	private int AGE;
	private String MAJOR;
	private String SCHOL;
	private String NSTIO;
	private String RNAME;
	private String SEX;
	private String IDNUM;
	private String ADDRE;
	private String PHNUM;
	private String QQ;
	private int POINT;
	private String HOMET;
	private int IFOST;
	private String HEAD_PIC;
	private String BRIEF;
	private String REG_DATE;
	
	public int getUSRID() {
		return USRID;
	}
	public void setUSRID(int uSRID) {
		USRID = uSRID;
	}
	public String getUSRNM() {
		return USRNM;
	}
	public void setUSRNM(String uSRNM) {
		USRNM = uSRNM;
	}
	public String getSTNUM() {
		return STNUM;
	}
	public void setSTNUM(String sTNUM) {
		STNUM = sTNUM;
	}
	public String getPASSW() {
		return PASSW;
	}
	public void setPASSW(String pASSW) {
		PASSW = pASSW;
	}
	public int getAGE() {
		return AGE;
	}
	public void setAGE(int aGE) {
		AGE = aGE;
	}
	public String getMAJOR() {
		return MAJOR;
	}
	public void setMAJOR(String mAJOR) {
		MAJOR = mAJOR;
	}
	public String getSCHOL() {
		return SCHOL;
	}
	public void setSCHOL(String sCHOL) {
		SCHOL = sCHOL;
	}
	public String getNSTIO() {
		return NSTIO;
	}
	public void setNSTIO(String nSTIO) {
		NSTIO = nSTIO;
	}
	public String getRNAME() {
		return RNAME;
	}
	public void setRNAME(String rNAME) {
		RNAME = rNAME;
	}
	public String getSEX() {
		return SEX;
	}
	public void setSEX(String sEX) {
		SEX = sEX;
	}
	public String getIDNUM() {
		return IDNUM;
	}
	public void setIDNUM(String iDNUM) {
		IDNUM = iDNUM;
	}
	public String getADDRE() {
		return ADDRE;
	}
	public void setADDRE(String aDDRE) {
		ADDRE = aDDRE;
	}
	public String getPHNUM() {
		return PHNUM;
	}
	public void setPHNUM(String pHNUM) {
		PHNUM = pHNUM;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public int getPOINT() {
		return POINT;
	}
	public void setPOINT(int pOINT) {
		POINT = pOINT;
	}
	public String getHOMET() {
		return HOMET;
	}
	public void setHOMET(String hOMET) {
		HOMET = hOMET;
	}
	public int getIFOST() {
		return IFOST;
	}
	public void setIFOST(int iFOST) {
		IFOST = iFOST;
	}
	public String getHEAD_PIC() {
		return HEAD_PIC;
	}
	public void setHEAD_PIC(String hEAD_PIC) {
		HEAD_PIC = hEAD_PIC;
	}
	public String getBRIEF() {
		return BRIEF;
	}
	public void setBRIEF(String bRIEF) {
		BRIEF = bRIEF;
	}
	public String getREG_DATE() {
		return REG_DATE;
	}
	public void setREG_DATE(String rEG_DATE) {
		REG_DATE = rEG_DATE;
	}
	
}
