package kgw.reservation.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Category {
	private long id;
	@NotNull
	@NotBlank(message="내용을 입력 해주세요.")
	private String name;
	
	public Category () {
	}
	
	public Category(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
