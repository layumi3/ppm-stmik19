/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Kelas ini merupakan kelas main dalam program. Kelas akan membaca file JSON 
 * yang ada dalam folder files dan mengeluarkan datanya dalam konsol.
 */
public class MainClass {
    public JSONArray data;
    
    /**
     * Metode untuk membaca isi data file Data.json yang ada dalam folder files.
     * Data yang dibaca dimasukkan dalam JSONObject data.
     */
    public void loadFile(){
        try{
            FileReader r = new FileReader("files/");
            JSONParser p = new JSONParser();
            Object o = (JSONObject)p.parse(r);
            data = (JSONArray)o;
            r.close();
        }catch(FileNotFoundException fe){
            fe.getMessage();
        }catch(ParseException p){
            p.getMessage();
        }catch(IOException e){
            e.getMessage();
        }
    }
    
    /**
     * Mengubah data JSON menjadi string dengan menggunakan bantuan dari kelas 
     * JSONHandler.
     * @return String yang berisi data dari file JSON.
     */
    public String showResult(){
        JSONHandler j = new JSONHandler();
        String result = j.convert(data);
        return result;
    }
    
    public void writeJSON (String a, long b, String c, String d){
        loadFile();
        JSONHandler j = new JSONHandler();
        j.arrange(a, b, c, d, data);
        try{
            FileWriter f = new FileWriter("files/Data.json");
            f.write(data.toJSONString());
            f.flush();
            f.close();
        }catch (IOException e){
            e.getMessage();
        }
    } 
    
    /**
     * Metode utama yang dijalankan saat program dieksekusi. Mengatur interaksi
     * antara pengguna dan program. Pengguna dapat memilih 2 aksi pada program. 
     * Pilihan 'baca' akan memuat data dari file JSON dan menampilkan hasilnya. 
     * Pilihan 'tulis' menambahkan data dari pengguna ke file JSON.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainClass a = new MainClass();
        Scanner s = Scanner(System.in);
        System.out.println("Apa yang ingin dilakukan? [baca/tulis]:");
        String s = s.nextLine();
        if(s == "baca"){
            a.loadFile();
            System.out.println(a.showResult());
        }else if(s == "tulis"){
            System.out.println("Nama: ");
            String n = s.nextLine();
            System.out.println("Urutan: ");
            long d = Long.getLong(s.nextLine());
            System.out.println("Jenis kelamin [pria/wanita]: ");
            String k = s.nextLine();
            System.out.println("Keterangan: ");
            String l = s.nextLine();
            a.writeJSON(n, d, k, l);
        }
    }
    
}
