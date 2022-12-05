/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domainmodel.ChiNhanh;
import domainmodel.SanPham;
import domainmodel.TaiKhoanAdmin;
import domainmodel.TaiKhoanNguoiDung;
import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.IKhuyenMai;
import service.implement.KhuyenMaiService;
import viewmodel.ChiNhanhView;
import viewmodel.KhuyenMaiView;
//import viewmodel.SanPhamViewModel;

/**
 *
 * @author trant
 */
public class KhuyenMai extends javax.swing.JPanel {

    IKhuyenMai iKhuyenMai;
    List<KhuyenMaiView> khuyenMaiViews;
    List<SanPham> sanPhamAddKM;
    List<SanPham> sanPhamHaveKM;
//    String[] columnNamesKhuyenMai = {"Ma","Ten","Noi dung", "Ngay bat dau", "Ngay ket thuc", "Gia tri triet khau", "Trang thai"};
    private final String tenChucVu;
    private final ChiNhanh cn;

    public KhuyenMai(String tenChucVu) {
        this.tenChucVu = tenChucVu;
        this.cn = null;
        initComponents();
        init();
        cbbFilterChiNhanh.setModel(new DefaultComboBoxModel(concatenate(new Object[]{"-Chon chi nhanh-"}, iKhuyenMai.getAllChiNhanhON().toArray())));// viet lai repo ChiNhanh thi sua doan nay
        khuyenMaiViews = iKhuyenMai.getAllKhuyenMai();
        sanPhamAddKM = iKhuyenMai.getAllSP();
        loadDataKhuyenMai();
        loadDataSPToAdd();
        // neu bang k co du lieu thi k fill controls
        if (!khuyenMaiViews.isEmpty()) {
            fillDataToControls(0);
        }
    }

    public KhuyenMai(String tenChucVu, ChiNhanh cn) {
        this.tenChucVu = tenChucVu;
        this.cn = cn;
        initComponents();
        init();
        khuyenMaiViews = iKhuyenMai.getAllKMByChiNhanh(cn);
        sanPhamAddKM = iKhuyenMai.getAllSPByChiNhanh(cn);
        cbbFilterChiNhanh.setModel(new DefaultComboBoxModel(new Object[]{toChiNhanhView(cn)}));// viet lai repo ChiNhanh thi sua doan nay
        loadDataKhuyenMai();
        loadDataSPToAdd();
        if (!khuyenMaiViews.isEmpty()) {
            fillDataToControls(0);
        }
    }

    private void init() {
        iKhuyenMai = new KhuyenMaiService();
        // Default Components
        txtIdKM.setEnabled(false);
        rdoFillTatCa.setSelected(true);
        rdoConHan.setSelected(true);
        txtSearchKM.setForeground(Color.GRAY);
        txtSearchSP.setForeground(Color.GRAY);
        pnlSPCoKM.setVisible(false);
        txtNgayBatDau.setDateFormatString("yyyy-MM-dd");
        txtNgayKetThuc.setDateFormatString("yyyy-MM-dd");
    }

    private Object[] concatenate(Object[] a, Object[] b) {
        Collection<Object> result = new ArrayList<Object>(a.length + b.length);
        result.addAll(Arrays.asList(a));
        result.addAll(Arrays.asList(b));
        return result.toArray();
    }

    private ChiNhanhView toChiNhanhView(ChiNhanh cn) {
        return new ChiNhanhView(cn.getId(), cn.getMa());
    }

    /// VIEW
    private void loadDataKhuyenMai() {
        DefaultTableModel model = (DefaultTableModel) tblKhuyenMai.getModel();
        model.setRowCount(0);

        if (khuyenMaiViews != null) {
            for (KhuyenMaiView kmv : khuyenMaiViews) {
                model.addRow(kmv.toDataRow());
            }
        }
    }

