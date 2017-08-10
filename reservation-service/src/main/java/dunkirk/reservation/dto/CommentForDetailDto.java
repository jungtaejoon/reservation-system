package dunkirk.reservation.dto;

import java.sql.*;

import org.apache.commons.lang3.builder.*;

public class CommentForDetailDto {
	private int id;
	private String comment;
	private float score;
	private String nickname;
	private Timestamp createDate;
	private int thumbnailFileId;

	public CommentForDetailDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getThumbnailFileId() {
		return thumbnailFileId;
	}

	public void setThumbnailFileId(int thumbnailFileId) {
		this.thumbnailFileId = thumbnailFileId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
