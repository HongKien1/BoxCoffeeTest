package com.boxcf.dao;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.boxcf.models.Box;

public class NhanVienDaoTest {

	private BoxDao dao;
	private Box box;
	private List<Box> list;

	@BeforeTest
	public void setUp() {
		dao = new BoxDao();
		box = new Box("B013XL", "Box 13", null, "XL", "Moi");
	}
	
	//test data provider
	@DataProvider(name = "boxData")
	private Object[][] db () {
		return new Object[][] {
			{null, "Box 1", "box1.jpg", "Mới", "S", 0}, // test case: id is empty
			{"B002S", null, "box1.jpg", "Mới", "S", 0}, // test case: name is empty			
			{"B002S", "Box 1", "box1.jpg", "Moi", "S", 1}, // test case: info is valid
		};
	}
	
	@Test(dataProvider = "boxData")
	public void insert(String id, String name, String image, String desc, String type, int result) {
		Box box = new Box(id, name, image, type, desc);
		Assert.assertEquals(result,  dao.insert2(box));
	}
	
	//test select all
		@Test()
		public void TestSelectAll() {
			list = dao.selectAll();
			Assert.assertEquals(false, list.isEmpty());
		}
	
	//test insert
	@Test()
	public void TestInsert() throws Exception {
		try {
			dao.insert(box);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
	}
	
	//test find by id
	@Test()
	public void TestFindById() {
		Box boxGeted = dao.selectById("B001S");
		Assert.assertEquals("Box 1", boxGeted.getTenBox());
	}
	
	//test find by keyword
	@Test()
	public void TestFinByKeyword() {
		list = dao.selectByKeyWord("Box");
		Assert.assertEquals(12, list.size());
	}

	//test update
	@Test()
	public void TestUpdate() {
		String expected = "Box Update";

		box.setTenBox(expected);

		dao.update(box);

		Box boxGeted = dao.selectById(box.getMaBox());
		Assert.assertEquals(expected, boxGeted.getTenBox());
	}

	//test delete
	@AfterClass
	public void TestDelete() {
		dao.delete("B002S");
		dao.delete(box.getMaBox());
	}
	
	//test pagination
	@Test()
	public void TestPagination() {
		list = dao.panigation(1);
		Assert.assertEquals(8, list.size());
	}
	
	//test find by box type
	@Test()
	public void TestFindByBoxType() {
		list = dao.selectByLoaiBox("S");
		Assert.assertEquals(3, list.size());	//trong database co 3 box thuoc loai S
	}
	
	//test get max id
	@Test()
	public void TestGetMaxId() {
		String maxId;
		try {
			maxId = dao.getMaxId();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		Assert.assertEquals("B014L", maxId);
	}
}
