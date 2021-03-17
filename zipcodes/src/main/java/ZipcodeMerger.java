

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZipcodeMerger {
  public List<ZipcodeGetterSetter> sortByLowerBounds(List<ZipcodeGetterSetter> zipcodeRangeList) 
  {
    Collections.sort(zipcodeRangeList, new ZipcodeComparator());
    return zipcodeRangeList;
  }

  public List<ZipcodeGetterSetter> mergeZipcodes(List<ZipcodeGetterSetter> sortedZipCodeList) {
    List<ZipcodeGetterSetter> mergedZipcodeList = new LinkedList<ZipcodeGetterSetter>();
    ZipcodeGetterSetter zipcode = null;
    for (ZipcodeGetterSetter zipcodeInterval : sortedZipCodeList) {
      if (zipcode == null)
        zipcode = zipcodeInterval;
      else {
        if (zipcode.getUpper_bound() >= zipcodeInterval.getLower_bound()) {
          zipcode.setUpper_bound(Math.max(zipcode.getUpper_bound(), zipcodeInterval.getUpper_bound()));
        } else {
          mergedZipcodeList.add(zipcode);
          zipcode = zipcodeInterval;
        }
      }
    }
    mergedZipcodeList.add(zipcode);
    return mergedZipcodeList;
  }

}
