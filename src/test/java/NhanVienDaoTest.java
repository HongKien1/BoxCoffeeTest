import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.box.utils.XDate;
import com.boxcf.dao.NhanVienDao;
import com.boxcf.models.NhanVien;

public class NhanVienDaoTest {

	private NhanVienDao dao;
	private NhanVien nv;
	private List<NhanVien> list;

	@BeforeTest
	public void setUp() {
		dao = new NhanVienDao();
	}

	// test data provider
	@DataProvider(name = "nvData")
	private Object[][] db2() {
		return new Object[][] {
				{ null, "Phạm Thị Ngân", XDate.toDate("02/02/2002", "MM/dd/yyyy"), "0964909321", "Cần Thơ", "123456",
						"no image", XDate.toDate("02/02/2023", "MM/dd/yyyy"), "User", false, 0 }, // test case: id is
																									// empty
				{ "NV10", null, XDate.toDate("02/02/2002", "MM/dd/yyyy"), "0964909321", "Cần Thơ", "123456", "no image",
						XDate.toDate("02/02/2023", "MM/dd/yyyy"), "User", false, 0 }, // test case: id is empty
				{ "NV10", "Phạm Thị Ngân", null, "0964909321", "Cần Thơ", "123456", "no image",
						XDate.toDate("02/02/2023", "MM/dd/yyyy"), "User", false, 0 }, // test case: id is empty
				{ "NV10", "Phạm Thị Ngân", XDate.toDate("02/02/2002", "MM/dd/yyyy"), "0964909321", "Cần Thơ", null,
						"no image", XDate.toDate("02/02/2023", "MM/dd/yyyy"), "User", false, 0 }, // test case: id is
																									// empty
				{ "NV10", "Phạm Thị Ngân", XDate.toDate("02/02/2002", "MM/dd/yyyy"), null, "Cần Thơ", "123456",
						"no image", XDate.toDate("02/02/2023", "MM/dd/yyyy"), "User", false, 0 }, // test case: id is
																									// empty
				{ "NV10", "Phạm Thị Ngân", XDate.toDate("02/02/2002", "MM/dd/yyyy"), "0964909321", "Cần Thơ", "123456",
						"no image", XDate.toDate("02/02/2023", "MM/dd/yyyy"), "User", false, 1 }, // test case: id is
																									// empty
		};
	}

	@Test(dataProvider = "nvData")
	public void insert(String id, String name, Date birthday, String tel, String address, String pass, String image,
			Date startDay, String role, boolean gender, int result) {

		nv = new NhanVien();
		nv.setMaNV(id);
		nv.setTenNV(name);
		nv.setSDT(tel);
		nv.setNgaySinh(birthday);
		nv.setGioiTinh(false);
		nv.setVaiTro(role);
		nv.setNgayVaoLam(startDay);
		nv.setDiaChi(address);
		nv.setMatKhau(pass);
		nv.setHinhAnh(image);

		Assert.assertEquals(result, dao.insert2(nv));

	}

//	//test select all
	@Test()
	public void TestSelectAll() {
		list = dao.selectAll();
		Assert.assertEquals(false, list.isEmpty());
	}
	
//	//test find by id
	@Test(priority = 1)
	public void TestFindById() {
		NhanVien nv = dao.selectById("NV10");
		Assert.assertEquals("Phạm Thị Ngân", nv.getTenNV());
	}
	
//	//test find by keyword
	@Test()
	public void TestFinByKeyword() {
		list = dao.selectByKeyword("Khang");
		Assert.assertEquals(2, list.size());	//co 2 nv khang trong database
	}

//	//test update
	@Test(priority = 2)
	public void TestUpdate() {
		String expected = "Nhan Vien Update";

		nv.setTenNV(expected);

		dao.update(nv);

		NhanVien nvGeted = dao.selectById(nv.getMaNV());
		Assert.assertEquals(expected, nvGeted.getTenNV());
	}

	// delete
	@AfterClass
	public void TestDelete() {
		dao.destroy("NV10");
	}

	
//	//test get max id
	@Test(priority = 3)
	public void TestGetMaxId() {
		String maxId;
		try {
			maxId = dao.getMaxId();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		Assert.assertEquals("NV10", maxId);
	}
	
	//test login
	@Test()
	public void TestLogin() {
		NhanVien nv = dao.login("NV08", "123123");		
		Assert.assertNotEquals(null, nv);
	}
}
