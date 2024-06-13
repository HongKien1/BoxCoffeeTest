
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.box.utils.XDate;
import com.boxcf.dao.HoaDonDao;
import com.boxcf.models.HoaDon;

public class HoaDonDaoTest {
	private HoaDonDao dao;
	private HoaDon hd;

	@BeforeTest
	public void setUp() {

		dao = new HoaDonDao();
		hd = new HoaDon();
		hd.setNgayTao(XDate.toDate("12/2/2023", "dd/MM/yyyy"));
		hd.setTenKH("abc");
		hd.setMaNV("NV04");
		hd.setGhiChu("123");
		hd.setTONGTIEN(100000);
		hd.setMaKM(null);

	}

	@Test(priority = 1)
	public void TestInsert() {
		try {
			dao.inserts(hd);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}

	}

	@Test(priority = 2)
	public void TestSelectById() {
		HoaDon hd = dao.selectById(308);

		Assert.assertTrue(hd != null);
	}

	@Test(priority = 3)
	public void TestNextId() {
		int id = dao.getNextId();

		Assert.assertTrue(id > 0);
	}

	@Test(priority = 4)
	public void TestSelectAll() {
		List<HoaDon> list = dao.selectAll();

		Assert.assertEquals(false, list.isEmpty());

	}
}
