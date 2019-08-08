import org.junit.Assert;

public class AssertTest {
	private String state = "stop";

	public void drive(int speed) {
		Assert.assertTrue("speed must be positive", speed > 0);
		this.state = "drive";
		// ...
	}
	
	
	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public static void main(String[] args) {

		new AssertTest().drive(1);
		
	}

}
