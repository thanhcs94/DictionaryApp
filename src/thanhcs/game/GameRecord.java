package thanhcs.game;

public class GameRecord {
	private int id;
	private String usename;
	private int kiluctu;
	private int kilucnghia;
	public GameRecord(int id, String usename, int kiluctu, int kilucnghia) {
		super();
		this.id =id;
		this.usename = usename;
		this.kiluctu = kiluctu;
		this.kilucnghia = kilucnghia;
	}
	
	public GameRecord()
	{
		
	}

	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the usename
	 */
	public String getUsename() {
		return usename;
	}

	/**
	 * @param usename the usename to set
	 */
	public void setUsename(String usename) {
		this.usename = usename;
	}

	/**
	 * @return the kiluctu
	 */
	public int getKiluctu() {
		return kiluctu;
	}

	/**
	 * @param kiluctu the kiluctu to set
	 */
	public void setKiluctu(int kiluctu) {
		this.kiluctu = kiluctu;
	}

	/**
	 * @return the kilucnghia
	 */
	public int getKilucnghia() {
		return kilucnghia;
	}

	/**
	 * @param kilucnghia the kilucnghia to set
	 */
	public void setKilucnghia(int kilucnghia) {
		this.kilucnghia = kilucnghia;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GameRecord [id=" + id + ", usename=" + usename + ", kiluctu="
				+ kiluctu + ", kilucnghia=" + kilucnghia + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	
}
