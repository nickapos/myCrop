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

/*
 * AboutWindow.java
 * This class will create a window with a text area and depending on the need
 * will present in the text are a message, be it an about or a readme.
 * Created on 11 Αυγ 2010, 9:51:33 μμ
 */
package gr.oncrete.nick.myCrop.UserInterface;

import gr.oncrete.nick.myCrop.BusinessLogic.InsertNutrientType;
import gr.oncrete.nick.myCrop.BusinessLogic.NutrientType;
import gr.oncrete.nick.myCrop.BusinessLogic.SelectInfo.SelectNutrientTypeDetails;
import gr.oncrete.nick.myCrop.BusinessLogic.DeleteNutrientType;
import gr.oncrete.nick.myCrop.BusinessLogic.UpdateInfo.UpdateNutrientTypeRecord;

/**
 *
 * @author nickapos
 */
public class NutrientTypesWindow extends javax.swing.JFrame {

    /** Creates new form AboutWindow */
    public NutrientTypesWindow() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nutTypeActionComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        nutTypeComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        nutTypeNameTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nutTypeSymbolTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        atomicWeightTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nutTypeObservationsTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        executeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("gr/oncrete/nick/myCrop/UserInterface/Bundle"); // NOI18N
        setTitle(bundle.getString("NutrientTypesWindow.title")); // NOI18N
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setLayout(new java.awt.GridLayout(7, 2));

        jLabel2.setText(bundle.getString("NutrientTypesWindow.jLabel2.text")); // NOI18N
        jPanel1.add(jLabel2);

        nutTypeActionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Insert", "Edit", "Delete" }));
        nutTypeActionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutTypeActionComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(nutTypeActionComboBox);

        jLabel4.setText(bundle.getString("NutrientTypesWindow.jLabel4.text")); // NOI18N
        jPanel1.add(jLabel4);

        nutTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(this.getNutTypesCombo()));
        nutTypeComboBox.setEnabled(false);
        nutTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutTypeComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(nutTypeComboBox);

        jLabel5.setText(bundle.getString("NutrientTypesWindow.jLabel5.text")); // NOI18N
        jPanel1.add(jLabel5);

        nutTypeNameTextField.setText(bundle.getString("NutrientTypesWindow.nutTypeNameTextField.text")); // NOI18N
        nutTypeNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutTypeNameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(nutTypeNameTextField);

        jLabel6.setText(bundle.getString("NutrientTypesWindow.jLabel6.text")); // NOI18N
        jPanel1.add(jLabel6);

        nutTypeSymbolTextField.setText(bundle.getString("NutrientTypesWindow.nutTypeSymbolTextField.text")); // NOI18N
        jPanel1.add(nutTypeSymbolTextField);

        jLabel7.setText(bundle.getString("NutrientTypesWindow.jLabel7.text")); // NOI18N
        jPanel1.add(jLabel7);

        atomicWeightTextField.setText(bundle.getString("NutrientTypesWindow.atomicWeightTextField.text")); // NOI18N
        jPanel1.add(atomicWeightTextField);

        jLabel1.setText(bundle.getString("NutrientTypesWindow.jLabel1.text")); // NOI18N
        jPanel1.add(jLabel1);

        nutTypeObservationsTextArea.setColumns(20);
        nutTypeObservationsTextArea.setRows(5);
        jScrollPane1.setViewportView(nutTypeObservationsTextArea);

        jPanel1.add(jScrollPane1);

        jLabel3.setText(bundle.getString("NutrientTypesWindow.jLabel3.text")); // NOI18N
        jPanel1.add(jLabel3);

        executeButton.setText(bundle.getString("NutrientTypesWindow.executeButton.text")); // NOI18N
        executeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(executeButton);

        getContentPane().add(jPanel1);

        getAccessibleContext().setAccessibleName(bundle.getString("NutrientTypesWindow.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void executeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeButtonActionPerformed
        int a = nutTypeActionComboBox.getSelectedIndex();
        if (a == 0)//if selected action is insert
        {
            String nutTypeName = nutTypeNameTextField.getText();
            String nutTypeSymbol = nutTypeSymbolTextField.getText();
            String nutTypeObs = nutTypeObservationsTextArea.getText();
            String aweight=atomicWeightTextField.getText();
            InsertNutrientType i = new InsertNutrientType(nutTypeName, nutTypeSymbol,aweight, nutTypeObs);
            this.refreshNutTypeCombo();
            this.clearFields();

        } else if (a == 1)//if selected action is edit
        {
            String nutTypeName = nutTypeNameTextField.getText();
            String nutTypeSymbol = nutTypeSymbolTextField.getText();
            String nutTypeObs = nutTypeObservationsTextArea.getText();
            String aweight=atomicWeightTextField.getText();
            UpdateNutrientTypeRecord u = new UpdateNutrientTypeRecord(nutTypeName,aweight,nutTypeSymbol,nutTypeObs);
            this.refreshNutTypeCombo();
            this.clearFields();
        } else if (a == 2)//if selected action is delete
        {
            String o = (String) nutTypeComboBox.getSelectedItem();
            if (o.length() > 0) {
                DeleteNutrientType dnt = new DeleteNutrientType(o);
                this.clearFields();
            }
            this.refreshNutTypeCombo();
        }


    }//GEN-LAST:event_executeButtonActionPerformed

    private void nutTypeNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutTypeNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nutTypeNameTextFieldActionPerformed

    private void nutTypeActionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutTypeActionComboBoxActionPerformed
        int a = nutTypeActionComboBox.getSelectedIndex();
        if (a == 0)//if selected action is insert
        {
            nutTypeComboBox.setEnabled(false);

        } else if (a == 1)//if selected action is edit
        {
            nutTypeComboBox.setEnabled(true);

        } else if (a == 2)//if selected action is delete
        {
            nutTypeComboBox.setEnabled(true);
        }
    }//GEN-LAST:event_nutTypeActionComboBoxActionPerformed

    private void nutTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutTypeComboBoxActionPerformed
        String a = (String) nutTypeComboBox.getSelectedItem();
        if (a.length() > 0) {
            SelectNutrientTypeDetails sn = new SelectNutrientTypeDetails();
            sn.SelectNutrientTypeDetailsWithName(a);
            nutTypeNameTextField.setText(sn.getName());
            nutTypeSymbolTextField.setText(sn.getSymbol());
            atomicWeightTextField.setText(sn.getaWeight());
            nutTypeObservationsTextArea.setText(sn.getObservations());
        }
    }//GEN-LAST:event_nutTypeComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NutrientTypesWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField atomicWeightTextField;
    private javax.swing.JButton executeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox nutTypeActionComboBox;
    private javax.swing.JComboBox nutTypeComboBox;
    private javax.swing.JTextField nutTypeNameTextField;
    private javax.swing.JTextArea nutTypeObservationsTextArea;
    private javax.swing.JTextField nutTypeSymbolTextField;
    // End of variables declaration//GEN-END:variables

   private String[] getNutTypesCombo() {
        NutrientType nt = new NutrientType();
        return nt.names();
    }

    private void refreshNutTypeCombo() {
        nutTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(this.getNutTypesCombo()));
    }

    /**
     * make the window appear in the appropriate thread
     * to be called from inside the main application frame
     *
     */
    public void displayWindow()
    {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NutrientTypesWindow().setVisible(true);
            }
        });
    }

    private void clearFields()
    {
        nutTypeNameTextField.setText("");
        nutTypeSymbolTextField.setText("");
        atomicWeightTextField.setText("");
        nutTypeObservationsTextArea.setText("");
    }
}