    // search and filter khuyen mai
    private void searchAndFilterKM(String search, int trangThai) {
        if (tenChucVu.equalsIgnoreCase("Ông chủ")) {
            int type = cbbFilterChiNhanh.getSelectedIndex(); // type = 0 all, !=0 theo chi nhanh
            if (type == 0) {
                // tim truoc loc sau
                if (search.isBlank()) {
                    if (trangThai == -1) { // -1 all, !-1 la theo trang thai
                        khuyenMaiViews = iKhuyenMai.getAllKhuyenMai();
                    } else {
                        khuyenMaiViews = iKhuyenMai.getAllKMByTrangThai(trangThai);
                    }
                } else {
                    if (trangThai == -1) {
                        khuyenMaiViews = iKhuyenMai.getAllKMByName(search);
                    } else {
                        khuyenMaiViews = iKhuyenMai.getAllKMByNameAndTrangThai(trangThai, search);
                    }
                }
            } else {
                ChiNhanhView cnv = (ChiNhanhView) cbbFilterChiNhanh.getSelectedItem();
                ChiNhanh cn = iKhuyenMai.getChiNhanhById(cnv.getId());
                if (search.isBlank()) {
                    if (trangThai == -1) {
                        khuyenMaiViews = iKhuyenMai.getAllKMByChiNhanh(cn);
                    } else {
                        khuyenMaiViews = iKhuyenMai.getAllKMByChiNhanhAndTrangThai(cn, trangThai);
                    }
                } else {
                    if (trangThai == -1) {
                        khuyenMaiViews = iKhuyenMai.getAllKMByChiNhanhAndName(cn, search);
                    } else {
                        khuyenMaiViews = iKhuyenMai.getAllKMByChiNhanhAndTrangThaiAndName(cn, trangThai, search);
                    }
                }
            }
        } else {
            if (search.isBlank()) {
                if (trangThai == -1) {
                    khuyenMaiViews = iKhuyenMai.getAllKMByChiNhanh(cn);
                } else {
                    khuyenMaiViews = iKhuyenMai.getAllKMByChiNhanhAndTrangThai(cn, trangThai);
                }
            } else {
                if (trangThai == -1) {
                    khuyenMaiViews = iKhuyenMai.getAllKMByChiNhanhAndName(cn, search);
                } else {
                    khuyenMaiViews = iKhuyenMai.getAllKMByChiNhanhAndTrangThaiAndName(cn, trangThai, search);
                }
            }
        }
    }

    private void searchAndFilterSPAdd(String search) {
        if (tenChucVu.equalsIgnoreCase("Ông chủ")) {
            int type = cbbFilterChiNhanh.getSelectedIndex();
            if (type == 0) {
                if (search.isBlank()) {
                    sanPhamAddKM = iKhuyenMai.getAllSP();
                } else {
                    if (iKhuyenMai.getAllSPByMa(search).isEmpty()) {
                        sanPhamAddKM = iKhuyenMai.getAllSPByName(search);
                    } else {
                        sanPhamAddKM = iKhuyenMai.getAllSPByMa(search);
                    }
                }
            } else {
                ChiNhanhView cnv = (ChiNhanhView) cbbFilterChiNhanh.getSelectedItem();
                ChiNhanh chiNhanh = iKhuyenMai.getChiNhanhById(cnv.getId());
                if (search.isBlank()) {
                    sanPhamAddKM = iKhuyenMai.getAllSPByChiNhanh(chiNhanh);
                } else {
                    if (iKhuyenMai.getAllSPByChiNhanhAndMa(chiNhanh, search).isEmpty()) {
                        sanPhamAddKM = iKhuyenMai.getAllSPByChiNhanhAndName(chiNhanh, search);
                    } else {
                        sanPhamAddKM = iKhuyenMai.getAllSPByChiNhanhAndMa(chiNhanh, search);
                    }
                }
            }
        } else {
            if (search.isBlank()) {
                sanPhamAddKM = iKhuyenMai.getAllSPByChiNhanh(cn);
            } else {
                if (iKhuyenMai.getAllSPByChiNhanhAndMa(cn, search).isEmpty()) {
                    sanPhamAddKM = iKhuyenMai.getAllSPByChiNhanhAndName(cn, search);
                } else {
                    sanPhamAddKM = iKhuyenMai.getAllSPByChiNhanhAndMa(cn, search);
                }
            }
        }
    }

