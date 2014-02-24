package thanhcs.dictionarydemo.database;

import java.io.Serializable;

public class MyWord implements Serializable,Comparable<MyWord>{

	private int id;
	private String word, sound,type, mean, vidu;
	private int learn, history;
	private String importan;
	
	public MyWord()
	{
		
	}
	

	
	public MyWord(int id, String word, String sound, String type, String mean,
			String vidu, int learn, int history, String importan) {
		super();
		this.id = id;
		this.word = word;
		this.sound = sound;
		this.type = type;
		this.mean = mean;
		this.vidu = vidu;
		this.learn = learn;
		this.history = history;
		this.importan = importan;
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
	 * @return the word
	 */
	public String getWord() {
		return word;
	}



	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}



	/**
	 * @return the sound
	 */
	public String getSound() {
		return sound;
	}



	/**
	 * @param sound the sound to set
	 */
	public void setSound(String sound) {
		this.sound = sound;
	}



	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}



	/**
	 * @return the mean
	 */
	public String getMean() {
		return mean;
	}



	/**
	 * @param mean the mean to set
	 */
	public void setMean(String mean) {
		this.mean = mean;
	}



	/**
	 * @return the vidu
	 */
	public String getVidu() {
		return vidu;
	}



	/**
	 * @param vidu the vidu to set
	 */
	public void setVidu(String vidu) {
		this.vidu = vidu;
	}



	/**
	 * @return the learn
	 */
	public int getLearn() {
		return learn;
	}



	/**
	 * @param learn the learn to set
	 */
	public void setLearn(int learn) {
		this.learn = learn;
	}



	/**
	 * @return the history
	 */
	public int getHistory() {
		return history;
	}



	/**
	 * @param history the history to set
	 */
	public void setHistory(int history) {
		this.history = history;
	}



	/**
	 * @return the importan
	 */
	public String getImportan() {
		return importan;
	}



	/**
	 * @param importan the importan to set
	 */
	public void setImportan(String importan) {
		this.importan = importan;
	}



	@Override
	public int compareTo(MyWord o) {
		return this.word.compareToIgnoreCase(o.word);
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyWord [id=" + id + ", word=" + word + ", sound=" + sound
				+ ", type=" + type + ", mean=" + mean + ", vidu=" + vidu
				+ ", learn=" + learn + ", history=" + history + ", importan="
				+ importan + "]";
	}


	

	
	
}
