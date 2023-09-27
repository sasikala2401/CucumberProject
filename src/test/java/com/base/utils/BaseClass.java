package com.base.utils;

	import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;



	public class BaseClass {
		public static WebDriver driver;
		
		public static void browserOpen(String browser) {
			switch (browser) {
			case "chrome":
				driver = new ChromeDriver();
				break;
				
			case "firefox":
				driver = new FirefoxDriver();
				break;
			
			case "ie":
				driver = new InternetExplorerDriver();
				break;
				
			case "edge":
				driver = new EdgeDriver();
				break;
				
			default:
				System.out.println("This browser is not feasible");
				break;
			}

		}

		public static void loadUrl(String url) {
			driver.get(url);
		}
		
		public static void windowMaximize() {
			driver.manage().window().maximize();
		}
		public static WebElement findElementById(String id) {
			return driver.findElement(By.id(id));
		}

		public static WebElement findElementByXpath(String xpath) {
			return driver.findElement(By.xpath(xpath));
		}
		
		public static WebElement findElementAB(By abs) {
			return driver.findElement(abs);
		}
		
		public static void pageTitle() {
			String pageTitle = driver.getTitle();
			System.out.println(pageTitle);
		}

		public static void pageClose() {
			driver.close();
		}
		
		public static void sleepTime(int time) throws InterruptedException {
			Thread.sleep(time);
		}
		
		public static void dataSend(WebElement element, String data) {
//			WebDriverWait wait = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(data);
		}
		
		public static void click(WebElement element) {
//			WebDriverWait wait = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		}
		
		public static void clickAndHold(WebElement element) {
			new Actions(driver).clickAndHold(element).perform();
		}
		
		public static void dropDownSelectAValue(String value,WebElement element) {
			Select s = new Select(element);
			s.selectByValue(value);
		}
		
		public static void dropDownAllOptions(WebElement element) {
			Select s = new Select(element);
			List<WebElement> options = s.getOptions();
			for (int i = 0; i < options.size(); i++) {
				String data = options.get(i).getText();
				System.out.println(data);
			}
					
		}
		
		public static void getAttribute(WebElement element) {
			String data = element.getAttribute("value");
			System.out.println(data);
		}
		
		public static String getCurrentUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		}
		
		public static void pageSource() {
			String pageSrc = driver.getPageSource();
			System.out.println(pageSrc);
		}
		
		public static void getText(WebElement element) {
			String data = element.getText();
			System.out.println(data);
		}
		
		public static void dragAndDrop(WebElement source,WebElement destination) {
			Actions ac = new Actions(driver);
			ac.dragAndDrop(source, destination).perform();
		}
		
		public static void rightClick(WebElement element) {
			Actions ac = new Actions(driver);
			ac.contextClick(element).perform();
		}
		
		public static void doubleClick(WebElement element) {
			Actions ac = new Actions(driver);
			ac.doubleClick(element).perform();
		}
		
		public static void back() {
			driver.navigate().back();
		}
		
		public static void forward() {
			driver.navigate().forward();
		}
		
		public static void refresh() {
			driver.navigate().refresh();
		}
		
		public static void navigateTo(String element) {
			driver.navigate().to(element);
		}
		
		public static void mouseHover(WebElement element) {
			Actions ac = new Actions(driver);
			ac.moveToElement(element).perform();
		}
		
		public static void simpleAlert() {
			driver.switchTo().alert().accept();
		}
		
		public static void confirmAlert(String option) {
			switch(option) {
			case "accept":
				driver.switchTo().alert().accept();
				break;
			
			case "dismiss":
				driver.switchTo().alert().dismiss();
				break;
			}	
			
		}
		
		public static void promptAlert(String data) {
			Alert element = driver.switchTo().alert();
			element.sendKeys(data);
			element.accept();
		}
		
		public static void frameIndex(int index) {
			driver.switchTo().frame(index);
		}
		
		public static void frameCount() {
			List<WebElement> frameCount = driver.findElements(By.tagName("iframe"));
			int frameList = frameCount.size();
			System.out.println("Number of frame present in the Webpage : "+frameList);
		}
		
		public static void scrnshot(File destiny) throws IOException {
			TakesScreenshot tk = (TakesScreenshot) driver;
			File srcFile = tk.getScreenshotAs(OutputType.FILE);
			//FileHandler.copy(srcFile, destiny);
			FileHandler.copy(srcFile, destiny);
		}
		
		public static void jsSetAttribute(WebElement element, String data) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value', '"+data+"')", element);
		}
		
		public static void jsGetAttribute(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String data = (String) js.executeScript("return arguments[0].getAttribute('value')", element);
			System.out.println(data);
		}
		
		public static void jsClick(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);
		}
		
		public static void jsHighLight(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style','background:blue ;border: solid 10px green;');",element);
		}
		
		public static void scrollUpAndDown(int startVal, int endVal) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy('"+startVal+"','"+endVal+"')");
			
		}
		
		public static void scrollIntoView(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",element);
		}
		
		public static String getWindowId() {
			String windowId = driver.getWindowHandle();
			return windowId;
		}
		
		public static void getWindowIds() {
			Set<String> windowHandles = driver.getWindowHandles();
			for (String childId : windowHandles) {
				System.out.println("Child Window ID : "+childId);
			}
		}
		
		public static void tableData() {
			List<WebElement> data = driver.findElements(By.tagName("td"));
			for (int i = 0; i < data.size(); i++) {
				String tableDatas = data.get(i).getText();
				System.out.println(tableDatas);
			}
		}
		
		public static void tableRowCount() {
			int count = 0;
			List<WebElement> data = driver.findElements(By.tagName("tr"));
			for (int i = 0; i < data.size(); i++) {
				count = count+1;
			}
			System.out.println("Number of Rows in Table : "+count);
		}
		
		public static void getCssValue(WebElement element) {
			String fontSize = element.getCssValue("font-size");
			String fontColor = element.getCssValue("color");
			String fontType = element.getCssValue("font-family");
			String lineHeight = element.getCssValue("line-height");
			
			System.out.println("Font Size : "+fontSize);
			System.out.println("Font Colour : "+fontColor);
			System.out.println("Font Type : "+fontType);
			System.out.println("Line Height : "+lineHeight);
		}
		
			public static void getDropDownOptions(WebElement element) {
				Select s = new Select(element);
				List<WebElement> options = s.getOptions();
				for (int i = 0; i < options.size(); i++) {
					System.out.println(options.get(i).getText());
			}
			}
			
			public static void selectByVisibleText(WebElement element,String text) {
				Select s = new Select(element);
				s.selectByVisibleText(text);
			}
			
			public static void selectByIndex(WebElement element,int index) {
				Select s = new Select(element);
				s.selectByIndex(index);
			}
				
			public static void deselectAllOptions(WebElement element) {
				Select s = new Select(element);
				s.deselectAll();
			}
			
			public static void impWait(int sec) {
				driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
			}
			
			public static void captureScreen() throws IOException {
				Date d = new Date();
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("./ScreenShot/" + d.toString().replace(":", "_") + ".png"));
			}
			
			//PROJECT CLASS METHODS
			
