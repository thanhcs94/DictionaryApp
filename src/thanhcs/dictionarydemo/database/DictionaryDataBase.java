package thanhcs.dictionarydemo.database;




import java.util.ArrayList;

import thanhcs.game.GameRecord;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DictionaryDataBase extends SQLiteOpenHelper {

	private final static String DATABASE_NAME = "anhv22";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME= "data";
	//====================
	// danh sách các field của table ds_Cauhoi
	private static final String ID = "id";
	private static final String  WORD = "word";
	private static final String SOUND = "sound";
	private static final String TYPE = "type";
	private static final String MEAN = "mean";
	private static final String VIDU = "vidu";
	private static final String LEARN = "learn";
	private static final String HISTORY = "history";
	private static final String IMPORTAN = "importan";

	//==========================
	
	
	private String createtable ="CREATE TABLE " + TABLE_NAME + "("
			+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT," 
			+ WORD + " TEXT,"
			+ SOUND + " TEXT, "
			+ TYPE + " TEXT, "
			+ MEAN + " TEXT, "
			+ VIDU + " TEXT, "
			+ LEARN + " INTEGER, "
			+ HISTORY +  " INTEGER, "
			+ IMPORTAN +  " TEXT"+ ")";
	
	
	
	
	
	
	private String updatetable = "DROP TABLE IF EXISTS " + TABLE_NAME;
	


	public DictionaryDataBase(Context context) {
		super(context, DATABASE_NAME, null	, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//	db.execSQL(createtable);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			//	db.execSQL(updatetable); 
			//	onCreate(db);

	}


	
	
	

	// them 1 cau hoi moi
	public void addword(MyWord word) {
		SQLiteDatabase db = this.getWritableDatabase();
		//	 String nullColumnHack=null; // chấp nhận field có giá trị null
		ContentValues values = new ContentValues();
		//	 if (word.get_id()!=-1) values.put(KEY_ID,Cauhoi.get_id());
		values.put(ID, word.getId()); 
		values.put(WORD, word.getWord()); 
		values.put(SOUND, word.getSound() ); 
		values.put(TYPE , word.getType()); 
		values.put(MEAN, word.getMean()); 
		values.put(VIDU, word.getVidu()); 
		values.put(LEARN, word.getLearn()); 
		values.put(HISTORY,word.getHistory());
		values.put(IMPORTAN,word.getImportan());


		System.out.println(word.toString());
		db.insert(TABLE_NAME, null, values);
		db.close(); 		
	}


	public MyWord getWord(int id)
	{
		MyWord a = new MyWord();
		SQLiteDatabase db = this.getReadableDatabase();
		String[] thecolumns = new String[] { ID, WORD, SOUND, TYPE, MEAN, VIDU, LEARN, HISTORY, IMPORTAN};
		Cursor cursor = db.query(TABLE_NAME, thecolumns, ID + "=" + id, null, null, null, null);


		if (cursor != null){ 
			cursor.moveToFirst();
			a.setId(Integer.parseInt(cursor.getString(0).toString()));
			a.setWord(cursor.getString(1));
			a.setSound(cursor.getString(2));
			a.setType(cursor.getString(3));
			a.setMean(cursor.getString(4));
			a.setVidu(cursor.getString(5));
			a.setLearn(Integer.parseInt(cursor.getString(6).toString()));
			a.setHistory(Integer.parseInt(cursor.getString(7).toString()));
			a.setImportan(cursor.getString(8));
		}

		return a;


	}


	

	


//
//	public ArrayList<MyWord> getallWord()
//	{
//		SQLiteDatabase sd= getWritableDatabase();
//		ArrayList<MyWord> list= new ArrayList<MyWord>();
//		Cursor c= sd.rawQuery("SELECT * FROM data",null);
//		c.moveToLast();
//		c.moveToNext();
//
//		while(c.moveToPrevious()){
//			MyWord word= new MyWord();
//			word.setId(c.getInt(c.getColumnIndex(ID)));
//			word.setHistory(c.getInt(c.getColumnIndex(HISTORY)));
//			word.setLearn(c.getInt(c.getColumnIndex(LEARN)));
//
//
//			word.setType(c.getString((c.getColumnIndex(TYPE))));
//			word.setVidu(c.getString(c.getColumnIndex(VIDU)));
//			word.setImportan(c.getString(c.getColumnIndex(IMPORTAN)));
//			word.setWord(c.getString(c.getColumnIndex(WORD)));
//			word.setMean(c.getString(c.getColumnIndex(MEAN)));
//			word.setSound(c.getString(c.getColumnIndex(SOUND)));
//
//			//	System.out.println("danh dach word la "+ list.toString());
//			list.add(word);
//		}
//
//
//		return list;
//	}


	
	
//	public ArrayList<MyWord> getfiveWord(int so)
//	{
//		ArrayList<MyWord> list= new ArrayList<MyWord>();
//		MyWord [] myWords = new MyWord[5];
//		SQLiteDatabase sd= getWritableDatabase();
//		for(int i=0;i<5;i++)
//		{
//			so= so+70;
//			myWords[i]= getWord(so);
//			list.add(myWords[i]);
//		}
//
//		return list;
//	}

	
	
	
	

	public ArrayList<MyWord> gettudahoc()
	{

		SQLiteDatabase sd= getWritableDatabase();
		ArrayList<MyWord> list= new ArrayList<MyWord>();
		Cursor c= sd.rawQuery("select * from data  where  learn =1",null);
		c.moveToLast();
		c.moveToNext();

		while(c.moveToPrevious()){
			MyWord word= new MyWord();
			word.setId(c.getInt(c.getColumnIndex(ID)));
			word.setHistory(c.getInt(c.getColumnIndex(HISTORY)));
			word.setLearn(c.getInt(c.getColumnIndex(LEARN)));


			word.setType(c.getString((c.getColumnIndex(TYPE))));
			word.setVidu(c.getString(c.getColumnIndex(VIDU)));
			word.setImportan(c.getString(c.getColumnIndex(IMPORTAN)));
			word.setWord(c.getString(c.getColumnIndex(WORD)));
			word.setMean(c.getString(c.getColumnIndex(MEAN)));
			word.setSound(c.getString(c.getColumnIndex(SOUND)));


			
			list.add(word);
		}


		return list;
	}


	//====================get list word theo thu tu tu dien 
	public ArrayList<MyWord> gettutheoAC(int a, int b)
	{
		int i=0;
		SQLiteDatabase sd= getWritableDatabase();
		ArrayList<MyWord> list= new ArrayList<MyWord>();
		Cursor c= sd.rawQuery("SELECT * FROM data where id between "+ a + " and "+ b,null);
		c.moveToLast();
		c.moveToNext();

		while(c.moveToPrevious()){
			i++;
			MyWord word= new MyWord();
			word.setId(c.getInt(c.getColumnIndex(ID)));
			word.setHistory(c.getInt(c.getColumnIndex(HISTORY)));
			word.setLearn(c.getInt(c.getColumnIndex(LEARN)));


			word.setType(c.getString((c.getColumnIndex(TYPE))));
			word.setVidu(c.getString(c.getColumnIndex(VIDU)));
			word.setImportan(c.getString(c.getColumnIndex(IMPORTAN)));
			word.setWord(c.getString(c.getColumnIndex(WORD)));
			word.setMean(c.getString(c.getColumnIndex(MEAN)));
			word.setSound(c.getString(c.getColumnIndex(SOUND)));
			list.add(word);
		}

		return list;
	}
	

	public int getContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_NAME;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();
 
		return cursor.getCount();
	}




	
	public void updatedahocword(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.rawQuery("UPDATE DICTIONARY SET learn =1 WHERE  stt = "+id, null);
		System.out.println("Thanh Cong CMnr : ");
		// Cursor c= db.rawQuery("select * from DICTIONARY  where  DAHOC =1",null);	
	}
}
