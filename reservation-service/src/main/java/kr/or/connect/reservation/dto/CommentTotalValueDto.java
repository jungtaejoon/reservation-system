package kr.or.connect.reservation.dto;

public class CommentTotalValueDto {
	private long totalCount;
	private float average;

	public CommentTotalValueDto() {

	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

}
