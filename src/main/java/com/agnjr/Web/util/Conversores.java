package com.agnjr.Web.util;

import com.agnjr.Web.model.Picador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class Conversores {



    public Date stringParaData(String dataString)
    {
        try {
            String DataAbertura = dataString;
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dt = df.parse(DataAbertura);
            java.sql.Date dataAberturaSql = new java.sql.Date(dt.getTime());

            return dataAberturaSql;
        }
        catch (Exception ex) {
            return null;
        }
    }


    public Calendar dataAtual(){
        Calendar c = Calendar.getInstance();
        return  c;
    }



    public String dataTimeParaString(Calendar dataString)
    {
        try {

            String st = (String) dataString.clone().toString();

            return st;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Formato inválido de data, favor inserir no formato: 1994-06-21");
            return null;
        }
    }



    public List<Boolean> wordToBool(int word) {

        List<Boolean> list=new ArrayList<Boolean>(Arrays.asList(new Boolean[15]));

        int cBit00=0;
        int cBit01=0;
        int cBit02=0;
        int cBit03=0;
        int cBit04=0;
        int cBit05=0;
        int cBit06=0;
        int cBit07=0;
        int cBit08=0;
        int cBit09=0;
        int cBit10=0;
        int cBit11=0;
        int cBit12=0;
        int cBit13=0;
        int cBit14=0;
        int cBit15=0;


        Boolean bit00=false;
        Boolean bit01=false;
        Boolean bit02=false;
        Boolean bit03=false;
        Boolean bit04=false;
        Boolean bit05=false;
        Boolean bit06=false;
        Boolean bit07=false;
        Boolean bit08=false;
        Boolean bit09=false;
        Boolean bit10=false;
        Boolean bit11=false;
        Boolean bit12=false;
        Boolean bit13=false;
        Boolean bit14=false;
        Boolean bit15=false;

        //Carrega valor da word
        cBit15=word;

        System.out.println("Valor alarmes: " + word);

        if(cBit15>=32768){
            cBit15=cBit15-32768;
            bit15=true;
        }
        if(cBit15<32768){
            cBit14=cBit15;
        }

        if(cBit14>=16384){
            cBit14=cBit14-16384;
            bit14=true;
        }
        if(cBit14<16384){
            cBit13=cBit14;
        }


        if(cBit13>=8192){
            cBit13=cBit13-8192;
            bit13=true;
        }
        if(cBit13<8192){
            cBit12=cBit13;
        }


        if(cBit12>=4096){
            cBit12=cBit12-4096;
            bit12=true;
        }
        if(cBit12<4096){
            cBit11=cBit12;
        }


        if(cBit11>=2048){
            cBit11=cBit11-2048;
            bit11=true;
        }
        if(cBit11<2048){
            cBit10=cBit11;
        }


        if(cBit10>=1024){
            cBit10=cBit10-1024;
            bit10=true;
        }
        if(cBit10<1024){
            cBit09=cBit10;
        }


        if(cBit09>=512){
            cBit09=cBit09-512;
            bit09=true;
        }
        if(cBit09<512){
            cBit08=cBit09;
        }


        if(cBit08>=256){
            cBit08=cBit08-256;
            bit08=true;
        }
        if(cBit08<256){
            cBit07=cBit08;
        }


        if(cBit07>=128){
            cBit07=cBit07-128;
            bit07=true;
        }
        if(cBit07<128){
            cBit06=cBit07;
        }


        if(cBit06>=64){
            cBit06=cBit06-64;
            bit06=true;
        }
        if(cBit06<64){
            cBit05=cBit06;
        }


        if(cBit05>=32){
            cBit05=cBit05-32;
            bit05=true;
        }
        if(cBit05<32){
            cBit04=cBit05;
        }


        if(cBit04>=16){
            cBit04=cBit04-16;
            bit04=true;
        }
        if(cBit04<16){
            cBit03=cBit04;
        }


        if(cBit03>=8){
            cBit03=cBit03-8;
            bit03=true;
        }
        if(cBit03<8){
            cBit02=cBit03;
        }


        if(cBit02>=4){
            cBit02=cBit02-4;
            bit02=true;
        }
        if(cBit02<4){
            cBit01=cBit02;
        }


        if(cBit01>=2){
            cBit01=cBit01-2;
            bit01=true;
        }
        if(cBit01<2){
            cBit00=cBit01;
        }


        if(cBit00>=1){
            cBit00=cBit00-1;
            bit00=true;
        }

        list.clear();


        if(bit00==false && bit01==false && bit02==false && bit03==false && bit04==false && bit05==false && bit06==false && bit07==false && bit08==false && bit09==false && bit10==false && bit11==false && bit12==false) {
            bit12 = true;
        }else {
            bit12=false;
        }



        list.add(bit00);
        list.add(bit01);
        list.add(bit02);
        list.add(bit03);
        list.add(bit04);
        list.add(bit05);
        list.add(bit06);
        list.add(bit07);



        list.add(bit08);
        list.add(bit09);
        list.add(bit10);
        list.add(bit11);
        list.add(bit12);
        list.add(bit13);
        list.add(bit14);
        list.add(bit15);



        return list;
    }

    public String dataParaString(Date dataString)
    {
        try {

            String st = (String) dataString.clone().toString();

            return st;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Formato inválido de data, favor inserir no formato: 1994-06-21");
            return null;
        }
    }


    public double stringParaDouble(String stringDouble)
    {
        try {
            String horasEstimasString = stringDouble.replaceAll(",", ".");
            Double valorDouble = Double.parseDouble(horasEstimasString);

            return valorDouble;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Formato inválido de Double, confira e tente novamente!");
            return 0;
        }
    }







    public float stringParaFloat(String stringFloat)
    {
        try {
            String horasEstimasString = stringFloat.replaceAll(",", ".");
            Float valorDouble = Float.parseFloat(horasEstimasString);

            return valorDouble;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Formato inválido de Double, confira e tente novamente!");
            return 0;
        }
    }




    public int stringParaInt(String stringFloat)
    {
        try {
            int i = Integer.parseInt(stringFloat);
            return i;
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Formato inválido de Inteiro, confira e tente novamente!");
            return 0;
        }
    }



}
