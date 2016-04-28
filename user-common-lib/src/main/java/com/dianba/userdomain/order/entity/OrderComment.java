package com.dianba.userdomain.order.entity;

import java.io.Serializable;

public class OrderComment implements Serializable {
	private static final long serialVersionUID = -3860217015481784222L;
	private Long id;
	private Long orderId;
	private String commentContent;
	private String commentDisplay;
	private String tags;
	private Integer commentTarget;
	private Integer grade;
	private Integer invalid;
	private Long commentTargetId;
	private Integer userId;
	private Integer commentTime;

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDisplay() {
		return commentDisplay;
	}

	public void setCommentDisplay(String commentDisplay) {
		this.commentDisplay = commentDisplay;
	}

	public Integer getCommentTarget() {
		return commentTarget;
	}

	public void setCommentTarget(Integer commentTarget) {
		this.commentTarget = commentTarget;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getInvalid() {
		return invalid;
	}

	public void setInvalid(Integer invalid) {
		this.invalid = invalid;
	}

	public Long getCommentTargetId() {
		return commentTargetId;
	}

	public void setCommentTargetId(Long commentTargetId) {
		this.commentTargetId = commentTargetId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Integer commentTime) {
		this.commentTime = commentTime;
	}
}