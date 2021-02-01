package net.gondr.domain;

public class YYSample2VO {
	private String userid;
	private String pass;
	private String passc;
	private String name;
	private String email;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "YYSample2VO [userid=" + userid + ", pass=" + pass + ", passc=" + passc + ", name=" + name + ", email="
				+ email + "]";
	}
	public String getPassc() {
		return passc;
	}
	public void setPassc(String passc) {
		this.passc = passc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
