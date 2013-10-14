/*
 *  Copyright (C) 2010 nickapos
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package gr.oncrete.nick.myCrop.BusinessLogic.FileHandlers;

import javax.swing.SwingWorker;
import java.util.ArrayList;

/**
 *This class is intentend to be used when we want a write or read file activity
 * to be preformed in a new thread.
 * @author nickapos 23 Νοε 2010
 */
public class NewThreadFileWriter extends SwingWorker<String, String> {

    String fileName;
    String content;

    public NewThreadFileWriter(String fname, String cont) {
        fileName = fname;
        content = cont;
    }
    /**
     * when we want to write a file
     * in a separate thread
     * @return
     */
@Override
    public String doInBackground() {
        MyFileWriter m = new MyFileWriter();
        m.createFile(fileName);
        m.writeToFile(content);
        m.closeFile();
        return "end of writing";
    }

}
