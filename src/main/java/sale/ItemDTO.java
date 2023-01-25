package sale;

public class ItemDTO {
	int id;
	String novelTitle;
	int sequence;
	String episodeTitle;
	int price;
	int episodeId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNovelTitle() {
		return novelTitle;
	}
	public void setNovelTitle(String novelTitle) {
		this.novelTitle = novelTitle;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getEpisodeTitle() {
		return episodeTitle;
	}
	public void setEpisodeTitle(String episodeTitle) {
		this.episodeTitle = episodeTitle;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getEpisodeId() {
		return episodeId;
	}
	public void setEpisodeId(int episodeId) {
		this.episodeId = episodeId;
	}
	@Override
	public String toString() {
		return "ItemDTO [id=" + id + ", novelTitle=" + novelTitle + ", sequence=" + sequence + ", episodeTitle="
				+ episodeTitle + ", price=" + price + ", episodeId=" + episodeId + "]";
	}
	
	
}
