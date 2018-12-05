package model;

public class Video {
	 private String linkId;
	 private String titre;
	 private long categorieId;
	 
	public Video(String linkId, String titre, long categorieId) {
		super();
		this.linkId = linkId;
		this.titre = titre;
		this.categorieId = categorieId;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public long getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(long categorieId) {
		this.categorieId = categorieId;
	}

	@Override
	public String toString() {
		return "Video [linkId=" + linkId + ", titre=" + titre + ", categorieId=" + categorieId + "]";
	}
	 
	
	
}
