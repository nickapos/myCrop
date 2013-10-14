/*
        myBill, bills tracking program
    Copyright (C) 2010  Nick Apostolakis

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.oncrete.nick.myCrop.BusinessLogic.FileHandlers;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author nickapos
 */
public class MyFileWriter {


    BufferedWriter bufferedWriter;

    public MyFileWriter() {
    }

    /**
     * This method will create the file
     *
     * @param fileName
     */
    public void createFile(String fileName) {
        try {

            //Construct the BufferedWriter object
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF8"));

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

    /**
     *
     * this method will write to the file line per line
     *
     */
    public void writeToFile(String line) {
        try {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
    }

    //this method when called will flush everything and close the file
    public void closeFile() {
        try {
            if (bufferedWriter != null) {
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
