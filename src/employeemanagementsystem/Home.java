/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagementsystem;

import com.sun.istack.internal.logging.Logger;
import com.sun.javafx.font.FontFactory;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Element;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.MessageFormat;
import javax.swing.Icon;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

/**
 *
 * @author Brily Branco
 */
public class Home extends javax.swing.JFrame {

    String id, nama, namapanjang, umur, username, password, gambar, gender, department, shift, karyawangp, divisi;
    ImageIcon icon;

    public Home() {
        initComponents();
        TanggalSaatini();
        Koneksi();
        TampilData();
    }

    public ImageIcon aturicon(String m, byte[] gambar) {
        if (m != null) {
            icon = new ImageIcon(m);
        } else {
            icon = new ImageIcon(gambar);
        }
        Image gambar1 = icon.getImage();
        Image gambar2 = gambar1.getScaledInstance(lblgambar.getWidth(), lblgambar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageicon = new ImageIcon(gambar2);
        return imageicon;
    }

    private void Koneksi() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "");
            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal " + e.getMessage());
        }
    }

    public void TanggalSaatini() {
        Thread th = new Thread() {
            public void run() {
                for (;;) {
                    Calendar calendar = new GregorianCalendar();
                    int bulan = calendar.get(Calendar.MONTH);
                    int tahun = calendar.get(Calendar.YEAR);
                    int hari = calendar.get(Calendar.DAY_OF_MONTH);
                    jMenu5.setText("Taggal " + hari + "-" + (bulan + 1) + "-" + tahun);

                    int hour = calendar.get(Calendar.HOUR);
                    int minute = calendar.get(Calendar.MINUTE);
                    int detik = calendar.get(Calendar.SECOND);
                    jMenu6.setText("Waktu: " + hour + ": " + (minute) + ": " + detik);

                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {

                    }
                }
            }

        };
        th.start();
    }
    private ImageIcon imageicon = null;
    String namafile = null;
    int s = 0;
    String gambarpersonal = null;
    private String jenkel;
    PreparedStatement prepare;
    Connection connection;
    ResultSet resultset;
    DefaultTableModel datalist = new DefaultTableModel();

    public void Clear() {
        txtid.setText("");
        txtnama.setText("");
        txtnamapanjang.setText("");
        cmbumur.setSelectedItem("Pilih");
        txtusername.setText("");
        txtpassword.setText("");
        mygroupjenkel.clearSelection();
        txtdepartment.setText("");
        txtshift.setText("");
        txtdivisi.setText("");
        txtgp.setText("");
        lblgambar.setText("");
    }

    public void TampilData() {

        datalist.addColumn("id");
        datalist.addColumn("Nama");
        datalist.addColumn("Nama Panjang");
        datalist.addColumn("Umur");
        datalist.addColumn("UserName");
        datalist.addColumn("Gambar");
        datalist.addColumn("Jenkel");
        datalist.addColumn("Department");
        datalist.addColumn("Shift");
        datalist.addColumn("Karyawan Gp");
        datalist.addColumn("Divisi");

        try {
            int i = 1;
            prepare = connection.prepareStatement("select * from employeeinfo");
            resultset = prepare.executeQuery();
            while (resultset.next()) {
                datalist.addRow(new Object[]{
                    ("" + i++),
                    resultset.getString("nama"),
                    resultset.getString("namapanjang"),
                    resultset.getString("umur"),
                    resultset.getString("username"),
                    resultset.getString("gambar"),
                    resultset.getString("jenkel"),
                    resultset.getString("department"),
                    resultset.getString("shift"),
                    resultset.getString("karyawangp"),
                    resultset.getString("divisi")
                });
            }
            tblhome.setModel(datalist);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mygroupjenkel = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmbumur = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtshift = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rbpria = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnamapanjang = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtgp = new javax.swing.JTextField();
        rbwanita = new javax.swing.JRadioButton();
        txtid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtdepartment = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        txtdivisi = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblhome = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txttotalkaryawan = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        lblgambar = new javax.swing.JLabel();
        lbljenkel = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Brily Branco\\Desktop\\JavaOOPtutorial\\images.jpg")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 0)), "Data Karyawan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        cmbumur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28" }));

        jLabel5.setText("Umur");

        jLabel9.setText("GP");

        mygroupjenkel.add(rbpria);
        rbpria.setText("Pria");

        jLabel3.setText("Nama");

        jLabel4.setText("Nama Panjang");

        jLabel6.setText("Jenkel");

        jLabel2.setText("ID");

        jLabel8.setText("Shift");

        mygroupjenkel.add(rbwanita);
        rbwanita.setText("Wanita");

        jLabel7.setText("Department");

        jLabel14.setText("Username");

        jLabel15.setText("Password");

        jLabel16.setText("Divisi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtdepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtshift, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(65, 65, 65)
                                .addComponent(txtdivisi))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addComponent(rbpria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbwanita)
                                .addGap(57, 57, 57))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtid)
                                    .addComponent(txtnamapanjang)
                                    .addComponent(cmbumur, 0, 161, Short.MAX_VALUE)
                                    .addComponent(txtnama, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(txtusername)
                                    .addComponent(txtpassword))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtgp, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtnamapanjang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbumur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rbpria)
                    .addComponent(rbwanita))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtdepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtshift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtgp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtdivisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jButton6.setText("Print");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        tblhome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhomeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblhome);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 153, 0)), "Operations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jButton7.setText("Attach");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Logout");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel11.setText("Total Karyawan");

        txttotalkaryawan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton9.setText("Show");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0)), "Cari", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel12.setText("Masukkan ID,Nama,Nama Panjang");

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        lblgambar.setText("No Image");

        lbljenkel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton10.setText("Refresh");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("Keluar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Help");

        jMenuItem2.setText("FAQ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Date");
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Time");
        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbljenkel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttotalkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9)
                                .addGap(70, 70, 70))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblgambar, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jButton10))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(186, 186, 186)
                            .addComponent(lbljenkel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblgambar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7)))
                        .addGap(11, 11, 11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txttotalkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9)
                    .addComponent(jButton8))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        frmlogin l = new frmlogin();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\Users\\Brily Branco\\Desktop\\JavaOOPtutorial\\images.jpg");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        JFileChooser jfilechooser = new JFileChooser();
        jfilechooser.setCurrentDirectory(new File("E:/"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
        jfilechooser.addChoosableFileFilter(filter);
        int hasil = jfilechooser.showSaveDialog(null);
        if (hasil == JFileChooser.APPROVE_OPTION) {
            File file = jfilechooser.getSelectedFile();
            String absolute = file.getAbsolutePath();
            lblgambar.setIcon(aturicon(absolute, null));

            gambarpersonal = absolute;
        } else {
            if (hasil == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "Tidak ada file yang dipilih");
            }
        }


    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        rbpria.setActionCommand("Pria");
        rbwanita.setActionCommand("Wanita");

        if (gambarpersonal != null) {
            try {
                prepare = connection.prepareStatement("insert into employeeinfo(id,nama,namapanjang,umur,username,password,gambar,jenkel,department,shift,karyawangp,divisi)values (?,?,?,?,?,?,?,?,?,?,?,?)");
                InputStream inputstream = new FileInputStream(new File(gambarpersonal));
                prepare.setString(1, txtid.getText());
                prepare.setString(2, txtnama.getText());
                prepare.setString(3, txtnamapanjang.getText());
                prepare.setString(4, cmbumur.getSelectedItem().toString());
                prepare.setString(5, txtusername.getText());
                prepare.setString(6, txtpassword.getText());
                prepare.setBlob(7, inputstream);
                prepare.setString(8, mygroupjenkel.getSelection().getActionCommand());
                prepare.setString(9, txtdepartment.getText());
                prepare.setString(10, txtshift.getText());
                prepare.setString(11, txtgp.getText());
                prepare.setString(12, txtdivisi.getText());
                prepare.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
                TampilData();
                Clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } else {

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhomeMouseClicked
        // TODO add your handling code here:
        //rbpria.setActionCommand("Pria");
        //rbwanita.setActionCommand("Wanita");
        int index = tblhome.getSelectedRow();
        String kliktabel = (tblhome.getModel().getValueAt(index,0).toString());
        
        try{
            prepare=connection.prepareStatement("select gambar from employeeinfo where id=?");
            prepare.setString(1,kliktabel);
            resultset=prepare.executeQuery();
            
            if(resultset.next()){
                byte[]gambartabel=resultset.getBytes("gambar");
                icon=new ImageIcon(gambartabel);
                lblgambar.setIcon(icon);
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
        }

        try{
            prepare=connection.prepareStatement("select * from employeeinfo where id=?");
            prepare.setString(1,kliktabel);
            resultset=prepare.executeQuery();
            
            if(resultset.next()){
               txtid.setText(resultset.getString("id"));
               txtnama.setText(resultset.getString("nama"));
               txtnamapanjang.setText(resultset.getString("namapanjang"));
               cmbumur.setSelectedItem(resultset.getString("umur"));
               txtusername.setText(resultset.getString("username"));
               txtpassword.setText(resultset.getString("password"));
               txtdepartment.setText(resultset.getString("department"));
               txtshift.setText(resultset.getString("shift"));
               txtgp.setText(resultset.getString("karyawangp"));
               txtdivisi.setText(resultset.getString("divisi"));
               lbljenkel.setText(resultset.getString("jenkel"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
        }
        
    }//GEN-LAST:event_tblhomeMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String id=txtid.getText();
        
        if(gambarpersonal !=null){
        try{
            prepare=connection.prepareStatement("update employeeinfo set gambar=? where id=?");
            InputStream inputstreamubah = new FileInputStream(new File(gambarpersonal));
            prepare.setBlob(1,inputstreamubah);
            prepare.setString(2,id);
            prepare.executeUpdate();
            
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
        }
        }
        try{
            prepare=connection.prepareStatement("update employeeinfo set nama=?,namapanjang=?,umur=?,username=?,password=?,department=?,shift=?,karyawangp=?,divisi=? where id=?");
            prepare.setString(1,txtnama.getText());
            prepare.setString(2,txtnamapanjang.getText());
            prepare.setString(3, cmbumur.getSelectedItem().toString());
            prepare.setString(4, txtusername.getText());
            prepare.setString(5, txtpassword.getText());
            prepare.setString(6, txtdepartment.getText());
            prepare.setString(7, txtshift.getText());
            prepare.setString(8, txtgp.getText());
            prepare.setString(9,txtdivisi.getText());
            prepare.setString(10,txtid.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data berhasil diubah!");
            Clear();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Gagal mengubah data "+e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        Home h=new Home();
        h.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Clear();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        try{
            prepare=connection.prepareStatement("select count(*)from employeeinfo");
            resultset=prepare.executeQuery();
            if(resultset.next()){
                txttotalkaryawan.setText(resultset.getString("count(*)"));
                txttotalkaryawan.setEnabled(false);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        MessageFormat header=new MessageFormat("Laporan");
        MessageFormat footer=new MessageFormat("Page(0,number,Integer");
        try{
            tblhome.print(JTable.PrintMode.NORMAL,header,footer);
        }catch(java.awt.print.PrinterException e){
            JOptionPane.showMessageDialog(null,"Print gagal %s%n "+e.getMessage());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
        // TODO add your handling code here:
        
       
        try{
            prepare=connection.prepareStatement("select gambar from employeeinfo where nama=?");
            prepare.setString(1,txtcari.getText());
            resultset=prepare.executeQuery();
            if(resultset.next()){
                byte[]gambarreleased=resultset.getBytes("gambar");
                icon=new ImageIcon(gambarreleased);
                lblgambar.setIcon(icon);
            }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
        }
        
        
        try{
            prepare=connection.prepareStatement("select * from employeeinfo where nama=?");
            prepare.setString(1,txtcari.getText());
            resultset=prepare.executeQuery();
            
            if(resultset.next()){
               txtid.setText(resultset.getString("id"));
               txtnama.setText(resultset.getString("nama"));
               txtnamapanjang.setText(resultset.getString("namapanjang"));
               cmbumur.setSelectedItem(resultset.getString("umur"));
               txtusername.setText(resultset.getString("username"));
               lbljenkel.setText(resultset.getString("jenkel"));
               txtusername.setText(resultset.getString("username"));
               txtdepartment.setText(resultset.getString("department"));
               txtshift.setText(resultset.getString("shift"));
               txtgp.setText(resultset.getString("karyawangp"));
               txtdivisi.setText(resultset.getString("divisi"));
               
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
        }
    }//GEN-LAST:event_txtcariKeyReleased

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbumur;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblgambar;
    private javax.swing.JLabel lbljenkel;
    private javax.swing.ButtonGroup mygroupjenkel;
    private javax.swing.JRadioButton rbpria;
    private javax.swing.JRadioButton rbwanita;
    private javax.swing.JTable tblhome;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtdepartment;
    private javax.swing.JTextField txtdivisi;
    private javax.swing.JTextField txtgp;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnamapanjang;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtshift;
    private javax.swing.JTextField txttotalkaryawan;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables

}
