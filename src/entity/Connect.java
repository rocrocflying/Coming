package entity;

public class Connect {

	private int USRID;
	private int id;
	private int up_state;//参加状态，0为伟参加，1为参加，2为发起人不得参加
	public int getUSRID() {
		return USRID;
	}
	public void setUSRID(int uSRID) {
		USRID = uSRID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUp_state() {
		return up_state;
	}
	public void setUp_state(int up_state) {
		this.up_state = up_state;
	}
	
	
	
}
