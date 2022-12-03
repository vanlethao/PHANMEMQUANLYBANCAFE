/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domainmodel.TaiKhoanAdmin;
import domainmodel.TaiKhoanNguoiDung;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import repository.BanRepository;
import repository.KhuVucRepository;
import service.implement.BanService;
import service.IBanService;
import service.IKhuVucService;
import service.implement.KhuVucService;
import viewmodel.BanViewModel;
import viewmodel.ChiNhanhViewModel_Hoang;
import viewmodel.KhuVucViewModel;

/**
 *
 * @author trant
 */
public class Ban extends javax.swing.JPanel {

    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel<KhuVucViewModel> comboKhuVuc;
    private DefaultComboBoxModel<ChiNhanhViewModel_Hoang> comboChiNhanh;
    private IBanService ibanService;
    private IKhuVucService iKhuVucService;
    private KhuVucRepository khuVucRepo;
    private BanRepository banRepo;
    private TaiKhoanAdmin taiKhoanAdmin;
    private TaiKhoanNguoiDung taiKhoanNguoiDung;

    KhuVucViewModel kvView = new KhuVucViewModel();
    BanViewModel banView = new BanViewModel();
    List<KhuVucViewModel> listkvView = new ArrayList<>();
    List<BanViewModel> listBanView = new ArrayList<>();
    List<ChiNhanhViewModel_Hoang> listcnView = new ArrayList<>();

