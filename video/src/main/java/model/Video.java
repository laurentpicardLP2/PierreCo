package model;

public class Video {
	 private String linkId;
	 private String title;
	 private long categorieId;
	 
	public Video(String linkId, String title, long categorieId) {
		super();
		this.linkId = linkId;
		this.title = title;
		this.categorieId = categorieId;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(long categorieId) {
		this.categorieId = categorieId;
	}

	@Override
	public String toString() {
		return "Video [linkId=" + linkId + ", title=" + title + ", categorieId=" + categorieId + "]";
	}
	 
	
	
}
