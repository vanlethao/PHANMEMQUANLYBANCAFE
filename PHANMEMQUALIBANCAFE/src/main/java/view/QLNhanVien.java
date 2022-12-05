/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domainmodel.ChiNhanh;
import domainmodel.ChucVu;
import domainmodel.NhanVien;
import domainmodel.TaiKhoanAdmin;
import domainmodel.TaiKhoanNguoiDung;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.IKhuyenMai;
import service.INhanVien;
import service.implement.KhuyenMaiService;
import service.implement.NhanVienService;
import viewmodel.ChiNhanhView;
import viewmodel.ChucVuView;
import viewmodel.NhanVienView;

/**
 *
 * @author trant
 */
public class QLNhanVien extends javax.swing.JPanel {

    List<NhanVienView> nhanVienViews;
    INhanVien iNhanVien;
    IKhuyenMai iKhuyenMai;
    byte[] avatar;
    ImageIcon defaultAvatar;
    private final String tenChucVu;
    private final ChiNhanh cn;

//    public QLNhanVien(TaiKhoanAdmin admin, TaiKhoanNguoiDung nguoiDung) {
//        initComponents();
//    }
    public QLNhanVien(String tenChucVu) {
        this.tenChucVu = tenChucVu;
        this.cn = null;
        initComponents();
        init();
        cbbChiNhanh.setModel(new DefaultComboBoxModel(iKhuyenMai.getAllChiNhanhON().toArray()));
        nhanVienViews = iNhanVien.getAllNhanVien();
        fillNVToTable();
    }

    public QLNhanVien(String tenChucVu, ChiNhanh cn) {
        this.tenChucVu = tenChucVu;
        this.cn = cn;
        initComponents();
        init();
        cbbChiNhanh.setVisible(false);
        cbbFilterChiNhanh.setModel(new DefaultComboBoxModel(new Object[]{cn})); // quen chua cast sang view
        nhanVienViews = iNhanVien.getAllNVByChiNhanh(cn);
        fillNVToTable();
    }

    private void init() {
        iNhanVien = new NhanVienService();
        iKhuyenMai = new KhuyenMaiService();

        
        rdoNam.setSelected(true);
        rdoAllNV.setSelected(true);
        cbbChucVu.setModel(new DefaultComboBoxModel(iNhanVien.getAllChucVu().toArray()));
        cbbFilterChiNhanh.setSelectedIndex(0);
//        cbbFilterChiNhanh.setModel(new DefaultComboBoxModel(concatenate(new Object[]{"- Tat ca chi nhanh -"}, iKhuyenMai.getAllChiNhanhON().toArray())));
        cbbFilterChiNhanh.setModel(new DefaultComboBoxModel(concatenate(new Object[]{"- Tat ca chi nhanh -"}, iKhuyenMai.getAllChiNhanh().toArray())));
        Image image = new ImageIcon(getClass().getClassLoader().getResource("icon\\add-image.png")).getImage();
        defaultAvatar = new ImageIcon(image.getScaledInstance(150, 200, Image.SCALE_SMOOTH));
        lblAnhNV.setIcon(defaultAvatar);

    }

    private Object[] concatenate(Object[] a, Object[] b) {
        Collection<Object> result = new ArrayList<Object>(a.length + b.length);
        result.addAll(Arrays.asList(a));
        result.addAll(Arrays.asList(b));
        return result.toArray();
    }

    // VIEW
    private void fillNVToTable() {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        if (!nhanVienViews.isEmpty()) {
            for (NhanVienView nvv : nhanVienViews) {
                model.addRow(nvv.toDataRow());
            }
        }
    }

