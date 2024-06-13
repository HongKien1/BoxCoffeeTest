package com.boxcf.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.boxcf.models.PhieuDatBox;
import com.box.utils.JdbcHelper;
import com.box.utils.XDate;
import com.boxcf.constands.BoxState;
import com.boxcf.models.ModelItem;
import java.util.Date;

public class PhieuDatBoxDao implements BoxCfDAO<PhieuDatBox, Integer> {

    public static PhieuDatBoxDao getInstant() {
        return new PhieuDatBoxDao();
    }

    @Override
    public PhieuDatBox createObjecet(ResultSet responce) {
        try {
            return new PhieuDatBox(
                    responce.getInt(1),
                    responce.getString(2),
                    responce.getString(3),
                    responce.getTimestamp(4),
                    responce.getTimestamp(5),
                    responce.getInt(6),
                    responce.getInt(7),
                    responce.getInt(8),
                    responce.getInt(9),
                    responce.getString(10),
                    responce.getString(11)
            );

        } catch (Exception e) {
            throw new Error("The Error in createObjecet DATBOX !");
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete DATBOX where MaDat = ?";

        try {
            int responce = JdbcHelper.update(sql, id);

            if (responce == 0) {
                throw new Error("The Error in delete DATBOX !");
            }
        } catch (Exception e) {
            throw new Error("The Error in delete DATBOX !");
        }

    }

    @Override
    public void insert(PhieuDatBox e) {
        String sql = "Insert into DATBOX values (?, ?, ?, ?, ?)";

        try {
            int responce = JdbcHelper.update(sql, e.getTenKH(), e.getGioBD(), e.getGioKT(), e.getTrangThai(), e.getMaBox());

            if (responce == 0) {
                throw new Error("The Error in insert DATBOX !");
            }
        } catch (Exception ex) {
            throw new Error("The Error in insert DATBOX !");
        }

    }

    public void insertProc(int maHD, ModelItem e, String nameCutomer) {
        String sql = "{ call sp_DatBox ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }";

        try {
            int responce = JdbcHelper.update(sql, maHD, e.getMaItem(), nameCutomer, e.getGioBD(), e.getGioKT(), e.getSoLuong(), e.getTraTruoc(), e.getSoLuong() * e.getLoaiBox().getGiaLoai(), e.getSoLuong() * e.getLoaiBox().getGiaLoai(), e.getTrangThai().toString(), e.getGhiChu());

            if (responce == 0) {
                throw new Error("Them du lieu that bai!");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Error("The Error in insertProc DATBOX !");
        }
    }

    public void inserBooktProc(int maHD, ModelItem e, String nameCutomer) {
        String sql = "{ call sp_DatBox ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }";

        try {
            int responce = JdbcHelper.update(sql, maHD, e.getMaItem(), nameCutomer, e.getGioBD(), e.getGioKT(), e.getSoLuong(), e.getTraTruoc(), e.getSoLuong() * e.getLoaiBox().getGiaLoai(), e.getTraTruoc(), e.getTrangThai().toString(), e.getGhiChu());

            if (responce == 0) {
                throw new Error("Them du lieu that bai!");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Error("The Error in insertProc DATBOX !");
        }
    }

    public void updateProc(ModelItem e, String state, Date gioKTMoi) {
        String sql = "{ call sp_update_DatBox ( ?, ?, ?, ?) }";

        try {
            int responce = JdbcHelper.update(sql, state, e.getGioKT(), e.getMaItem(), gioKTMoi);

            if (responce == 0) {
                throw new Error("The Error in updateProc DATBOX !");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Error("The Error in updateProc DATBOX !");
        }
    }

    public void receiveBox(PhieuDatBox model) {
        String sql = "{ call sp_nhan_box ( ?, ?, ?) }";

        try {
            int responce = JdbcHelper.update(sql, model.getMaHD(), model.getMaBox().toString(), model.getThanhTien());

            if (responce == 0) {
                throw new Error("The Error in updateActive DATBOX !");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Error("The Error in updateActive DATBOX !");
        }
    }

    public void cancelBox(PhieuDatBox model) {
        String sql = "update PhieuDatBox\n"
                + "set TrangThai = 'used', GhiChu = 'da huy', GioKT = ?\n"
                + "where  MaBox = ? and TrangThai = 'booked' and MaHD = ? ";

        try {
            int responce = JdbcHelper.update(sql, XDate.now(), model.getMaBox().toString(), model.getMaHD());

            if (responce == 0) {
                throw new Error("The Error in cancelBox DATBOX !");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Error("The Error in cancelBox DATBOX !");
        }
    }

    public void cancelBoxWhenActive(PhieuDatBox model) {
        String sql = "update PhieuDatBox\n"
                + "set TrangThai = 'used', GhiChu = 'tra som', GioKT = GETDATE()\n"
                + "where  MaBox = ? and MaHD = ? ";

        try {
            int responce = JdbcHelper.update(sql, model.getMaBox().toString(), model.getMaHD());

            if (responce == 0) {
                throw new Error("The Error in cancelBoxWhenActive DATBOX !");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            throw new Error("The Error in cancelBoxWhenActive DATBOX !");
        }
    }

    public void updateNhanBox(ModelItem data) {
        String sql = "{ call sp_update_NhanBox ( ?, ? ) }";

        try {
            int responce = JdbcHelper.update(sql, data.getMaItem().toString(), data.getGioBD());

            if (responce == 0) {
                throw new Error("The Error in updateProc DATBOX !");
            }
        } catch (Exception ex) {
            throw new Error("The Error in updateProc DATBOX !");
        }
    }

    @Override
    public List<PhieuDatBox> selectAll() {
        List<PhieuDatBox> list = new ArrayList<>();
        String sql = "select * from DATBOX";

        try {
            ResultSet responce = JdbcHelper.query(sql);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }
            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectAll DATBOX !");
        }
        return list;
    }

    @Override
    public PhieuDatBox selectById(Integer id) {
        String sql = "select * from PhieuDatBox \n"
                + "where MaHD = ?";
        PhieuDatBox db = null;
        try {

            ResultSet responce = JdbcHelper.query(sql, id);

            // admission a ResultSet return a Box
            if (responce.next()) {
                db = createObjecet(responce);
            }
            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectById DATBOX !");
        }
        return db;
    }

    //----------------------------------------------------
    public PhieuDatBox selectByBox(String id) {
        String sql = "select * from PhieuDatBox where MaBox = ? and TrangThai = 'active'";
        PhieuDatBox db = null;

        try {

            ResultSet responce = JdbcHelper.query(sql, id);

            // admission a ResultSet return a Box
            if (responce.next()) {
                db = createObjecet(responce);
            }

            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectByBox DATBOX !");
        }
        return db;
    }

    public PhieuDatBox selectByIdBox(String idBox) {
        String sql = "select * from PhieuDatBox where MaBox = ? and TrangThai = 'active'";
        PhieuDatBox db = null;

        try {

            ResultSet responce = JdbcHelper.query(sql, idBox);

            // admission a ResultSet return a Box
            if (responce.next()) {
                db = createObjecet(responce);
            }

            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectByBox DATBOX !");
        }
        return db;
    }

    public List<PhieuDatBox> selectByHd(int id) {
        String sql = "select * from PhieuDatBox\n"
                + "where MaHD = ?";
        return selectBySql(sql, id);
    }

    public List<PhieuDatBox> selectWithBooked() {
        String sql = "select * from PhieuDatBox\n"
                + "where TrangThai = 'booked'";
        return selectBySql(sql);
    }

    @Override
    public List<PhieuDatBox> selectBySql(String sql, Object... args) {
        List<PhieuDatBox> list = new ArrayList<>();

        try {
            ResultSet responce = JdbcHelper.query(sql, args);

            while (responce.next()) {
                list.add(createObjecet(responce));
            }
            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectBySql DATBOX !");
        }
        return list;
    }

    @Override
    public void update(PhieuDatBox e) {

    }

    public int getState(BoxState state) {
        String sql = "select count(*) from PhieuDatBox\n"
                + "where TrangThai =  ?";
        String sqlEmpty = "select count(*) from Box\n"
                + "where MaBox not in (select MaBox from PhieuDatBox\n"
                + "where  TrangThai = 'active')";

        if (state == BoxState.empty) {
            sql = sqlEmpty;
            return (int) JdbcHelper.value(sql);

        }

        return (int) JdbcHelper.value(sql, state.toString());
    }

    //---------------------------dat box--------------------------
    //get trang thai tu mabox
    public String getTrangThai(String mabox) {
        String sql = "select top 1 trangthai\n"
                + "from box a\n"
                + "inner join PhieuDatBox b on b.mabox = a.mabox\n"
                + "where a.mabox = ? "
                + "order by GioKT desc";

        try {
            ResultSet rs = JdbcHelper.query(sql, mabox);
            if (rs.next()) {
                String result = rs.getString(1);
                rs.getStatement().getConnection().close();

                return result;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "empty";
    }

    public Date getGioKT(String maBox) {
        String sql = "select gioKT from PhieuDatBox where mabox = ?";

        return (Date) JdbcHelper.value(sql, maBox);
    }

    //huy box --> set trangthai = empty
    public void setEmpty(String maBox) {
        String sql = "update PhieuDatBox set trangthai = 'used' where mabox = ?";

        JdbcHelper.update(sql, maBox);
    }

    //lay ra ds box dat va dat truoc
    public List<PhieuDatBox> getListActive(String maBox) {
        String sql = "select *\n"
                + "from phieudatbox\n"
                + "where mabox = ? and (trangthai like 'active' or trangthai like 'booked')";

        return selectBySql(sql, maBox);
    }

    //get ra gio dat ke tiep
    public PhieuDatBox getNextBooked(String maBox) {
        String sql = "select top 1 *\n"
                + "from phieudatbox\n"
                + "where mabox = ? and trangthai like 'booked'\n"
                + "order by gioBD asc";

        PhieuDatBox db = null;

        try {

            ResultSet responce = JdbcHelper.query(sql, maBox);

            if (responce.next()) {
                db = createObjecet(responce);
            }

            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in selectByBox DATBOX !");
        }
        return db;
    }

    //get dang su dung
    public PhieuDatBox getUsing(String maBox) {
        String sql = "select *\n"
                + "from phieudatbox\n"
                + "where mabox = ? and trangthai like 'active'\n";

        PhieuDatBox db = null;

        try {

            ResultSet responce = JdbcHelper.query(sql, maBox);

            if (responce.next()) {
                db = createObjecet(responce);
            }

            responce.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new Error("The Error in getUsing DATBOX !");
        }
        return db;
    }

    //dat truoc
    public List<PhieuDatBox> getBookedListProc(String maBox) {
        String sql = "select * \n"
                + "from phieudatbox\n"
                + "	where MaBox = ? and trangthai like 'booked'"
                + "order by GioBD asc";

        return selectBySql(sql, maBox);
    }

    //kiem tra box co dang xai hay ko
    public Object isActive(String maBox) {
        String sql = "select * from PhieuDatBox where MaBox = ? and TrangThai like 'active'";

        return JdbcHelper.value(sql, maBox);
    }

    public PhieuDatBox getActive(String maBox) {
        String sql = "select * from PhieuDatBox where MaBox = ? and TrangThai like 'active'";

        return selectBySql(sql, maBox).size() > 0 ? selectBySql(sql, maBox).get(0) : null;
    }

    //get ra phieu dat box thong qua maBox
    public static void main(String[] args) {
        System.out.println("phieu dat: " + PhieuDatBoxDao.getInstant().selectById(186));
    }
}