    public Ban(TaiKhoanAdmin admin, TaiKhoanNguoiDung nguoiDung) {
        initComponents();
        banRepo = new BanRepository();
        ibanService = new BanService();
        iKhuVucService = new KhuVucService();
        khuVucRepo = new KhuVucRepository();
        taiKhoanAdmin = admin;
        taiKhoanNguoiDung = nguoiDung;
        if (taiKhoanAdmin != null) {
            cboChiNhanh.setVisible(true);
            comboChiNhanh = (DefaultComboBoxModel) new DefaultComboBoxModel<>(iKhuVucService.getAllChiNhanh().toArray());
            cboChiNhanh.setModel((DefaultComboBoxModel) comboChiNhanh);
            comboKhuVuc = (DefaultComboBoxModel) new DefaultComboBoxModel<>(
                    iKhuVucService.getAllKhuVucByChiNhanh(((ChiNhanhViewModel_Hoang) comboChiNhanh.getSelectedItem()).getId()).toArray());
            loadData(((ChiNhanhViewModel_Hoang) comboChiNhanh.getSelectedItem()).getId());
        } else {
            cboChiNhanh.setVisible(false);
            comboKhuVuc = (DefaultComboBoxModel) new DefaultComboBoxModel<>(
                    iKhuVucService.getAllKhuVucByChiNhanh(ibanService.getChiNhanhByTaiKhoan(nguoiDung.getId()).getId()).toArray());
            loadData(ibanService.getChiNhanhByTaiKhoan(nguoiDung.getId()).getId());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Ban = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSoBan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBan = new javax.swing.JTable();
        btnThemBan = new javax.swing.JButton();
        cbKhuVuc = new javax.swing.JComboBox<>();
        makhuvuc = new javax.swing.JLabel();
        lblHienThi = new javax.swing.JLabel();
        btnXoaBan = new javax.swing.JButton();
        KhuVuc = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaKhuVuc = new javax.swing.JTextField();
        btnThemKhuVuc = new javax.swing.JButton();
        btnCapNhatKhuVuc = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhuVuc = new javax.swing.JTable();
        cbTrangThaiKhuVuc = new javax.swing.JComboBox<>();
        cboChiNhanh = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(225, 218, 197));

        Ban.setBackground(new java.awt.Color(225, 218, 197));
        Ban.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bàn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(108, 83, 54))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(108, 83, 54));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Số bàn");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(108, 83, 54));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Khu Vực");

        txtSoBan.setBackground(new java.awt.Color(225, 218, 197));
        txtSoBan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        tblBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Số Bàn", "Khu Vực"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBan);
        if (tblBan.getColumnModel().getColumnCount() > 0) {
            tblBan.getColumnModel().getColumn(0).setMinWidth(0);
            tblBan.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        btnThemBan.setBackground(new java.awt.Color(108, 83, 54));
        btnThemBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemBan.setForeground(new java.awt.Color(225, 218, 197));
        btnThemBan.setText("Thêm");
        btnThemBan.setBorderPainted(false);
        btnThemBan.setFocusPainted(false);
        btnThemBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemBanActionPerformed(evt);
            }
        });

        cbKhuVuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhuVucActionPerformed(evt);
            }
        });

        btnXoaBan.setBackground(new java.awt.Color(108, 83, 54));
        btnXoaBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaBan.setForeground(new java.awt.Color(225, 218, 197));
        btnXoaBan.setText("Xóa");
        btnXoaBan.setBorderPainted(false);
        btnXoaBan.setFocusPainted(false);
        btnXoaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BanLayout = new javax.swing.GroupLayout(Ban);
        Ban.setLayout(BanLayout);
        BanLayout.setHorizontalGroup(
            BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BanLayout.createSequentialGroup()
                .addGroup(BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BanLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BanLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BanLayout.createSequentialGroup()
                                .addGroup(BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(BanLayout.createSequentialGroup()
                                        .addGap(240, 240, 240)
                                        .addComponent(lblHienThi)
                                        .addGap(21, 21, 21)
                                        .addComponent(makhuvuc))
                                    .addGroup(BanLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnXoaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnThemBan, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))))
                    .addGroup(BanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)))
                .addContainerGap())
        );
        BanLayout.setVerticalGroup(
            BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BanLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BanLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnThemBan))
                    .addGroup(BanLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BanLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(BanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(makhuvuc)
                            .addComponent(lblHienThi)))
                    .addGroup(BanLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnXoaBan)))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        KhuVuc.setBackground(new java.awt.Color(225, 218, 197));
        KhuVuc.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12)), "Khu Vực", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(108, 83, 54))); // NOI18N
        KhuVuc.setForeground(new java.awt.Color(108, 83, 54));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(108, 83, 54));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Trạng Thái");

        txtMaKhuVuc.setBackground(new java.awt.Color(225, 218, 197));
        txtMaKhuVuc.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        btnThemKhuVuc.setBackground(new java.awt.Color(108, 83, 54));
        btnThemKhuVuc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemKhuVuc.setForeground(new java.awt.Color(225, 218, 197));
        btnThemKhuVuc.setText("Thêm");
        btnThemKhuVuc.setBorderPainted(false);
        btnThemKhuVuc.setFocusPainted(false);
        btnThemKhuVuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhuVucActionPerformed(evt);
            }
        });

        btnCapNhatKhuVuc.setBackground(new java.awt.Color(108, 83, 54));
        btnCapNhatKhuVuc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhatKhuVuc.setForeground(new java.awt.Color(225, 218, 197));
        btnCapNhatKhuVuc.setText("Cập Nhật");
        btnCapNhatKhuVuc.setBorderPainted(false);
        btnCapNhatKhuVuc.setFocusPainted(false);
        btnCapNhatKhuVuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatKhuVucActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(108, 83, 54));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Mã");

        tblKhuVuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Mã", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhuVuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuVucMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhuVuc);
        if (tblKhuVuc.getColumnModel().getColumnCount() > 0) {
            tblKhuVuc.getColumnModel().getColumn(0).setMinWidth(0);
            tblKhuVuc.getColumnModel().getColumn(0).setMaxWidth(0);
            tblKhuVuc.getColumnModel().getColumn(1).setResizable(false);
        }

        cbTrangThaiKhuVuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang Hoạt Động", "Dừng Hoạt Động" }));
        cbTrangThaiKhuVuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTrangThaiKhuVucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KhuVucLayout = new javax.swing.GroupLayout(KhuVuc);
        KhuVuc.setLayout(KhuVucLayout);
        KhuVucLayout.setHorizontalGroup(
            KhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhuVucLayout.createSequentialGroup()
                .addGroup(KhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(KhuVucLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(KhuVucLayout.createSequentialGroup()
                        .addGroup(KhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(KhuVucLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(btnThemKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCapNhatKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(KhuVucLayout.createSequentialGroup()
                                .addGroup(KhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(KhuVucLayout.createSequentialGroup()
                                        .addContainerGap(13, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addGap(30, 30, 30))
                                    .addGroup(KhuVucLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(KhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTrangThaiKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(104, 104, 104)))
                .addContainerGap())
        );
        KhuVucLayout.setVerticalGroup(
            KhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhuVucLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(KhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(KhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTrangThaiKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(KhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKhuVuc)
                    .addComponent(btnCapNhatKhuVuc))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

        cboChiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChiNhanhActionPerformed(evt);
            }
        });

        jLabel4.setText("Chi nhánh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(KhuVuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
     private void loadData(String idChiNhanh) {
        load_KhuVuc_By_ChiNhanh(iKhuVucService.getAllKhuVucByChiNhanh(idChiNhanh));
        load_Ban_By_KhuVuc(ibanService.getAllBanByKhuVuc(((KhuVucViewModel) comboKhuVuc.getSelectedItem()).getIdKhuVuc()));
        addComboKhuVucByChiNhah(idChiNhanh);
    }

    private void fillDataToFormBan(int row) {
        txtSoBan.setText(tblBan.getValueAt(row, 1).toString());
        comboKhuVuc.setSelectedItem((findbyName(tblBan.getModel().getValueAt(row, 2).toString())));
    }

    private KhuVucViewModel findbyName(String MaKV) {
        for (int i = 0; i < comboKhuVuc.getSize(); i++) {
            KhuVucViewModel kv = comboKhuVuc.getElementAt(i);
            if (MaKV.equalsIgnoreCase(kv.getMakhuvuc())) {
                return kv;
            }
        }
        return null;
    }

    private void fillDataToFormKhuVuc(int row) {
        txtMaKhuVuc.setText(tblKhuVuc.getValueAt(row, 1).toString());
        if (tblKhuVuc.getValueAt(row, 2).toString().equalsIgnoreCase("Dừng Hoạt Động")) {
            cbTrangThaiKhuVuc.setSelectedIndex(0);
        } else {
            cbTrangThaiKhuVuc.setSelectedIndex(1);
        }

    }

    private void load_Ban_By_KhuVuc(List<BanViewModel> list) {
        defaultTableModel = (DefaultTableModel) tblBan.getModel();
        defaultTableModel.setRowCount(0);
        for (BanViewModel x : list) {
            defaultTableModel.addRow(x.getDataBan());
        }

    }

    private void load_KhuVuc_By_ChiNhanh(List<KhuVucViewModel> list) {
        defaultTableModel = (DefaultTableModel) tblKhuVuc.getModel();
        defaultTableModel.setRowCount(0);
        for (KhuVucViewModel x : list) {
            defaultTableModel.addRow(x.getDataKhuVuc());
        }
    }

    private void addComboKhuVucByChiNhah(String idChiNhanh) {
        listkvView = iKhuVucService.getAllKhuVucByChiNhanh(idChiNhanh);
        comboKhuVuc = (DefaultComboBoxModel) (new DefaultComboBoxModel<>(listkvView.toArray()));
        cbKhuVuc.setModel((DefaultComboBoxModel) comboKhuVuc);
    }


    private void btnThemKhuVucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhuVucActionPerformed
        if (checkFormEmptyBan(txtMaKhuVuc) && checkVuotquakituKhuVuc(txtMaKhuVuc.getText())
                && checkMaKhuVuc(txtMaKhuVuc.getText())) {
            if (taiKhoanNguoiDung == null) {
                iKhuVucService.insertKhuVucToChiNhanh(txtMaKhuVuc.getText(),
                        ((ChiNhanhViewModel_Hoang) comboChiNhanh.getSelectedItem()).getId());
            } else {
                iKhuVucService.insertKhuVucToChiNhanh(txtMaKhuVuc.getText(),
                        ibanService.getChiNhanhByTaiKhoan(taiKhoanNguoiDung.getId()).getId());
            }
            JOptionPane.showMessageDialog(this, "Thêm Khu Vực thành công");
            addComboKhuVucByChiNhah(((ChiNhanhViewModel_Hoang) comboChiNhanh.getSelectedItem()).getId());
            load_KhuVuc_By_ChiNhanh(iKhuVucService.getAllKhuVucByChiNhanh(((ChiNhanhViewModel_Hoang) comboChiNhanh.getSelectedItem()).getId()));
        } else {
            JOptionPane.showMessageDialog(this, "Thêm khu vực thất bại");
        }

    }//GEN-LAST:event_btnThemKhuVucActionPerformed

    private void btnCapNhatKhuVucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatKhuVucActionPerformed
        int row = tblKhuVuc.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khu vực trên bảng");
        } else {
            if (checkFormEmpty1(txtMaKhuVuc)) {
                KhuVucViewModel khuVucViewModel = new KhuVucViewModel();
                khuVucViewModel.setMakhuvuc(tblKhuVuc.getValueAt(row, 1).toString());
                if (cbTrangThaiKhuVuc.getSelectedIndex() == 0) {
                    khuVucViewModel.setTrangthai(1);
                } else {
                    khuVucViewModel.setTrangthai(0);
                }
                iKhuVucService.updateKhuVuc(khuVucViewModel, txtMaKhuVuc.getText(), cbTrangThaiKhuVuc.getSelectedIndex() == 1 ? 1 : 0);
                JOptionPane.showMessageDialog(this, "Cập nhật thành công  ");
                load_KhuVuc_By_ChiNhanh(iKhuVucService.getAllKhuVucByChiNhanh(((ChiNhanhViewModel_Hoang) comboChiNhanh.getSelectedItem()).getId()));

            }
        }

    }//GEN-LAST:event_btnCapNhatKhuVucActionPerformed

    private void btnThemBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemBanActionPerformed

        if (checkFormEmptyBan(txtSoBan) && checkNumber(txtSoBan.getText())
                && checkVuotquakituBan(txtSoBan.getText()) && checkSoBan(Integer.parseInt(txtSoBan.getText()))) {
            KhuVucViewModel kvView = (KhuVucViewModel) comboKhuVuc.getSelectedItem();
            ibanService.insertBan(Integer.parseInt(txtSoBan.getText()), kvView);
            JOptionPane.showMessageDialog(this, "Thêm Bàn thành công");
            load_Ban_By_KhuVuc(ibanService.getAllBanByKhuVuc(((KhuVucViewModel) comboKhuVuc.getSelectedItem()).getIdKhuVuc()));
        }
    }//GEN-LAST:event_btnThemBanActionPerformed

    private void cbKhuVucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhuVucActionPerformed
        load_Ban_By_KhuVuc(ibanService.getAllBanByKhuVuc(((KhuVucViewModel) comboKhuVuc.getSelectedItem()).getIdKhuVuc()));
    }//GEN-LAST:event_cbKhuVucActionPerformed

    private void cbTrangThaiKhuVucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTrangThaiKhuVucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTrangThaiKhuVucActionPerformed

    private void tblBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBanMouseClicked
        int row = tblBan.getSelectedRow();
        fillDataToFormBan(row);
    }//GEN-LAST:event_tblBanMouseClicked

    private void tblKhuVucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuVucMouseClicked
        int row = tblKhuVuc.getSelectedRow();
        fillDataToFormKhuVuc(row);
    }//GEN-LAST:event_tblKhuVucMouseClicked

    private void btnXoaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaBanActionPerformed
        int row = tblBan.getSelectedRow();
        ibanService.deleteBan(tblBan.getValueAt(row, 0).toString());
        JOptionPane.showMessageDialog(this, "Xoa Thành Công");
        load_Ban_By_KhuVuc(ibanService.getAllBanByKhuVuc(((KhuVucViewModel) comboKhuVuc.getSelectedItem()).getIdKhuVuc()));
    }//GEN-LAST:event_btnXoaBanActionPerformed

    private void cboChiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChiNhanhActionPerformed
        comboKhuVuc = (DefaultComboBoxModel) new DefaultComboBoxModel<>(
                iKhuVucService.getAllKhuVucByChiNhanh(((ChiNhanhViewModel_Hoang) comboChiNhanh.getSelectedItem()).getId()).toArray());
        loadData(((ChiNhanhViewModel_Hoang) comboChiNhanh.getSelectedItem()).getId());
    }//GEN-LAST:event_cboChiNhanhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Ban;
    private javax.swing.JPanel KhuVuc;
    private javax.swing.JButton btnCapNhatKhuVuc;
    private javax.swing.JButton btnThemBan;
    private javax.swing.JButton btnThemKhuVuc;
    private javax.swing.JButton btnXoaBan;
    private javax.swing.JComboBox<KhuVucViewModel> cbKhuVuc;
    private javax.swing.JComboBox<String> cbTrangThaiKhuVuc;
    private javax.swing.JComboBox<String> cboChiNhanh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHienThi;
    private javax.swing.JLabel makhuvuc;
    private javax.swing.JTable tblBan;
    private javax.swing.JTable tblKhuVuc;
    private javax.swing.JTextField txtMaKhuVuc;
    private javax.swing.JTextField txtSoBan;
    // End of variables declaration//GEN-END:variables
