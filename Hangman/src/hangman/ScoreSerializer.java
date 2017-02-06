/***************************************************************
* file: ScoreSerializer.java
* author: Luis Cortes, Oscar Hernandez, Henry Hu, Y-Uyen La, and An Le 
* class: CS 245 - Programming Graphical User Interfaces
*
* assignment: Swing Project v1.3
* date last modified: 2/5/2017
*
* purpose: This class is used for loading and saving scores by serializing a 
* score array.
*
****************************************************************/ 
package hangman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ScoreSerializer implements Serializable {
    
    //method: loadScores
    //purpose: Loads scores from a file and dumps them into a Score array.
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

    //method: saveScores
    //purpose: Given an array of scores, save them to a file on disk.
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