    private void fillNVToControls() {
        int row = tblNhanVien.getSelectedRow();
        String maNV = tblNhanVien.getValueAt(row, 1) + "";
        List<NhanVienView> nvvs = iNhanVien.getAllNVByMa(maNV);
        if (!nvvs.isEmpty()) {
            NhanVienView nvv = nvvs.get(0);
            txtMaNV.setText(nvv.getMa());
            txtHoTenNV.setText(nvv.getHoTen());
            txtSDT.setText(nvv.getSdt());
            txtThanhPho.setText(nvv.getThanhPho());
            txtQuocGia.setText(nvv.getQuocGia());
            txtLuong.setText(nvv.getLuong() + "");
            if (nvv.getGioTinh().equalsIgnoreCase("Nam")) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }

            if (nvv.getTrangThai() == 1) {
                cbbTrangThai.setSelectedIndex(1);
            } else {
                cbbTrangThai.setSelectedIndex(2);
            }
            if(tenChucVu.equalsIgnoreCase("Ông chủ")) {
                cbbChiNhanh.setSelectedIndex(indexChiNhanh(tblNhanVien.getValueAt(row, 8) + ""));
            }
            cbbChucVu.setSelectedIndex(indexChucVu(tblNhanVien.getValueAt(row, 9) + ""));
            // load anh nv
            if (nvv.getAvatar() != null) {
                Image image = new ImageIcon(nvv.getAvatar()).getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);
                lblAnhNV.setIcon(new ImageIcon(image));
            } else {
                lblAnhNV.setIcon(defaultAvatar);
            }
//            cbbChucVu.setSelectedItem(nvv.getChucVu()); // bi loi k chay dc, du co cast ve doi tuong roi, chua hieu sai o dau
//            cbbChiNhanh.setSelectedItem(nvv.getChiNhanh()));
        }
    }

    private int indexChiNhanh(String maCN) {
        List<ChiNhanhView> cnvs = iKhuyenMai.getAllChiNhanhON();
        if (!cnvs.isEmpty()) {
            for (int i = 0; i < cnvs.size(); i++) {
                if (cnvs.get(i).getMa().equalsIgnoreCase(maCN)) {
                    return i;
                }
            }
        }
        return 0;
    }

    private int indexChucVu(String tenCV) {
        List<ChucVuView> cvvs = iNhanVien.getAllChucVu();
        if (!cvvs.isEmpty()) {
            for (int i = 0; i < cvvs.size(); i++) {
                if (cvvs.get(i).getTen().equalsIgnoreCase(tenCV)) {
                    return i;
                }
            }
        }
        return 0;
    }

    private void resetControls() {
        txtMaNV.setText("");
        txtHoTenNV.setText("");
        txtSDT.setText("");
        txtThanhPho.setText("");
        txtQuocGia.setText("");
        txtLuong.setText("");
        rdoNam.setSelected(true);
        cbbTrangThai.setSelectedIndex(0);
        cbbChucVu.setSelectedIndex(0);
        cbbChiNhanh.setSelectedIndex(0);
    }

    private Object[] getDataFormControls() {
        return new Object[]{txtMaNV.getText().trim(), txtHoTenNV.getText().trim(),
            txtSDT.getText().trim(), txtThanhPho.getText().trim(), txtQuocGia.getText().trim(),
            txtLuong.getText().trim(), cbbTrangThai.getSelectedIndex()
        };
    }

    private NhanVien getNVFromControls() {
        if (tenChucVu.equalsIgnoreCase("Ông chủ")) {
            return new NhanVien(null, txtMaNV.getText().trim(), txtHoTenNV.getText().trim(), txtQuocGia.getText().trim(),
                txtThanhPho.getText().trim(), txtSDT.getText().trim(), rdoNam.isSelected() ? "Nam" : "Nu",
                Float.parseFloat(txtLuong.getText().trim()), cbbTrangThai.getSelectedIndex() == 1 ? 1 : 0,
                avatar, iKhuyenMai.getChiNhanhById(((ChiNhanhView) cbbChiNhanh.getSelectedItem()).getId()),
                iNhanVien.getChucVuById(((ChucVuView) cbbChucVu.getSelectedItem()).getId()),
                null);
        } else { // theo chi nhanh cu the
            return new NhanVien(null, txtMaNV.getText().trim(), txtHoTenNV.getText().trim(), txtQuocGia.getText().trim(),
                txtThanhPho.getText().trim(), txtSDT.getText().trim(), rdoNam.isSelected() ? "Nam" : "Nu",
                Float.parseFloat(txtLuong.getText().trim()), cbbTrangThai.getSelectedIndex() == 1 ? 1 : 0,
                avatar, cn,
                iNhanVien.getChucVuById(((ChucVuView) cbbChucVu.getSelectedItem()).getId()),
                null);
        }
        
    }

    private void searchAndFilterNV(String search, int trangThai) {
        if (tenChucVu.equalsIgnoreCase("Ông chủ")) {
            int type = cbbFilterChiNhanh.getSelectedIndex();
            if (type == 0) { // 0 = all, !=0 theo chi nhanh
                if (search.isBlank()) {
                    if (trangThai == -1) {
                        nhanVienViews = iNhanVien.getAllNhanVien();
                    } else {
                        nhanVienViews = iNhanVien.getAllNVByTrangThai(trangThai);
                    }
                } else {
                    if (trangThai == -1) {
                        if (iNhanVien.getAllNVByMa(search).isEmpty()) {
                            if (iNhanVien.getAllNVByName(search).isEmpty()) {
                                nhanVienViews = iNhanVien.getAllNVBySDT(search);
                            } else {
                                nhanVienViews = iNhanVien.getAllNVByName(search);
                            }
                        } else {
                            nhanVienViews = iNhanVien.getAllNVByMa(search);
                        }
                    } else {
                        if (iNhanVien.getAllNVByMaAndTrangThai(trangThai, search).isEmpty()) {
                            if (iNhanVien.getAllNVByNameAndTrangThai(trangThai, search).isEmpty()) {
                                nhanVienViews = iNhanVien.getAllNVBySDTAndTrangThai(trangThai, search);
                            } else {
                                nhanVienViews = iNhanVien.getAllNVByNameAndTrangThai(trangThai, search);
                            }
                        } else {
                            nhanVienViews = iNhanVien.getAllNVByMaAndTrangThai(trangThai, search);
                        }
                    }
                }
            } else {
                ChiNhanhView cnv = (ChiNhanhView) cbbFilterChiNhanh.getSelectedItem();
                String id = cnv.getId();
                ChiNhanh cn = iKhuyenMai.getChiNhanhById(id);
                if (search.isBlank()) {
                    if (trangThai == -1) {
                        nhanVienViews = iNhanVien.getAllNVByChiNhanh(cn);
                    } else {
                        nhanVienViews = iNhanVien.getAllNVByChiNhanhAndTrangThai(cn, trangThai);
                    }
                } else {
                    if (trangThai == -1) {
                        if (iNhanVien.getAllNVByChiNhanhAndMa(cn, search).isEmpty()) {
                            if (iNhanVien.getAllNVByChiNhanhAndName(cn, search).isEmpty()) {
                                nhanVienViews = iNhanVien.getAllNVByChiNhanhAndSDT(cn, search);
                            } else {
                                nhanVienViews = iNhanVien.getAllNVByChiNhanhAndName(cn, search);
                            }
                        } else {
                            nhanVienViews = iNhanVien.getAllNVByChiNhanhAndMa(cn, search);
                        }
                    } else {
                        if (iNhanVien.getAllNVByChiNhanhAndTrangThaiAndMa(cn, trangThai, search).isEmpty()) {
                            if (iNhanVien.getAllNVByChiNhanhAndTrangThaiAndName(cn, trangThai, search).isEmpty()) {
                                nhanVienViews = iNhanVien.getAllNVByChiNhanhAndTrangThaiAndSDT(cn, trangThai, search);
                            } else {
                                nhanVienViews = iNhanVien.getAllNVByChiNhanhAndTrangThaiAndName(cn, trangThai, search);
                            }
                        } else {
                            nhanVienViews = iNhanVien.getAllNVByChiNhanhAndTrangThaiAndMa(cn, trangThai, search);
                        }
                    }
                }
            }
        } else {
            if (search.isBlank()) {
                if (trangThai == -1) {
                    nhanVienViews = iNhanVien.getAllNVByChiNhanh(cn);
                } else {
                    nhanVienViews = iNhanVien.getAllNVByChiNhanhAndTrangThai(cn, trangThai);
                }
            } else {
                if (trangThai == -1) {
                    if (iNhanVien.getAllNVByChiNhanhAndMa(cn, search).isEmpty()) {
                        if (iNhanVien.getAllNVByChiNhanhAndName(cn, search).isEmpty()) {
                            nhanVienViews = iNhanVien.getAllNVByChiNhanhAndSDT(cn, search);
                        } else {
                            nhanVienViews = iNhanVien.getAllNVByChiNhanhAndName(cn, search);
                        }
                    } else {
                        nhanVienViews = iNhanVien.getAllNVByChiNhanhAndMa(cn, search);
                    }
                } else {
                    if (iNhanVien.getAllNVByChiNhanhAndTrangThaiAndMa(cn, trangThai, search).isEmpty()) {
                        if (iNhanVien.getAllNVByChiNhanhAndTrangThaiAndName(cn, trangThai, search).isEmpty()) {
                            nhanVienViews = iNhanVien.getAllNVByChiNhanhAndTrangThaiAndSDT(cn, trangThai, search);
                        } else {
                            nhanVienViews = iNhanVien.getAllNVByChiNhanhAndTrangThaiAndName(cn, trangThai, search);
                        }
                    } else {
                        nhanVienViews = iNhanVien.getAllNVByChiNhanhAndTrangThaiAndMa(cn, trangThai, search);
                    }
                }
            }
        }
    }

    // CUD
    private void addNhanVien() { // chi them nhan vien o cac chi nhanh dang hoat dong
        if (iNhanVien.validateDataInput(getDataFormControls()).isBlank()) {
            JOptionPane.showMessageDialog(null, iNhanVien.addNhanVien(getNVFromControls()));
            int trangThai = rdoAllNV.isSelected() ? -1 : (rdoNVOn.isSelected() ? 1 : 0);
            searchAndFilterNV("", trangThai);
            fillNVToTable();
//            if(iNhanVien.addNhanVien(getNVFromControls()). equalsIgnoreCase("Them thanh cong!")){
                 resetControls();
//            }   
        } else {
            JOptionPane.showMessageDialog(null, iNhanVien.validateDataInput(getDataFormControls()));
        }
    }

    private void updateNhanVien() {
        int row = tblNhanVien.getSelectedRow();
        if (row != -1) {
            if (iNhanVien.validateDataInput(getDataFormControls()).isBlank()) {
                boolean check = false; // so sanh 2 gia tri maNCC tren table va control, tru thi update cac truong khac ngoai tru maNCC, false thi update ca maNCC nhung phai check trung
                String maNVTable = tblNhanVien.getValueAt(row, 1) + "";
                String maNVControls = txtMaNV.getText().trim();
                if (maNVTable.equalsIgnoreCase(maNVControls)) {
                    check = true;
                }
                String id = tblNhanVien.getValueAt(row, 0) + "";
                NhanVien ncc = getNVFromControls();
                if (tenChucVu.equalsIgnoreCase("Ông chủ")) {
                    JOptionPane.showMessageDialog(null, iNhanVien.updateNhanVienByAdmin(id, ncc, check));
                } else {
                    JOptionPane.showMessageDialog(null, iNhanVien.updateNhanVien(id, ncc, check));
                }
                int trangThai = rdoAllNV.isSelected() ? -1 : (rdoNVOn.isSelected() ? 1 : 0);
                String search = txtSearchNV.getText().trim();
                searchAndFilterNV(search, trangThai);
                fillNVToTable();
            } else {
                JOptionPane.showMessageDialog(null, iNhanVien.validateDataInput(getDataFormControls()));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ban can chon 1 hang trong bang truoc!");
        }
    }

    private void deleteNhaVien() {
        int row = tblNhanVien.getSelectedRow();
        if (row != -1) {
            String id = tblNhanVien.getValueAt(row, 0) + "";
            JOptionPane.showMessageDialog(null, iNhanVien.deleteNhanVien(id));
            int trangThai = rdoAllNV.isSelected() ? -1 : (rdoNVOn.isSelected() ? 1 : 0);
            String search = txtSearchNV.getText().trim();
            searchAndFilterNV(search, trangThai);
            fillNVToTable();
            resetControls();
        } else {
            JOptionPane.showMessageDialog(null, "Ban can chon 1 hang trong bang truoc hoac dien ma nhan vien hop le!");
        }
    }

    private void exportExcelNCC() {
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;
        JFileChooser excelFileChooser = new JFileChooser(".\\src");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChosser = excelFileChooser.showSaveDialog(null);
        if (excelChosser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
                for (int i = 0; i < tblNhanVien.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < tblNhanVien.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(tblNhanVien.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(this, "Exported");
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }
                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                } catch (IOException ex) {
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        txtMaNV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtThanhPho = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoTenNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQuocGia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        btnAddNhanVien = new javax.swing.JButton();
        btnUpdateNV = new javax.swing.JButton();
        btnDeleteNV = new javax.swing.JButton();
        btnExecl = new javax.swing.JButton();
        txtSearchNV = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblAnhNV = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbbChiNhanh = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        btnChonAnhNV = new javax.swing.JButton();
        cbbFilterChiNhanh = new javax.swing.JComboBox<>();
        rdoAllNV = new javax.swing.JRadioButton();
        rdoNVOn = new javax.swing.JRadioButton();
        rdoNVOff = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("Ma");

        jLabel3.setText("Ho ten");

        jLabel4.setText("Quoc gia");

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ma", "Ho ten", "Gioi tinh", "Sdt", "Thanh pho", "Quoc gia", "Luong", "Chi nhanh", "Chuc vu", "Trang thai"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);
        if (tblNhanVien.getColumnModel().getColumnCount() > 0) {
            tblNhanVien.getColumnModel().getColumn(0).setMinWidth(0);
            tblNhanVien.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblNhanVien.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        btnAddNhanVien.setText("Them");
        btnAddNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNhanVienActionPerformed(evt);
            }
        });

        btnUpdateNV.setText("Cap Nhat");
        btnUpdateNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateNVActionPerformed(evt);
            }
        });

        btnDeleteNV.setText("Xoa");
        btnDeleteNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteNVActionPerformed(evt);
            }
        });

        btnExecl.setText("Xuat file");
        btnExecl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExeclActionPerformed(evt);
            }
        });

        txtSearchNV.setText("Tim theo ma, ten, sdt...");
        txtSearchNV.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchNVCaretUpdate(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnhNV, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnhNV, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setText("Thanh Pho");

        jLabel6.setText("SDT");

        jLabel7.setText("Gioi tinh:");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nu");

        jLabel8.setText("Luong:");

        jLabel9.setText("Chi nhanh:");

        cbbChiNhanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Chuc vu:");

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Trang thai:");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Chon trang thai-", "Con lam", "Da nghi" }));

        btnChonAnhNV.setText("Upload");
        btnChonAnhNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhNVActionPerformed(evt);
            }
        });

        cbbFilterChiNhanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbFilterChiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbFilterChiNhanhActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoAllNV);
        rdoAllNV.setText("All");
        rdoAllNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAllNVActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoNVOn);
        rdoNVOn.setText("Trang thai 1");
        rdoNVOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNVOnActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoNVOff);
        rdoNVOff.setText("Trang thai 2");
        rdoNVOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNVOffActionPerformed(evt);
            }
        });

        jLabel1.setText("Xem theo chi nhanh:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearchNV, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbFilterChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnAddNhanVien)
                        .addGap(28, 28, 28)
                        .addComponent(btnUpdateNV)
                        .addGap(31, 31, 31)
                        .addComponent(btnDeleteNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExecl)
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(jLabel5)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtThanhPho, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                        .addComponent(txtLuong))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(cbbChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                    .addComponent(txtHoTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(24, 24, 24)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtQuocGia, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                        .addComponent(cbbChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jLabel10))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoNu))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnChonAnhNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 596, Short.MAX_VALUE)
                        .addComponent(rdoAllNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoNVOn)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNVOff)
                        .addGap(118, 118, 118))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtHoTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtThanhPho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChonAnhNV)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoAllNV)
                            .addComponent(rdoNVOn)
                            .addComponent(rdoNVOff))
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNhanVien)
                    .addComponent(btnUpdateNV)
                    .addComponent(btnDeleteNV)
                    .addComponent(btnExecl)
                    .addComponent(txtSearchNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbFilterChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNhanVienActionPerformed
        addNhanVien();
    }//GEN-LAST:event_btnAddNhanVienActionPerformed

    private void btnUpdateNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateNVActionPerformed
        updateNhanVien();
    }//GEN-LAST:event_btnUpdateNVActionPerformed

    private void btnDeleteNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteNVActionPerformed
        deleteNhaVien();
    }//GEN-LAST:event_btnDeleteNVActionPerformed

    private void btnExeclActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExeclActionPerformed
        exportExcelNCC();
    }//GEN-LAST:event_btnExeclActionPerformed

    private void btnChonAnhNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhNVActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(this);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();//return file selected-gán path cho File
            Image image = new ImageIcon(file.getAbsolutePath()).getImage().getScaledInstance(lblAnhNV.getWidth(), lblAnhNV.getHeight(), Image.SCALE_SMOOTH);
            lblAnhNV.setIcon(new ImageIcon(image));//tao đối tượng ImageIcon(lấy path file truyền vào)rồi seticon cho label
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "png", baos);
                avatar = new byte[baos.toByteArray().length];
                avatar = baos.toByteArray();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnChonAnhNVActionPerformed

    private void cbbFilterChiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbFilterChiNhanhActionPerformed
