package com.gjuan.mapas;

import java.util.Calendar;

public class tiempo {
    Calendar c= Calendar.getInstance();
    private int dia,mes,anio,hora,minu,seg;
    public tiempo(){
     dia=c.get(Calendar.DATE);
        mes=c.get(Calendar.MONTH)+1;
        anio=c.get(Calendar.YEAR);
        hora=c.get(Calendar.HOUR);
        minu=c.get(Calendar.MINUTE);
        seg=c.get(Calendar.SECOND);
    }
        public String verFecha(){
            return String.format("%02d/%02d/%02d",dia,mes,anio);
        }
    public String verHora(){
        return  String.format("%02d/%02d/%02d",hora,minu,seg);
    }
}
