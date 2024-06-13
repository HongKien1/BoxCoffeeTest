import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.box.utils.XDate;
import com.boxcf.dao.KhuyenMaiDao;
import com.boxcf.models.KhuyenMai;

public class KhuyenMaiDaoTest {

	private KhuyenMaiDao dao;
	private KhuyenMai km;
	private List<KhuyenMai> list;

	@BeforeTest
	public void setUp() {
		dao = new KhuyenMaiDao();
		km = new KhuyenMai("B013XL", "KhuyenMai 13", XDate.toDate("01/07/2023", "MM/dd/yyyy"),
				XDate.toDate("01/08/2023", "MM/dd/yyyy"), 100, 10, 500000);
	}

	// test data provider
	@DataProvider(name = "KhuyenMaiData")
	private Object[][] db() {
		return new Object[][] {
				{ null, "Tri ân khách hàng", XDate.toDate("01/07/2023", "MM/dd/yyyy"),
						XDate.toDate("01/08/2023", "MM/dd/yyyy"), 100, 10, 500000, 0 },
				{ "KM10", null, XDate.toDate("01/07/2023", "MM/dd/yyyy"), XDate.toDate("01/08/2023", "MM/dd/yyyy"), 100,
						10, 500000, 0 },
				{ "KM10", "Tri ân khách hàng", null, XDate.toDate("01/08/2023", "MM/dd/yyyy"), 100, 10, 500000, 0 },
				{ "KM10", "Tri ân khách hàng", XDate.toDate("01/07/2023", "MM/dd/yyyy"),
						XDate.toDate("01/08/2023", "MM/dd/yyyy"), 100, 10, 500000, 1 }, };
	}

	@Test(dataProvider = "KhuyenMaiData")
	public void insert(String MaKM, String TenKM, Date NgayBD, Date NgayKT, int SoLuot, int PhanTram, long DieuKienGiam,
			int result) {
		KhuyenMai km = new KhuyenMai(MaKM, TenKM, NgayBD, NgayKT, SoLuot, PhanTram, DieuKienGiam);
		Assert.assertEquals(result, dao.insert2(km));
	}

	// test select all
	@Test()
	public void TestSelectAll() {
		list = dao.selectAll();
		Assert.assertEquals(false, list.isEmpty());
	}

	// test insert
	@Test()
	public void TestInsert() throws Exception {
		try {
			dao.insert(km);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}

	// test find by id
	@Test()
	public void TestFindById() {
		KhuyenMai kmGeted = dao.selectById("C13141510");
		Assert.assertEquals("C13141510", kmGeted.getMaKM());
	}

	// test find by keyword
	@Test()
	public void TestFinByKeyword() {
		list = dao.selectByKeyword("Tri ân");
		Assert.assertEquals(1, list.size());
	}

	// test update
	@Test()
	public void TestUpdate() {
		String expected = "Khuyen mai Update";

		km.setTenKM(expected);

		dao.update(km);

		KhuyenMai kmGeted = dao.selectById(km.getMaKM());
		Assert.assertEquals(expected, kmGeted.getTenKM());
	}

	// test delete
	@AfterClass
	public void TestDelete() {
		dao.destroy("KM10");
		dao.destroy(km.getMaKM());
	}

	// select by condition
	@Test()
	public void TestFinByCondition() {
		list = dao.selectByCondition(100000);
		Assert.assertEquals(3, list.size());
	}
}
