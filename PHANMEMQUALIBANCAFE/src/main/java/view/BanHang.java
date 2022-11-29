/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domainmodel.NhanVien;
import domainmodel.TaiKhoanAdmin;
import domainmodel.TaiKhoanNguoiDung;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.IBanHangService;
import service.implement.BanHangService;
import viewmodel.Area;
import viewmodel.KhuyenMaiDangHoatDong;
import viewmodel.ProductForSale;
import viewmodel.Table;
import viewmodel.ThemKhachViewModel;

/**
 *
 * @author trant
 */
public class BanHang extends javax.swing.JPanel {

    private IBanHangService banHangService;
    private List<ItemSanPham> listItemSanPham;
    private DefaultTableModel modelTable;
    private DefaultComboBoxModel<Area> modelComboArea;
    private List<ItemBan> listItemBan;
    ThemKhachViewModel _khach = null;
    private boolean _ConfirmCloseDlong = false;

    public BanHang(TaiKhoanAdmin admin, TaiKhoanNguoiDung nguoiDung) {
        initComponents();
        hideInfoKhach();
        modelTable = new DefaultTableModel();
        modelTable = (DefaultTableModel) tblSpChon.getModel();
        banHangService = new BanHangService();
        modelComboArea = (DefaultComboBoxModel) new DefaultComboBoxModel<>(banHangService.getAllKhuVuc().toArray());
        cboKhuVuc.setModel((DefaultComboBoxModel) modelComboArea);
        listItemSanPham = new ArrayList<>();
        listItemBan = new ArrayList<>();
        showProductForSale();
        setEventClickForItemSanPham();
        showKhuyenMai();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        DlogTraTien = new javax.swing.JDialog();
        pnlTraTien = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblDiemTichLuy = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTienTichLuy = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboDungDiem = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        btnTraTien = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lblSoTienCanTra = new javax.swing.JLabel();
        lblCloseLog = new javax.swing.JLabel();
        pnlLeft = new javax.swing.JPanel();
        pnlTimSanPham = new javax.swing.JPanel();
        txtTimSp = new javax.swing.JTextField();
        btnTimSp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlListSp = new javax.swing.JPanel();
        pnlSPChon = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSpChon = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnlBan = new javax.swing.JPanel();
        cboKhuVuc = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlHoaDon = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblTienCanThanhToan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblSoBan = new javax.swing.JLabel();
        pnlTimKhach = new javax.swing.JPanel();
        txtTimKhach = new javax.swing.JTextField();
        btnThemKhach = new javax.swing.JButton();
        btnTimKhach = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtKhuyenMai = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtHienThiKhach = new javax.swing.JTextArea();

        DlogTraTien.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DlogTraTien.setUndecorated(true);
        DlogTraTien.addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                DlogTraTienWindowLostFocus(evt);
            }
        });

        pnlTraTien.setBackground(new java.awt.Color(111, 80, 44));
        pnlTraTien.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Điểm tích lũy :");

        lblDiemTichLuy.setBackground(new java.awt.Color(111, 80, 44));
        lblDiemTichLuy.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblDiemTichLuy.setForeground(new java.awt.Color(255, 255, 255));
        lblDiemTichLuy.setText("0");
        lblDiemTichLuy.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        lblDiemTichLuy.setOpaque(true);

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("=");

        lblTienTichLuy.setBackground(new java.awt.Color(111, 80, 44));
        lblTienTichLuy.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTienTichLuy.setForeground(new java.awt.Color(255, 255, 255));
        lblTienTichLuy.setText("0");
        lblTienTichLuy.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        lblTienTichLuy.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("VND");

        cboDungDiem.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        cboDungDiem.setForeground(new java.awt.Color(255, 255, 255));
        cboDungDiem.setText("Xác nhận dùng điểm");
        cboDungDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDungDiemActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nhập tiền khách đưa :");

        txtTienKhachDua.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tiền thừa :");

        lblTienThua.setBackground(new java.awt.Color(111, 80, 44));
        lblTienThua.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblTienThua.setForeground(new java.awt.Color(255, 255, 255));
        lblTienThua.setText("0");
        lblTienThua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        lblTienThua.setOpaque(true);

        btnTraTien.setBackground(new java.awt.Color(204, 153, 0));
        btnTraTien.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        btnTraTien.setForeground(new java.awt.Color(153, 51, 0));
        btnTraTien.setText("Trả tiền");
        btnTraTien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTraTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraTienActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Số tiền cần trả :");

        lblSoTienCanTra.setBackground(new java.awt.Color(111, 80, 44));
        lblSoTienCanTra.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblSoTienCanTra.setForeground(new java.awt.Color(255, 255, 255));
        lblSoTienCanTra.setText("0");
        lblSoTienCanTra.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        lblSoTienCanTra.setOpaque(true);

        lblCloseLog.setBackground(new java.awt.Color(111, 80, 44));
        lblCloseLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_cancel_30px.png"))); // NOI18N
        lblCloseLog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCloseLog.setOpaque(true);
        lblCloseLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseLogMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCloseLogMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCloseLogMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlTraTienLayout = new javax.swing.GroupLayout(pnlTraTien);
        pnlTraTien.setLayout(pnlTraTienLayout);
        pnlTraTienLayout.setHorizontalGroup(
            pnlTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTraTienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTraTienLayout.createSequentialGroup()
                        .addGroup(pnlTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6)
                            .addComponent(jLabel15))
                        .addGap(22, 22, 22)
                        .addGroup(pnlTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSoTienCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlTraTienLayout.createSequentialGroup()
                                .addComponent(lblDiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTienTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblTienThua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTienKhachDua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnlTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTraTienLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(cboDungDiem)
                                .addContainerGap(101, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTraTienLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTraTien, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTraTienLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblCloseLog))))
        );
        pnlTraTienLayout.setVerticalGroup(
            pnlTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTraTienLayout.createSequentialGroup()
                .addComponent(lblCloseLog, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblDiemTichLuy)
                    .addComponent(jLabel8)
                    .addComponent(lblTienTichLuy)
                    .addComponent(jLabel10)
                    .addComponent(cboDungDiem))
                .addGroup(pnlTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTraTienLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(pnlTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lblSoTienCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(pnlTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(pnlTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lblTienThua))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTraTienLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTraTien, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout DlogTraTienLayout = new javax.swing.GroupLayout(DlogTraTien.getContentPane());
        DlogTraTien.getContentPane().setLayout(DlogTraTienLayout);
        DlogTraTienLayout.setHorizontalGroup(
            DlogTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 909, Short.MAX_VALUE)
            .addGroup(DlogTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlTraTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DlogTraTienLayout.setVerticalGroup(
            DlogTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
            .addGroup(DlogTraTienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlTraTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        pnlLeft.setBackground(new java.awt.Color(255, 255, 255));
        pnlLeft.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlLeftMouseClicked(evt);
            }
        });

        pnlTimSanPham.setBackground(new java.awt.Color(255, 255, 255));
        pnlTimSanPham.setBorder(null);

        txtTimSp.setForeground(new java.awt.Color(204, 204, 204));
        txtTimSp.setText("Nhập tên sản phẩm cần tìm");
        txtTimSp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTimSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimSpMouseClicked(evt);
            }
        });

        btnTimSp.setBackground(new java.awt.Color(255, 255, 255));
        btnTimSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_20px.png"))); // NOI18N
        btnTimSp.setBorder(null);
        btnTimSp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout pnlTimSanPhamLayout = new javax.swing.GroupLayout(pnlTimSanPham);
        pnlTimSanPham.setLayout(pnlTimSanPhamLayout);
        pnlTimSanPhamLayout.setHorizontalGroup(
            pnlTimSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTimSp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimSp, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );
        pnlTimSanPhamLayout.setVerticalGroup(
            pnlTimSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimSanPhamLayout.createSequentialGroup()
                .addGroup(pnlTimSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimSp)
                    .addComponent(btnTimSp, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane1.setBorder(null);

        pnlListSp.setBackground(new java.awt.Color(255, 255, 255));
        pnlListSp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        pnlListSp.setLayout(new java.awt.GridLayout(0, 7, 10, 10));
        jScrollPane1.setViewportView(pnlListSp);

        pnlSPChon.setBackground(new java.awt.Color(255, 255, 255));
        pnlSPChon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));

        jScrollPane7.setBorder(null);

        tblSpChon.setBorder(null);
        tblSpChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền", "Gỡ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSpChon.setGridColor(new java.awt.Color(255, 255, 255));
        tblSpChon.getTableHeader().setReorderingAllowed(false);
        tblSpChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSpChonMouseClicked(evt);
            }
        });
        tblSpChon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblSpChonKeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(tblSpChon);
        if (tblSpChon.getColumnModel().getColumnCount() > 0) {
            tblSpChon.getColumnModel().getColumn(0).setMinWidth(0);
            tblSpChon.getColumnModel().getColumn(0).setMaxWidth(0);
            tblSpChon.getColumnModel().getColumn(1).setMinWidth(60);
            tblSpChon.getColumnModel().getColumn(1).setMaxWidth(60);
            tblSpChon.getColumnModel().getColumn(2).setResizable(false);
            tblSpChon.getColumnModel().getColumn(3).setResizable(false);
            tblSpChon.getColumnModel().getColumn(4).setResizable(false);
            tblSpChon.getColumnModel().getColumn(5).setResizable(false);
            tblSpChon.getColumnModel().getColumn(6).setMinWidth(30);
            tblSpChon.getColumnModel().getColumn(6).setMaxWidth(30);
        }

        javax.swing.GroupLayout pnlSPChonLayout = new javax.swing.GroupLayout(pnlSPChon);
        pnlSPChon.setLayout(pnlSPChonLayout);
        pnlSPChonLayout.setHorizontalGroup(
            pnlSPChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPChonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSPChonLayout.setVerticalGroup(
            pnlSPChonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPChonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setBorder(null);

        pnlBan.setLayout(new java.awt.GridLayout(0, 8, 10, 10));
        jScrollPane2.setViewportView(pnlBan);

        cboKhuVuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhuVucActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/gray.png"))); // NOI18N
        jLabel2.setText("Bàn Trống");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/new_moon_10px.png"))); // NOI18N
        jLabel3.setText("Đã hết");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/green.png"))); // NOI18N
        jLabel4.setText("Đang chọn");

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlLeftLayout.createSequentialGroup()
                        .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlSPChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlTimSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(pnlLeftLayout.createSequentialGroup()
                                .addComponent(cboKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlTimSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addComponent(cboKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLeftLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlSPChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlHoaDon.setBackground(new java.awt.Color(111, 80, 44));
        pnlHoaDon.setPreferredSize(new java.awt.Dimension(400, 754));
        pnlHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHoaDonMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tạm tính"));

        jLabel16.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel16.setText("Tổng tiền :");

        lblTongTien.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblTongTien.setText("0");

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel13.setText("Số tiền cần thanh toán :");

        lblTienCanThanhToan.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblTienCanThanhToan.setText("0");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Bàn số :");

        lblSoBan.setText("-");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTienCanThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblSoBan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTongTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblSoBan))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblTongTien))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblTienCanThanhToan))
                .addGap(99, 99, 99))
        );

        pnlTimKhach.setBackground(new java.awt.Color(255, 255, 255));
        pnlTimKhach.setBorder(null);

        txtTimKhach.setForeground(new java.awt.Color(204, 204, 204));
        txtTimKhach.setText("Nhập số điện thoại cần tìm");
        txtTimKhach.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtTimKhach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKhachMouseClicked(evt);
            }
        });
        txtTimKhach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKhachKeyReleased(evt);
            }
        });

        btnThemKhach.setBackground(new java.awt.Color(255, 255, 255));
        btnThemKhach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add_20px.png"))); // NOI18N
        btnThemKhach.setBorder(null);
        btnThemKhach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnTimKhach.setBackground(new java.awt.Color(255, 255, 255));
        btnTimKhach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_20px.png"))); // NOI18N
        btnTimKhach.setBorder(null);
        btnTimKhach.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKhachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTimKhachLayout = new javax.swing.GroupLayout(pnlTimKhach);
        pnlTimKhach.setLayout(pnlTimKhachLayout);
        pnlTimKhachLayout.setHorizontalGroup(
            pnlTimKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTimKhachLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnTimKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKhach)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        pnlTimKhachLayout.setVerticalGroup(
            pnlTimKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTimKhachLayout.createSequentialGroup()
                .addGroup(pnlTimKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        btnThanhToan.setBackground(new java.awt.Color(204, 153, 0));
        btnThanhToan.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(153, 51, 0));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setBorder(null);
        btnThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtKhuyenMai.setEditable(false);
        txtKhuyenMai.setColumns(20);
        txtKhuyenMai.setForeground(new java.awt.Color(255, 102, 102));
        txtKhuyenMai.setRows(5);
        txtKhuyenMai.setBorder(javax.swing.BorderFactory.createTitledBorder("Các khuyến mãi hiện có"));
        jScrollPane3.setViewportView(txtKhuyenMai);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sale_60px.png"))); // NOI18N

        jScrollPane4.setBorder(null);

        txtHienThiKhach.setEditable(false);
        txtHienThiKhach.setBackground(new java.awt.Color(111, 80, 44));
        txtHienThiKhach.setColumns(20);
        txtHienThiKhach.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtHienThiKhach.setForeground(new java.awt.Color(255, 255, 255));
        txtHienThiKhach.setRows(3);
        txtHienThiKhach.setBorder(null);
        jScrollPane4.setViewportView(txtHienThiKhach);

        javax.swing.GroupLayout pnlHoaDonLayout = new javax.swing.GroupLayout(pnlHoaDon);
        pnlHoaDon.setLayout(pnlHoaDonLayout);
        pnlHoaDonLayout.setHorizontalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoaDonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(pnlHoaDonLayout.createSequentialGroup()
                        .addGroup(pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane3)
                            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(pnlTimKhach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnlHoaDonLayout.setVerticalGroup(
            pnlHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoaDonLayout.createSequentialGroup()
                .addComponent(pnlTimKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnlHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setEventClickForItemSanPham() {
        for (ItemSanPham item : listItemSanPham) {
            item.getLblAvatarSp().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    addProductForSaleToTable(item);
                    upTotalItemSanPham(item);
                    totalMoney();
                    totalMoneyAfterSale();
                }

            });
        }
    }

    private void upTotalItemSanPham(ItemSanPham item) {
        int soLuong = 0;
        double thanhTien = 0;
        if (tblSpChon.getRowCount() > 0) {
            for (int i = 0; i < tblSpChon.getRowCount(); i++) {
                if (item.getId().equalsIgnoreCase(tblSpChon.getValueAt(i, 0).toString())) {
                    soLuong = Integer.parseInt(tblSpChon.getValueAt(i, 4).toString());
                    soLuong++;
                    tblSpChon.setValueAt(soLuong, i, 4);
                    thanhTien = Double.parseDouble(tblSpChon.getValueAt(i, 4).toString())
                            * Double.valueOf(tblSpChon.getValueAt(i, 3).toString());
                    tblSpChon.setValueAt(new BigDecimal(thanhTien), i, 5);
                    break;
                }
            }
        }
    }

    private void totalMoney() {
        double tongTien = 0;
        for (int i = 0; i < tblSpChon.getRowCount(); i++) {
            tongTien += Double.valueOf(tblSpChon.getValueAt(i, 5).toString());
        }
        lblTongTien.setText(String.valueOf(new BigDecimal(tongTien)));

    }

    private void totalMoneyAfterSale() {
        double soTienChietKhau = 0;
        double soTienPhaiTra = 0;
        double tongTienPhaiTra = 0;
        for (int i = 0; i < tblSpChon.getRowCount(); i++) {
            KhuyenMaiDangHoatDong kmView = banHangService.getKhuyenMaibySanPham(tblSpChon.getValueAt(i, 0).toString());
            if (kmView != null && kmView.getGiaTriChietKhau() != null) {
                soTienChietKhau = (Double.parseDouble(tblSpChon.getValueAt(i, 3).toString())
                        / 100) * kmView.getGiaTriChietKhau();
                soTienPhaiTra = Double.parseDouble(tblSpChon.getValueAt(i, 3).toString()) - soTienChietKhau;
                tongTienPhaiTra += soTienPhaiTra * Integer.parseInt(tblSpChon.getValueAt(i, 4).toString());
            } else {
                tongTienPhaiTra += Double.parseDouble(tblSpChon.getValueAt(i, 3).toString())
                        * Integer.parseInt(tblSpChon.getValueAt(i, 4).toString());
            }
        }
        lblTienCanThanhToan.setText(String.valueOf(new BigDecimal(tongTienPhaiTra)));
    }

    private void addProductForSaleToTable(ItemSanPham item) {
        int soLuong = 0;
        boolean check = false;
        BigDecimal thanhTien = new BigDecimal(item.getLblGiaSp().getText());
        for (int i = 0; i < tblSpChon.getRowCount(); i++) {
            if (item.getId().equalsIgnoreCase(tblSpChon.getValueAt(i, 0).toString())) {
                check = true;
                break;
            }
        }
        if (check != true) {
            modelTable.addRow(new Object[]{item.getId(), item.getMa(), item.getLblTenSp().getText(),
                item.getLblGiaSp().getText(), 0, thanhTien});
        }
    }

    private void showProductForSale() {
        List<ProductForSale> listProductForSale = banHangService.getAllProductForSale();
        if (listProductForSale != null) {
            for (ProductForSale product : listProductForSale) {
                ItemSanPham item = new ItemSanPham();
                item.setId(product.getIdSp());
                item.setMa(product.getMaSp());
                if (product.getTrangThai() != null) {
                    item.setTrangThai(product.getTrangThai());
                }
                if (product.getTenSp() != null) {
                    item.getLblTenSp().setText(product.getTenSp());
                }
                if (product.getTenKhuyenMai() != null) {
                    item.getLblTenKhuyenMai().setText(product.getTenKhuyenMai());
                    item.getLblSaleSp().setEnabled(true);
                } else {
                    item.getLblSaleSp().setEnabled(false);
                }
                if (product.getGiaBan() != null) {
                    item.getLblGiaSp().setText(String.valueOf(product.getGiaBan()));
                }
                if (product.getAvatar() != null) {
                    Image image = new ImageIcon(product.getAvatar()).getImage().
                            getScaledInstance(180, 180, Image.SCALE_SMOOTH);
                    item.getLblAvatarSp().setIcon(new ImageIcon(image));
                }
                pnlListSp.add(item);
                pnlListSp.revalidate();
                pnlListSp.repaint();
                listItemSanPham.add(item);

            }
        }

    }

    private void showKhuyenMai() {
        List<KhuyenMaiDangHoatDong> listKmActive = banHangService.getAllKhuyenMai();
        String allKhuyenMai = "";
        for (KhuyenMaiDangHoatDong km : listKmActive) {
            allKhuyenMai += "- " + km.getTenKhuyenMai() + " : " + km.getMoTa() + "\n";
        }
        txtKhuyenMai.setText(allKhuyenMai);
    }
    private void txtTimSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimSpMouseClicked
        txtTimSp.setForeground(Color.BLACK);
        txtTimSp.setText("");
    }//GEN-LAST:event_txtTimSpMouseClicked

    private void txtTimKhachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKhachMouseClicked
        txtTimKhach.setForeground(Color.BLACK);
        txtTimKhach.setText("");
        hideInfoKhach();

    }//GEN-LAST:event_txtTimKhachMouseClicked

    private void setHoverOfSearch() {
        Color color = new Color(225, 225, 225);
        txtTimSp.setText("Nhập tên sản phẩm cần tìm");
        txtTimKhach.setText("Nhập số điện thoại cần tìm");
        txtTimSp.setForeground(color);
        txtTimKhach.setForeground(color);
    }
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        setHoverOfSearch();
    }//GEN-LAST:event_formMouseClicked


    private void tblSpChonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblSpChonKeyReleased
        int row = tblSpChon.getSelectedRow();
        double thanhTien = 0;
        if (!banHangService.checkSo(tblSpChon.getValueAt(row, 4).toString())) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
            tblSpChon.setValueAt(1, row, 4);
        } else {
            if (Integer.parseInt(tblSpChon.getValueAt(row, 4).toString()) == 0) {
                modelTable.removeRow(row);
            } else {
                thanhTien = Double.parseDouble(tblSpChon.getValueAt(row, 4).toString()) * Double.valueOf(tblSpChon.getValueAt(row, 3).toString());
                tblSpChon.setValueAt(new BigDecimal(thanhTien), row, 5);
            }
        }
    }//GEN-LAST:event_tblSpChonKeyReleased

    private void pnlLeftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLeftMouseClicked
        setHoverOfSearch();
    }//GEN-LAST:event_pnlLeftMouseClicked

    private void pnlHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHoaDonMouseClicked
        setHoverOfSearch();
    }//GEN-LAST:event_pnlHoaDonMouseClicked

    private void addEventMouseClickToItemBan(ItemBan itemBan) {
        itemBan.getLblAvatar().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                itemBan.changeStateConfirm();
                if (itemBan.isConfirm() == true && itemBan.getTrangThai() == 0) {
                    lblSoBan.setText(itemBan.getLblSoBan().getText());
                } else {
                    lblSoBan.setText("-");
                }

            }
        });
        itemBan.getLblSoBan().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                itemBan.changeStateConfirm();
                if (itemBan.isConfirm() == true && itemBan.getTrangThai() == 0) {
                    lblSoBan.setText(itemBan.getLblSoBan().getText());
                } else {
                    lblSoBan.setText("-");
                }
            }
        });
    }

    private void showTableOfArea(Area area) {
        List<Table> listTable = banHangService.getAllBanByKhuVuc(area);
        if (!listTable.isEmpty()) {
            for (Table table : listTable) {
                ItemBan itemBan = new ItemBan();
                itemBan.getLblSoBan().setText(table.getSoBan().toString());
                itemBan.setTrangThai(table.getTrangThaiBan());
                if (itemBan.getTrangThai() != 0) {
                    itemBan.getLblSoBan().setBackground(Color.red);
                    itemBan.getLblAvatar().setBackground(Color.red);
                }
                listItemBan.add(itemBan);
                pnlBan.add(itemBan);
                pnlBan.revalidate();
                pnlBan.repaint();
                addEventMouseClickToItemBan(itemBan);

            }
        } else {
            JOptionPane.showMessageDialog(pnlBan, "Khu vực này không có bàn");
        }
    }
    private void cboKhuVucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKhuVucActionPerformed
        pnlBan.removeAll();
        pnlBan.revalidate();
        pnlBan.repaint();
        Area area = (Area) modelComboArea.getSelectedItem();
        showTableOfArea(area);

    }//GEN-LAST:event_cboKhuVucActionPerformed

    private void tblSpChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSpChonMouseClicked
        int row = tblSpChon.getSelectedRow();
        int column = tblSpChon.getSelectedColumn();
        if (column == 6) {
            boolean remove = (boolean) tblSpChon.getValueAt(row, column);
            if (remove == true) {
                modelTable.removeRow(row);
                totalMoney();
                totalMoneyAfterSale();
            }
        }

    }//GEN-LAST:event_tblSpChonMouseClicked

    private void hideInfoKhach() {
        txtHienThiKhach.setText("");
        _khach = null;
    }


    private void btnTimKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKhachActionPerformed
        _khach = banHangService.getKhachHangBySdt(txtTimKhach.getText());
        if (_khach != null) {
            txtHienThiKhach.setText("Mã khách hàng : " + _khach.getMa() + "\n" + "Tên khách hàng : " + _khach.getHoTen() + "\n"
                    + "Số điện thoại : " + _khach.getSdt());

        } else {
            JOptionPane.showMessageDialog(this, "Thông tin không tồn tại. Vui lòng kiểm tra lại !");
            hideInfoKhach();
        }
    }//GEN-LAST:event_btnTimKhachActionPerformed

    private void txtTimKhachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKhachKeyReleased
        if (txtTimKhach.getText().isBlank()) {
            hideInfoKhach();
        }
    }//GEN-LAST:event_txtTimKhachKeyReleased

    private void setTraTien() {
        double tienTichLuy = 0;
        int diemTichLuy = 0;
        if (_khach != null) {
            diemTichLuy = _khach.getDiemTichLuy();
            tienTichLuy = _khach.getDiemTichLuy() * banHangService.getGiaTriDiem();
            lblDiemTichLuy.setText(String.valueOf(diemTichLuy));
            lblTienTichLuy.setText(String.valueOf(new BigDecimal(tienTichLuy)));

        }
        lblSoTienCanTra.setText(lblTienCanThanhToan.getText());
        if (cboDungDiem.isSelected()) {
            txtTienKhachDua.setText("");
            double tienCanThanhToan = Double.parseDouble(lblSoTienCanTra.getText());
            float giaTriDiem = banHangService.getGiaTriDiem();
            if (tienTichLuy > tienCanThanhToan) {
                double tienConLai = tienTichLuy - tienCanThanhToan;
                int diemConLai = (int) (tienConLai / giaTriDiem);
                lblSoTienCanTra.setText("0");
                lblDiemTichLuy.setText(String.valueOf(diemConLai));
                lblTienTichLuy.setText(String.valueOf(new BigDecimal(diemConLai * giaTriDiem)));
            } else {
                tienCanThanhToan = tienCanThanhToan - tienTichLuy;
                lblSoTienCanTra.setText(String.valueOf(new BigDecimal(tienCanThanhToan)));
                lblDiemTichLuy.setText("0");
                lblTienTichLuy.setText("0");
            }
        } else {
            lblSoTienCanTra.setText(lblTienCanThanhToan.getText());
            lblDiemTichLuy.setText(String.valueOf(diemTichLuy));
            lblTienTichLuy.setText(String.valueOf(new BigDecimal(tienTichLuy)));
        }

    }
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (tblSpChon.getRowCount() > 0 && !lblSoBan.getText().equalsIgnoreCase("-")) {
            DlogTraTien.setVisible(true);
            DlogTraTien.setSize(900, 340);
            DlogTraTien.setLocationRelativeTo(null);
            setTraTien();
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng sản phẩm và Số bàn");
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void lblCloseLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseLogMouseClicked
        _ConfirmCloseDlong = true;
        if (_ConfirmCloseDlong == true) {
            DlogTraTien.setVisible(false);/////chưa ổn
        }
    }//GEN-LAST:event_lblCloseLogMouseClicked


    private void DlogTraTienWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_DlogTraTienWindowLostFocus

        if (_ConfirmCloseDlong == true) {
            DlogTraTien.setVisible(false);
            _ConfirmCloseDlong = false;
        } else {
            JOptionPane.showMessageDialog(DlogTraTien, "Vui lòng đóng giao diện thanh toán");
            DlogTraTien.setVisible(true);
            setTraTien();
        }
    }//GEN-LAST:event_DlogTraTienWindowLostFocus

    private void lblCloseLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseLogMouseEntered
        lblCloseLog.setBackground(Color.red);
    }//GEN-LAST:event_lblCloseLogMouseEntered

    private void lblCloseLogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseLogMouseExited

        Color color = new Color(111, 80, 44);
        lblCloseLog.setBackground(color);
    }//GEN-LAST:event_lblCloseLogMouseExited

    private void cboDungDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDungDiemActionPerformed
        setTraTien();
    }//GEN-LAST:event_cboDungDiemActionPerformed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased

        if (banHangService.checkSo(txtTienKhachDua.getText())) {
            double tienThua = Double.parseDouble(txtTienKhachDua.getText()) - Double.parseDouble(lblSoTienCanTra.getText());
            lblTienThua.setText(String.valueOf(new BigDecimal(tienThua)));
        }
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void btnTraTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraTienActionPerformed
//        if (txtTienKhachDua.getText().isBlank()) {
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền khách đưa");
//        } else if (Double.parseDouble(lblTienThua.getText()) < 0) {
//            JOptionPane.showMessageDialog(this, "Số tiền chưa đủ thanh toán");
//        } else {
//            Date ngayTaoHD = new Date();
//            DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
//            dateFormat.format(ngayTaoHD);
//            NhanVien nhanVien = banHangService.getNhanVienbyTaiKhoan(new Login().getNguoiDung().getId());
//            String idHoaDon = banHangService.inserHoaDon(banHangService.autoGenMaHoaDon(), ngayTaoHD,
//                    nhanVien.getId(), Integer.parseInt(lblSoBan.getText()));
//            for (int i = 0; i < tblSpChon.getRowCount(); i++) {
//                banHangService.insertChiTietHoaDon(tblSpChon.getValueAt(i, 0).toString(),
//                        idHoaDon, Integer.parseInt(tblSpChon.getValueAt(i, 4).toString()),
//                        new BigDecimal(lbl), BigDecimal.TEN);
//            }
//
//        }

    }//GEN-LAST:event_btnTraTienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DlogTraTien;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemKhach;
    private javax.swing.JButton btnTimKhach;
    private javax.swing.JButton btnTimSp;
    private javax.swing.JButton btnTraTien;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cboDungDiem;
    private javax.swing.JComboBox<String> cboKhuVuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblCloseLog;
    private javax.swing.JLabel lblDiemTichLuy;
    private javax.swing.JLabel lblSoBan;
    private javax.swing.JLabel lblSoTienCanTra;
    private javax.swing.JLabel lblTienCanThanhToan;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTienTichLuy;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JPanel pnlBan;
    private javax.swing.JPanel pnlHoaDon;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlListSp;
    private javax.swing.JPanel pnlSPChon;
    private javax.swing.JPanel pnlTimKhach;
    private javax.swing.JPanel pnlTimSanPham;
    private javax.swing.JPanel pnlTraTien;
    private javax.swing.JTable tblSpChon;
    private javax.swing.JTextArea txtHienThiKhach;
    private javax.swing.JTextArea txtKhuyenMai;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTimKhach;
    private javax.swing.JTextField txtTimSp;
    // End of variables declaration//GEN-END:variables
}
