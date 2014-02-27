package databasecaunoithongdung.dictionary;

public class Caunoithongdung {
	
	private int stt, loai, yeuthich;
	private String ndanh, ndviet;
	
	public Caunoithongdung()
	{
		
	}

	public Caunoithongdung(int stt, String ndanh,
			String ndviet,  int loai, int yeuthich) {
		super();
		this.stt = stt;
		this.loai = loai;
		this.yeuthich = yeuthich;
		this.ndanh = ndanh;
		this.ndviet = ndviet;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public int getLoai() {
		return loai;
	}

	public void setLoai(int loai) {
		this.loai = loai;
	}

	public int getYeuthich() {
		return yeuthich;
	}

	public void setYeuthich(int yeuthich) {
		this.yeuthich = yeuthich;
	}

	public String getNdanh() {
		return ndanh;
	}

	public void setNdanh(String ndanh) {
		this.ndanh = ndanh;
	}

	public String getNdviet() {
		return ndviet;
	}

	public void setNdviet(String ndviet) {
		this.ndviet = ndviet;
	}

	@Override
	public String toString() {
		return "Caunoithongdung [stt=" + stt + ", loai=" + loai + ", yeuthich="
				+ yeuthich + ", ndanh=" + ndanh + ", ndviet=" + ndviet + "]";
	}
	
	
	
	

}
