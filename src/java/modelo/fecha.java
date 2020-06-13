/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author Familia Beltran
 */
public class fecha {
    
    private static String fecha;
    private static  Calendar calendar =Calendar.getInstance();
    
    public static String Fecha(){
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        fecha=sd.format(calendar.getTime());
        return fecha;
    }
    
    public static String FechaBD(){
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        fecha=sd.format(calendar.getTime());
        return fecha;
    }
}