//		public static String getExcelData(String path, int i, int j) throws IOException {
//			File f = new File(path);
//			FileInputStream fis = new FileInputStream(f);
//			Workbook wb = new XSSFWorkbook(fis);
//			Sheet sheet = wb.getSheet("Sheet1");
//				Row row = sheet.getRow(i);
//					Cell cell = row.getCell(j);
//					String value = cell.getStringCellValue();
//				return value;
//		}
//		
//		public String getCellData(int rowNum,int columnNum) throws IOException
//		{
//			FileInputStream fi=new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\TestNG\\SampleTest\\src\\test\\resources\\Test Data\\DataProvider.xlsx");
//			Workbook wb=new XSSFWorkbook(fi);
//			Sheet sheet=wb.getSheet("Sheet1");
//			Row row=sheet.getRow(rowNum);
//			Cell column=row.getCell(columnNum);
//		
//			String value;
//			try{
//			value = column.getStringCellValue(); 
//			}
//			catch(Exception e)
//			{
//				value="";
//			}
//			return value;
//		}
//		
//		public static String getDateFromExcel(int i, int j) throws IOException {
//			String value = null;
//			File f = new File("C:\\Users\\admin\\eclipse-workspace\\TestNG\\SampleTest\\src\\test\\resources\\Test Data\\SearchHotelPage.xlsx");
//			FileInputStream fis = new FileInputStream(f);
//			Workbook wb = new XSSFWorkbook(fis);
//			Sheet sheet = wb.getSheet("Sheet1");
//				Row row = sheet.getRow(i);
//					Cell cell = row.getCell(j);
//					if (DateUtil.isCellDateFormatted(cell)) {
//						Date dateCellValue = cell.getDateCellValue();
//						SimpleDateFormat sc = new SimpleDateFormat("dd/MM/yyyy");
//						value = sc.format(dateCellValue);			
//						}
//					return value;
//		}
//		
//		public static int getNoFromExcel(int i, int j) throws IOException {
//			File f = new File("C:\\Users\\admin\\eclipse-workspace\\TestNG\\SampleTest\\src\\test\\resources\\Test Data\\SearchHotelPage.xlsx");
//			FileInputStream fis = new FileInputStream(f);
//			Workbook wb = new XSSFWorkbook(fis);
//			Sheet sheet = wb.getSheet("Sheet1");
//				Row row = sheet.getRow(i);
//					Cell cell = row.getCell(j);
//			double numericCellValue = cell.getNumericCellValue();
//			int value = (int) numericCellValue;
//			return value;	
//		}
//		
//		public static void excelWrite() throws IOException {
//			File f = new File("C:\\Users\\admin\\eclipse-workspace\\TestNG\\SampleTest\\src\\test\\resources\\Test Data\\SearchHotelPage.xlsx");
//			FileInputStream fis = new FileInputStream(f);
//			Workbook wb = new XSSFWorkbook(fis);
//			Sheet cSheet = wb.createSheet("Adactin2");
//			Row createRow = cSheet.createRow(0);
//			Cell createCell = createRow.createCell(0);
//			List<WebElement> data = driver.findElements(By.tagName("tr"));
//			for (int i = 0; i < data.size(); i++) {
//				String tableDatas = data.get(i).getText();
//				System.out.println(tableDatas);
//			createCell.setCellValue(tableDatas);
//			FileOutputStream fos = new FileOutputStream(f);
//			wb.write(fos);
//			}
//		}
//		
//		public int getRowCount() throws IOException 
//		{
//			FileInputStream fi=new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\TestNG\\SampleTest\\src\\test\\resources\\Test Data\\DataProvider.xlsx");
//			Workbook wb=new XSSFWorkbook(fi);
//			Sheet sheet=wb.getSheet("Sheet1");
//			int rowcount=sheet.getPhysicalNumberOfRows();
//			return rowcount;		
//		}
//		
//		public int getCellCount()  throws IOException 
//		{
//			FileInputStream fi=new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\TestNG\\SampleTest\\src\\test\\resources\\Test Data\\DataProvider.xlsx");
//			Workbook wb=new XSSFWorkbook(fi);
//			Sheet sheet=wb.getSheet("Sheet1");
//			Row row=sheet.getRow(0);
//		   	int cellcount=row.getPhysicalNumberOfCells();
//			return cellcount;		
//		}
//
//		public static String getPropertyData(String key) throws IOException {
//			FileReader read = new FileReader("C:\\Users\\admin\\eclipse-workspace\\TestNG\\SampleTest\\src\\test\\resources\\Test Data\\file.properties");
//			
//			Properties prop = new Properties();
//			prop.load(read);
//			return prop.getProperty(key);
//			
//		}
//		
//		public static String getXMLData(String tagname, int index) throws ParserConfigurationException, SAXException, IOException {
//			File f = new File("C:\\Users\\admin\\eclipse\\Project\\MavenTest\\src\\test\\resources\\Data\\file.xml");
//
//			DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = newInstance.newDocumentBuilder();
//			Document doc = builder.parse(f);
//
//			NodeList byTagName = doc.getElementsByTagName("user");
//			
//			for (int i = 0; i < byTagName.getLength(); i++) {
//				Node item = byTagName.item(i);
//				if(index==i) {
//				Element ele = (Element)item;
//			return ele.getElementsByTagName(tagname).item(0).getTextContent();
//			
//				}
//			}
//			return tagname;
//			
//		}
//		
////		public static String getJSONData(String key) throws IOException, ParseException {
////			FileReader read = new FileReader("C:\\Users\\admin\\eclipse\\Project\\MavenTest\\src\\test\\resources\\Data\\file.json");
////			JSONParser parse = new JSONParser();
////			Object obj = parse.parse(read);
////			JSONObject jsonObj = (JSONObject) obj;
////				
////			return (String)jsonObj.get(key);
////			}
//		
//		public static String getTimeStamp() {
//			Date dt = new Date();
//			return "Current Date With Time Stamp : " + dt;
//		}
}
