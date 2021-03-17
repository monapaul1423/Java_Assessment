import java.util.List;
import java.util.Scanner;

public class MainClass 
{

  public static void main(String[] args)
  {
	  
    Scanner scan = new Scanner(System.in);
    String zipcodeRanges = scan.nextLine();
    
    ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(zipcodeRanges);
    List<ZipcodeGetterSetter> zipcodeList = zipcodeProcessor.stripZipcode();
    ZipcodeMerger zipcode_merger = new ZipcodeMerger();
    List<ZipcodeGetterSetter> sortedZipCodeList = zipcode_merger.sortByLowerBounds(zipcodeList);
    List<ZipcodeGetterSetter> mergedZipcodeList = zipcode_merger.mergeZipcodes(sortedZipCodeList);
    for (ZipcodeGetterSetter zipcode : mergedZipcodeList) {
      System.out.println("[" + zipcode.getLower_bound() + "," + zipcode.getUpper_bound() + "]");
    }

    scan.close();
  }
}
