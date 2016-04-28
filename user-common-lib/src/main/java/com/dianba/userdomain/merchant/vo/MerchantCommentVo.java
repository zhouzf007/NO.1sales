package com.dianba.userdomain.merchant.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class MerchantCommentVo implements Serializable {

	private static final long serialVersionUID = -397325933480680283L;

	public static List<String> toTags(String line) {
		line = line == null ? "" : line;
		String[] tags = line.split(",");
		List<String> tagList = new ArrayList<>(tags.length);
		for (String tag : tags) {
			if (tag != null && !tag.equals(""))
				tagList.add(tag);
		}
		return tagList;
	}

	private String tags;
	private String nickName;
	private String grade;
	private String commentContent;
	private Integer commentTime;
	private String photoUrl;
	private String realCommentTime;

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Integer getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Integer commentTime) {
		this.commentTime = commentTime;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getRealCommentTime() {
		return realCommentTime;
	}

	public void setRealCommentTime(String realCommentTime) {
		this.realCommentTime = realCommentTime;
	}

	static class TagFormatter {
		private static final String PATTERN = "\\$tag\\$(.*?)\\$tag\\$";
		private static final Pattern P = Pattern.compile(PATTERN);

		public static void main(String[] args) {
			String str = "$tag$dfas,fsadg,sg,sf,s,dgas,df,sf,$tag$djfksjdfkls;fksdjfs;kl";
			System.out.println(formatContext(str));
			;
		}

		public static String formatContext(String str) {
			String line = getString(str);
			if (StringUtils.isNoneBlank(line)) {
				str = str.replace("$tag$" + line + "$tag$", "");
			}
			return str;
		}

		public static List<String> getTags(String str) {
			// String str =
			// "$tag$dfas,fsadg,sg,sf,s,dgas,df,sf,$tag$djfksjdfkls;fksdjfs;kl";
			String line = getString(str); // 用正则表达式获取指定字符串内容中的指定内容
			String[] tags = line.split(",");
			List<String> tagList = new ArrayList<>(tags.length);
			for (String tag : tags) {
				if (tag != null && !tag.equals(""))
					tagList.add(tag);
			}
			return tagList;
		}

		private static String getString(String str) {
			Matcher m = P.matcher(str);
			ArrayList<String> strs = new ArrayList<String>();
			while (m.find()) {
				strs.add(m.group(1));
			}
			// for (String s : strs) {
			// System.out.println(s);
			// }
			if (strs.isEmpty()) {
				return "";
			}
			return strs.get(0);
		}
	}

}