    /// SAN PHAM
    private void loadDataSPToAdd() {
        DefaultTableModel model = (DefaultTableModel) tblSanPhamAdd.getModel();
        model.setRowCount(0);
        if (sanPhamAddKM != null) {
            for (SanPham sp : sanPhamAddKM) {
                model.addRow(new Object[]{sp.getMa(), sp.getTen(), sp.getGiaBan(), Boolean.FALSE});
            }
        }
    }

    private void loadDataSPHaveKM(domainmodel.KhuyenMai km) {
        DefaultTableModel model = (DefaultTableModel) tblSanPhamDelete.getModel();
        model.setRowCount(0);
        if (tenChucVu.equalsIgnoreCase("Ông chủ")) {
            int type = cbbFilterChiNhanh.getSelectedIndex();
            if (type == 0) {
                sanPhamHaveKM = iKhuyenMai.getAllSPByKhuyenMai(km);
            } else {
                ChiNhanhView cnv = (ChiNhanhView) cbbFilterChiNhanh.getSelectedItem();
                ChiNhanh chiNhanh = iKhuyenMai.getChiNhanhById(cnv.getId());
                sanPhamHaveKM = iKhuyenMai.getAllSPByKhuyenMaiAndChiNhanh(chiNhanh, km);
            }
        } else {
            sanPhamHaveKM = iKhuyenMai.getAllSPByKhuyenMaiAndChiNhanh(cn, km);
        }

        if (sanPhamHaveKM != null) {
            for (SanPham sp : sanPhamHaveKM) {
                model.addRow(new Object[]{sp.getMa(), sp.getTen(), sp.getGiaBan(), Boolean.TRUE});
            }
        }
    }

    private void fillDataToControls(int row) {
        String id = (String) tblKhuyenMai.getValueAt(row, 0);
        KhuyenMaiView kmv = iKhuyenMai.getKhuyenMaiViewById(id);
        domainmodel.KhuyenMai km = iKhuyenMai.getKMById(id);
        txtIdKM.setText(kmv.getId());
        txtTenKM.setText(kmv.getTenKM());
        txtNgayBatDau.setDate(kmv.getNgayBatDau());
        txtNgayKetThuc.setDate(kmv.getNgayKetThuc());
        txtChietKhau.setText(kmv.getChietKhau() + "");
        txtMoTa.setText(kmv.getMoTa());
        if (kmv.getTrangThai() == 1) {
            rdoConHan.setSelected(true);
        } else {
            rdoHetHan.setSelected(true);
        }
        pnlSPCoKM.setVisible(true);
        loadDataSPHaveKM(km);
    }

    private Object[] getDataFromControls() {
        return new Object[]{
            txtTenKM.getText().trim(),
            txtMoTa.getText().trim(),
            txtNgayBatDau.getDate(),
            txtNgayKetThuc.getDate(),
            txtChietKhau.getText()
        };
    }

    private void resetControl() {
        txtIdKM.setText("");
        txtTenKM.setText("");
        txtNgayBatDau.setDate(null);
        txtNgayKetThuc.setDate(null);
        txtChietKhau.setText("");
        txtMoTa.setText("");
        rdoConHan.setSelected(true);
    }

