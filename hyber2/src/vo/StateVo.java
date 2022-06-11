package vo;

public class StateVo {
	public int id;
	public String state_name;
	public CntryVo cid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public CntryVo getCid() {
		return cid;
	}
	public void setCid(CntryVo cid) {
		this.cid = cid;
	}
}
