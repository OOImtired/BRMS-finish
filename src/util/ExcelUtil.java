package util;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import dao.UserOrderDao;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import model.Rental;

public class ExcelUtil {
	UserOrderDao dao=new UserOrderDao();
	Rental rental=new Rental();
	
	public void importExcel() {
		File file=null;
		Workbook workbook=null;
		Sheet sheet=null;
		file=new File("E:\\各种PPT和Word\\Java课设\\用户订单表.xls");
		try {
			workbook = Workbook.getWorkbook(file);
			sheet = workbook.getSheet(0);
			int rows = sheet.getRows();
			for(int i=0;i<rows;i++) {
				//获取单元格
				Cell lpnCell = sheet.getCell(0,i);
				Cell brandCell = sheet.getCell(1,i);
				Cell typeCell = sheet.getCell(2,i);
				Cell startdateCell = sheet.getCell(3,i);
				Cell enddateCell = sheet.getCell(4,i);
				Cell rentalnumberCell = sheet.getCell(5,i);
				Cell nameCell = sheet.getCell(6,i);
				Cell telenumberCell = sheet.getCell(7,i);
				//获取单元格里的内容
				String lpnContents = lpnCell.getContents();
				String brandContents = brandCell.getContents();
				String typeContents = typeCell.getContents();
				String startdateContents = startdateCell.getContents();
				String enddateContents = enddateCell.getContents();
				String rentalnumberContents = rentalnumberCell.getContents();
				String nameContents = nameCell.getContents();
				String telenumberContents = telenumberCell.getContents();
				//将字符串类型转换为其他类型
				Date startdate=Date.valueOf(startdateContents);
				Date enddate=Date.valueOf(enddateContents);
				int rentalnumber = Integer.valueOf(rentalnumberContents);
				//存入数据库
				rental.setLpn(lpnContents);
				rental.setBrand(brandContents);
				rental.setType(typeContents);
				rental.setStartdate(startdate);
				rental.setEnddate(enddate);
				rental.setRentalnumber(rentalnumber);
				rental.setUsername(nameContents);
				rental.setTelenumber(telenumberContents);
				dao.insertUserOrder(rental);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			workbook.close();
		}
	}
	public void exportExcel() {
		WritableWorkbook createWorkbook=null;
	    try {
	    	File file=new File("E:\\各种PPT和Word\\Java课设\\用户订单表.xls");
	    	createWorkbook=Workbook.createWorkbook(file);
			//创建用户租借信息的sheet页
			WritableSheet createSheet = createWorkbook.createSheet("用户租借信息", 0);
			//参1：x坐标
			//参2：y坐标
			//参3：label内容
			Label lpnHead = new Label(0,0,"车牌号");
			Label brandHead = new Label(1,0,"品牌");
			Label typeHead = new Label(2,0,"类型");
			Label startDateHead = new Label(3,0,"开始时间");
			Label endDateHead = new Label(4,0,"结束时间");
			Label rentalNumberHead = new Label(5,0,"租车数量");
			Label usernameHead = new Label(6,0,"用户名");
			Label telenumberHead = new Label(7,0,"联系方式");
			
			createSheet.addCell(lpnHead);
			createSheet.addCell(brandHead);
			createSheet.addCell(typeHead);
			createSheet.addCell(startDateHead);
			createSheet.addCell(endDateHead);
			createSheet.addCell(rentalNumberHead);
			createSheet.addCell(usernameHead);
			createSheet.addCell(telenumberHead);
			List<Rental> queryUserOrder = dao.queryUserOrder();
			int rowNumber=1;
			for(Rental re:queryUserOrder) {
				Label lpn=new Label(0,rowNumber,re.getLpn());
				Label brand=new Label(1,rowNumber,re.getBrand());
				Label type=new Label(2,rowNumber,re.getType());
				Label startdate=new Label(3,rowNumber,re.getStartdate().toString());
				Label enddate=new Label(4,rowNumber,re.getEnddate().toString());
				Label rentalnumber=new Label(5,rowNumber,Integer.toString(re.getRentalnumber()));
				Label username=new Label(6,rowNumber,re.getUsername());
				Label telenumber=new Label(7,rowNumber,re.getTelenumber());
				
				createSheet.addCell(lpn);
				createSheet.addCell(brand);
				createSheet.addCell(type);
				createSheet.addCell(startdate);
				createSheet.addCell(enddate);
				createSheet.addCell(rentalnumber);
				createSheet.addCell(username);
				createSheet.addCell(telenumber);
		
				rowNumber++;
			}
			createWorkbook.write();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				createWorkbook.close();
			} catch (WriteException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
