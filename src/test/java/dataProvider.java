import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {

    @Test(dataProvider = "driveTest")
    public void testCaseData(String greetings, String testNumber, int id){
//        this test will execute 3 times using the sent 3 arrays
        System.out.println(greetings+ " " + testNumber + " " + id );

    }

    @DataProvider(name="driveTest")
    public Object[][] getData(){
//        Multi dimension object
        Object[][] data =  {{"hello1", "text1", 1}, {"hello2", "text2", 12}, {"hello3", "text3", 123}};
        return data;
    }

}
