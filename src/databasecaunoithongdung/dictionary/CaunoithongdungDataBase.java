package databasecaunoithongdung.dictionary;

import java.util.ArrayList;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.audiofx.NoiseSuppressor;

public class CaunoithongdungDataBase extends SQLiteOpenHelper {

	private final static String DATABASE_NAME = "CAUNOITD_DB";
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME= "CAUNOITHONGDUNG";
	//===============
	// danh sách các field của table cau oi thong dung 
		private static final String STT = "stt";
		private static final String  NDANH= "ndunganh";
		private static final String NDVIET = "ndviet";
		private static final String LOAI = "loai";
		private static final String YEUTHICH= "yeuthich";
		
	//=====================
		
		private String createtablecaunoithongdung ="CREATE TABLE " + TABLE_NAME + "("
      + STT + " INTEGER PRIMARY KEY AUTOINCREMENT," 
		+ NDANH + " TEXT,"
      + NDVIET + " TEXT, "
      + LOAI + " INTEGER, "
      + YEUTHICH +  " INTEGER" + ")";
 private String updatetablecaunoithongdung = "DROP TABLE IF EXISTS " + TABLE_NAME;
		
	
	
	//===============
	
	public CaunoithongdungDataBase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase dbcntd) {
	//	dbcntd.execSQL(createtablecaunoithongdung);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase dbcntd, int arg1, int arg2) {
	//	dbcntd.execSQL(updatetablecaunoithongdung);
	//	onCreate(dbcntd);
		
	}
	
	// them 1 cau hoi moi
			public void addcaunoithongdung(Caunoithongdung caunoi) {
				 SQLiteDatabase db = this.getWritableDatabase();
			//	 String nullColumnHack=null; // chấp nhận field có giá trị null
				 ContentValues values = new ContentValues();
			//	 if (word.get_id()!=-1) values.put(KEY_ID,Cauhoi.get_id());
				 values.put(STT, caunoi.getStt()); 
				 values.put(NDANH, caunoi.getNdanh()); 
				 values.put(NDVIET, caunoi.getNdviet() ); 
				 values.put(YEUTHICH, caunoi.getYeuthich()); 
				 values.put(LOAI,caunoi.getLoai()); 
				

				 db.insert(TABLE_NAME, null, values);
				
				 db.close(); 		
			}
			
			
			
			//get 1 cau noi 
			public Caunoithongdung getcaunoithongdung(int id)
			{
				SQLiteDatabase db = this.getReadableDatabase();

				Cursor cursor = db.query(TABLE_NAME, new String[] {STT,
				 NDANH, NDVIET, LOAI, YEUTHICH}, STT+ "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
				if (cursor != null)
				cursor.moveToFirst();

				Caunoithongdung caunoi = new Caunoithongdung(Integer.parseInt(cursor.getString(0).toString()),
						cursor.getString(1),
						cursor.getString(2),
						Integer.parseInt(cursor.getString(3).toString()),
						Integer.parseInt(cursor.getString(4).toString())
						);
						
						
						// return word
				cursor.close();
				db.close();

				return caunoi;
				
			}

			public ArrayList<Caunoithongdung> getallcaunoithongdung()
			{
				SQLiteDatabase sd= getWritableDatabase();
				ArrayList<Caunoithongdung> list= new ArrayList<Caunoithongdung>();
				Cursor c= sd.rawQuery("select * from "+TABLE_NAME,null);
				c.moveToLast();
				c.moveToNext();
				
				while(c.moveToPrevious()){
					Caunoithongdung caunoi= new Caunoithongdung();
					caunoi.setStt(c.getInt(c.getColumnIndex(STT)));
					caunoi.setLoai(c.getInt(c.getColumnIndex(LOAI)));
					caunoi.setYeuthich(c.getInt(c.getColumnIndex(YEUTHICH)));
					
					
					
					caunoi.setNdanh(c.getString(c.getColumnIndex(NDANH)));
					caunoi.setNdviet(c.getString(c.getColumnIndex(NDVIET)));
				
					System.out.println("danh dach cau noi thong dung la "+ list.toString());
					list.add(caunoi);
				}
				
				
				return list;
			}
			
			
			public ArrayList<Caunoithongdung> getloaicntd(int i)
			{
				SQLiteDatabase sd= getWritableDatabase();
				ArrayList<Caunoithongdung> list= new ArrayList<Caunoithongdung>();
				Cursor c= sd.rawQuery("SELECT * FROM CAUNOITHONGDUNG where loai ="+ i,null);
				c.moveToLast();
				c.moveToNext();
				
				while(c.moveToPrevious()){
					Caunoithongdung caunoi= new Caunoithongdung();
					caunoi.setStt(c.getInt(c.getColumnIndex(STT)));
					caunoi.setLoai(c.getInt(c.getColumnIndex(LOAI)));
					caunoi.setYeuthich(c.getInt(c.getColumnIndex(YEUTHICH)));
					
					
					
					caunoi.setNdanh(c.getString(c.getColumnIndex(NDANH)));
					caunoi.setNdviet(c.getString(c.getColumnIndex(NDVIET)));
				
					System.out.println("danh dach cau noi thong dung la "+ list.toString());
					list.add(caunoi);
				}
				
				
				return list;
			}

			
	
	
}