    private domainmodel.KhuyenMai getKMFromControls() {
        return new domainmodel.KhuyenMai(null, txtTenKM.getText().trim(),
                txtNgayBatDau.getDate(), txtNgayKetThuc.getDate(), txtMoTa.getText(),
                Float.parseFloat(txtChietKhau.getText().trim()),
                rdoConHan.isSelected() == true ? 1 : 0
        );
    }

//    private String auotGenMa() {
//        return null;
//    }
//    private Date convertDate(Date d) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String dateCovert = sdf.format(d);
//        return Date.valueOf(dateCovert);
//    }
//    private Float calculateChietKhau() {
//        String slMuaStr = txtSoLuongMua.getText().trim();
//        String slTangStr = txtSoLuongTang.getText().trim();
//        if (slMuaStr.isBlank() || slTangStr.isBlank()) {
//            return null;
//        } else {
//            float slMua = Float.parseFloat(slMuaStr);
//            float slTang = Float.parseFloat(slTangStr);
//            return (slTang / (slMua + slTang)) * 100;
//        }
//    }
    // lay san pham them khuyen mai
    private List<SanPham> getSPAdd() {
        List<SanPham> sanPhams = new ArrayList<>();
        for (int i = 0; i < sanPhamAddKM.size(); i++) {
            if (tblSanPhamAdd.getValueAt(i, 3).equals(Boolean.TRUE)) {
                String ma = tblSanPhamAdd.getValueAt(i, 0) + "";
                sanPhams.add(iKhuyenMai.getSanPhamByMa(ma));
            }
        }
        return sanPhams;
    }

    // lay san pham xoa khuyen mai
    private List<SanPham> getSPDelete() {
        List<SanPham> sanPhams = new ArrayList<>();
        for (int i = 0; i < sanPhamHaveKM.size(); i++) {
            if (tblSanPhamDelete.getValueAt(i, 3).equals(Boolean.FALSE)) {
                String ma = tblSanPhamDelete.getValueAt(i, 0) + "";
                sanPhams.add(iKhuyenMai.getSanPhamByMa(ma));
            }
        }
        return sanPhams;
    }

    private void isSelectAllSPAdd(boolean check) {
        if (check == true) {
            for (int i = 0; i < sanPhamAddKM.size(); i++) {
                tblSanPhamAdd.setValueAt(true, i, 3);
            }
        } else {
            for (int i = 0; i < sanPhamAddKM.size(); i++) {
                tblSanPhamAdd.setValueAt(false, i, 3);
            }
        }
    }

    private void isSelectAllSPDelete(boolean check) {
        if (check == true) {
            for (int i = 0; i < sanPhamHaveKM.size(); i++) {
                tblSanPhamDelete.setValueAt(false, i, 3);
            }
        } else {
            for (int i = 0; i < sanPhamHaveKM.size(); i++) {
                tblSanPhamDelete.setValueAt(true, i, 3);
            }
        }
    }

    /// CUD
    private void addKhuyenMai() {
        if (iKhuyenMai.validateDataInput(getDataFromControls()).isBlank()) {
            if (!getSPAdd().isEmpty()) {
                String mes = iKhuyenMai.addKhuyenMai(getKMFromControls(), getSPAdd());
                JOptionPane.showMessageDialog(null, mes);
                if (mes.equalsIgnoreCase("Them thanh cong!")) {
                    resetControl();
                }
                int trangThai = rdoFillTatCa.isSelected() ? -1 : (rdoFillConHan.isSelected() ? 1 : 0);
                searchAndFilterKM("", trangThai);
                loadDataKhuyenMai();
            } else {
                JOptionPane.showMessageDialog(null, "Can chon it nhat mot san pham ap dung!");
            }
        } else {
            JOptionPane.showMessageDialog(null, iKhuyenMai.validateDataInput(getDataFromControls()));
        }
    }

