package com.yb.entity;

public class ActivityPraise {

	
	    private int apris_id;
	    private int act_id;
	    private String usrid;
	    private int prais_state;
	    public ActivityPraise()
	    {
	       super();
	    }
	    /**
	     * 返回apris_id
	     * @return
	     */
	    public int getApris_id()
	    {
	        return this.apris_id;
	    }
	    /**
	     * 设置apris_id
	     * @param apris_id
	     */
	    public void setApris_id(int apris_id)
	    {
	        this.apris_id = apris_id;
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
	     * 返回usrid
	     * @return
	     */
	    public String getUsrid()
	    {
	        return this.usrid;
	    }
	    /**
	     * 设置usrid
	     * @param usrid
	     */
	    public void setUsrid(String usrid)
	    {
	        this.usrid = usrid;
	    }
	    /**
	     * 返回prais_state
	     * @return
	     */
	    public int getPrais_state()
	    {
	        return this.prais_state;
	    }
	    /**
	     * 设置prais_state
	     * @param prais_state
	     */
	    public void setPrais_state(int prais_state)
	    {
	        this.prais_state = prais_state;
	    }
	}
