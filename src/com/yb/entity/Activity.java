package com.yb.entity;

public class Activity
{
    private int act_id;
    private int user_id;
    private String act_title;
    private String act_place;
    private String act_detail;
    private int act_count;
    private String act_charge;
    private String act_email;
    private String act_phone;
    private String act_qq;
    private String act_weix;
    private String act_date;
    private String begin_date;
    private String end_date;
    private int act_good;
    private String act_image;
   
	public Activity() {
		super();
	}
   
    /**
     * ����act_id
     * @return
     */
    public int getAct_id()
    {
        return this.act_id;
    }
    /**
     * ����act_id
     * @param act_id
     */
    public void setAct_id(int act_id)
    {
        this.act_id = act_id;
    }
    /**
     * ����user_id
     * @return
     */
    public int getUser_id()
    {
        return this.user_id;
    }
    /**
     * ����user_id
     * @param user_id
     */
    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }
    /**
     * ����act_title
     * @return
     */
    public String getAct_title()
    {
        return this.act_title;
    }
    /**
     * ����act_title
     * @param act_title
     */
    public void setAct_title(String act_title)
    {
        this.act_title = act_title;
    }
    /**
     * ����act_place
     * @return
     */
    public String getAct_place()
    {
        return this.act_place;
    }
    /**
     * ����act_place
     * @param act_place
     */
    public void setAct_place(String act_place)
    {
        this.act_place = act_place;
    }
    /**
     * ����act_detail
     * @return
     */
    public String getAct_detail()
    {
        return this.act_detail;
    }
    /**
     * ����act_detail
     * @param act_detail
     */
    public void setAct_detail(String act_detail)
    {
        this.act_detail = act_detail;
    }
    /**
     * ����act_count
     * @return
     */
    public int getAct_count()
    {
        return this.act_count;
    }
    /**
     * ����act_count
     * @param act_count
     */
    public void setAct_count(int act_count)
    {
        this.act_count = act_count;
    }
    /**
     * ����act_charger
     * @return
     */
    public String getAct_charge()
    {
        return this.act_charge;
    }
    /**
     * ����act_charger
     * @param act_charger
     */
    public void setAct_charge(String act_charge)
    {
        this.act_charge = act_charge;
    }
    /**
     * ����act_email
     * @return
     */
    public String getAct_email()
    {
        return this.act_email;
    }
    /**
     * ����act_email
     * @param act_email
     */
    public void setAct_email(String act_email)
    {
        this.act_email = act_email;
    }
    /**
     * ����act_phone
     * @return
     */
    public String getAct_phone()
    {
        return this.act_phone;
    }
    /**
     * ����act_phone
     * @param act_phone
     */
    public void setAct_phone(String act_phone)
    {
        this.act_phone = act_phone;
    }
    /**
     * ����act_qq
     * @return
     */
    public String getAct_qq()
    {
        return this.act_qq;
    }
    /**
     * ����act_qq
     * @param act_qq
     */
    public void setAct_qq(String act_qq)
    {
        this.act_qq = act_qq;
    }
    /**
     * ����act_weix
     * @return
     */
    public String getAct_weix()
    {
        return this.act_weix;
    }
    /**
     * ����act_weix
     * @param act_weix
     */
    public void setAct_weix(String act_weix)
    {
        this.act_weix = act_weix;
    }
    /**
     * ����act_date
     * @return
     */
    public String getAct_date()
    {
        return this.act_date.substring(0,19);
    }
    /**
     * ����act_date
     * @param act_date
     */
    public void setAct_date(String act_date)
    {
        this.act_date = act_date;
    }
    /**
     * ����begin_date
     * @return
     */
    public String getBegin_date()
    {
        return this.begin_date.substring(0,19);
    }
    /**
     * ����begin_date
     * @param begin_date
     */
    public void setBegin_date(String begin_date)
    {
        this.begin_date = begin_date;
    }
    /**
     * ����end_date
     * @return
     */
    public String getEnd_date()
    {
        return this.end_date.substring(0,19);
    }
    /**
     * ����end_date
     * @param end_date
     */
    public void setEnd_date(String end_date)
    {
        this.end_date = end_date;
    }
    /**
     * ����act_good
     * @return
     */
    public int getAct_good()
    {
        return this.act_good;
    }
    /**
     * ����act_good
     * @param act_good
     */
    public void setAct_good(int act_good)
    {
        this.act_good = act_good;
    }
    /**
     * ����act_image
     * @return
     */
    public String getAct_image()
    {
        return this.act_image;
    }
    /**
     * ����act_image
     * @param act_image
     */
    public void setAct_image(String act_image)
    {
        this.act_image = act_image;
    }
   
}