    private void updateKhuyenMai() {
        int row = tblKhuyenMai.getSelectedRow();
        if (row != -1) {
            if (iKhuyenMai.validateDataInput(getDataFromControls()).isBlank()) {
                String id = tblKhuyenMai.getValueAt(row, 0) + "";
                domainmodel.KhuyenMai km = getKMFromControls();
                JOptionPane.showMessageDialog(null, iKhuyenMai.updateKhuyenMai(id, km, getSPAdd(), getSPDelete()));
                int trangThai = rdoFillTatCa.isSelected() ? -1 : (rdoFillConHan.isSelected() ? 1 : 0);
                Color color = txtSearchKM.getForeground();
                if (!color.equals(Color.GRAY)) {
                    String search = txtSearchKM.getText().trim();
                    searchAndFilterKM(search, trangThai);
                } else {
                    searchAndFilterKM("", trangThai);
                }
                loadDataKhuyenMai();
//                if(trangThai == -1){
//                    loadDataSPHaveKM(iKhuyenMai.getKMById(id));
//                } else {
//                    loadDataSPHaveKM(iKhuyenMai.getK);
//                }
                loadDataSPHaveKM(iKhuyenMai.getKMById(id));
            } else {
                JOptionPane.showMessageDialog(null, iKhuyenMai.validateDataInput(getDataFromControls()));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ban can chon 1 hang trong bang truoc hoac dien ma khuyen mai hop le!");
        }
    }

//    private void deleteKhuyenMai() { // xoa han
//        int row = tblKhuyenMai.getSelectedRow();
//        if (row != -1) {
//            String id = (String) tblKhuyenMai.getValueAt(row, 0);
//            domainmodel.KhuyenMai km = iKhuyenMai.getKMById(id);
//            JOptionPane.showMessageDialog(null, iKhuyenMai.deleteKM(id, iKhuyenMai.getAllSPByKhuyenMai(km)));
////            khuyenMaiViews.clear();
////            khuyenMaiViews = iKhuyenMai.getAllKhuyenMai();
//            loadDataKhuyenMai();
//        } else {
//            JOptionPane.showMessageDialog(null, "Ban can chon 1 hang trong bang truoc!");
//        }
//    }
    private void deleteKM() { // chuyen trang thai
        int row = tblKhuyenMai.getSelectedRow();
        if (row != -1) {
            String id = (String) tblKhuyenMai.getValueAt(row, 0);
            JOptionPane.showMessageDialog(null, iKhuyenMai.deleteKhuyenMai(id));
            int trangThai = rdoFillTatCa.isSelected() ? -1 : (rdoFillConHan.isSelected() ? 1 : 0);
            String search = txtSearchKM.getText().trim();
            searchAndFilterKM(search, trangThai);
            loadDataKhuyenMai();
        } else {
            JOptionPane.showMessageDialog(null, "Ban can chon 1 hang trong bang truoc!");
        }
    }

    private void exportExcelKM() {
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
                for (int i = 0; i < tblKhuyenMai.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < tblKhuyenMai.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(tblKhuyenMai.getValueAt(i, j).toString());
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
        jPanel1 = new javax.swing.JPanel();
        pnlChiTietKM = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtIdKM = new javax.swing.JTextField();
        txtChietKhau = new javax.swing.JTextField();
        txtTenKM = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        rdoConHan = new javax.swing.JRadioButton();
        rdoHetHan = new javax.swing.JRadioButton();
        btnAddKhuyenMai = new javax.swing.JButton();
        btnUpdateKhuyenMai = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        pnlSPCoKM = new javax.swing.JPanel();
        chkbBoChonTatCa = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSanPhamDelete = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        txtSearchKM = new javax.swing.JTextField();
        cbbFilterChiNhanh = new javax.swing.JComboBox<>();
        btnDeleteKhuyenMai = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        rdoFillTatCa = new javax.swing.JRadioButton();
        rdoFillConHan = new javax.swing.JRadioButton();
        rdoFillHetHan = new javax.swing.JRadioButton();
        btnExportExcel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSanPhamAdd = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        chkbSelectAllSPAdd = new javax.swing.JCheckBox();
        txtSearchSP = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        pnlChiTietKM.setBackground(new java.awt.Color(220, 204, 186));

        jLabel2.setText("ID:");

        jLabel3.setText("Ten:");

        jLabel10.setText("Noi dung:");

        jLabel11.setText("Ngay bat dau:");

        jLabel12.setText("Ngay ket thuc:");

        jLabel13.setText("Chiet khau(%):");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        jLabel4.setText("Trang thai:");

        buttonGroup2.add(rdoConHan);
        rdoConHan.setText("Con han");

        buttonGroup2.add(rdoHetHan);
        rdoHetHan.setText("Het han");

        btnAddKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add_20px.png"))); // NOI18N
        btnAddKhuyenMai.setText("Them Khuyen Mai");
        btnAddKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKhuyenMaiActionPerformed(evt);
            }
        });

        btnUpdateKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdateKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_sync_30px.png"))); // NOI18N
        btnUpdateKhuyenMai.setText("Cap Nhat Khuyen Mai");
        btnUpdateKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateKhuyenMaiActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Chi tiet khuyen mai");

        chkbBoChonTatCa.setText("Bo chon tat ca");
        chkbBoChonTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbBoChonTatCaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("San pham duoc ap dung khuyen mai");

        tblSanPhamDelete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma", "Ten", "Gia", "Trang thai"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblSanPhamDelete);

        javax.swing.GroupLayout pnlSPCoKMLayout = new javax.swing.GroupLayout(pnlSPCoKM);
        pnlSPCoKM.setLayout(pnlSPCoKMLayout);
        pnlSPCoKMLayout.setHorizontalGroup(
            pnlSPCoKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPCoKMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSPCoKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSPCoKMLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(chkbBoChonTatCa))
                    .addGroup(pnlSPCoKMLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE))))
        );
        pnlSPCoKMLayout.setVerticalGroup(
            pnlSPCoKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSPCoKMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSPCoKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkbBoChonTatCa)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlChiTietKMLayout = new javax.swing.GroupLayout(pnlChiTietKM);
        pnlChiTietKM.setLayout(pnlChiTietKMLayout);
        pnlChiTietKMLayout.setHorizontalGroup(
            pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTietKMLayout.createSequentialGroup()
                .addGroup(pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChiTietKMLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlChiTietKMLayout.createSequentialGroup()
                                .addGroup(pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTenKM)
                                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2)
                                    .addComponent(txtChietKhau)
                                    .addGroup(pnlChiTietKMLayout.createSequentialGroup()
                                        .addComponent(rdoConHan)
                                        .addGap(34, 34, 34)
                                        .addComponent(rdoHetHan)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtIdKM)))
                            .addGroup(pnlChiTietKMLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlChiTietKMLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnUpdateKhuyenMai)
                        .addGap(39, 39, 39)
                        .addComponent(btnAddKhuyenMai)
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(pnlChiTietKMLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlSPCoKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlChiTietKMLayout.setVerticalGroup(
            pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChiTietKMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(39, 39, 39)
                .addGroup(pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdoConHan)
                    .addComponent(rdoHetHan))
                .addGap(18, 18, 18)
                .addGroup(pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(pnlSPCoKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdateKhuyenMai)
                    .addGroup(pnlChiTietKMLayout.createSequentialGroup()
                        .addComponent(btnAddKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlChiTietKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlChiTietKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.setBackground(new java.awt.Color(220, 204, 186));

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ten", "Noi dung", "Ngay bat dau", "Ngay ket thuc", "Gia tri chiet khau", "Trang thai"
            }
        ));
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuyenMai);
        if (tblKhuyenMai.getColumnModel().getColumnCount() > 0) {
            tblKhuyenMai.getColumnModel().getColumn(0).setMinWidth(0);
            tblKhuyenMai.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblKhuyenMai.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        txtSearchKM.setText("Tim theo ten...");
        txtSearchKM.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchKMCaretUpdate(evt);
            }
        });
        txtSearchKM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchKMFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchKMFocusLost(evt);
            }
        });

        cbbFilterChiNhanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbFilterChiNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbFilterChiNhanhActionPerformed(evt);
            }
        });

        btnDeleteKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_remove_30px.png"))); // NOI18N
        btnDeleteKhuyenMai.setText("Xoa Khuyen Mai");
        btnDeleteKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteKhuyenMaiActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Danh sach khuyen mai");

        buttonGroup1.add(rdoFillTatCa);
        rdoFillTatCa.setText("Tat ca");
        rdoFillTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFillTatCaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoFillConHan);
        rdoFillConHan.setText("Kich hoat");
        rdoFillConHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFillConHanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoFillHetHan);
        rdoFillHetHan.setText("Chua ap dung");
        rdoFillHetHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoFillHetHanActionPerformed(evt);
            }
        });

        btnExportExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_microsoft_excel_30px.png"))); // NOI18N
        btnExportExcel.setText("Xuat file excel");
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Xem theo chi nhanh:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExportExcel)
                        .addGap(37, 37, 37)
                        .addComponent(btnDeleteKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSearchKM, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdoFillTatCa)
                        .addGap(24, 24, 24)
                        .addComponent(rdoFillConHan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoFillHetHan)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(340, 340, 340)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbFilterChiNhanh, 0, 178, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(cbbFilterChiNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoFillTatCa)
                    .addComponent(rdoFillConHan)
                    .addComponent(rdoFillHetHan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteKhuyenMai)
                    .addComponent(btnExportExcel))
                .addGap(76, 76, 76))
        );

        jPanel3.setBackground(new java.awt.Color(220, 204, 186));

        tblSanPhamAdd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma", "Ten", "Gia", "Chon"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblSanPhamAdd);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Chon san pham ap dung");

        chkbSelectAllSPAdd.setText("Chon tat ca");
        chkbSelectAllSPAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbSelectAllSPAddActionPerformed(evt);
            }
        });

        txtSearchSP.setText("Tim theo ma, ten...");
        txtSearchSP.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchSPCaretUpdate(evt);
            }
        });
        txtSearchSP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchSPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchSPFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtSearchSP, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chkbSelectAllSPAdd)
                        .addGap(34, 34, 34))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkbSelectAllSPAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKhuyenMaiActionPerformed
        addKhuyenMai();
        loadDataSPToAdd();
    }//GEN-LAST:event_btnAddKhuyenMaiActionPerformed

    private void btnUpdateKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateKhuyenMaiActionPerformed
        updateKhuyenMai();
    }//GEN-LAST:event_btnUpdateKhuyenMaiActionPerformed

    private void chkbBoChonTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbBoChonTatCaActionPerformed
        isSelectAllSPDelete(chkbBoChonTatCa.isSelected());
    }//GEN-LAST:event_chkbBoChonTatCaActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        int row = tblKhuyenMai.getSelectedRow();
        if (row != -1) {
            fillDataToControls(row);
        }
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void txtSearchKMCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchKMCaretUpdate
        int trangThai = rdoFillTatCa.isSelected() ? -1 : (rdoFillConHan.isSelected() ? 1 : 0);
        Color color = txtSearchKM.getForeground();
        if (!color.equals(Color.GRAY)) {
            String search = txtSearchKM.getText().trim();
            searchAndFilterKM(search, trangThai);
            loadDataKhuyenMai();
        }
    }//GEN-LAST:event_txtSearchKMCaretUpdate

    private void cbbFilterChiNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbFilterChiNhanhActionPerformed
        int trangThai = rdoFillTatCa.isSelected() ? -1 : (rdoFillConHan.isSelected() ? 1 : 0);
        searchAndFilterKM("", trangThai);
        searchAndFilterSPAdd("");
        loadDataKhuyenMai();
        loadDataSPToAdd();
    }//GEN-LAST:event_cbbFilterChiNhanhActionPerformed

    private void btnDeleteKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteKhuyenMaiActionPerformed
