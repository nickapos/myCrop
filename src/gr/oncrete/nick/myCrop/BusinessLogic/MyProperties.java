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
package gr.oncrete.nick.myCrop.BusinessLogic;

import java.util.Properties;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;

/**
 *
 * This class is intendend to use the properties of the database
 * @author nickapos 16 Δεκ 2010
 */
public class MyProperties {

    Properties p;

    public MyProperties() {
        p = new Properties();
    }

    public MyProperties(Properties p1) {
        p = p1;
    }

    public void setDBUrl(String url) {
        p.setProperty("url", url);
    }

    public void setDBUName(String u) {
        p.setProperty("username", u);
    }

    public void setDBPass(String pas) {
        p.setProperty("password", pas);

    }

    /**
     * set the jdbc driver
     * @param pas
     */
    public void setDBDriver(String ddriver) {
        p.setProperty("dbdriver", ddriver);
    }

    /**
     * set the db name in a networked environment
     * or the dbfilename in a embeded environment
     * @param pas
     */
    public void setDBName(String dname) {
        p.setProperty("dbname", dname);
    }

    /**
     * get the jdbc driver
     * @param pas
     */
    public String getDBDriver() {
        return p.getProperty("dbdriver");
    }

    /**
     *
     * set the db name in a networked environment
     * or the dbfilename in a embeded environment
     * @return
     */
    public String getDBName() {
        return p.getProperty("dbname");
    }

    public String getDBUrl() {
        return p.getProperty("url");
    }

    public String getDBUname() {
        return p.getProperty("username");
    }

    public String getDBPass() {
        return p.getProperty("password");
    }

    /**
     * Store the application properties
     *
     */
    public void storeProperties() {
        try {
            FileWriter out = new FileWriter("appProperties");
            p.store(out, "---MyCrop Properties---");
            out.close();
        } catch (IOException ioe) {
            System.out.println("application properties saving error has occured");
            ioe.printStackTrace();
        }

    }

    /**
     *
     * load the application properties
     *
     */
    public void loadProperties() {
        try {
            FileReader in = new FileReader("appProperties");
            p.load(in);
            in.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("Unfortunately the configuration file was not found. Creating a default one.");
            this.defaultCfg();

        } catch (IOException ioe) {
            System.out.println("application properties loading error has occured");
            ioe.printStackTrace();
        }
    }

    /**
     * 
     * @return true if the properties object is empty
     */
    public boolean isEmpty() {
        return p.isEmpty();
    }

    /**
     * return the contents of the class in a string
     * @return
     */
    public String toStr() {
        if (!this.isEmpty()) {
            return this.getDBDriver() + this.getDBUrl() + this.getDBName() + this.getDBUname() + this.getDBPass();
        }
        return "";
    }

    /**
     * create a default cfg file
     *
     */
    private void defaultCfg() {
        this.setDBDriver("org.hsqldb.jdbcDriver");
        this.setDBUName("sa");
        this.setDBPass("");
        this.setDBUrl("jdbc:hsqldb:");
        this.setDBName("file:mydb");
        this.storeProperties();

    }
}
