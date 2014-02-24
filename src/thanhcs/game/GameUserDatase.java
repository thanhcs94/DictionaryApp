package thanhcs.game;

import java.util.ArrayList;

import databasecaunoithongdung.dictionary.Caunoithongdung;

import thanhcs.dictionarydemo.database.MyWord;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class GameUserDatase extends SQLiteOpenHelper{

	private final static String DATABASE_NAME = "GAMEUSER";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME= "gameuser";
	
	
	private static final String ID = "id";
	private static final String  USER = "user";
	private static final String   KILUCTU= "kiluctu";
	private static final String KILUCNGHIA = "kilucnghia";
	
	private String createtable ="CREATE TABLE " + TABLE_NAME + "("
			+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT," 
			+ USER + " TEXT,"
			+ KILUCTU + " INTEGER, "
			+ KILUCNGHIA + " INTEGER"+ ")";
	private String updatetable = "DROP TABLE IF EXISTS " + TABLE_NAME;
	
	public GameUserDatase(Context context) {
		super(context, DATABASE_NAME, null,DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void onCreate(SQLiteDatabase db) {
//		db.execSQL(createtable);
		
	}
	
	
	
	
	//them nguoi choi
	public void addGameRecord(GameRecord user) {
		SQLiteDatabase db = this.getWritableDatabase();
		//	 String nullColumnHack=null; // chấp nhận field có giá trị null
		ContentValues values = new ContentValues();
		//	 if (word.get_id()!=-1) values.put(KEY_ID,Cauhoi.get_id());
		values.put(ID,user.getId()); 
		values.put(USER,user.getUsename()); 
		values.put(KILUCTU, user.getKiluctu() ); 
		values.put(KILUCNGHIA , user.getKilucnghia()); 
		
		System.out.println(user.toString());
		db.insert(TABLE_NAME, null, values);
		db.close(); 		
	}

	public GameRecord getUser(int id)
	{
		GameRecord a = new GameRecord();
		SQLiteDatabase db = this.getReadableDatabase();
		String[] thecolumns = new String[] { ID, USER, KILUCTU, KILUCNGHIA};
		Cursor cursor = db.query(TABLE_NAME, thecolumns, ID + "=" + id, null, null, null, null);


		if (cursor != null){ 
			cursor.moveToFirst();
			a.setId(Integer.parseInt(cursor.getString(0).toString()));
			a.setUsename((cursor.getString(1)));
			a.setKiluctu(Integer.parseInt(cursor.getString(2).toString()));
			a.setKilucnghia(Integer.parseInt(cursor.getString(3).toString()));
			
		}

		return a;


	}
	
	
	public ArrayList<GameRecord> getallUser()
	{
		SQLiteDatabase sd= getWritableDatabase();
		ArrayList<GameRecord> list= new ArrayList<GameRecord>();
		Cursor cursor= sd.rawQuery("select * from "+TABLE_NAME,null);
		cursor.moveToLast();
		cursor.moveToNext();
		
		while(cursor.moveToPrevious()){
			GameRecord a = new GameRecord();
			a.setId(Integer.parseInt(cursor.getString(0).toString()));
			a.setUsename((cursor.getString(1)));
			a.setKiluctu(Integer.parseInt(cursor.getString(2).toString()));
			a.setKilucnghia(Integer.parseInt(cursor.getString(3).toString()));
		
			//System.out.println("danh dach cau noi thong dung la "+ list.toString());
			list.add(a);
		}
		
		
		return list;
	}
	
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		db.execSQL(updatetable); 
	//	onCreate(db);

		
	}

	
	
	
}
