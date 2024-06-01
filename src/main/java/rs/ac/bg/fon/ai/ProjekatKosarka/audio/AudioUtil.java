/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.ProjekatKosarka.audio;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class AudioUtil {

    private static AudioUtil instance;

    public static AudioUtil getInstance(String path) {
        if (instance == null) {
            instance = new AudioUtil(path);
        }
        return instance;
    }

    private AudioUtil(String path) {
        pustiMix(path);
    }

    public void pustiMix(String path) {
        InputStream in = null;
        Clip clip = null;
        AudioInputStream audioStream = null;
        try {

            while (true) {
                Enumeration<URL> listaResursa = getClass().getClassLoader().getResources(path);
              
                   
                if (listaResursa.hasMoreElements()) {
                    URL resource = listaResursa.nextElement();
                    File folder = new File(resource.toURI());
                    File[] files = folder.listFiles();
                    for (File file : files) {
                        String filePath = file.getName();
                        
                        System.out.println(filePath);
                        
                        in = getClass().getClassLoader().getResourceAsStream(path+"/" + filePath);
                    if (in == null) {
                        throw new RuntimeException("Ne postoji takav fajl");
                    }

                    audioStream = AudioSystem.getAudioInputStream(in);
                    clip = AudioSystem.getClip();
                    clip.open(audioStream);
                    clip.start();
                    Thread.sleep(clip.getMicrosecondLength() / 1000);
                        
                    }
                    
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Problem sa pustanjem muzike u pozadini");
        } finally {
            try {
                if (clip != null) {
                    clip.close();
                }
                if (audioStream != null) {
                    audioStream.close();
                }
                if (in != null) {
                    audioStream.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(AudioUtil.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
