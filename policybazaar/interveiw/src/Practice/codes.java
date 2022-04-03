package Practice;


public class codes {

	public static void getRendomData() {
	int x=	(int) (Math.random()*28);
	System.out.println(x);
	}

	public static void main(String[] args) {
		getRendomData();
		
//		codes abcd = new codes();
//		System.out.println(abcd.repeatLetter("a"));
//	}
//
//	public int repeatLetter(String letter) {
//		String name = "I am vikas";
//		
//		int count = 0;
//		String[] word = name.split("");
//		for (int i = 0; i < word.length; i++) {
//			if (letter.equals(word[i])) {
//				count++;
//			}
//		}
//		return count;
//		ArrayList<String> abcd = new ArrayList<String>();
//		abcd.add("vikas");
//		System.out.println(abcd.size());
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vikassahu\\policybazaar\\interveiw\\drivers\\chromedriver.exe");
//		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--Headless");
//		WebDriver driver = new ChromeDriver(options);
//		driver.get("https://google.com/");
//		System.out.println(driver.getTitle());
//		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("vikas"+Keys.ENTER);
//		System.out.println(driver.getTitle());
//		
	}
}