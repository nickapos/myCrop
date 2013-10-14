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

package gr.oncrete.nick.myCrop.BusinessLogic.ImportDB;
import gr.oncrete.nick.myCrop.BusinessLogic.FileHandlers.FileHandlerReadFile;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author nickapos
 */
public class ImportFile {


    private String fileName;//the file name to be imported
    private FileHandlerReadFile reader;
    public ImportFile()
    {

    }

    public void setFileName(String fname)
    {
        fileName=fname;
    }

    public String getFileName()
    {
        return fileName;
    }

    /**
     * this method will read the file provided by filename and return its contents in an arraylist
     *
     *
     * @return the contents of the file read
     */
    protected ArrayList<String> readFile()
    {
        reader = new FileHandlerReadFile(fileName);
        reader.readFile();
        return reader.returnContents();
    }

    public void importFileToDB()
    {
        ArrayList a = this.readFile();

        Iterator b = a.iterator();
        while (b.hasNext() && b.next()!=null)
        {
            System.out.println(b.next());
        }
    }


}
