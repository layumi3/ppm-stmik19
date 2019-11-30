/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Iterator;
/**
 * Kelas ini digunakan untuk mengubah JSON menjadi string.
 */
public class JSONHandler {
    private String nama; 
    private int urutan;
    private String jkelamin;
    private String keterangan;
    
    /**
     * Metode untuk membaca JSON menjadi data per bagian. Setelah didapat data, data 
     * disusun menjadi sebuah string yang menunjukkan seluruh data dalam JSON.
     * @param t JSONObject Data dalam bentuk JSON.
     * @return String Hasil penyusunan JSON menjadi String.
     */
    public String convert(JSONArray t){
        Iterator<String> i = t.iterator();
        while(i.hasNext()){
            nama = t.get("nama");
            urutan = t.get("urutan");
            if(t.get("jenis_kelamin") == 0){
                jkelamin = "pria";
            }else{
                jkelamin = "wanita";
            }
            keterangan = (String)t.get("keterangan");
            String result = "nama: "+nama+"\n"
                    +"urutan: "+urutan+"\n"
                    +"jenis kelamin: "+jkelamin+"\n"
                    +"keterangan: "+keterangan+"\n\n";
        }
        return result;
    }
    
    /**
     * Metode untuk mengubah data satuan menjadi JSONObject dan menambahkannya ke
     * JSONArray yang disediakan sebagai argumen metode. 
     * @param a String nama yang akan ditambahkan ke JSON.
     * @param b long nomor urut yang akan ditambahkan ke JSON.
     * @param c String jenis kelamin yang ditambahkan ke JSON. 1 untuk pria dan 0 untuk wanita
     * @param d String keterangan yang ditambahkan ke JSON.
     * @param e JSONArray obyek JSONArray yang menyimpan seluruh data yang akan ditulis ke file JSON.
     */
    public void arrange(String a, long b, String c, String d, JSONArray e){
        JSONObject x = new JSONObject();
        x.put("nama", d);
        x.put("urutan", c);
        if(b == "pria"){
            x.put("jenis_kelamin", "1");
        }else{
            x.put("jenis_kelamin", "0");
        }
        x.put("keterangan", a);
        e.add(x);
    }
}
