/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controllers.LocationController;
import Models.Location;
import itpm.Main;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JPanel;

/**
 *
 * @author Roshan Withanage
 */
public class ManageLocations extends javax.swing.JFrame {

    /**
     * Creates new form ManageLocations
     */
    public ManageLocations() {
    	setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        try {
            loadTable();
        } catch (Exception ex) {
            Logger.getLogger(ManageLocations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void serchDataFromTable(String s) {
        DefaultTableModel dtm = (DefaultTableModel) this.table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtm);
        table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(s));
    }

    private void loadTable() throws Exception {
        List<Location> details = null;

        details = LocationController.getInstance().SearchAll();

        DefaultTableModel but_dt = (DefaultTableModel) this.table.getModel();
        but_dt.setRowCount(0);

        for (int i = 0; i < details.size(); i++) {
            Vector v = new Vector();

            Location obj = details.get(i);

            v.add(obj.getId());
            v.add(obj.getBuilding());
            v.add(obj.getRoom());
            v.add(obj.getRoom_type());
            v.add(obj.getCapacity());

            but_dt.addRow(v);

        }
    }

    private void resetTxt() {
        id.setText("0");
        building_txt.setText("");
        room_txt.setText("");
        r1.setSelected(true);
        r2.setSelected(false);
        capacity_txt.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        id = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        building_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        room_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        r1 = new javax.swing.JRadioButton();
        r1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        r2 = new javax.swing.JRadioButton();
        r2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jLabel5 = new javax.swing.JLabel();
        capacity_txt = new javax.swing.JTextField();
        clear_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton1.setFont(new Font("Tahoma", Font.BOLD, 20));
        search = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton3.setFont(new Font("Tahoma", Font.BOLD, 15));
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator2.setForeground(new Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(1440, 810));
        jPanel1.setPreferredSize(new java.awt.Dimension(1440, 810));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Building", "Room", "Room Type", "capacity"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        id.setBackground(new java.awt.Color(153, 255, 255));
        id.setForeground(new Color(0, 102, 255));
        id.setText("0");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("ABC Institute");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new Font("Dialog", Font.BOLD, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Building Name");

        building_txt.setBackground(new java.awt.Color(255, 255, 255));
        building_txt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        building_txt.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new Font("Dialog", Font.BOLD, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Room Name");

        room_txt.setBackground(new java.awt.Color(255, 255, 255));
        room_txt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        room_txt.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new Font("Dialog", Font.BOLD, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Room Type");

        r1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(r1);
        r1.setForeground(new java.awt.Color(0, 0, 0));
        r1.setSelected(true);
        r1.setText("Lecture Hall");

        r2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(r2);
        r2.setForeground(new java.awt.Color(0, 0, 0));
        r2.setText("Laboratory");

        jLabel5.setFont(new Font("Dialog", Font.BOLD, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Capacity");

        capacity_txt.setBackground(new java.awt.Color(255, 255, 255));
        capacity_txt.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        capacity_txt.setForeground(new java.awt.Color(0, 0, 0));
        capacity_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                capacity_txtKeyTyped(evt);
            }
        });

        clear_btn.setFont(new Font("Dialog", Font.BOLD, 15)); // NOI18N
        clear_btn.setForeground(new java.awt.Color(0, 0, 0));
        clear_btn.setText("Clear");
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });

        delete_btn.setFont(new Font("Dialog", Font.BOLD, 15)); // NOI18N
        delete_btn.setForeground(new java.awt.Color(0, 0, 0));
        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        update_btn.setFont(new Font("Dialog", Font.BOLD, 15)); // NOI18N
        update_btn.setForeground(new java.awt.Color(0, 0, 0));
        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(56)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel2)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel3)
        						.addComponent(jLabel4)
        						.addComponent(jLabel5))
        					.addGap(127)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(capacity_txt, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(r1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
        							.addComponent(room_txt, 257, 257, 257)
        							.addComponent(building_txt, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
        							.addComponent(r2, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(update_btn, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
        					.addGap(98)
        					.addComponent(delete_btn, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
        					.addComponent(clear_btn, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(36)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(building_txt, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2))
        			.addGap(58)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(room_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(53)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel3)
        				.addComponent(r1))
        			.addGap(10)
        			.addComponent(r2)
        			.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(capacity_txt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(delete_btn, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
        				.addComponent(clear_btn, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
        				.addComponent(update_btn, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        			.addGap(54))
        );
        jPanel2Layout.linkSize(SwingConstants.VERTICAL, new Component[] {building_txt, room_txt, capacity_txt});
        jPanel2.setLayout(jPanel2Layout);

        jLabel1.setFont(new Font("Dialog", Font.BOLD, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Location Details");

        jLabel7.setFont(new Font("Dialog", Font.BOLD, 35)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Manage Locations");

        jButton1.setText("Add New Location");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setForeground(new java.awt.Color(0, 0, 0));

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        
        separator = new JSeparator();
        separator.setForeground(new Color(255, 255, 240));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(33)
        			.addComponent(id)
        			.addPreferredGap(ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
        			.addComponent(jLabel6)
        			.addGap(610))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(31)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)
        					.addGap(21)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addGap(31)
        							.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        								.addGroup(jPanel1Layout.createSequentialGroup()
        									.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addComponent(search, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
        								.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 709, GroupLayout.PREFERRED_SIZE))))
        					.addContainerGap(35, Short.MAX_VALUE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        					.addGap(421)
        					.addComponent(jLabel7)
        					.addContainerGap())))
        		.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addComponent(separator, GroupLayout.DEFAULT_SIZE, 1440, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(37)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel6)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(id)
        					.addGap(23)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(separator, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel7))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(18)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        							.addGap(7)
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(search, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        							.addGap(18)
        							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE))
        						.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(32)
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 546, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        if (id.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "Please Select to Update...");
        } else {
            Location obj = new Location();
            obj.setId(Integer.parseInt(id.getText()));
            obj.setBuilding(building_txt.getText());
            obj.setRoom(room_txt.getText());
            if (r1.isSelected()) {
                obj.setRoom_type(r1.getText());
            } else {
                obj.setRoom_type(r2.getText());
            }
            obj.setCapacity(Integer.parseInt(capacity_txt.getText()));

            try {
                LocationController.getInstance().Update(obj);
                JOptionPane.showMessageDialog(null, "Updated...");
                resetTxt();
                table.removeAll();
                loadTable();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_update_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        if (id.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "Please Select to Delete...");
        } else {
            Location obj = new Location();
            obj.setId(Integer.parseInt(id.getText()));

            try {
                LocationController.getInstance().Delete(obj);
                JOptionPane.showMessageDialog(null, "Deleted...");
                resetTxt();
                table.removeAll();
                loadTable();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) this.table.getModel();
        int sr = table.getSelectedRow();
        id.setText(dtm.getValueAt(sr, 0).toString());
        building_txt.setText(dtm.getValueAt(sr, 1).toString());
        room_txt.setText(dtm.getValueAt(sr, 2).toString());
        if (dtm.getValueAt(sr, 2).toString().equals(r1.getText())) {
            r1.setSelected(true);
            r2.setSelected(false);
        } else {
            r1.setSelected(false);
            r2.setSelected(true);
        }
        capacity_txt.setText(dtm.getValueAt(sr, 4).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        resetTxt();
    }//GEN-LAST:event_clear_btnActionPerformed

    private void capacity_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capacity_txtKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_capacity_txtKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AddLocation obj = new AddLocation();
        obj.setVisible(true);
        obj.setExtendedState(obj.getExtendedState() | obj.MAXIMIZED_BOTH);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Main obj = new Main();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        serchDataFromTable(search.getText());
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageLocations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageLocations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageLocations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageLocations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageLocations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField building_txt;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField capacity_txt;
    private javax.swing.JButton clear_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton r1;
    private javax.swing.JRadioButton r2;
    private javax.swing.JTextField room_txt;
    private javax.swing.JTextField search;
    private javax.swing.JTable table;
    private javax.swing.JButton update_btn;
    private JSeparator separator;
}