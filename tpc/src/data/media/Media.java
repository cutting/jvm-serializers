package data.media;

import java.util.List;
import static data.ReprUtil.repr;

@SuppressWarnings("serial")
public class Media implements java.io.Serializable {
	public enum Player {
		JAVA, FLASH
	}

	public String uri;
	public String title;        // Can be unset.
	public int width;
	public int height;
	public String format;
	public long duration;
	public long size;
	public int bitrate;         // Can be unset.
	public boolean hasBitrate;
	public List<String> persons;
	public Player player;
	public String copyright;    // Can be unset.

	public Media() {}

	public Media(String uri, String title, int width, int height, String format, long duration, long size, int bitrate, boolean hasBitrate, List<String> persons, Player player, String copyright)
	{
		this.uri = uri;
		this.title = title;
		this.width = width;
		this.height = height;
		this.format = format;
		this.duration = duration;
		this.size = size;
		this.bitrate = bitrate;
		this.hasBitrate = hasBitrate;
		this.persons = persons;
		this.player = player;
		this.copyright = copyright;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Media media = (Media) o;

		if (bitrate != media.bitrate) return false;
		if (duration != media.duration) return false;
		if (hasBitrate != media.hasBitrate) return false;
		if (height != media.height) return false;
		if (size != media.size) return false;
		if (width != media.width) return false;
		if (copyright != null ? !copyright.equals(media.copyright) : media.copyright != null) return false;
		if (format != null ? !format.equals(media.format) : media.format != null) return false;
		if (persons != null ? !persons.equals(media.persons) : media.persons != null) return false;
		if (player != media.player) return false;
		if (title != null ? !title.equals(media.title) : media.title != null) return false;
		if (uri != null ? !uri.equals(media.uri) : media.uri != null) return false;

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = uri != null ? uri.hashCode() : 0;
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + width;
		result = 31 * result + height;
		result = 31 * result + (format != null ? format.hashCode() : 0);
		result = 31 * result + (int) (duration ^ (duration >>> 32));
		result = 31 * result + (int) (size ^ (size >>> 32));
		result = 31 * result + bitrate;
		result = 31 * result + (hasBitrate ? 1 : 0);
		result = 31 * result + (persons != null ? persons.hashCode() : 0);
		result = 31 * result + (player != null ? player.hashCode() : 0);
		result = 31 * result + (copyright != null ? copyright.hashCode() : 0);
		return result;
	}

	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("[Media ");
		sb.append("uri=").append(repr(uri));
		sb.append(", title=").append(repr(title));
		sb.append(", width=").append(width);
		sb.append(", height=").append(height);
		sb.append(", format=").append(repr(format));
		sb.append(", duration=").append(duration);
		sb.append(", size=").append(size);
		sb.append(", bitrate=").append(hasBitrate ? Integer.toString(bitrate) : "?");
		sb.append(", persons=").append(repr(persons));
		sb.append(", player=").append(player);
		sb.append(", copyright=").append(copyright);
		sb.append("]");
		return sb.toString();
	}
}