//        deleteKhuyenMai();
        deleteKM();
    }//GEN-LAST:event_btnDeleteKhuyenMaiActionPerformed

    private void rdoFillTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFillTatCaActionPerformed
        int trangThai = rdoFillTatCa.isSelected() ? -1 : (rdoFillConHan.isSelected() ? 1 : 0);
        Color color = txtSearchKM.getForeground();
        if (!color.equals(Color.GRAY)) {
            String search = txtSearchKM.getText().trim();
            searchAndFilterKM(search, trangThai);
            loadDataKhuyenMai();
        } else {
            searchAndFilterKM("", trangThai);
            loadDataKhuyenMai();
        }
    }//GEN-LAST:event_rdoFillTatCaActionPerformed

    private void rdoFillConHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFillConHanActionPerformed
        rdoFillTatCaActionPerformed(evt);
    }//GEN-LAST:event_rdoFillConHanActionPerformed

    private void rdoFillHetHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoFillHetHanActionPerformed
        rdoFillTatCaActionPerformed(evt);
    }//GEN-LAST:event_rdoFillHetHanActionPerformed

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed
        exportExcelKM();
    }//GEN-LAST:event_btnExportExcelActionPerformed

    private void chkbSelectAllSPAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbSelectAllSPAddActionPerformed
        isSelectAllSPAdd(chkbSelectAllSPAdd.isSelected());
    }//GEN-LAST:event_chkbSelectAllSPAddActionPerformed

    private void txtSearchSPCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchSPCaretUpdate
        Color color = txtSearchKM.getForeground();
        if (!color.equals(Color.GRAY)) {
            searchAndFilterSPAdd(txtSearchSP.getText().trim());
            loadDataSPToAdd();
        }
    }//GEN-LAST:event_txtSearchSPCaretUpdate

    private void txtSearchKMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchKMFocusGained
        txtSearchKM.setText("");
        txtSearchKM.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtSearchKMFocusGained

    private void txtSearchKMFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchKMFocusLost
        if (txtSearchKM.getText().isBlank()) {
            txtSearchKM.setText("Tim theo ten...");
            txtSearchKM.setForeground(Color.GRAY);
            int trangThai = rdoFillTatCa.isSelected() ? -1 : (rdoFillConHan.isSelected() ? 1 : 0);
            searchAndFilterKM("", trangThai);
            loadDataKhuyenMai();
        }
    }//GEN-LAST:event_txtSearchKMFocusLost

    private void txtSearchSPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchSPFocusGained
        txtSearchSP.setText("");
        txtSearchSP.setForeground(Color.BLACK);
    }//GEN-LAST:event_txtSearchSPFocusGained

    private void txtSearchSPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchSPFocusLost
        if (txtSearchSP.getText().isBlank()) {
            txtSearchSP.setText("Tim theo ma, ten...");
            txtSearchSP.setForeground(Color.GRAY);
            searchAndFilterSPAdd("");
            loadDataSPToAdd();
        }
    }//GEN-LAST:event_txtSearchSPFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddKhuyenMai;
    private javax.swing.JButton btnDeleteKhuyenMai;
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnUpdateKhuyenMai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbFilterChiNhanh;
    private javax.swing.JCheckBox chkbBoChonTatCa;
    private javax.swing.JCheckBox chkbSelectAllSPAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnlChiTietKM;
    private javax.swing.JPanel pnlSPCoKM;
    private javax.swing.JRadioButton rdoConHan;
    private javax.swing.JRadioButton rdoFillConHan;
    private javax.swing.JRadioButton rdoFillHetHan;
    private javax.swing.JRadioButton rdoFillTatCa;
    private javax.swing.JRadioButton rdoHetHan;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTable tblSanPhamAdd;
    private javax.swing.JTable tblSanPhamDelete;
    private javax.swing.JTextField txtChietKhau;
    private javax.swing.JTextField txtIdKM;
    private javax.swing.JTextArea txtMoTa;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    private javax.swing.JTextField txtSearchKM;
    private javax.swing.JTextField txtSearchSP;
    private javax.swing.JTextField txtTenKM;
    // End of variables declaration//GEN-END:variables
}
