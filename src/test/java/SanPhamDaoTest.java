import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.boxcf.dao.SanPhamDao;
import com.boxcf.models.SanPham;

public class SanPhamDaoTest {
	private SanPhamDao dao;
	private SanPham sp;

	@BeforeTest
	public void setUp() {
		dao = new SanPhamDao();
		sp = new SanPham();
		sp.setMaSP("TS004");
		sp.setTenSP("Rau Má Đậu Xanh");
		sp.setGia(25000);
		sp.setMaLoai("LSP07");
		sp.setHinhAnh("nho.jpg");
		sp.setMoTa("abc");

	}

	@Test(priority = 1)
	public void TestInsertSuccessfuly() throws Exception {
		dao.insertTest(sp);
	}

	@Test(priority = 2, expectedExceptions = Error.class)
	public void TestInsertFailure() throws Exception {
		dao.insertTest(sp);
	}

	@Test(priority = 3)
	public void TestGet() {
		SanPham spGeted = dao.selectById(sp.getMaSP());
		Assert.assertTrue(spGeted != null);
	}

	@Test(priority = 4)
	public void TestGetEqua() {
		SanPham spGeted = dao.selectById(sp.getMaSP());
		Assert.assertTrue(spGeted.equals(sp));
	}

	@Test(priority = 5)
	public void TestUpdate() {
		String expected = "Rau Má Đậu Nành";

		sp.setTenSP(expected);

		dao.update(sp);

		SanPham spGeted = dao.selectById(sp.getMaSP());
		Assert.assertEquals(expected, spGeted.getTenSP());
	}

	@Test(priority = 7)
	public void TestSelectAll() {
		List<SanPham> list = dao.selectAll();
		Assert.assertEquals(false, list.isEmpty());
	}

	@Test(priority = 8)
	public void TestSelectByTenLoaiSP() {
		List<SanPham> list = dao.selectByTenLoaiSP("Trái cây");
		Assert.assertEquals(false, list.isEmpty());
	}

	@Test(priority = 9)
	public void TestSelectByTenDanhMuc() {
		List<SanPham> list = dao.selectByTenDanhMuc("Đồ ăn");
		Assert.assertEquals(false, list.isEmpty());
	}

	@Test(priority = 10)
	public void TestSelectByKeyWordType0() {
		List<SanPham> list = dao.selectByKeyWord("Nước Cam", 0);
		Assert.assertEquals(false, list.isEmpty());
	}

	@Test(priority = 11)
	public void TestSelectByKeyWordType1() {
		List<SanPham> list = dao.selectByKeyWord("DK002", 1);
		Assert.assertEquals(false, list.isEmpty());
	}

	@Test(priority = 13)
	public void TestPagination() {
		List<SanPham> list = dao.panigation(1);
		Assert.assertEquals(8, list.size());
	}

	@Test(priority = 14)
	public void TestDelete() {

		dao.delete(sp.getMaSP());

		SanPham spGeted = dao.selectByIdActive(sp.getMaSP());
		Assert.assertEquals(true, spGeted == null);
	}

	@AfterClass
	public void clear() {
		dao.destroy(sp.getMaSP());
	}
}
