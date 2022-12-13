/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domainmodel.TaiKhoanAdmin;
import domainmodel.TaiKhoanNguoiDung;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.IBanHangService;
import service.ICa;
import service.implement.BanHangService;
import service.implement.CaService;
import viewmodel.CaViewModel_Quan;
import viewmodel.ChiNhanhViewModel_Hoang;
import viewmodel.NhanVienViewModel_Van;

/**
 *
 * @author trant
 */
public class QLCa extends javax.swing.JPanel implements Runnable {

    private ICa caService;
    private IBanHangService banHangService;
    private TaiKhoanAdmin _admin;
    private TaiKhoanNguoiDung _nguoiDung;
    private DefaultTableModel modelTableNhanVien;
    private DefaultTableModel modelTableCa;
    private DefaultComboBoxModel<ChiNhanhViewModel_Hoang> modelComboChiNhanh;

    public QLCa(TaiKhoanAdmin admin, TaiKhoanNguoiDung nguoiDung) {
        initComponents();
        _admin = admin;
        _nguoiDung = nguoiDung;
        caService = new CaService();
        banHangService = new BanHangService();
        modelTableNhanVien = new DefaultTableModel();
        modelTableCa = new DefaultTableModel();
        modelTableNhanVien = (DefaultTableModel) tblNhanVien.getModel();
        modelTableCa = (DefaultTableModel) tblCa.getModel();

        Thread loadData = new Thread(this);
        loadData.start();

    }

