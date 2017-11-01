package tree;

public class DataStorage implements Comparable<DataStorage>{
	
	private int freq;
	private String str;
	
	public DataStorage(int frequency){
		this(null, frequency);
	}
	
	public DataStorage(String s, int frequency){
		this.str = s;
		this.freq = frequency;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String s) {
		this.str = s;
	}

	@Override
	public int compareTo(DataStorage ds) {
		// TODO Auto-generated method stub
		return this.freq-ds.freq;
	}
	
}
