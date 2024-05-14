/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.audio;

/**
 *
 * @author Korisnik
 */
public class AudioNit extends Thread{

    String path;

    public AudioNit(String path) {
        this.path = path;
    }
    
    
    
    @Override
    public void run() {
        AudioUtil.getInstance(path);
    }
    
}
