package com.yb.entity;

public class ActivityJoin {

	 private String join_id;
	    private String act_id;
	    private int usrid;
	    private String join_date;
	    private int join_state;
	    public ActivityJoin()
	    {
	    	super();
	    }
	    /**
	     * 返回join_id
	     * @return
	     */
	    public String getJoin_id()
	    {
	        return this.join_id;
	    }
	    /**
	     * 设置join_id
	     * @param join_id
	     */
	    public void setJoin_id(String join_id)
	    {
	        this.join_id = join_id;
	    }
	    /**
	     * 返回act_id
	     * @return
	     */
	    public String getAct_id()
	    {
	        return this.act_id;
	    }
	    /**
	     * 设置act_id
	     * @param act_id
	     */
	    public void setAct_id(String act_id)
	    {
	        this.act_id = act_id;
	    }
	    /**
	     * 返回usrid
	     * @return
	     */
	    public int getUsrid()
	    {
	        return this.usrid;
	    }
	    /**
	     * 设置usrid
	     * @param usrid
	     */
	    public void setUsrid(int usrid)
	    {
	        this.usrid = usrid;
	    }
	    /**
	     * 返回join_date
	     * @return
	     */
	    public String getJoin_date()
	    {
	        return this.join_date;
	    }
	    /**
	     * 设置join_date
	     * @param join_date
	     */
	    public void setJoin_date(String join_date)
	    {
	        this.join_date = join_date;
	    }
	    /**
	     * 返回join_state
	     * @return
	     */
	    public int getJoin_state()
	    {
	        return this.join_state;
	    }
	    /**
	     * 设置join_state
	     * @param join_state
	     */
	    public void setJoin_state(int join_state)
	    {
	        this.join_state = join_state;
	    }
	}
