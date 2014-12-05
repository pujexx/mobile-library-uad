package com.pujexx.mlibraryuad.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pujexx on 8/26/14.
 */
public class DateConverter {

    public String toLocalFormat(String date){

        int bulan =1;
        int tahun = 1;
        int hari =1;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");

        Date testDate = null;
        try {
            testDate = sdf.parse(date);
           /* bulan = testDate.getMonth();
            tahun = testDate.getYear();
            hari = testDate.getDay();*/
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        //return String.valueOf(hari)+" "+this.Bulan(bulan)+" "+String.valueOf(tahun);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");



        String newFormat = formatter.format(testDate);

       /* Date datereformat = null;
        try{
            datereformat = formatter.parse(newFormat);
            bulan = datereformat.getMonth();
            tahun = datereformat.getYear();
            hari = datereformat.getDay();
        }catch (ParseException e){
            e.printStackTrace();
        }
*/


        String[] split = newFormat.split("-");
        hari = Integer.parseInt(split[0]);
        bulan = Integer.parseInt(split[1]);
        tahun = Integer.parseInt(split[2]);

       // return newFormat;
        return String.valueOf(hari)+" "+this.Bulan(bulan)+" "+String.valueOf(tahun);

        //System.out.println(".....Date..."+newFormat);
    }

    public String parseTime(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");

        Date testDate = null;
        try {
            testDate = sdf.parse(date);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:MM:SS");
        String stringdate = date;
        String[] times = stringdate.split(" ");
        String[] time = times[1].split(":");
        return  time[0]+" : "+time[1];
    }

    public String Bulan(int bulan){
        String namaBulan = "Januari";
        switch (bulan){
            case 1 :
                namaBulan = "Januari";
               break;
            case 2 :
                namaBulan = "Februari";
                break;
            case 3 :
                namaBulan = "Maret";
                break;
            case 4 :
                namaBulan = "April";
                break;
            case 5 :
                namaBulan = "Mei";
                break;
            case 6 :
                namaBulan = "Juni";
                break;
            case 7 :
                namaBulan = "Juli";
                break;
            case 8 :
                namaBulan = "Agustus";
                break;
            case 9 :
                namaBulan = "September";
                break;
            case 10 :
                namaBulan = "Oktober";
                break;
            case 11 :
                namaBulan = "November";
                break;
            case 12 :
                namaBulan = "Desember";
                break;
            default:
                namaBulan = "Januari";
                break;
        }
        return namaBulan;
    }
}
