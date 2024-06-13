import java.sql.SQLException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.boxcf.dao.ComboDao;
import com.boxcf.models.Combo;

public class ComboDaoTest {
	private ComboDao dao;
	private Combo combo;

	@BeforeTest
	public void setUp() {

		dao = new ComboDao();
		combo = new Combo();
		combo.setMaCB("CB007XL");
		combo.setTenCB("Combo 1");
		combo.setGia(300000);
		combo.setMaLoaiBox("XL");
		combo.setSoLuongDoUong(2);
		combo.setSoLuongDoAn(2);
		combo.setMoTa("abc");
	}

	@Test(priority = 1)
	public void TestInsert() throws Exception {
		dao.insertTest(combo);
	}


	@Test(priority = 2)
	public void TestSelectById() {
		Combo comboGeted = dao.selectById(combo.getMaCB());
		Assert.assertTrue(comboGeted != null);
	}

	@Test(priority = 3)
	public void TestUpdate() {
		String expected = "Combo Update";

		combo.setTenCB(expected);

		dao.update(combo);

		Combo comboGeted = dao.selectById(combo.getMaCB());
		Assert.assertEquals(expected, comboGeted.getTenCB());
	}
	
	@Test(priority = 4)
	public void TestSelectAll() {
		List<Combo> list = dao.selectAll();
		Assert.assertEquals(false, list.isEmpty());
	}
	
	@Test(priority = 5)
	public void TestSelectByMaLoaiBox() {
		List<Combo> list = dao.selectByLoaiBox("L");
		Assert.assertEquals(false, list.isEmpty());
	}
	
	@Test(priority = 6)
	public void TestSelectByKeyWord() {
		List<Combo> list = dao.selectByKeyWord("Cập Đôi Hoàn Hảo");
		Assert.assertEquals(false, list.isEmpty());
	}
	
	@Test(priority = 7)
	public void TestPagination() {
		List<Combo> list = dao.panigation(1);
		Assert.assertEquals(7, list.size());
	}
	
	@Test(priority = 7)
	public void TestMaxId() throws SQLException {
		String expected = "CB007XL";
		String maxId = dao.getMaxId();
		Assert.assertEquals(expected, maxId);
	}

	@Test(priority = 8)
	public void TestDelete() {

		dao.delete(combo.getMaCB());

		Combo comboGeted = dao.selectById(combo.getMaCB());
		Assert.assertEquals(true, comboGeted == null);
	}

}
