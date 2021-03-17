

import java.util.Comparator;

public class ZipcodeComparator implements Comparator<ZipcodeGetterSetter> 
{
  public int compare(ZipcodeGetterSetter interval1, ZipcodeGetterSetter interval2) {
    if (interval1.getLower_bound() > interval2.getLower_bound())
      return 1;
    else
      return -1;
  }
}
