package Day11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reply {

	
	// 1. 필드
	private String content;
	private String pw;
	private String writer;
	private String date;
	private int index;
	// 2. 생성자
		// 1. 빈생성자
	public Reply() {}
	
		

	// 2. 댓글 등록시 사용되는 생성자
	public Reply(String content, String pw, String writer, int index) {
		this.content = content;
		this.pw = pw;
		this.writer = writer;
		this.index = index;
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		this.date = format.format(date);
	}
	
		// 3. 풀생성자
	public Reply(String content, String pw, String writer, String date, int index) {
		this.content = content;
		this.pw = pw;
		this.writer = writer;
		this.date = date;
		this.index = index;
	}
	
	
	// 3. 메소드
	public String getContent() {
		return content;
	}

	

	public void setContent(String content) {
		this.content = content;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
	
}
