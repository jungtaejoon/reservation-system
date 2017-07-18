package kr.or.reservation.domain;

public class AVGForComment {
	private int amountOfCount;
	private String avgScore;
	
	public AVGForComment() {
		// TODO Auto-generated constructor stub
	}

	public AVGForComment(int amountOfCount, String avgScore) {
		this.amountOfCount = amountOfCount;
		this.avgScore = avgScore;
	}

	public int getAmountOfCount() {
		return amountOfCount;
	}

	public void setAmountOfCount(int amountOfCount) {
		this.amountOfCount = amountOfCount;
	}

	public String getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}

	@Override
	public String toString() {
		return "amountOfCount : \"" + amountOfCount + "\", avgScore : \"" + avgScore +"\"";
	}
	
	
	
}
