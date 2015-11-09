package entity;

public class activity_info {
	 private int act_id;
	    private String user_id;
	    private String act_title;
	    private String act_place;
	    private String act_detail;
	    private int act_count;
	    private String act_charger;
	    private String act_email;
	    private String act_phone;
	    private String act_qq;
	    private String act_weix;
	    private String act_date;
	    private String begin_date;
	    private String end_date;
	    private int act_good;
	    private String act_image;
	    private int act_state;
		public activity_info() {
			super();
		}
	    public activity_info(int act_id, String user_id,String act_title,String act_place,String act_detail,int act_count ,
	    		String act_charger,String act_email,String act_phone,String act_qq,String act_weix,String act_date,String begin_date,
	    		String end_date,int act_good,String act_image, int act_state)
	    {
	    	
	    	super();
	        this.act_id=act_id;
	        this.user_id=user_id;
	        this.act_title=act_title;
	        this.act_place=act_place;
	        this.act_detail=act_detail;
	        this.act_count=act_count;
	        this.act_charger=act_charger;
	        this.act_email=act_email;
	        this.act_phone=act_phone;
	        this.act_qq=act_qq;
	        this.act_weix=act_weix;
	        this.act_date=act_date;
	        this.begin_date=begin_date;
	        this.end_date=end_date;
	        this.act_good=act_good;
	        this.act_image=act_image;
	        this.act_state=act_state;
	    }
	    /**
	     * 返回act_id
	     * @return
	     */
	    public int getAct_id()
	    {
	        return this.act_id;
	    }
	    /**
	     * 设置act_id
	     * @param act_id
	     */
	    public void setAct_id(int act_id)
	    {
	        this.act_id = act_id;
	    }
	    /**
	     * 返回user_id
	     * @return
	     */
	    public String getUser_id()
	    {
	        return this.user_id;
	    }
	    /**
	     * 设置user_id
	     * @param user_id
	     */
	    public void setUser_id(String user_id)
	    {
	        this.user_id = user_id;
	    }
	    /**
	     * 返回act_title
	     * @return
	     */
	    public String getAct_title()
	    {
	        return this.act_title;
	    }
	    /**
	     * 设置act_title
	     * @param act_title
	     */
	    public void setAct_title(String act_title)
	    {
	        this.act_title = act_title;
	    }
	    /**
	     * 返回act_place
	     * @return
	     */
	    public String getAct_place()
	    {
	        return this.act_place;
	    }
	    /**
	     * 设置act_place
	     * @param act_place
	     */
	    public void setAct_place(String act_place)
	    {
	        this.act_place = act_place;
	    }
	    /**
	     * 返回act_detail
	     * @return
	     */
	    public String getAct_detail()
	    {
	        return this.act_detail;
	    }
	    /**
	     * 设置act_detail
	     * @param act_detail
	     */
	    public void setAct_detail(String act_detail)
	    {
	        this.act_detail = act_detail;
	    }
	    /**
	     * 返回act_count
	     * @return
	     */
	    public int getAct_count()
	    {
	        return this.act_count;
	    }
	    /**
	     * 设置act_count
	     * @param act_count
	     */
	    public void setAct_count(int act_count)
	    {
	        this.act_count = act_count;
	    }
	    /**
	     * 返回act_charger
	     * @return
	     */
	    public String getAct_charger()
	    {
	        return this.act_charger;
	    }
	    /**
	     * 设置act_charger
	     * @param act_charger
	     */
	    public void setAct_charger(String act_charger)
	    {
	        this.act_charger = act_charger;
	    }
	    /**
	     * 返回act_email
	     * @return
	     */
	    public String getAct_email()
	    {
	        return this.act_email;
	    }
	    /**
	     * 设置act_email
	     * @param act_email
	     */
	    public void setAct_email(String act_email)
	    {
	        this.act_email = act_email;
	    }
	    /**
	     * 返回act_phone
	     * @return
	     */
	    public String getAct_phone()
	    {
	        return this.act_phone;
	    }
	    /**
	     * 设置act_phone
	     * @param act_phone
	     */
	    public void setAct_phone(String act_phone)
	    {
	        this.act_phone = act_phone;
	    }
	    /**
	     * 返回act_qq
	     * @return
	     */
	    public String getAct_qq()
	    {
	        return this.act_qq;
	    }
	    /**
	     * 设置act_qq
	     * @param act_qq
	     */
	    public void setAct_qq(String act_qq)
	    {
	        this.act_qq = act_qq;
	    }
	    /**
	     * 返回act_weix
	     * @return
	     */
	    public String getAct_weix()
	    {
	        return this.act_weix;
	    }
	    /**
	     * 设置act_weix
	     * @param act_weix
	     */
	    public void setAct_weix(String act_weix)
	    {
	        this.act_weix = act_weix;
	    }
	    /**
	     * 返回act_date
	     * @return
	     */
	    public String getAct_date()
	    {
	        return this.act_date;
	    }
	    /**
	     * 设置act_date
	     * @param act_date
	     */
	    public void setAct_date(String act_date)
	    {
	        this.act_date = act_date;
	    }
	    /**
	     * 返回begin_date
	     * @return
	     */
	    public String getBegin_date()
	    {
	        return this.begin_date;
	    }
	    /**
	     * 设置begin_date
	     * @param begin_date
	     */
	    public void setBegin_date(String begin_date)
	    {
	        this.begin_date = begin_date;
	    }
	    /**
	     * 返回end_date
	     * @return
	     */
	    public String getEnd_date()
	    {
	        return this.end_date;
	    }
	    /**
	     * 设置end_date
	     * @param end_date
	     */
	    public void setEnd_date(String end_date)
	    {
	        this.end_date = end_date;
	    }
	    /**
	     * 返回act_good
	     * @return
	     */
	    public int getAct_good()
	    {
	        return this.act_good;
	    }
	    /**
	     * 设置act_good
	     * @param act_good
	     */
	    public void setAct_good(int act_good)
	    {
	        this.act_good = act_good;
	    }
	    /**
	     * 返回act_image
	     * @return
	     */
	    public String getAct_image()
	    {
	        return this.act_image;
	    }
	    /**
	     * 设置act_image
	     * @param act_image
	     */
	    public void setAct_image(String act_image)
	    {
	        this.act_image = act_image;
	    }
	    /**
	     * 返回act_state
	     * @return
	     */
	    public int getAct_state()
	    {
	        return this.act_state;
	    }
	    /**
	     * 设置act_state
	     * @param act_state
	     */
	    public void setAct_state(int act_state)
	    {
	        this.act_state = act_state;
	    }

}
