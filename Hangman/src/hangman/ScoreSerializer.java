/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author hh
 */
public class ScoreSerializer implements Serializable {
    
public Score[] loadScores(String filename) {
		File f = new File(filename);
		if (f.exists() && f.canRead()) {
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Score[] scores = (Score[]) ois.readObject();
				ois.close();
				return scores;
			} catch(Exception e) {
				return null;
			}
		}
		return null;
	}
	
	public void saveScores(String filename, Score[] scores) {
		File f = new File(filename);
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(scores);
			fos.close();
		} catch (Exception e) {
			System.out.println("Failed to save the registry");
		}
        }
}
