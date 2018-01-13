package secure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 
import static secure.login.SID;

/**
 *
 * @author sooryagangarajk
 */
public class TeacherFrame extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public static DefaultListModel dlm;
    public static boolean flag = false;
    public int ABRowCount = 0, rowCount = 0;
    static int lastRow;
    String sid = SID;
    public static String date;

    /**
     * Creates new form add
     */
    public TeacherFrame() {
        initComponents();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ////SGK////
        Vector comboBoxItems = new Vector();

        String Sql1 = "select SUB_NM from Subject_Details where SID='" + SID + "';";
        comboBoxItems = new Vector();
        conn = MySqlConnect.ConnectDB();
        try {
            Statement st = conn.createStatement();
            //status.setText("");
            rs = st.executeQuery(Sql1);
            while (rs.next()) {
                // status.setText(status.getText()+"\n"+rs.getString(1));
                comboBoxItems.add(rs.getString(1));

            }

        } catch (Exception e) {

        }

        final DefaultComboBoxModel model2 = new DefaultComboBoxModel(comboBoxItems);
        //jComboBox2.setModel(model2);
        jComboBox1.setModel(model2);

        ////SGK////
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        date = dtf.format(localDate);
        System.out.println(date);
        //////SGK//////

        comboBoxItems = new Vector();

        comboBoxItems.add(date + " 8:30:00");
        comboBoxItems.add(date + " 9:30:00");
        comboBoxItems.add(date + " 10:20:00");
        comboBoxItems.add(date + " 11:30:00");
        comboBoxItems.add(date + " 12:20:00");
        comboBoxItems.add(date + " 14:00:00");
        comboBoxItems.add(date + " 14:50:00");
        comboBoxItems.add(date + " 15:40:00");

        final DefaultComboBoxModel model3 = new DefaultComboBoxModel(comboBoxItems);
        jComboBox3.setModel(model3);
        ////SGK////

        String Sql4 = "select * from `Section`;";
        comboBoxItems = new Vector();
        conn = MySqlConnect.ConnectDB();
        try {
            Statement st = conn.createStatement();
            //status.setText("");
            rs = st.executeQuery(Sql4);
            while (rs.next()) {
                // status.setText(status.getText()+"\n"+rs.getString(1));
                comboBoxItems.add(rs.getString(1));

            }

        } catch (Exception e) {

        }

        final DefaultComboBoxModel model4 = new DefaultComboBoxModel(comboBoxItems);
        jComboBox4.setModel(model4);

        ///  select CLASS from `Student_Details` WHERE GROUP BY class;
    }

    public void loadData() {

        table.setDefaultEditor(Object.class, null);//Disables Editing
        tableAB.setDefaultEditor(Object.class, null);//Disables Editing
        System.out.println("loadData:" + flag);
        if (flag) {
            System.out.println("FLAG=TRUE");
            flag = false;
            conn = MySqlConnect.ConnectDB();
///select Name_Of_Student,USN from Student_Details where CLASS='CSE5B' order by USN ;

            String Sql = "select Name_Of_Student,USN from Student_Details where CLASS='" + jComboBox4.getSelectedItem().toString() + "' order by USN ;";
            String Sql1 = "select sd.Name_Of_Student,sd.USN from Student_Details sd,StudentAndSections sas where sd.USN=sas.USN and Section='" + jComboBox4.getSelectedItem().toString() + "';";
            try {
                pst = conn.prepareStatement(Sql1);
                rs = pst.executeQuery();
                rowCount = 0;
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                while (rs.next()) {
                    String column1 = rs.getString(1);
                    String column2 = rs.getString(2);
                    System.out.println(column1 + "" + column2);

                    model.setRowCount(rowCount + 1);
                    if (tableAB.getModel() != null) {
                        table.getModel().setValueAt(column1, rowCount, 0);
                    }
                    table.getModel().setValueAt(column2, rowCount, 1);

                    rowCount++;
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        ABtxt = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        total = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableAB = new javax.swing.JTable();
        Submit = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        datesCombo = new javax.swing.JComboBox<>();
        showBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ResultTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Attendance_count = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        StartingDate = new javax.swing.JComboBox<>();
        EndingDate = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel7.setText("Absentees list:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:30:00", "9:30:00", "10:20:00", "11:30:00", "12:20:00", "2:00:00", "2:50:00", "3:40:00", "" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUB" }));
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox2MouseEntered(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        ABtxt.setText(" ");
        ABtxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ABtxtMouseEntered(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "USN"
            }
        ));
        table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableFocusGained(evt);
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(table);

        total.setText("0");
        total.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                totalMouseEntered(evt);
            }
        });

        jLabel6.setText("Total List:");

        tableAB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "USN"
            }
        ));
        tableAB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableABMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableAB);

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE5B" }));
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox4MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ABtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Submit))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ABtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Submit)
                        .addComponent(jLabel6)
                        .addComponent(total)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Take Attendance", jPanel4);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "USN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        datesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017-12-30 8:30:00", "9:30:00", "10:20:00", "11:30:00", "12:20:00", "2:00:00", "2:50:00", "3:40:00" }));
        datesCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datesComboMouseClicked(evt);
            }
        });
        datesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datesComboActionPerformed(evt);
            }
        });

        showBtn.setText("Show all Absentees");
        showBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(datesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showBtn))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Check", jPanel2);

        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Attendance", "Name", "USN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ResultTable);

        jLabel1.setText("To:");

        jButton2.setText("Check");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Attendance shortage check");

        jLabel4.setText("Minimum Class Count:");

        Attendance_count.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Attendance_count.setText("70");
        Attendance_count.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Attendance_countMouseClicked(evt);
            }
        });

        jLabel5.setText("Subject:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ad Java" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox1MouseEntered(evt);
            }
        });

        StartingDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017-12-30 8:30:00", "9:30:00", "10:20:00", "11:30:00", "12:20:00", "2:00:00", "2:50:00", "3:40:00" }));
        StartingDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartingDateMouseClicked(evt);
            }
        });
        StartingDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartingDateActionPerformed(evt);
            }
        });

        EndingDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017-12-30 8:30:00", "9:30:00", "10:20:00", "11:30:00", "12:20:00", "2:00:00", "2:50:00", "3:40:00" }));
        EndingDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EndingDateMouseClicked(evt);
            }
        });
        EndingDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndingDateActionPerformed(evt);
            }
        });

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE5B" }));
        jComboBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox5MouseEntered(evt);
            }
        });
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel8.setText("Class:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addComponent(Attendance_count, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(StartingDate, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EndingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(StartingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EndingDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Attendance_count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Attendance Shortage", jPanel1);

        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TEACHER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(324, 324, 324)
                .addComponent(jButton3)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Attendance_countMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Attendance_countMouseClicked
        Attendance_count.setText("");
    }//GEN-LAST:event_Attendance_countMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ////SGK////        ResultTable
        if (!jComboBox5.getSelectedItem().equals("CSE5B") && !jComboBox5.getSelectedItem().toString().isEmpty()) {
            String subjectCode = "";
            String Section = jComboBox5.getSelectedItem().toString();

            conn = MySqlConnect.ConnectDB();
            String Sql0 = "select SUB_Code from SUBJECTS where SUB_NM='" + jComboBox1.getSelectedItem().toString() + "';";

            try {
                Statement st = conn.createStatement();
                rs = st.executeQuery(Sql0);
                if (rs.next()) {
                    subjectCode = rs.getString("SUB_Code");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            StartingDate.getSelectedItem().toString();
            EndingDate.getSelectedItem().toString();
            Attendance_count.getText();
            jComboBox1.getSelectedItem();

            ///
//        String Sql2 = "select COUNT(a.USN) ,s.Name_Of_Student, a.USN "
//                + "from Attendance a ,Student_Details s "
//                + "where a.P_A='1'  and a.USN=s.USN "
//                + "and a.SUB_Code='" + subjectCode + "' "
//                + "and a.DATE between '" + StartingDate.getSelectedItem().toString() + "' and '" + EndingDate.getSelectedItem().toString() + "' "
//                + "group by a.USN having COUNT(a.USN)<" + Attendance_count.getText() + ";";
            String Sql2 = "select COUNT(a.USN) ,s.Name_Of_Student, a.USN "
                    + "from Attendance a ,Student_Details s,StudentAndSections sas "
                    + "where sas.USN=s.USN and sas.Section='" + Section + "' and a.P_A='1'  "
                    + "and a.USN=s.USN and a.SUB_Code='" + subjectCode + "' "
                    + "and a.DATE between '" + StartingDate.getSelectedItem().toString() + "' and '" + EndingDate.getSelectedItem().toString() + "' "
                    + "group by a.USN having COUNT(a.USN)<" + Attendance_count.getText() + ";";
            
            
            /*
            
            select COUNT(a.USN) ,s.Name_Of_Student, a.USN from Attendance a ,Student_Details s,StudentAndSections sas 
            where sas.USN=s.USN and sas.Section='" + Section + "' and a.P_A='1'  
            and a.USN=s.USN and a.SUB_Code='" + subjectCode + "' 
            and a.DATE between '" + StartingDate.getSelectedItem().toString() + "' and '" + EndingDate.getSelectedItem().toString() + "' 
            group by a.USN having COUNT(a.USN)<70;"
            
            */

            try {
                Statement st = conn.createStatement();
                //status.setText("");
                rs = st.executeQuery(Sql2);
                //jTable1.getModel().getRowCount();

                DefaultTableModel model = (DefaultTableModel) ResultTable.getModel();
                //
                //while(model.getRowCount() > 0){
                //   for(int i = 0 ; i < model.getRowCount();i++){
                //      model.removeRow(i);
                //   }
                //}
                model.setRowCount(0);
                int rowCount = 0;
                while (rs.next()) {

                    String column1 = rs.getString(1);
                    String column2 = rs.getString(2);
                    String column3 = rs.getString(3);
                    System.out.println(column1 + ":" + column2 + ":" + column3);

                    if (ResultTable.getModel() != null) {
                        model.setRowCount(rowCount + 1);
                    }

                    ResultTable.getModel().setValueAt(column1, rowCount, 0);
                    ResultTable.getModel().setValueAt(column2, rowCount, 1);
                    ResultTable.getModel().setValueAt(column3, rowCount, 2);

                    rowCount++;
                }

            } catch (Exception e) {
                //status.setText(status.getText()+"\n"+e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void showBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtnActionPerformed
        ////// show all absentees
        String sItem = (String) datesCombo.getSelectedItem();
        //status
        String SID_here = SID;
        //status.setText(SID_here);

        conn = MySqlConnect.ConnectDB();
        String Sql = "select  sd.Name_Of_Student ,a.USN from Attendance a,Student_Details sd where a.USN=sd.USN and DATE='" + datesCombo.getSelectedItem().toString() + "' and SID='" + SID + "' and P_A='0';";

        try {
            Statement st = conn.createStatement();
            //status.setText("");
            rs = st.executeQuery(Sql);
            jTable1.getModel().getRowCount();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            //
            //while(model.getRowCount() > 0){
            //   for(int i = 0 ; i < model.getRowCount();i++){
            //      model.removeRow(i);
            //   }
            //}

            int rowCount = 0;
            while (rs.next()) {

                String column1 = rs.getString(1);
                String column2 = rs.getString(2);
                System.out.println(column1 + "" + column2);

                if (jTable1.getModel() != null) {
                    model.setRowCount(rowCount + 1);
                }
                jTable1.getModel().setValueAt(column1, rowCount, 0);
                jTable1.getModel().setValueAt(column2, rowCount, 1);

                rowCount++;
            }

        } catch (Exception e) {
            //status.setText(status.getText()+"\n"+e);
        }
        // dkdkd
    }//GEN-LAST:event_showBtnActionPerformed

    private void datesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datesComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datesComboActionPerformed

    private void datesComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datesComboMouseClicked

    }//GEN-LAST:event_datesComboMouseClicked

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        if (!jComboBox2.getSelectedItem().toString().equals("SUB")) {
            String subjectCode = "";
            //        conn = MySqlConnect.ConnectDB();
            //
            //        String Sql = "select Name_Of_Student,USN from `Mini_project`.`Student_Details` order by USN";
            //        try {
            //            pst = conn.prepareStatement(Sql);
            //            rs = pst.executeQuery();
            //            int rowCount=0;
            //            while (rs.next()) {
            //                String column1=rs.getString(1);
            //                String column2=rs.getString(2);
            //                dlm.addElement(column1);
            //
            //                table.getModel().setValueAt(column1, rowCount, 0);
            //                table.getModel().setValueAt(column2, rowCount, 1);
            //
            //                rowCount++;
            //            }
            //        } catch (SQLException ex) {
            //            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            //        }
            //
            //put all present

            conn = MySqlConnect.ConnectDB();
            String Sql0 = "select SUB_Code from SUBJECTS where SUB_NM='" + jComboBox2.getSelectedItem().toString() + "';";

            try {
                Statement st = conn.createStatement();
                rs = st.executeQuery(Sql0);
                if (rs.next()) {
                    subjectCode = rs.getString("SUB_Code");
                }
            } catch (SQLException ex) {
                Logger.getLogger(TeacherFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                ///
                conn = MySqlConnect.ConnectDB();
                //           String usn= usn2.getText().toUpperCase();
                //           String name= name2.getText();
                //           String add=add2.getText();
                //           String email=email2.getText();
                //           String phone=phone2.getText();

                String Sql = "INSERT INTO Attendance (SUB_Code, DATE, P_A, USN, SID) VALUES (?, ?, ?, ?, ?)";
                for (int i = 0; i < rowCount; i++) {
                    PreparedStatement preparedStmt = conn.prepareStatement(Sql);
                    preparedStmt.setString(1, subjectCode);
                    preparedStmt.setString(2, jComboBox3.getSelectedItem().toString());
                    preparedStmt.setString(3, "1");
                    String usn = (String) table.getModel().getValueAt(i, 1);
                    preparedStmt.setString(4, usn);
                    preparedStmt.setString(5, SID);

                    // execute the java preparedstatement
                    preparedStmt.executeUpdate();
                    System.out.println("Pr:" + usn);
                }
                ///
            } catch (SQLException ex) {
                Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Update all absentees
            try {
                ///
                conn = MySqlConnect.ConnectDB();
                //           String usn= usn2.getText().toUpperCase();
                //           String name= name2.getText();
                //           String add=add2.getText();
                //           String email=email2.getText();
                //           String phone=phone2.getText();

                String Sql = "UPDATE Attendance SET P_A=? WHERE USN=? and SID=? and DATE=?;";

                for (int i = 0; i < ABRowCount; i++) {
                    PreparedStatement preparedStmt = conn.prepareStatement(Sql);
                    preparedStmt.setString(1, "0");
                    preparedStmt.setString(2, (String) tableAB.getModel().getValueAt(i, 1));
                    preparedStmt.setString(3, SID);
                    preparedStmt.setString(4, jComboBox3.getSelectedItem().toString());

                    // execute the java preparedstatement
                    preparedStmt.executeUpdate();
                    System.out.println("AD:" + (String) tableAB.getModel().getValueAt(i, 1));
                }
                ///
            } catch (SQLException ex) {
                Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, ex);
            }

            String str = "ABSENTEES:\n\n";
            for (int i = 0; i < ABRowCount; i++) {
                str = str + (String) tableAB.getModel().getValueAt(i, 0) + "\n";
            }

            JOptionPane.showMessageDialog(null, str);
        } else {
            JOptionPane.showMessageDialog(null, "Select the subject");
        }

    }//GEN-LAST:event_SubmitActionPerformed

    private void tableABMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableABMouseClicked
        if (ABRowCount != 0) {
            ABRowCount--;
        }
        ((DefaultTableModel) tableAB.getModel()).removeRow(tableAB.getSelectedRow());
    }//GEN-LAST:event_tableABMouseClicked

    private void totalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalMouseEntered
        total.setText(rowCount + "");
    }//GEN-LAST:event_totalMouseEntered

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int i = table.getSelectedRow();

        addToATable(table.getSelectedRow(), i);
    }//GEN-LAST:event_tableMouseClicked

    private void tableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusGained

    }//GEN-LAST:event_tableFocusGained

    private void ABtxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ABtxtMouseEntered

        ABtxt.setText(ABRowCount + "");
    }//GEN-LAST:event_ABtxtMouseEntered

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        (new login()).setVisible(true);
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseClicked

        flag = true;
        loadData();

    }//GEN-LAST:event_jComboBox4MouseClicked

    private void tableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseEntered
        // TODO add your handling code here:
        /////////////////////SGK////////////////////
        loadData();

    }//GEN-LAST:event_tableMouseEntered

    private void jComboBox4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseEntered
        // TODO add your handling code here:
        flag = true;
    }//GEN-LAST:event_jComboBox4MouseEntered

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        Vector comboBoxItems = new Vector();

        String Sql1 = "SELECT DATE FROM Attendance WHERE SID='" + SID + "' GROUP BY DATE;";
        comboBoxItems = new Vector();
        conn = MySqlConnect.ConnectDB();
        try {
            Statement st = conn.createStatement();
            //status.setText("");
            rs = st.executeQuery(Sql1);
            while (rs.next()) {
                // status.setText(status.getText()+"\n"+rs.getString(1));
                comboBoxItems.add(rs.getString(1));

            }

        } catch (Exception e) {

        }

        final DefaultComboBoxModel model6 = new DefaultComboBoxModel(comboBoxItems);
        final DefaultComboBoxModel model7 = new DefaultComboBoxModel(comboBoxItems);
        final DefaultComboBoxModel model8 = new DefaultComboBoxModel(comboBoxItems);

        datesCombo.setModel(model6);
        EndingDate.setModel(model7);
        StartingDate.setModel(model8);
        // TODO add your handling code here:
        // 
        // SELECT DATE FROM Attendance WHERE SID='DSI0111' AND SUB_Code='15CS552' GROUP BY DATE;


    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void StartingDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartingDateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_StartingDateMouseClicked

    private void StartingDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartingDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StartingDateActionPerformed

    private void EndingDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EndingDateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_EndingDateMouseClicked

    private void EndingDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndingDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EndingDateActionPerformed

    private void jComboBox2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseEntered
        Vector comboBoxItems = new Vector();
        String Sql4 = "select s.SUB_NM from Subject_And_SID a,SUBJECTS_AND_SECTIONS b,SUBJECTS s where s.SUB_Code=b.SUB_Code and a.SUB_Code=b.SUB_Code and a.SID ='" + sid + "' and  b.Section='" + jComboBox4.getSelectedItem() + "';";
        // String Sql4 = " select s.SUB_NM from Subject_And_SID a,SUBJECTS_AND_SECTIONS b,SUBJECTS s where s.SUB_Code=b.SUB_Code and a.SUB_Code=b.SUB_Code and a.SID ='DSI0111' and  b.Section='5CSEB';";
        comboBoxItems = new Vector();
        conn = MySqlConnect.ConnectDB();
        try {
            Statement st = conn.createStatement();
            //status.setText("");
            rs = st.executeQuery(Sql4);
            while (rs.next()) {
                // status.setText(status.getText()+"\n"+rs.getString(1));
                comboBoxItems.add(rs.getString(1));

            }

        } catch (Exception e) {

        }

        final DefaultComboBoxModel model4 = new DefaultComboBoxModel(comboBoxItems);
        jComboBox2.setModel(model4);
    }//GEN-LAST:event_jComboBox2MouseEntered

    private void jComboBox5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5MouseClicked

    private void jComboBox5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MouseEntered
        Vector comboBoxItems = new Vector();
        String Sql4 = "select * from `Section`;";
        comboBoxItems = new Vector();
        conn = MySqlConnect.ConnectDB();
        try {
            Statement st = conn.createStatement();
            //status.setText("");
            rs = st.executeQuery(Sql4);
            while (rs.next()) {
                // status.setText(status.getText()+"\n"+rs.getString(1));
                comboBoxItems.add(rs.getString(1));

            }

        } catch (Exception e) {

        }

        final DefaultComboBoxModel model4 = new DefaultComboBoxModel(comboBoxItems);
        jComboBox5.setModel(model4);        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5MouseEntered

    private void jComboBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseEntered
        Vector comboBoxItems = new Vector();
        String Sql4 = "select s.SUB_NM from Subject_And_SID a,SUBJECTS_AND_SECTIONS b,SUBJECTS s where s.SUB_Code=b.SUB_Code and a.SUB_Code=b.SUB_Code and a.SID ='" + sid + "' and  b.Section='" + jComboBox5.getSelectedItem() + "';";
        // String Sql4 = " select s.SUB_NM from Subject_And_SID a,SUBJECTS_AND_SECTIONS b,SUBJECTS s where s.SUB_Code=b.SUB_Code and a.SUB_Code=b.SUB_Code and a.SID ='DSI0111' and  b.Section='5CSEB';";
        comboBoxItems = new Vector();
        conn = MySqlConnect.ConnectDB();
        try {
            Statement st = conn.createStatement();
            //status.setText("");
            rs = st.executeQuery(Sql4);
            while (rs.next()) {
                // status.setText(status.getText()+"\n"+rs.getString(1));
                comboBoxItems.add(rs.getString(1));

            }

        } catch (Exception e) {

        }

        final DefaultComboBoxModel model4 = new DefaultComboBoxModel(comboBoxItems);
        jComboBox1.setModel(model4);
    }//GEN-LAST:event_jComboBox1MouseEntered

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

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
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ABtxt;
    private javax.swing.JTextField Attendance_count;
    private javax.swing.JComboBox<String> EndingDate;
    private javax.swing.JTable ResultTable;
    private javax.swing.JComboBox<String> StartingDate;
    private javax.swing.JButton Submit;
    private javax.swing.JComboBox<String> datesCombo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton showBtn;
    private javax.swing.JTable table;
    private javax.swing.JTable tableAB;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
private void addToATable(int selectedRow, int i) {/////////////////////////////////////////////////
        if (lastRow != i) {
            DefaultTableModel model = (DefaultTableModel) tableAB.getModel();
            lastRow = i;
            model.setRowCount(ABRowCount + 1);
            String c1 = (String) table.getModel().getValueAt(selectedRow, 0);
            String c2 = (String) table.getModel().getValueAt(selectedRow, 1);
            tableAB.getModel().setValueAt(c1, ABRowCount, 0);
            tableAB.getModel().setValueAt(c2, ABRowCount, 1);
            ABRowCount++;
        }
    }
}
