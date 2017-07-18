package connect.reservation.domain;

import java.sql.Timestamp;

public class DisplayInfo {
	private int id;
	private int product_id;
	private String observation_time;
	private Timestamp display_start;
	private Timestamp display_end;
	private String place_name;
	private String place_lot;
	private String place_street;
	private String tel;
	private String homepage;
	private String email;
	private Timestamp create_date;
	private Timestamp modify_date;
	
	
	public DisplayInfo() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getObservation_time() {
		return observation_time;
	}
	public void setObservation_time(String observation_time) {
		this.observation_time = observation_time;
	}
	public Timestamp getDisplay_start() {
		return display_start;
	}
	public void setDisplay_start(Timestamp display_start) {
		this.display_start = display_start;
	}
	public Timestamp getDisplay_end() {
		return display_end;
	}
	public void setDisplay_end(Timestamp display_end) {
		this.display_end = display_end;
	}
	public String getPlace_name() {
		return place_name;
	}
	public void setPlace_name(String place_name) {
		this.place_name = place_name;
	}
	public String getPlace_lot() {
		return place_lot;
	}
	public void setPlace_lot(String place_lot) {
		this.place_lot = place_lot;
	}
	public String getPlace_street() {
		return place_street;
	}
	public void setPlace_street(String place_street) {
		this.place_street = place_street;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}
	public Timestamp getModify_date() {
		return modify_date;
	}
	public void setModify_date(Timestamp modify_date) {
		this.modify_date = modify_date;
	}
	
	
	@Override
	public String toString() {
		return "DisplayInfo [id=" + id + ", product_id=" + product_id + ", observation_time=" + observation_time
				+ ", display_start=" + display_start + ", display_end=" + display_end + ", place_name=" + place_name
				+ ", place_lot=" + place_lot + ", place_street=" + place_street + ", tel=" + tel + ", homepage="
				+ homepage + ", email=" + email + ", create_date=" + create_date + ", modify_date=" + modify_date + "]";
	}
	
}
