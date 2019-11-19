package Midterm;

public class AdminEntry {

	static int quoteId = 0;
	static int viewedCount = 0;
	static int likedCount = 0;
	static int dislikedCount = 0;
	int id;
	String quote;
	String author;
	int viewed;
	int liked;
	int disliked;
	
	public AdminEntry(String quote, String author) {
		super();
		this.id = quoteId++;
		this.quote = quote;
		this.author = author;
		this.viewed = 0;
		this.liked = 0;
		this.disliked = 0;
	}
	
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getViewed() {
		return viewed;
	}
	public void setViewed(int viewed) {
		this.viewed = viewed;
	}
	public int getLiked() {
		return liked;
	}
	public void setLiked(int liked) {
		this.liked = liked;
	}
	public int getDisliked() {
		return disliked;
	}
	public void setDisliked(int disliked) {
		this.disliked = disliked;
	}
	public void viewGetter() {
		this.viewed++;
	}
	public void LikeGetter() {
		this.liked++;
	}
	public void DisLikeGetter() {
		this.disliked++;
	}
	public int getId() {
		return id;
	}
	public void upLike() {
		this.liked++;
	}
	public void upDislike() {
		this.disliked++;
	}
	public void setId(int id) {
		this.id = id;
	}
}