    @Override
    public void run() {
        if (_admin != null) {
            modelComboChiNhanh = (DefaultComboBoxModel) new DefaultComboBoxModel<>(banHangService.getAllChiNhanh().toArray());
            cboChiNhanh.setModel((DefaultComboBoxModel) modelComboChiNhanh);
            showNhanVienToTable(caService.getNhanVienByChiNhanh(
                    ((ChiNhanhViewModel_Hoang) modelComboChiNhanh.getElementAt(0)).getId())
            );

        } else {
            cboChiNhanh.setVisible(false);
        }
        showCaToTable(caService.getAllCa());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dLogMoCa = new javax.swing.JDialog();
        pnlMoCa = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTienKetDauCa = new javax.swing.JTextField();
        btnMoCaHuyBo = new javax.swing.JButton();
        btnXacNhanMoCa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        dLongDongCa = new javax.swing.JDialog();
        pnlDongCa = new javax.swing.JPanel();
        txtTienKetCuoiCa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnXacNhanDongCa = new javax.swing.JButton();
        btnDongCaHuyBo = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pnlQLCa = new javax.swing.JPanel();
        btnMoCa = new javax.swing.JButton();
        btnDongCa = new javax.swing.JButton();
        pnlCa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCa = new javax.swing.JTable();
        pnlNhanVien = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        cboChiNhanh = new javax.swing.JComboBox<>();
        pnlCRUDCa = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMaCa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnXoaCa = new javax.swing.JButton();
        btnSuaCa = new javax.swing.JButton();
        btnThemCa = new javax.swing.JButton();
        txtGioBatDau = new javax.swing.JTextField();
        txtPhutBatDau = new javax.swing.JTextField();
        txtGioKetThuc = new javax.swing.JTextField();
        txtPhutKetThuc = new javax.swing.JTextField();
        lblCanhBaoGioBatDau = new javax.swing.JLabel();
        lblCanhBaoGioKetThuc = new javax.swing.JLabel();
        lblCanhBaoMa = new javax.swing.JLabel();
        btnCapNhatCaNhanVien = new javax.swing.JButton();
        lblCaDangHoatDong = new javax.swing.JLabel();

        dLogMoCa.addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                dLogMoCaWindowLostFocus(evt);
            }
        });

        pnlMoCa.setBackground(new java.awt.Color(225, 218, 197));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Tiền két đầu ca ( Tiền mặt )");

        btnMoCaHuyBo.setBackground(new java.awt.Color(255, 0, 0));
        btnMoCaHuyBo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnMoCaHuyBo.setForeground(new java.awt.Color(255, 255, 255));
        btnMoCaHuyBo.setText("Hủy bỏ");
        btnMoCaHuyBo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnXacNhanMoCa.setBackground(new java.awt.Color(0, 153, 0));
        btnXacNhanMoCa.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnXacNhanMoCa.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhanMoCa.setText("Xác nhận mở ca");
        btnXacNhanMoCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setText("VND");

        javax.swing.GroupLayout pnlMoCaLayout = new javax.swing.GroupLayout(pnlMoCa);
        pnlMoCa.setLayout(pnlMoCaLayout);
        pnlMoCaLayout.setHorizontalGroup(
            pnlMoCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMoCaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMoCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMoCaLayout.createSequentialGroup()
                        .addGroup(pnlMoCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMoCaLayout.createSequentialGroup()
                                .addComponent(txtTienKetDauCa, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel8))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlMoCaLayout.createSequentialGroup()
                        .addComponent(btnXacNhanMoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoCaHuyBo, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlMoCaLayout.setVerticalGroup(
            pnlMoCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMoCaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMoCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKetDauCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMoCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhanMoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoCaHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        dLogMoCa.getContentPane().add(pnlMoCa, java.awt.BorderLayout.CENTER);

        dLongDongCa.addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                dLongDongCaWindowLostFocus(evt);
            }
        });

        pnlDongCa.setBackground(new java.awt.Color(225, 218, 197));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setText("Tiền thực tế trong két ( tiền mặt ):");

        jLabel11.setText("VND");

        btnXacNhanDongCa.setBackground(new java.awt.Color(0, 153, 0));
        btnXacNhanDongCa.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnXacNhanDongCa.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhanDongCa.setText("Xác nhận đóng ca");
        btnXacNhanDongCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnDongCaHuyBo.setBackground(new java.awt.Color(255, 0, 0));
        btnDongCaHuyBo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnDongCaHuyBo.setForeground(new java.awt.Color(255, 255, 255));
        btnDongCaHuyBo.setText("Hủy bỏ");
        btnDongCaHuyBo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel12.setText("Doanh thu trong ca :");

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel13.setText("20000");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel14.setText("VND");

        jLabel15.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel15.setText("Chênh lệch :");

        jLabel16.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel16.setText("200");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel17.setText("VND");

        jLabel18.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel18.setText("Tiền két đầu ca :");

        jLabel19.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel19.setText("20000");
        jLabel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel20.setText("VND");

        jLabel21.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel21.setText("Tiền bàn giao ( tiền mặt ) :");

        jLabel22.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel22.setText("20000");
        jLabel22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel23.setText("VND");

        javax.swing.GroupLayout pnlDongCaLayout = new javax.swing.GroupLayout(pnlDongCa);
        pnlDongCa.setLayout(pnlDongCaLayout);
        pnlDongCaLayout.setHorizontalGroup(
            pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDongCaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel21)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlDongCaLayout.createSequentialGroup()
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel23))
                        .addGroup(pnlDongCaLayout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel14)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDongCaLayout.createSequentialGroup()
                        .addGroup(pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTienKetCuoiCa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDongCaLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDongCaLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel17))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDongCaLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlDongCaLayout.createSequentialGroup()
                .addComponent(btnXacNhanDongCa, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDongCaHuyBo, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
        );
        pnlDongCaLayout.setVerticalGroup(
            pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDongCaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(pnlDongCaLayout.createSequentialGroup()
                        .addGroup(pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtTienKetCuoiCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel21))))
                .addGap(33, 33, 33)
                .addGroup(pnlDongCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXacNhanDongCa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDongCaHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        dLongDongCa.getContentPane().add(pnlDongCa, java.awt.BorderLayout.CENTER);

        pnlQLCa.setBackground(new java.awt.Color(225, 218, 197));

        btnMoCa.setBackground(new java.awt.Color(108, 83, 54));
        btnMoCa.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        btnMoCa.setForeground(new java.awt.Color(255, 255, 255));
        btnMoCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/openCa48px.png"))); // NOI18N
        btnMoCa.setText("Mở ca");
        btnMoCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoCaActionPerformed(evt);
            }
        });

        btnDongCa.setBackground(new java.awt.Color(108, 83, 54));
        btnDongCa.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        btnDongCa.setForeground(new java.awt.Color(255, 255, 255));
        btnDongCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/CloseCa48px.png"))); // NOI18N
        btnDongCa.setText("Đóng ca");
        btnDongCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDongCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongCaActionPerformed(evt);
            }
        });

        pnlCa.setBackground(new java.awt.Color(225, 218, 197));
        pnlCa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách ca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 14))); // NOI18N

        tblCa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chọn", "Id", "Mã ca", "Giờ bắt đầu", "Giờ kết thúc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCa.getTableHeader().setReorderingAllowed(false);
        tblCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCa);
        if (tblCa.getColumnModel().getColumnCount() > 0) {
            tblCa.getColumnModel().getColumn(0).setMinWidth(50);
            tblCa.getColumnModel().getColumn(0).setMaxWidth(50);
            tblCa.getColumnModel().getColumn(1).setMinWidth(0);
            tblCa.getColumnModel().getColumn(1).setMaxWidth(0);
            tblCa.getColumnModel().getColumn(2).setResizable(false);
            tblCa.getColumnModel().getColumn(3).setResizable(false);
            tblCa.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout pnlCaLayout = new javax.swing.GroupLayout(pnlCa);
        pnlCa.setLayout(pnlCaLayout);
        pnlCaLayout.setHorizontalGroup(
            pnlCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlCaLayout.setVerticalGroup(
            pnlCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pnlNhanVien.setBackground(new java.awt.Color(225, 218, 197));
        pnlNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách nhân viên theo chi nhánh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 14))); // NOI18N

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Mã nhân viên", "Tên nhân viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.getTableHeader().setReorderingAllowed(false);
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblNhanVien);
        if (tblNhanVien.getColumnModel().getColumnCount() > 0) {
            tblNhanVien.getColumnModel().getColumn(0).setMinWidth(0);
            tblNhanVien.getColumnModel().getColumn(0).setMaxWidth(0);
            tblNhanVien.getColumnModel().getColumn(1).setResizable(false);
            tblNhanVien.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout pnlNhanVienLayout = new javax.swing.GroupLayout(pnlNhanVien);
        pnlNhanVien.setLayout(pnlNhanVienLayout);
        pnlNhanVienLayout.setHorizontalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
        );
        pnlNhanVienLayout.setVerticalGroup(
            pnlNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/location_10px.png"))); // NOI18N
        jLabel10.setText("Chi nhánh");

        cboChiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChiNhanhActionPerformed(evt);
            }
        });

        pnlCRUDCa.setBackground(new java.awt.Color(225, 218, 197));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Mã ca :");

        txtMaCa.setBackground(new java.awt.Color(225, 218, 197));
        txtMaCa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtMaCa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaCaKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Giờ bắt đầu :");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Giờ kết thúc :");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(":");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(":");

        btnXoaCa.setBackground(new java.awt.Color(108, 83, 54));
        btnXoaCa.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnXoaCa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_remove_30px.png"))); // NOI18N
        btnXoaCa.setText("XÓA CA");
        btnXoaCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCaActionPerformed(evt);
            }
        });

        btnSuaCa.setBackground(new java.awt.Color(108, 83, 54));
        btnSuaCa.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSuaCa.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_sync_30px.png"))); // NOI18N
        btnSuaCa.setText("CẬP NHẬT CA");
        btnSuaCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCaActionPerformed(evt);
            }
        });

        btnThemCa.setBackground(new java.awt.Color(108, 83, 54));
        btnThemCa.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnThemCa.setForeground(new java.awt.Color(255, 255, 255));
        btnThemCa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add_20px.png"))); // NOI18N
        btnThemCa.setText("THÊM CA");
        btnThemCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCaActionPerformed(evt);
            }
        });

        txtGioBatDau.setBackground(new java.awt.Color(225, 218, 197));
        txtGioBatDau.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        txtGioBatDau.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGioBatDau.setBorder(javax.swing.BorderFactory.createTitledBorder("Giờ"));
        txtGioBatDau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGioBatDauKeyReleased(evt);
            }
        });

        txtPhutBatDau.setBackground(new java.awt.Color(225, 218, 197));
        txtPhutBatDau.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        txtPhutBatDau.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhutBatDau.setBorder(javax.swing.BorderFactory.createTitledBorder("Phút"));
        txtPhutBatDau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhutBatDauKeyReleased(evt);
            }
        });

        txtGioKetThuc.setBackground(new java.awt.Color(225, 218, 197));
        txtGioKetThuc.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        txtGioKetThuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGioKetThuc.setBorder(javax.swing.BorderFactory.createTitledBorder("Giờ"));
        txtGioKetThuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGioKetThucKeyReleased(evt);
            }
        });

        txtPhutKetThuc.setBackground(new java.awt.Color(225, 218, 197));
        txtPhutKetThuc.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        txtPhutKetThuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPhutKetThuc.setBorder(javax.swing.BorderFactory.createTitledBorder("Phút"));
        txtPhutKetThuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhutKetThucKeyReleased(evt);
            }
        });

        lblCanhBaoGioBatDau.setForeground(new java.awt.Color(255, 51, 51));

        lblCanhBaoGioKetThuc.setForeground(new java.awt.Color(255, 51, 51));

        lblCanhBaoMa.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout pnlCRUDCaLayout = new javax.swing.GroupLayout(pnlCRUDCa);
        pnlCRUDCa.setLayout(pnlCRUDCaLayout);
        pnlCRUDCaLayout.setHorizontalGroup(
            pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCRUDCaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCRUDCaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSuaCa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlCRUDCaLayout.createSequentialGroup()
                        .addGroup(pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCRUDCaLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(22, 22, 22)
                                .addGroup(pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGioBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlCRUDCaLayout.createSequentialGroup()
                                        .addComponent(txtGioKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPhutKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtMaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlCRUDCaLayout.createSequentialGroup()
                                .addGroup(pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(118, 118, 118)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPhutBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCanhBaoGioBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCanhBaoGioKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCanhBaoMa, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
                        .addGap(0, 56, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlCRUDCaLayout.setVerticalGroup(
            pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCRUDCaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaCa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCanhBaoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCanhBaoGioBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel7)
                        .addComponent(txtGioBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPhutBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblCanhBaoGioKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlCRUDCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(txtPhutKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtGioKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnThemCa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoaCa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuaCa)
                .addContainerGap())
        );

        btnCapNhatCaNhanVien.setBackground(new java.awt.Color(108, 83, 54));
        btnCapNhatCaNhanVien.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnCapNhatCaNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhatCaNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_sync_30px.png"))); // NOI18N
        btnCapNhatCaNhanVien.setText("CẬP NHẬT CA NHÂN VIÊN");
        btnCapNhatCaNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhatCaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatCaNhanVienActionPerformed(evt);
            }
        });

        lblCaDangHoatDong.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        lblCaDangHoatDong.setForeground(new java.awt.Color(255, 0, 0));
        lblCaDangHoatDong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCaDangHoatDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/notification_40px.png"))); // NOI18N
        lblCaDangHoatDong.setText("Ca 1 đang hoạt động");

        javax.swing.GroupLayout pnlQLCaLayout = new javax.swing.GroupLayout(pnlQLCa);
        pnlQLCa.setLayout(pnlQLCaLayout);
        pnlQLCaLayout.setHorizontalGroup(
            pnlQLCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLCaLayout.createSequentialGroup()
                .addGroup(pnlQLCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQLCaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlQLCaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(pnlNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlQLCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlQLCaLayout.createSequentialGroup()
                                .addComponent(btnCapNhatCaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlQLCaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pnlQLCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDongCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMoCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCaDangHoatDong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pnlCRUDCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnlQLCaLayout.setVerticalGroup(
            pnlQLCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQLCaLayout.createSequentialGroup()
                .addGroup(pnlQLCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(pnlQLCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQLCaLayout.createSequentialGroup()
                        .addGroup(pnlQLCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlQLCaLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnCapNhatCaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlQLCaLayout.createSequentialGroup()
                                .addComponent(pnlCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pnlQLCaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlQLCaLayout.createSequentialGroup()
                                .addComponent(lblCaDangHoatDong, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(btnMoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDongCa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlCRUDCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addComponent(pnlNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlQLCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlQLCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboChiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChiNhanhActionPerformed
        showNhanVienToTable(caService.getNhanVienByChiNhanh(
                ((ChiNhanhViewModel_Hoang) modelComboChiNhanh.getSelectedItem()).getId())
        );

    }//GEN-LAST:event_cboChiNhanhActionPerformed

    private void btnMoCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoCaActionPerformed
        dLogMoCa.setVisible(true);
        dLogMoCa.setSize(720, 350);
        dLogMoCa.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMoCaActionPerformed

    private void btnDongCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongCaActionPerformed
        dLongDongCa.setVisible(true);
        dLongDongCa.setSize(740, 350);
        dLongDongCa.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnDongCaActionPerformed

    private void dLogMoCaWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dLogMoCaWindowLostFocus
        dLogMoCa.setVisible(false);
    }//GEN-LAST:event_dLogMoCaWindowLostFocus

    private void dLongDongCaWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dLongDongCaWindowLostFocus
        dLongDongCa.setVisible(false);

    }//GEN-LAST:event_dLongDongCaWindowLostFocus

    private void btnThemCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCaActionPerformed
        if (!txtMaCa.getText().isBlank() && !txtGioBatDau.getText().isBlank() && !txtGioKetThuc.getText().isBlank()) {
            LocalTime gioBatDau = LocalTime.of(Integer.parseInt(txtGioBatDau.getText()),
                    Integer.parseInt(txtPhutBatDau.getText()));
            LocalTime gioKetThuc = LocalTime.of(Integer.parseInt(txtGioKetThuc.getText()),
                    Integer.parseInt(txtPhutKetThuc.getText()));
            CaViewModel_Quan caView = new CaViewModel_Quan();
            caView.setMa(txtMaCa.getText());
            caView.setGioBD(gioBatDau);
            caView.setGioKT(gioKetThuc);
            String id = caService.insertCa(caView);
            if (id != null) {
                JOptionPane.showMessageDialog(this, "Thêm ca làm việc thành công");
                showCaToTable(caService.getAllCa());
            } else {
                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ Mã ca và giờ");
        }

    }//GEN-LAST:event_btnThemCaActionPerformed

    private void btnXoaCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaCaActionPerformed

    private void btnSuaCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaCaActionPerformed

    private void txtGioBatDauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGioBatDauKeyReleased
        if (!caService.checkHourOfCa(txtGioBatDau.getText())) {
            txtGioBatDau.setText("");
            lblCanhBaoGioBatDau.setText("Giờ không hợp lệ");
        } else {
            lblCanhBaoGioBatDau.setText("");
        }
    }//GEN-LAST:event_txtGioBatDauKeyReleased

    private void txtPhutBatDauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhutBatDauKeyReleased
        if (!caService.checkMinuteOfCa(txtPhutBatDau.getText())) {
            txtPhutBatDau.setText("");
            lblCanhBaoGioBatDau.setText("Phút không hợp lệ");
        } else {
            lblCanhBaoGioBatDau.setText("");
        }
    }//GEN-LAST:event_txtPhutBatDauKeyReleased

    private void txtGioKetThucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGioKetThucKeyReleased
        if (!caService.checkHourOfCa(txtGioKetThuc.getText())) {
            txtGioKetThuc.setText("");
            lblCanhBaoGioKetThuc.setText("Giờ không hợp lệ");
        } else {
            lblCanhBaoGioKetThuc.setText("");
        }
    }//GEN-LAST:event_txtGioKetThucKeyReleased

    private void txtPhutKetThucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhutKetThucKeyReleased
        if (!caService.checkMinuteOfCa(txtPhutKetThuc.getText())) {
            txtPhutKetThuc.setText("");
            lblCanhBaoGioKetThuc.setText("Giờ không hợp lệ");
        } else {
            lblCanhBaoGioKetThuc.setText("");
        }
    }//GEN-LAST:event_txtPhutKetThucKeyReleased

    private void txtMaCaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaCaKeyReleased
        if (txtMaCa.getText().length() > 5) {
            txtMaCa.setText("");
            lblCanhBaoMa.setText("Tối đa 5 kí tự");
        } else {
            lblCanhBaoMa.setText("");
            if (!caService.checkExistedOfMaCa(txtMaCa.getText())) {
                txtMaCa.setText("");
                lblCanhBaoMa.setText("Mã này đã được sử dụng");
            } else {
                lblCanhBaoMa.setText("");
            }
        }
    }//GEN-LAST:event_txtMaCaKeyReleased

    private void btnCapNhatCaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatCaNhanVienActionPerformed
        int rowNhanVien = tblNhanVien.getSelectedRow();
        Set<String> CaSelected = new HashSet<>();
        if (rowNhanVien != -1) {
            for (int i = 0; i < tblCa.getRowCount(); i++) {
                if (tblNhanVien.getValueAt(i, 0).equals(true)) {
                    CaSelected.add(tblCa.getValueAt(i, 1).toString());
                }
            }
            caService.addCaToNhanVien(tblNhanVien.getValueAt(rowNhanVien, 0).toString(), CaSelected);
            JOptionPane.showMessageDialog(this, "Cập nhật ca cho nhân viên thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 nhân viên");
        }
    }//GEN-LAST:event_btnCapNhatCaNhanVienActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int row = tblNhanVien.getSelectedRow();
        if (row != -1) {
            Set<CaViewModel_Quan> caOfNhanVien = caService.getCaOfNhanVien(tblNhanVien.getValueAt(row, 0).toString());
            if (caOfNhanVien.isEmpty()) {
                for (int i = 0; i < tblCa.getRowCount(); i++) {
                    tblCa.setValueAt(false, i, 0);
                }
            }
        }

    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void tblCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCaMouseClicked

    }//GEN-LAST:event_tblCaMouseClicked

    private void showNhanVienToTable(Set<NhanVienViewModel_Van> setNhanVienView) {
        modelTableNhanVien.setRowCount(0);
        for (NhanVienViewModel_Van nv : setNhanVienView) {
            modelTableNhanVien.addRow(new Object[]{nv.getIdNhanVien(), nv.getMaNhanVien(), nv.getHoTen()});
        }
    }

    private void showCaToTable(List<CaViewModel_Quan> setCaView) {
        modelTableCa.setRowCount(0);
        for (CaViewModel_Quan caView : setCaView) {
            modelTableCa.addRow(new Object[]{false, caView.getId(), caView.getMa(), caView.getGioBD(), caView.getGioKT()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatCaNhanVien;
    private javax.swing.JButton btnDongCa;
    private javax.swing.JButton btnDongCaHuyBo;
    private javax.swing.JButton btnMoCa;
    private javax.swing.JButton btnMoCaHuyBo;
    private javax.swing.JButton btnSuaCa;
    private javax.swing.JButton btnThemCa;
    private javax.swing.JButton btnXacNhanDongCa;
    private javax.swing.JButton btnXacNhanMoCa;
    private javax.swing.JButton btnXoaCa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChiNhanh;
    private javax.swing.JDialog dLogMoCa;
    private javax.swing.JDialog dLongDongCa;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCaDangHoatDong;
    private javax.swing.JLabel lblCanhBaoGioBatDau;
    private javax.swing.JLabel lblCanhBaoGioKetThuc;
    private javax.swing.JLabel lblCanhBaoMa;
    private javax.swing.JPanel pnlCRUDCa;
    private javax.swing.JPanel pnlCa;
    private javax.swing.JPanel pnlDongCa;
    private javax.swing.JPanel pnlMoCa;
    private javax.swing.JPanel pnlNhanVien;
    private javax.swing.JPanel pnlQLCa;
    private javax.swing.JTable tblCa;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtGioBatDau;
    private javax.swing.JTextField txtGioKetThuc;
    private javax.swing.JTextField txtMaCa;
    private javax.swing.JTextField txtPhutBatDau;
    private javax.swing.JTextField txtPhutKetThuc;
    private javax.swing.JTextField txtTienKetCuoiCa;
    private javax.swing.JTextField txtTienKetDauCa;
    // End of variables declaration//GEN-END:variables
}