private boolean checkFormEmptyBan(JTextField soban) {
        if (soban.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được trống");
            return false;
        } else {
            return true;
        }
    }

    private boolean checkNumber(String num) {
        Pattern regexInt = Pattern.compile("^[0-9]+$");
        if (!regexInt.matcher(num).find()) {
            JOptionPane.showMessageDialog(this, "Số không hợp lệ(0-9)", "Number Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private boolean checkVuotquakituBan(String soban) {
        Pattern regex = Pattern.compile("^\\w{1,5}+$");
        if (!regex.matcher(soban).find()) {
            JOptionPane.showMessageDialog(this, "Tối đa 5 kí tự", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private boolean checkVuotquakituKhuVuc(String makv) {
        Pattern regex = Pattern.compile("^\\w{1,5}+$");
        if (!regex.matcher(makv).find()) {
            JOptionPane.showMessageDialog(this, "Tối đa 5 kí tự", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    private boolean checkFormEmpty1(JTextField ma) {
        if (ma.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được trống");
            return false;
        } else {
            return true;
        }
    }

    private boolean checkSoBan(Integer soBan) {
        domainmodel.Ban ban = banRepo.getBanFormSoBan(soBan);
        if (ban != null) {
            JOptionPane.showMessageDialog(this, "Số bàn này đã tồn tại");
            return false;
        }
        return true;
    }

    private boolean checkMaKhuVuc(String maKhuVuc) {
        domainmodel.KhuVuc khuVuc = khuVucRepo.getKhuVucFromMa(maKhuVuc);
        if (khuVuc != null) {
            JOptionPane.showMessageDialog(this, "Mã khu vực này đã tồn tại");
            return false;
        }
        return true;
    }
}
