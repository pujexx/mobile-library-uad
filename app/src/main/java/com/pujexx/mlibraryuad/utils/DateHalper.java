package com.pujexx.mlibraryuad.utils;

public class DateHalper {
	
	public static String convertMonth(int bulan){
		String stringbulan = "";
		switch (bulan) {
		case 1:
			stringbulan = "Jan";
			break;
		case 2:
			stringbulan = "Feb";
			break;
		case 3:
			stringbulan = "Mar";
			break;
		case 4:
			stringbulan = "Apr";
			break;
		case 5:
			stringbulan = "Mei";
			break;
		case 6:
			stringbulan = "Jun";
			break;
		case 7:
			stringbulan = "Jul";
			break;
		case 8:
			stringbulan = "Agu";
			break;
		case 9:
			stringbulan = "Sep";
			break;
		case 10:
			stringbulan = "Okt";
			break;
		case 11:
			stringbulan = "Nov";
			break;
		case 12:
			stringbulan = "Des";
			break;
		default:
			stringbulan = "Jan";
			break;
		}
		return stringbulan;
	}
	
	public static String Tanggal(String tanggal){
		
		String splittanggal[] = tanggal.split("-");
		
		String penanggalan = splittanggal[2]+" "+convertMonth(Integer.parseInt(splittanggal[1]))+" "+splittanggal[0];
		
		return penanggalan;
	}
	
	
	
}
