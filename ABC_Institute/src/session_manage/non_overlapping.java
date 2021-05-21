/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session_manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * 
 */
public class non_overlapping extends javax.swing.JPanel {

    private Connection conn = null;

    public non_overlapping() {
        initComponents();
        load_nonoverLapping();
        room_listto_cmb();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	}
        });
        table_one = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 15));
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton1.setFont(new Font("Tahoma", Font.BOLD, 10));
        jButton2 = new javax.swing.JButton();
        jButton2.setFont(new Font("Tahoma", Font.BOLD, 10));
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        table_one.setAutoCreateRowSorter(true);
        table_one.setBackground(new java.awt.Color(51, 51, 51));
        table_one.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        table_one.setForeground(new java.awt.Color(255, 255, 255));
        table_one.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Session Code", "Lecturer One", "Lecturer Two", "Subject Name", "Subject Code", "Group Id", "Tag", "No Of Student", "Duration", "Room"
            }
        ));
        table_one.setGridColor(new java.awt.Color(255, 255, 255));
        table_one.setIntercellSpacing(new java.awt.Dimension(5, 5));
        table_one.setRowHeight(25);
        table_one.setSelectionBackground(new java.awt.Color(122, 71, 221));
        table_one.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_oneMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_one);

        jLabel1.setText("Non Overlapping");

        jLabel2.setText("Id");

        jLabel3.setText("Room");

        jButton1.setText("update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jScrollPane3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jTextField1)
        				.addComponent(jComboBox1, 0, 174, Short.MAX_VALUE))
        			.addGap(31)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addGap(157)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(225, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(11)
        			.addComponent(jLabel1)
        			.addGap(18)
        			.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel4))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jButton2)
        						.addComponent(jButton1)))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    private void table_oneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_oneMouseClicked
        getSelected_rowid();
    }//GEN-LAST:event_table_oneMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        save_rooms();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        remove_room();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table_one;
    // End of variables declaration//GEN-END:variables

    private void load_nonoverLapping() {
        try {
            DefaultTableModel df = (DefaultTableModel) table_one.getModel();
            df.setRowCount(0);
            String strSetData = "SELECT * FROM abc.nonoverlap";
            ResultSet rs = mydb.search(strSetData);
            String strDsc;
            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("non_Code"));
                v.add(rs.getString("lecturer_1"));
                v.add(rs.getString("lecturer_2"));
                v.add(rs.getString("subjectName"));
                v.add(rs.getString("subjectCode"));
                v.add(rs.getString("groupID"));
                v.add(rs.getString("tag"));
                v.add(rs.getString("noOfStudents"));
                v.add(rs.getString("duration"));
                v.add(rs.getString("room"));
                df.addRow(v);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getSelected_rowid() {
        int tblRow = table_one.getSelectedRow();
        DefaultTableModel df = (DefaultTableModel) table_one.getModel();
        jTextField1.setText(df.getValueAt(tblRow, 0).toString());
        try {
            String strSetData = "SELECT * FROM nonoverlap" + " " + "where " + "non_Code = " + "'" + df.getValueAt(tblRow, 0) + "'";
            System.out.println(strSetData);
            ResultSet rs = mydb.search(strSetData);
            String strDsc;
            if (rs.next()) {

                strDsc = rs.getString("non_id");
                jLabel4.setText(strDsc);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void room_listto_cmb() {
        try {

            String strSetData = "SELECT * FROM location";
            ResultSet rs = mydb.search(strSetData);
            String strDsc;
            while (rs.next()) {

                strDsc = rs.getString("room");
                jComboBox1.addItem(strDsc);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void save_rooms() {
        try {
            int dialogButton = 0;
            if (jTextField1.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter session Code");
            } else {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Do you confirm to save?", "Warning", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    //
                    conn = mydb.getDBCon();
                    conn.setAutoCommit(false);
                    String strSave = "update nonoverlap set room = '" + jComboBox1.getSelectedItem() + "' where non_id='" + jLabel4.getText() + "'";
                    mydb.iud(strSave);
                    conn.commit();
                    JOptionPane.showMessageDialog(this, "Success");
                    load_nonoverLapping();
                    //
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void search_id() {
        try {
            String strSetData = "SELECT * FROM nonoverlap" + "where " + "non_Code=" + "'" + jTextField1.getText() + "'";
            System.out.println(strSetData);
            ResultSet rs = mydb.search(strSetData);
            String strDsc;
            if (rs.next()) {

                strDsc = rs.getString("non_id");
                jLabel4.setText(strDsc);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void remove_room() {
        try {
            String ss = null;
            String strSave = "update nonoverlap set room = '" + ss + "' where non_id='" + jLabel4.getText() + "'";
            mydb.iud(strSave);
            JOptionPane.showMessageDialog(this, "Success");
            load_nonoverLapping();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
