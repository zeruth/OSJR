package rsreflection;

public class FieldInfo {

  private final String className;
  private final String fieldName;
  private final int multiplier;
  
  /**
   * FieldInfo - Object representing RS class definitions.
   * @param c = Class name.
   * @param f = Field name.
   * @param m = Multiplier.
   */
  public FieldInfo(String c, String f, int m) {
    className = c;
    fieldName = f;
    multiplier = m;
  }

  public int getMultiplier() {
    return multiplier;
  }

  public String getClassName() {
    return className;
  }

  public String getFieldName() {
    return fieldName;
  }

  /**
   * printFieldInfo - Print's definition to console.
   */
  public void printFieldInfo() {
    System.out.println(className);
    System.out.println(fieldName);
    System.out.println(multiplier);
  }
}