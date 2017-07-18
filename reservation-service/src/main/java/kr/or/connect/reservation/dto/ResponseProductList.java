package kr.or.connect.reservation.dto;

import java.util.List;

import kr.or.connect.reservation.domain.Product;

public class ResponseProductList {
	private long totalCount;
	private List<MainPageProductDto> list;

	public ResponseProductList() {
		
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public List<MainPageProductDto> getList() {
		return list;
	}

	public void setList(List<MainPageProductDto> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ResponseProductList [totalCount=" + totalCount + ", list=" + list + "]";
	}

}
