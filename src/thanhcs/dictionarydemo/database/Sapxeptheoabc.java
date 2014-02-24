package thanhcs.dictionarydemo.database;

import java.util.Comparator;


public class Sapxeptheoabc implements Comparator<MyWord> {

	@Override
	public int compare(MyWord a, MyWord b) {
		if(a.getWord().compareTo(b.getWord()) == 1){
			return 1;
		}
		else if(a.getWord().compareTo(b.getWord()) == -1){
			return -1;
		}
		else{
			return 0;
		}
			
	}

}