//        if()
        if(cbbFilterChiNhanh.getSelectedIndex() == 0) {
            cbbChiNhanh.setVisible(true);
        } else {
            cbbChiNhanh.setVisible(false);
        }
        txtSearchNV.setText("");
        rdoAllNV.setSelected(true);
        searchAndFilterNV("", -1);
        fillNVToTable();
    }//GEN-LAST:event_cbbFilterChiNhanhActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        fillNVToControls();
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void txtSearchNVCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchNVCaretUpdate
        int trangThai = rdoAllNV.isSelected() ? -1 : (rdoNVOn.isSelected() ? 1 : 0);
        String search = txtSearchNV.getText().trim();
        searchAndFilterNV(search, trangThai);
        fillNVToTable();
    }//GEN-LAST:event_txtSearchNVCaretUpdate

    private void rdoAllNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAllNVActionPerformed
        int trangThai = rdoAllNV.isSelected() ? -1 : (rdoNVOn.isSelected() ? 1 : 0);
        String search = txtSearchNV.getText().trim();
        searchAndFilterNV(search, trangThai);
        fillNVToTable();
    }//GEN-LAST:event_rdoAllNVActionPerformed

    private void rdoNVOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNVOnActionPerformed
        rdoAllNVActionPerformed(evt);
    }//GEN-LAST:event_rdoNVOnActionPerformed

    private void rdoNVOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNVOffActionPerformed
        rdoAllNVActionPerformed(evt);
    }//GEN-LAST:event_rdoNVOffActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNhanVien;
    private javax.swing.JButton btnChonAnhNV;
    private javax.swing.JButton btnDeleteNV;
    private javax.swing.JButton btnExecl;
    private javax.swing.JButton btnUpdateNV;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbChiNhanh;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JComboBox<String> cbbFilterChiNhanh;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnhNV;
    private javax.swing.JRadioButton rdoAllNV;
    private javax.swing.JRadioButton rdoNVOff;
    private javax.swing.JRadioButton rdoNVOn;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtHoTenNV;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtQuocGia;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearchNV;
    private javax.swing.JTextField txtThanhPho;
    // End of variables declaration//GEN-END:variables
}
