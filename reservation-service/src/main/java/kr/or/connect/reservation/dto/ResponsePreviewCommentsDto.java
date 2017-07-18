package kr.or.connect.reservation.dto;

public class ResponsePreviewCommentsDto {
	private CommentTotalValueDto total;
	private PreviewCommentDto previewComment;

	public ResponsePreviewCommentsDto() {
	}

	public CommentTotalValueDto getTotal() {
		return total;
	}

	public void setTotal(CommentTotalValueDto total) {
		this.total = total;
	}

	public PreviewCommentDto getPreviewComment() {
		return previewComment;
	}

	public void setPreviewComment(PreviewCommentDto previewComment) {
		this.previewComment = previewComment;
	}

}
